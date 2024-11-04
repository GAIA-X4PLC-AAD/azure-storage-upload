import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobStorageException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class UploadAsset {

    public static void uploadFileToBlob(final String filePath, final String sasToken, final String azureStorageName,
                                        final tring containerName) {
        try {
            // Extract the file name from the file path
            final String fileName = Paths.get(filePath).getFileName().toString();

            // Create a Blob Service Client
            final BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .endpoint("https://" + azureStorageName + ".blob.core.windows.net")
                    .sasToken(sasToken)
                    .buildClient();

            // Create a Blob Client
            final BlobClient blobClient = blobServiceClient.getBlobContainerClient(containerName).getBlobClient(fileName);

            // Upload the file
            System.out.println("Uploading file " + fileName + " to the container...");
            blobClient.upload(new FileInputStream(new File(filePath)), new File(filePath).length(), true);

            System.out.println("File " + filePath + " uploaded successfully.");
        } catch (final BlobStorageException | final IOException e) {
            System.out.println("Error uploading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java UploadAsset <local_file_path_of_asset> <azure_storage_name> <source_container_name>");
            System.exit(100);
        }

        // Path to the file to be uploaded
        final String filePath = args[0];

        // Azure storage account name from command line argument
        final String azureStorageName = args[1];

        // Container name from command line argument
        final String containerName = args[2];

        // Retrieve SAS token from environment variable
        final String sasToken = System.getenv("SAS_TOKEN");
        if (sasToken == null) {
            System.out.println("SAS token not found in environment variable SAS_TOKEN.");
            System.exit(101);
        }

        // Check if the file path exists
        if (!new File(filePath).exists()) {
            System.out.println("File path does not exist: " + filePath);
            System.exit(102);
        }

        // Upload the file to the container
        uploadFileToBlob(filePath, sasToken, azureStorageName, containerName);
    }
}