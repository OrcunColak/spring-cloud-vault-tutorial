# Readme

The original idea is from  
https://medium.com/@eminyildiz122/vault-spring-boot-integration-5e137b2ff79c

# Vault Installation

Go to
http://localhost:8200/ui/vault

# Download keys Step

Click the "Download keys" button. A JSON file will be downloaded.

# Unseal Step

1. Open the JSON file
2. Enter 3 under the "keys_base64" keys object into vault screen one by one
3. Enter the "root_token" into token screen.

Your data is encrypted and the encryption key is stored in Vault’s keyring along with all other keys.
The keyring is encrypted with a root key.
The root encryption key is encrypted with the unseal key.

In order for us to access our data, we need the unseal key, which gives us access to the root key, which gives us access
to, what I will call, the final key that decrypts our data!

# Vault Secrets

Secrets it can manage include:

Key/Value pairs
Passwords
Certificates
Encryption keys

# KV Engine
Click "Enable new Engine"

# Vault Deployment Options

Vault can be deployed in a number of ways:

A standalone instance for development and exploration purposes
A single instance backed by a Persistent Volume
As a cluster of instances (normally 3 or 5 nodes)