package org.thoth.security.hash;

import org.thoth.security.hash.Sha512;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Sha512Test {

    @Test
    public void test_hash_to_hex() throws Exception {
        // setup
        String username = "mjremijan";
        String password = "super!secret";
        Sha512 sha = new Sha512();

        // test
        String asHex
            = sha.hashToHex(password, username);

        // assert
        Assert.assertEquals(
              "F38CD5290D11B20159E36740843A8D93CFDFA395CF594F328613EF5C7BA42D9EAC00BF3EE47B7E8CE1587040B36365F05C8E15E9392C288A1D7C4CFB66097848"
            , asHex);
    }


    @Test
    public void test_hash_to_base64() throws Exception {
        // setup
        String username = "mjremijan";
        String password = "super!secret";
        Sha512 sha = new Sha512();

        // test
        String asBase64
            = sha.hashToBase64(password, username);

        // assert
        Assert.assertEquals(
              "84ZVKQ0RSGFZ42DAHDQNK8/FO5XPWU8YHHPVXHUKLZ6SAL8+5HT+JOFYCECZY2XWXI4V6TKSKIODFEZ7ZGL4SA=="
            , asBase64);
    }
}
