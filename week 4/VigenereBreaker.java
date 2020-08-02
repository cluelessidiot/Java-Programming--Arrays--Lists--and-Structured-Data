import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String a="";
        for(int i=whichSlice;i<message.length();i=i+totalSlices){
        a=a+message.charAt(i);
        }
        return a;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        for(int i=0;i<klength;i++){
        String spEncrypted = sliceString(encrypted,i,klength);
        CaesarCracker cc = new CaesarCracker(mostCommon); 
        key[i] = cc.getKey(spEncrypted);
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    HashSet readDictionary(FileResource fr){
    HashSet <String> dict = new HashSet <String> ();
    for (String line : fr.lines()) {
    dict.add(line.toLowerCase());
    
    }
    return dict;
    }
     int countWords(String message,HashSet<String> dict){
        String [] split = message.split("\\W+");
        int ct = 0;
        for(int i=0;i<split.length;i++){
          if(dict.contains(split[i]))
               ct++;        
        
        }
        return ct;
        }
    
    void test(){
    FileResource fr = new FileResource ();
    String msg = fr.asString();
    int [] k  = tryKeyLength(msg,4,'e');
    for(int i=0;i<4;i++)
      System.out.println(k[i]);
    VigenereCipher vc = new VigenereCipher(k);
    String decrypt = vc.decrypt(msg);
     System.out.println(decrypt);
    }
    
}
