package org.thoth.security.hash.sha512;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // http://www.convertstring.com/Hash/SHA512
        // http://www.lorem-ipsum.co.uk/hasher.php
        // http://passwordsgenerator.net/sha512-hash-generator/
        //   - NOTE: with this website there is no 'salt' option.  So instead I concatinated username + password
        // https://hash.online-convert.com/sha512-generator
        //   - NOTE: with this website there is no 'salt' option.  So instead I concatinated username + password
        System.out.printf("WEBSITE%n");
        System.out.printf("     HEX = %s%n", "F38CD5290D11B20159E36740843A8D93CFDFA395CF594F328613EF5C7BA42D9EAC00BF3EE47B7E8CE1587040B36365F05C8E15E9392C288A1D7C4CFB66097848".toUpperCase());
        System.out.printf("  Base64 = %s%n", "84zVKQ0RsgFZ42dAhDqNk8/fo5XPWU8yhhPvXHukLZ6sAL8+5Ht+jOFYcECzY2XwXI4V6TksKIodfEz7Zgl4SA==");

        String username = "mjremijan";
        String password = "super!secret";

        System.out.printf("SHA512%n");
        System.out.printf("     HEX = %s%n", new SHA512().hashToHex(password, username));
        System.out.printf("  Base64 = %s%n", new SHA512().hashToBase64(password, username));
    }
}
