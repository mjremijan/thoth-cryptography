# thoth-security

Research and Development on security (Hashing, Encryption, etc.)

## Areas of Research

The list of sub-modules and the research they cover.

### thoth-security-01-cipher-algorithm-list

Print all the algorithm names supported by the JVM.  This is what is passed to `Cipher.getInstance("algorithm")`.

### thoth-security-01-provider-list

Print the names of all the security providers that are part of the JVM.

### thoth-security-02-hash-sha512

How to do a SHA-512 hash with a salt.  

### thoth-security-03-encryption-symmetric-aes

How to do a simple AES encryption relying on defaults for all configuration...never use this code!

### thoth-security-03-encryption-symmetric-aes256

How to do a encryption using AES/GCM/PKCS5Padding, with a 256 bit key, and a 96 bit IV.  
The Java Cryptography Extension (JCE) Unlimited Strength is required to be installed for this.

Enjoy!

