# Introduction
This directory shows how to access azure storage with python.

# Getting Started
You may want to use this as a starting point for your own project by reusing the code provided in this directory, or you can call the python scripts directly from your local machine.

> Note that the scripts are not linked to a specific azure storage account. The storage account can be set via variable `azure_storage_name`, values might be `msgedcstorage` or `msgmetadatastorage`.

## Usage
### Prerequisites
#### Install the azure-storage-blob package
```bash
pip install azure-storage-blob
```
#### Obtain SAS-Token from msg and set it as environment variable 
bash:
```bash
export SAS_TOKEN="<your SAS token>"
```
powershell:
```powers
$env:SAS_TOKEN="<your SAS token>"
```
### List of all files in a given container
```bash
python list_files_in_container.py <azure_storage_name> <container_name>
```
### Upload a file to a given container in azure storage
```bash 
python upload_asset.py <path_to_local_file> <azure_storage_name> <source_container_name>
```
> Note that the file will not be updated once the file already exists.




