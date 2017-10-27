package org.thoth.security.algorithm;

import java.security.Provider;
import java.security.Security;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class AlgorithmList {

    public static void main(String[] args) throws Exception {
        for (Provider provider : Security.getProviders()) {
            System.out.printf("PROVIDER: %s%n",provider.getName());
            for (Provider.Service service : provider.getServices())  {
                System.out.printf("     ALGORITHM: \"%s\"%n", service.getAlgorithm());
            }
            System.out.printf("%n");
        }
    }
}
