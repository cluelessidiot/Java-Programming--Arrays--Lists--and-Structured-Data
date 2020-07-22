
/**
 * Write a description of cesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class cesarCipher {
String encrypt(String input,int key){
 StringBuilder encrypted= new StringBuilder(input);
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);   
 for(int i=0;i<encrypted.length();i++){
     int flag=0;
     char currChar = encrypted.charAt(i);
     if(currChar>='a' && currChar<='z'){
          currChar=Character.toUpperCase(currChar);
          flag=1;
          
        }
     int pos= alphabet.indexOf(currChar);
     if(pos!=-1){
     char replChar = shiftedAlphabet.charAt(pos);
     if(flag==0)
        encrypted.setCharAt(i,replChar);
        
    else
        encrypted.setCharAt(i,Character.toLowerCase(replChar));
    }
    }
 return encrypted.toString();
 
}
String encryptTwoKeys(String input,int key1,int key2){
 StringBuilder encrypted= new StringBuilder(input);
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1); 
 String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
 for(int i=0;i<encrypted.length();i++){
     int flag=0;
     char replChar;
     char currChar = encrypted.charAt(i);
     if(currChar>='a' && currChar<='z'){
          currChar=Character.toUpperCase(currChar);
          flag=1;
          
        }
     int pos= alphabet.indexOf(currChar);
     if(pos!=-1){
     if(i%2==0)    
        replChar = shiftedAlphabet1.charAt(pos);
     else
        replChar = shiftedAlphabet2.charAt(pos);
     if(flag==0)
        encrypted.setCharAt(i,replChar);
        
    else
        encrypted.setCharAt(i,Character.toLowerCase(replChar));
    }
    }
 return encrypted.toString();
 
}
void testCaesar(){
 //int key=17;
 //FileResource fr = new FileResource();
 //String message = fr.asString();

 System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
  System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));

 

}
}
