import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobItem;

public class ListFilesInContainer {

    public static void listFilesInContainer(final String sasToken, final String azureStorageName,
                                            final String containerName) {
        try {
            // Create a Blob Service Client
            final BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .endpoint("https://" + azureStorageName + ".blob.core.windows.net")
                    .sasToken(sasToken)
                    .buildClient();

            // Create a Container Client
            final BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

            // List all blobs in the container
            System.out.println("Files in container '" + containerName + "':");
            for (final BlobItem blobItem : containerClient.listBlobs()) {
                System.out.println(blobItem.getName());
            }
        } catch (final Exception e) {
            System.out.println("Error listing files in the container: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ListFilesInContainer <azure_storage_name> <container_name>");
            System.exit(100);
        }

        // Azure storage account name from command line argument
        final String azureStorageName = args[0];

        // Container name from command line argument
        final String containerName = args[1];

        // Retrieve SAS token from environment variable
        final String sasToken = System.getenv("SAS_TOKEN");
        if (sasToken == null) {
            System.out.println("SAS token not found in environment variable SAS_TOKEN.");
            System.exit(101);
        }

        // List files in the container
        listFilesInContainer(sasToken, azureStorageName, containerName);
    }
}