# thoth-cryptography

Research and Development on cryptography (Hashing, Encryption, etc.)

## Areas of Research

The list of sub-modules and the research they cover.

### thoth-cryptography-01-cipher-algorithm-list

Print all the algorithm names supported by the JVM.  This is what is passed to `Cipher.getInstance("algorithm")`.

### thoth-cryptography-01-provider-list

Print the names of all the security providers that are part of the JVM.

### thoth-cryptography-02-hash-sha512

How to do a SHA-512 hash with a salt.  

### thoth-cryptography-03-encryption-symmetric-aes256

How to do single key, symmetric, encryption using AES/GCM/PKCS5Padding, with a 256 bit key, and a 96 bit IV.  
The Java Cryptography Extension (JCE) Unlimited Strength is required to be installed for this.

### thoth-cryptography-04-encryption-asymmetric-rsa4096

How to do public/private key, asymmetric, encryption using RSA/ECB/OAEPWithSHA-512AndMGF1Padding, 
with a 4096 bit key.

Enjoy!

