package org.thoth.security.hash.sha512;

import org.apache.commons.codec.digest.Crypt;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String username = "mjremijan";
        String password = "super!secret";

        System.out.printf("Stackoverflow1 HEX = %s%n", new Stackoverflow1().get_SHA_512_SecurePassword(password, username));
        System.out.printf("GithubGist1    HEX = %s%n", new GithubGist1().getSHA512(password, username));
        System.out.printf("Mkyong1        HEX = %s%n", new Mkyong1().hash(password, username));
        System.out.printf("Mkyong2        HEX = %s%n", new Mkyong2().hash(password, username));
        System.out.printf("Crypt          HEX = %s%n", Crypt.crypt(password, username));

        // http://www.convertstring.com/Hash/SHA512
        System.out.printf("WEBSITE1       HEX = %s%n", "F38CD5290D11B20159E36740843A8D93CFDFA395CF594F328613EF5C7BA42D9EAC00BF3EE47B7E8CE1587040B36365F05C8E15E9392C288A1D7C4CFB66097848");
        // http://www.lorem-ipsum.co.uk/hasher.php
        System.out.printf("WEBSITE2       HEX = %s%n", "f38cd5290d11b20159e36740843a8d93cfdfa395cf594f328613ef5c7ba42d9eac00bf3ee47b7e8ce1587040b36365f05c8e15e9392c288a1d7c4cfb66097848".toUpperCase());
        // http://passwordsgenerator.net/sha512-hash-generator/
        //   - NOTE: with this website there is no 'salt' option.  So instead I concatinated username + password
        System.out.printf("WEBSITE3       HEX = %s%n", "F38CD5290D11B20159E36740843A8D93CFDFA395CF594F328613EF5C7BA42D9EAC00BF3EE47B7E8CE1587040B36365F05C8E15E9392C288A1D7C4CFB66097848".toUpperCase());
        // https://hash.online-convert.com/sha512-generator
        //   - NOTE: with this website there is no 'salt' option.  So instead I concatinated username + password
        System.out.printf("WEBSITE4       HEX = %s%n", "F38CD5290D11B20159E36740843A8D93CFDFA395CF594F328613EF5C7BA42D9EAC00BF3EE47B7E8CE1587040B36365F05C8E15E9392C288A1D7C4CFB66097848".toUpperCase());
        System.out.printf("            Base64 = %s%n", "84zVKQ0RsgFZ42dAhDqNk8/fo5XPWU8yhhPvXHukLZ6sAL8+5Ht+jOFYcECzY2XwXI4V6TksKIodfEz7Zgl4SA==");

        System.out.printf("Stackoverflow2 HEX = %s%n", new Stackoverflow2().get_SHA_512_SecurePassword_asHex(password, username));
        System.out.printf("            Base64 = %s%n", new Stackoverflow2().get_SHA_512_SecurePassword_asBase64(password, username));
    }
}
