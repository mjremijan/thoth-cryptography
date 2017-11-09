package org.thoth.security.hash;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Sha512Test {

    @Test
    public void test_hash_with_optional_to_hex() throws Exception {
        // setup
        String username = "mjremijan";
        String password = "super!secret";
        Sha512 sha = new Sha512();

        // test
        String asHex
            = sha.hashToHex(password, Optional.of(username));

        // assert
        Assert.assertEquals(
              "F38CD5290D11B20159E36740843A8D93CFDFA395CF594F328613EF5C7BA42D9EAC00BF3EE47B7E8CE1587040B36365F05C8E15E9392C288A1D7C4CFB66097848"
            , asHex);
    }

    @Test
    public void test_hash_without_optional_to_hex() throws Exception {
        // setup
        String password = "super!secret";
        Sha512 sha = new Sha512();

        // test
        String asHex
            = sha.hashToHex(password, Optional.empty());

        // assert
        Assert.assertEquals(
              "516A1FE9D87FE5B953D91B48B1A2FFA5AE5F670914C1B6FE0835D8877918DC4E8BC8FB8CCD520DBA940C21B4F294DFD1B4EFF2E06AB110C6A06E35068251C1DD"
            , asHex);
    }


    @Test
    public void test_hash_with_optional_to_base64() throws Exception {
        // setup
        String username = "mjremijan";
        String password = "super!secret";
        Sha512 sha = new Sha512();

        // test
        String asBase64
            = sha.hashToBase64(password, Optional.of(username));

        // assert
        Assert.assertEquals(
              "84ZVKQ0RSGFZ42DAHDQNK8/FO5XPWU8YHHPVXHUKLZ6SAL8+5HT+JOFYCECZY2XWXI4V6TKSKIODFEZ7ZGL4SA=="
            , asBase64);
    }


    @Test
    public void test_hash_without_optional_to_base64() throws Exception {
        // setup
        String password = "super!secret";
        Sha512 sha = new Sha512();

        // test
        String asBase64
            = sha.hashToBase64(password, Optional.empty());

        // assert
        Assert.assertEquals(
              "UWOF6DH/5BLT2RTISAL/PA5FZWKUWBB+CDXYH3KY3E6LYPUMZVINUPQMIBTYLN/RTO/Y4GQXEMAGBJUGGLHB3Q=="
            , asBase64);
    }
}
