package org.thoth.security.symmetric.aes256;

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
//            for (String key : provider.stringPropertyNames()) {
//                System.out.printf("     key=\"%s\", property=\"%s\"%n", key, provider.getProperty(key));
//            }
            for (Provider.Service service : provider.getServices())  {
                System.out.printf("     algorithm=\"%s\"%n", service.getAlgorithm());
            }
        }
    }
}
