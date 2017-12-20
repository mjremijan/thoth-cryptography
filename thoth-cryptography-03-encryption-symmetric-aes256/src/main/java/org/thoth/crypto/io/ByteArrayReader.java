package org.thoth.crypto.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ByteArrayReader {

    protected Path inputFile;

    public ByteArrayReader(Path inputFile) {
        this.inputFile = inputFile;
    }

    public byte[] read() {
        try (
            Scanner scanner
                =  new Scanner(inputFile);

            ByteArrayOutputStream baos
                = new ByteArrayOutputStream();
        ){
            while (scanner.hasNext()) {
                baos.write(Byte.parseByte(scanner.nextLine()));
            }
            
            baos.flush();
            return baos.toByteArray();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
