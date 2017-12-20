# thoth-security-02-hash-sha512

## Area of Research

How to do a SHA-512 hash with a salt.

Research shows the most common way generate a hash with a value and a salt is to first concatenate `toBeHashed + salt` and then hash.

Research was conducted on the following sites to verify the Java code is generating a correct hash:

* http://www.convertstring.com/Hash/SHA512
* http://www.lorem-ipsum.co.uk/hasher.php
* http://passwordsgenerator.net/sha512-hash-generator/ 
    - NOTE: with this website there is no 'salt' option.  So instead I concatinated `toBeHashed + salt`
* https://hash.online-convert.com/sha512-generator
    - NOTE: with this website there is no 'salt' option.  So instead I concatinated `toBeHashed + salt`
     