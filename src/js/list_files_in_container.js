const { BlobServiceClient } = require('@azure/storage-blob');

async function listFilesInContainer(sasToken, azureStorageName, containerName) {
    try {
        const blobServiceClient = new BlobServiceClient(`https://${azureStorageName}.blob.core.windows.net?${sasToken}`);
        const containerClient = blobServiceClient.getContainerClient(containerName);

        console.log(`Files in container '${containerName}':`);
        for await (const blob of containerClient.listBlobsFlat()) {
            console.log(blob.name);
        }
    } catch (error) {
        console.error(`Error listing files in the container: ${error.message}`);
    }
}

if (process.argv.length !== 4) {
    console.log('Usage: node list_files_in_container.js <azure_storage_name> <container_name>');
    process.exit(100);
}

const azureStorageName = process.argv[2];
const containerName = process.argv[3];
const sasToken = process.env.SAS_TOKEN;

if (!sasToken) {
    console.error('SAS token not found in environment variable SAS_TOKEN.');
    process.exit(101);
}

listFilesInContainer(sasToken, azureStorageName, containerName);