package filemanager;

import java.io.*;
import java.util.*; //used to include scanner

/**
 * @author SCTPL
 */

public class MenuMain {
    public static void main(String args[]) throws IOException {
        //declare a scanner for user Input
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        //switch the choice from user
        String strInputFile = "";
        String content="";
try{
       File file=new File("D://java//log.txt");
     FileWriter fw=new FileWriter(file); 
	    
            BufferedWriter bw=new BufferedWriter(fw); 

        do {
            //display our selection menu
            System.out.println("*** Welcome To File Management System ***");
            System.out.println("1. Create file");
            System.out.println("2. Rename file");
            System.out.println("3. Delete file");
            System.out.println("4. Create directory");
            System.out.println("5. Rename directory");
            System.out.println("6. Delete directory");
            System.out.println("7. View Files in a Directory");
            System.out.println("8. Copy File");
            System.out.println("9. Encrypt");
            System.out.println("10. Decrypt");
            System.out.println("11. Compress");
            System.out.println("12. Decompress");
            System.out.println("13. Folder Compression");
			System.out.println("14. Exit");
            System.out.println("**********************************************");
            System.out.println("Please enter your choice:");
			
            //get user input
            choice = scanner.nextInt();
            scanner = new Scanner(System.in);
            switch (choice) {
                case 1:
                    //  prompt to get file path
                    System.out.println("Enter the file path where you want to create the file ");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    //prompt user
                    System.out.println("Enter the content :");
                    // get their input as a String
                    String strContent = scanner.nextLine();

                    FileUtility.createFile(strInputFile, strContent);
            
            //log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File Created! ";

	    
                       
            
            
            
                    break;

                case 2:
                    //  prompt to get file path
                    System.out.println("Enter the file path where you want to rename the file ");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    //  prompt to get file path
                    System.out.println("Enter the new name of a file with extension ex : testing.txt");
                    // get their input as a String
                    String strNewFileName = scanner.nextLine();

                    FileUtility.reNameFile(strInputFile, strNewFileName);

//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+=" File Renamed!\n";

	    
                       
            
            
            

                    break;

                case 3:
                    //  prompt to get file path
                    System.out.println("Enter the file path that you want to delete");
                    // get their input as a String
                    strInputFile = scanner.nextLine();

                    FileUtility.deleteFile(strInputFile);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File Deleted!\n";

	    
                       
            
            bw.flush();
            

                    break;

                case 4:
                    //  prompt to get file path
                    System.out.println("Enter the directory that you want to create");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    FileUtility.createDirectory(strInputFile);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="Directory Created!\n";

	    
                       
            
            bw.flush();
            

                    break;
                case 5:
                    //  prompt to get file path
                    System.out.println("Enter the directory that you want to rename");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    //  prompt to get file path
                    System.out.println("Enter the new name(not path) of a directory  ex : Sid : ");
                    // get their input as a String
                    String strNewDirectoryName = scanner.nextLine();
                    FileUtility.reNameDirectory(strInputFile, strNewDirectoryName);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="Directory Renamed!\n";

	    
                       
            
            
            

                    break;
                case 6:
                    //  prompt to get file path
                    System.out.println("Enter the directory that you want to delete");
                    // get their input as a String
                    strInputFile = scanner.nextLine();

                    FileUtility.deleteDirectory(strInputFile);

//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="Directory Deleted!\n";

	    
                       
            
            
            

                    break;

                case 7:
                    //  prompt to get file path
                    System.out.println("Enter the directory that you want to view");
                    // get their input as a String
                    strInputFile = scanner.nextLine();

                    FileUtility.listFilesFromDirectory(strInputFile);

//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="Directory Viewed!\n";

	    
                       
            
            
            

                    break;

                case 8:
                    //  prompt to get file path
                    System.out.println("Enter the file path that you want to copy");
                    // get their input as a String
                    String strinput= scanner.nextLine();
                    System.out.println("Enter the path where you want to paste the selected file ");
                    String stroutput= scanner.nextLine();
                    File strInputFil=new File(strinput);
                    File strOutputPat=new File(stroutput);   
                    FileUtility.copyFolder(strInputFil, strOutputPat);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File//Directory Pasted!\n";

	    
                       
            
            
            


                    break;
                

case 9:
                    //  prompt to get file path
                    System.out.print("\nEnter the file path that you want to encrypt : ");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    System.out.println("Enter encryption key: ");
                    String ekey=scanner.nextLine();
                    FileUtility.encryptFile(strInputFile,ekey);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File Encrypted!\n";            

                    break;

                case 10:

                    //  prompt to get file path
                    System.out.print("\nEnter the file path that you want to Decrypt : ");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    System.out.println("Enter Decryption key: ");
                    String dkey=scanner.nextLine();
                    FileUtility.decryptFile(strInputFile,dkey);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File Decrypted!\n";

	    
                       
            
            
            

                    break;


                case 11:
                    //  prompt to get file path
                    System.out.print("\nEnter the file path that you want to Compress : ");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    FileUtility.compressFile(strInputFile);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File Compressed!\n";

	    
                       
            
            
            

                    break;

          case 12:
                    //  prompt to get file path
                    System.out.print("\nEnter the file path that you want to Decompress : ");
                    // get their input as a String
                    strInputFile = scanner.nextLine();
                    FileUtility.decompress(strInputFile);
//log code 
            
            if (!file.exists()) {
                file.createNewFile();
            } 

            content+="File Decompressed!\n";

	    
                       
            
            
            

                    break;

case 13:
System.out.println("Enter the folder you want to compress: ");
String folderpath=scanner.nextLine();
int i=0;
File filex=new File(folderpath);
String[] fileslist=new String[50];
if(filex.isDirectory())
{
File[] files = filex.listFiles();
        for(File filexx : files){
            if(filexx.isFile()){ fileslist[i]=filexx.getAbsolutePath();
              i++;
        }

FileUtility.zipDirectory(filex,fileslist);
}
}
else
{
System.out.println("It is not a directory!");
}
break;

                case 14://exit
                    System.out.println("Exit....!");
                    break;
                default://default
                    System.out.println("You entered an invalid choice");
            }
        } while (choice != 14);
bw.write(content);
bw.flush();
bw.close();
}
catch(NullPointerException np)
{
	System.out.println("Folder zipped successfully");
}

catch(Exception e){System.out.println("Invalid choice");}


    }//main

}//class