
/**
 * Write a description of cesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cesarCipher {
String encrypt(String input,int key){
 StringBuilder encrypted= new StringBuilder();
 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);   ;
 
 return shiftedAlphabet;
 
}
}
