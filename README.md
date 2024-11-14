Uploading files / assets to the azure storage
====

## Introduction
This repository should show you how to browse and upload files to the azure storage. 

## Scripts

Please refer to the readme files in the `src` directory for more information.

To access the azure storage, you need to have an **SAS token**. The SAS token can be requested from the msg team.
> NOTE: Please handle the SAS token with care! Do not share it with unauthorized persons.

### Upload an asset to the azure storage (python)
To programmatically upload an asset to a specific azure storage you can use the provided **python** script `upload_asset.py`. The script is located in the `src/python` directory next to this README file.

### Browse the assets in the azure storage (python)
To list all files in a specific container in the azure storage you can use the provided **python** script `list_files_in_container.py`. The script is located in the `src/python` directory next to this README file.

### Programming examples for Java and JavaScript
You can also find programming examples for **java** (`src/java`) and **JavaScript** (`src/js`) in the corresponding directories.

## Existing storages and containers
Possible supported azure storage names and existing containers are:
- `msgedcstorage` (storage, used for the EDC)
  - `uc1-src`
  - `uc2-src`
  - `uc2-src`
  - `uc1-dest`
  - `uc2-dest`
  - `uc3-dest`
- `msgmetadatastorage` (storage, used for storing videos, images, etc. linked in the metadata of assets)
  - `msg-systems-ag`
  - `triangraphics`

If you need an additional container in the `msgmetadatastorage` please reach out to msg.

Please find additional information regarding the `msgedcstorage` (here)[https://github.com/GAIA-X4PLC-AAD/edc-blockchain-broker/blob/fix/issue53/README_AssetRegistration_Transfer.md]

## License
see [LICENSE](LICENSE) file

## Contribution
see [CONTRIBUTING.md](CONTRIBUTING.md) file


