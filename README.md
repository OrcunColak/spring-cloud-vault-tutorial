# Readme

The original idea is from  
https://medium.com/@eminyildiz122/vault-spring-boot-integration-5e137b2ff79c

After the "Download key" step

1. Enter 3 keys_base64 keys into vault screen one by one
2. root_token is used for login

Your data is encrypted and the encryption key is stored in Vault’s keyring along with all other keys.
The keyring is encrypted with a root key.
The root encryption key is encrypted with the unseal key.

In order for us to access our data, we need the unseal key, which gives us access to the root key, which gives us access
to, what I will call, the final key that decrypts our data!

# Vault

Go to

http://localhost:8200/ui/vault/auth?with=token

# Vault Secrets

Secrets it can manage include:

Key/Value pairs
Passwords
Certificates
Encryption keys

# Vault Deployment Options

Vault can be deployed in a number of ways:

A standalone instance for development and exploration purposes
A single instance backed by a Persistent Volume
As a cluster of instances (normally 3 or 5 nodes)