# thoth-security

Research and Development on security (Hashing, Encryption, etc.)

Areas of Research
------------------

* **thoth-security-01-cipher-algorithm-list** - Print all the algorithm names supported
by the JVM.  This is what is passed to `Cipher.getInstance("algorithm")`.

* **thoth-security-01-provider-list** - Print the names of all the security providers that
are part of the JVM.

* **thoth-security-01-hash-sha512** - How to do a SHA-512 hash with a salt.  
Research shows the most common way is to concatenate `toBeHashed + salt` and then hash.

** AES Algorithms **

PROVIDER: SunJCE
     ALGORITHM: "AES"
     ALGORITHM: "AES_128/ECB/NoPadding"
     ALGORITHM: "AES_128/CBC/NoPadding"
     ALGORITHM: "AES_128/OFB/NoPadding"
     ALGORITHM: "AES_128/CFB/NoPadding"
     ALGORITHM: "AES_128/GCM/NoPadding"
     ALGORITHM: "AES_192/ECB/NoPadding"
     ALGORITHM: "AES_192/CBC/NoPadding"
     ALGORITHM: "AES_192/OFB/NoPadding"
     ALGORITHM: "AES_192/CFB/NoPadding"
     ALGORITHM: "AES_192/GCM/NoPadding"
     ALGORITHM: "AES_256/ECB/NoPadding"
     ALGORITHM: "AES_256/CBC/NoPadding"
     ALGORITHM: "AES_256/OFB/NoPadding"
     ALGORITHM: "AES_256/CFB/NoPadding"
     ALGORITHM: "AES_256/GCM/NoPadding"
     ALGORITHM: "AESWrap"
     ALGORITHM: "AESWrap_128"
     ALGORITHM: "AESWrap_192"
     ALGORITHM: "AESWrap_256"
     ALGORITHM: "AES"     

https://security.stackexchange.com/questions/52665/which-is-the-best-cipher-mode-and-padding-mode-for-aes-encryption

In general, stick with CBC or CTR, with PKCS#7 where necessary (you don't 
need padding on stream cipher modes) and use an authenticity check 
(HMAC-SHA256 for example) on the ciphertext. Both CBC and CTR come 
recommended by Niels Ferguson and Bruce Schneier, both of whom are 
respected cryptographers.

That being said, there are new modes! EAX and GCM have recently been 
given a lot of attention. GCM was put into the TLS 1.2 suite and fixes 
a lot of problems that existed in CBC and stream ciphers. The primary 
benefit is that both are authenticated modes, in that they build the 
authenticity checks into the cipher mode itself, rather than having 
to apply one separately. This fixes some problems with padding oracle
attacks and various other trickery. These modes aren't quite as simple 
to explain (let alone implement) but they are considered to be very strong.

Enjoy!

