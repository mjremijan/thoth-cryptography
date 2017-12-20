package org.thoth.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class ByteArrayWriter {

    protected Path outputFile;

    public ByteArrayWriter(Path outputFile) {
        this.outputFile = outputFile;
    }

    public void write(byte[] bytesArrayToWrite) {
        try (
            OutputStream os
                = Files.newOutputStream(outputFile);

            PrintWriter writer
                =  new PrintWriter(os);
        ){
            for (int i=0; i<bytesArrayToWrite.length; i++) {
                if (i>0) {
                    writer.println();
                }
                writer.print(bytesArrayToWrite[i]);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
