package filemanager;


import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import java.util.zip.ZipInputStream;


/**
 * @author SCTPL
 */
public class FileUtility {
    // constant variable declaration
    private static final String zipFolder = "D:\\zip folder\\";

    private static final String extractFolder = "D:\\Extracted Files";

    



 private static final String key = "abcdefghijklmnop";
		    private static final String ALGORITHM = "AES";
		    private static final String TRANSFORMATION = "AES";


    //file operations
    public static void createFile(String inputFile, String content) throws IOException {
        try {
            File file = new File(inputFile);
            // if file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //get the file in File writer 
            FileWriter fw=new FileWriter(file); 
            
            //initialize the buffer writter with the file
            BufferedWriter bw=new BufferedWriter(fw);

            
            //write the content in the file
            bw.write(content);

            
            //flush and close the buffer
            bw.flush();
            bw.close();

            System.out.println("File " + inputFile + " has been created successfully..!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void reNameFile(String inputFile, String newFileName) {
        //get the file path in File object
        File file = new File(inputFile);
        //validate the file
        if (file.exists()) {
            String fileDirectory = file.getParent();
            File newName = new File(fileDirectory + "\\" + newFileName);
            //perform rename and check it also
            if (file.renameTo(newName)) {
                System.out.println("File has been Renamed.");
            } else {
                System.out.println("Error in Renaming the file.");
            }
        } else {
            System.out.println("Invalid file path");
        }
    }

    public static void deleteFile(String inputFile) {
        //get the file path in File object
        File file = new File(inputFile);
        //validate the file
        if (file.isFile()) {
            try {
                //delete and check if the opertaion has completed or not
                if(file.delete())
                {
                    System.out.println("File deleted successfully!");
                }
               
                }
             catch(Exception e)
                {
                   System.out.println(e);
                } 
	}
 else
                {
                    System.out.println("Failed to delete file!");
                }   	
    }

    public static void createDirectory(String inputDirectory) {
        //get the file path in File object
        File file = new File(inputDirectory);
        if (file.exists()) {
            System.out.println("The directory is already present");
        } else {
            //use mkdirs() or mkdir() and check its return value
            file.mkdirs();
             System.out.println("Directory Created!");  
        }				
    }

    public static void reNameDirectory(String inputFile, String newDirName) {
        //get the file path in File object
        File file = new File(inputFile);
        if (file.isDirectory()) {
            File newName = new File(file.getParent() + "\\" + newDirName);
            //use renameTo() and check its return value 
            if(file.renameTo(newName))
            {
                  System.out.println("Successfully renamed!");
             }
             else
             {
                  System.out.println("Could not rename the file!");
             }		
			
    }
else{System.out.println("There is no such directory!");}
}

    public static void deleteDirectory(String inputDirectory)throws IOException  {
         String ch;

         Scanner sc=new Scanner(System.in);
        //get the file path in File object
          File file=new File(inputDirectory);
        
		
        //check if its a directory  or not
         if(file.isDirectory())
         {	
        //check if the directory has childs or not
            if (file.list().length == 0) {
                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());
            } else {
        //ask user whether he wants to delete the directory or not
                     
                     System.out.println("\nThere are files in the directory.\nAre you sure you want to delete it? (Y(yes) or N(no)): ");
                     ch=sc.nextLine();
                     switch(ch)
                     {
                      case "Y":
                           Delete(file);
                         break;
 
                      case "N":
                           System.out.println("Your directory is safe!");
                           break;
                      default: System.out.println("Invalid Choice!"); 
                     }
                }  
	}
else{System.out.println("There is no such directory!");}
file.delete();
    }

public static void Delete(File f)throws IOException {
if (f.isDirectory()) {
    for (File c : f.listFiles())
      Delete(c);
  }
try
{
  if (!f.delete())
    System.out.println("Failed to delete file: " + f);
}
catch(Exception e){System.out.println(e);}
}


	

    public static void listFilesFromDirectory(String inputDirectory) {
        //get the file path in File object
        File directory = new File(inputDirectory);
        //check if its a directory  or not
        if (directory.isDirectory()) {
            //check if the directory has childs or not
            if(directory.list().length!=0)
            {
                for(File c:directory.listFiles())
                 {
                      //seperate the files and print [Folder] or [File]
                     if(c.isDirectory())  
                     {System.out.println(c.getAbsolutePath().substring(c.getAbsolutePath().lastIndexOf("\\")+1)+ "    Folder" );}
                     else
                     {System.out.println(c.getAbsolutePath().substring(c.getAbsolutePath().lastIndexOf("\\")+1)+ "    File" );} 
                 }
             }
           else
             {  System.out.println("Directory Empty!");  
            }
        } else {
            System.out.println("Invalid file directory");
        }
    }

	
/*    public static void copyFile(String inputPath, String outputPath) throws IOException {
String ch;

         Scanner sc=new Scanner(System.in);
		InputStream is = null;
        OutputStream os = null;
        File inputFile = new File(inputPath);
             

        if(inputFile.exists())
{
        is=new FileInputStream(inputFile);

        File outputFile = new File(outputPath + "//" + inputFile.getName());
        byte[] buffer=new byte[1024];
        int length;  
	    // Check if same fileName or DirectoryName does not exist
        if(outputFile.exists())
        {
             System.out.println("\nFile with same name exists!\nDo you want to replace file? (Y(yes) or N(no)): ");
             ch=sc.nextLine(); 
             switch(ch)
		{
		case "Y":os=new FileOutputStream(outputFile);
                 while((length=is.read(buffer))>0)
                   {
                       os.write(buffer,0,length);
                    }
                break;
		case "N":
                     System.out.println("Copy Abandoned!");
                      break;
		default:System.out.println("Invalid Choice!");
		}
        }
        else
        {
             os=new FileOutputStream(outputFile);
                 while((length=is.read(buffer))>0)
                   {
                       os.write(buffer,0,length);         
                    }
        }
}
else
{
System.out.println("Selected is not a file!");
}

}*/



public static void copyFolder(File src,File dest)
    	throws IOException{
    	if(src.isDirectory()){

    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from "
                              + src + "  to " + dest);
    		}

    		//list all the directory contents
    		String files[] = src.list();

    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}

    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest);

    	        byte[] buffer = new byte[1024];

    	        int length;
    	        //copy the file content in bytes
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }

    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
    }





