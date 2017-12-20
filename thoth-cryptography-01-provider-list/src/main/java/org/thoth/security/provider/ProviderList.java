package org.thoth.security.provider;

import java.security.Provider;
import java.security.Security;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ProviderList {

    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.printf("%s%n",provider.getName());
        }
    }
}
