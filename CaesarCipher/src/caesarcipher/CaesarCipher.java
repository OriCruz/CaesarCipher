package caesarcipher;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author oriana.cruz
 */
public class CaesarCipher {

    public static void main(String[] args) {
        // variables
        Scanner scan = null;
        File password = new File ("NewWords.txt");//Insert name of the Encrypted words here 
        int shift = 5;
        String pass = "";
        
        //Try & Catch
        try{
            scan = new Scanner(password);
            System.out.println(password+" File found & opened!");
        }
        catch(FileNotFoundException fne){
            System.out.println(password+" File not found");
            System.exit(0);
        }
        System.out.println("***Decrpypted***");
        //Read in all info the file has 
        while(scan.hasNext())
        {
            pass = scan.nextLine().toLowerCase();      
            System.out.println(decrypt(pass, shift));
        }
        scan.close();
    }
        
    //Decryption Method & Algorithm
    public static String decrypt(String pass, int shift){
        //Variables
        char [] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String decrypted="";
        int letterPos;
        char currentChar;
        int sub; 
        
        //loop through the length of the password
        for (int i = 0; i < pass.length(); i++) {
            //CurrentChar set to the iTH position  
            currentChar = pass.charAt(i);
            //letterPos is set to the index of the current char within the given array
            letterPos = String.valueOf(letters).indexOf(currentChar);
            //Difference (Getting the char decrypted)
            sub = letterPos - shift;
           
            //Control Stucture to "Restart" the alphabet from Z[25] after A[0] is run but has negative remainder
            if(sub<0){
                //26-shift becuase the alphabet's length is 26, in oder cases change to the length of that. 
               decrypted += (char)(currentChar + (26-shift)); 
            }
            else{
                //Add the shifted number to a string 
                decrypted += letters[sub];
            }
        }
        return decrypted;
    }
}