public static void zipDirectory(File dir,String[] fileslist) {
        try {
            String pathfolder=dir.getAbsolutePath()+".zip";
            FileOutputStream fos = new FileOutputStream(pathfolder);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(int i=0;i<fileslist.length;i++){
				String filePath=fileslist[i];
                System.out.println("Zipping "+filePath);
                //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                //read the file and write to ZipOutputStream
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    









// --------------

    //Phase 3 of the project : compress - decompress
    public static void compressFile(String inputFile) throws IOException {

        
    try
{
        File file = new File(inputFile);
        String fileNameWithExtension = file.getName();
        String fileName = fileNameWithExtension.substring(0, fileNameWithExtension.lastIndexOf("."));
//make directory if not exists
        if(!file.isDirectory())
        {
          file.mkdirs();
        }      
		

        //perform zip - logic and code explained in the pdf doc  
        ZipOutputStream zip=new ZipOutputStream(new FileOutputStream(fileName+".zip"));
        ZipEntry ze=new ZipEntry(fileNameWithExtension);
        zip.putNextEntry(ze);		      
        FileInputStream fis=new FileInputStream(file);
        final int BUFFER=2048;
        byte[] buffer=Files.readAllBytes(Paths.get(inputFile));
        zip.write(buffer,0,buffer.length);
        zip.closeEntry();
        zip.close();        

		
        System.out.print("\nFile has been compressed successfully..!\n");

}
catch(Exception e){System.out.println("Enter correct path!");}
           
            }

 public static void decompress(String zipFile) {
try
{
File file=new File(zipFile);
FileInputStream fis = new FileInputStream(file);

        // this is where you start, with an InputStream containing the bytes from the zip file
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry entry;
            // while there are entries I process them
        
while ((entry = zis.getNextEntry()) != null) {
      System.out.println("Unzipping: " + entry.getName());

      int size;
      byte[] buffer = new byte[2048];

      FileOutputStream fos = new FileOutputStream(entry.getName());
      BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length);

      while ((size = zis.read(buffer, 0, buffer.length)) != -1) {
        bos.write(buffer, 0, size);
      }
      bos.flush();
      bos.close();
    }
    zis.close();
    fis.close();
  }

catch(Exception e){System.out.println("Enter correct path!");}
}





public static void encryptFile(String inputfile,String ekey) {
 String outputencfile = "D:\\Encrypted Files\\";
		        try {
                            File inputFile=new File(inputfile);
                            
                            if(inputFile.exists() && inputFile.isFile())
                           {
		            Key secretKey = new SecretKeySpec(ekey.getBytes(), ALGORITHM);
		            
		            //initialize the cipher
		            Cipher cipher = Cipher.getInstance("AES");
		            
		            //set the mode
		            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		            //read the file
		            FileInputStream inputStream = new FileInputStream(inputFile);
		            byte[] inputBytes = new byte[(int) inputFile.length()];
		            inputStream.read(inputBytes);
					
		          	//get enc file into byte
		            byte[] outputBytes = cipher.doFinal(inputBytes);
					
		            //write the bytes to the location
		            FileOutputStream outputStream = new FileOutputStream(inputFile);
		            outputStream.write(outputBytes);
		            
					//close the streams
		            inputStream.close();
		            outputStream.close();
		            
		            //show message
		            System.out.println("File has been encrypted successfully...!");
		            System.out.println("The file is safe...");
                           }

else
{
System.out.println("There is no such file!");
}

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		
	public static void decryptFile(String inputfile,String dkey) {
    String outputdecfile = "D:\\Decrypted File\\";


		try {
                       
                            File inputFile=new File(inputfile);
                            
                            if(inputFile.exists() && inputFile.isFile())
                           {
			Key secretKey = new SecretKeySpec(dkey.getBytes(), ALGORITHM);

			//initialize the cipeher
			Cipher cipher = Cipher.getInstance("AES");

			//set the mode
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			//read the file
			FileInputStream inputStream = new FileInputStream(inputFile);
			byte[] inputBytes = new byte[(int) inputFile.length()];
			inputStream.read(inputBytes);

			//get enc file into byte
			byte[] outputBytes = cipher.doFinal(inputBytes);

			//write the bytes to the location
			FileOutputStream outputStream = new FileOutputStream(inputFile);
			outputStream.write(outputBytes);

			//close the streams
			inputStream.close();
			outputStream.close();

			//show message
			System.out.print("\nFile has been decrypted successfully..!\n");
                       }


else
{
System.out.println("There is no such file!");
}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


















} // end of FileUtility class

