# thoth-security-encryption-symmetric-aes256

## Area of Research

Create AES-256 encryption/decryption functionality with a secret key that
is able to be persisted and re-used by the application.

## AES mode and padding

https://security.stackexchange.com/questions/52665/which-is-the-best-cipher-mode-and-padding-mode-for-aes-encryption

> In general, stick with CBC or CTR, with PKCS#7 where necessary (you don't 
> need padding on stream cipher modes) and use an authenticity check 
> (HMAC-SHA256 for example) on the ciphertext. Both CBC and CTR come 
> recommended by Niels Ferguson and Bruce Schneier, both of whom are 
> respected cryptographers.
> 
> That being said, there are new modes! EAX and GCM have recently been 
> given a lot of attention. GCM was put into the TLS 1.2 suite and fixes 
> a lot of problems that existed in CBC and stream ciphers. The primary 
> benefit is that both are authenticated modes, in that they build the 
> authenticity checks into the cipher mode itself, rather than having 
> to apply one separately. This fixes some problems with padding oracle
> attacks and various other trickery. These modes aren't quite as simple 
> to explain (let alone implement) but they are considered to be very strong.

## References

https://www.veracode.com/blog/research/encryption-and-decryption-java-cryptography

https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Cipher

https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html#Cipher

http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html

https://github.com/1MansiS/java_crypto/blob/master/cipher/SecuredGCMUsage.java

