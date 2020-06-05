package sctpl.javaInternship.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author SCTPL
 * A  class that encrypts or decrypts a file.
 */
public class EncryptDecrypt {
    private static final String key = "zxcvbnmasdfghjkl";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encryptFile(File inputFile, File outputFile) {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            //initialize the cipher
            
            //set the mode
            

            //read the file
            
			
            
			//get enc file into byte
            
			
            //write the bytes to the location
            
			
            
			//close the streams
            
			
			
            //show message
            System.out.print("\nFile has been encrypted successfully..!\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void decryptFile(File inputFile,
                                   File outputFile) {
        try {

            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            
			//initialize the cipeher
            
            
			//set the mode
            
            
			//read the file
            
			
            
			//get enc file into byte
            
            
			//write the bytes to the location
            
			
            
			//close the streams
            inputStream.close();
            outputStream.close();
            
			//show message
            System.out.print("\nFile has been decrypted successfully..!\n");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}