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
    void test(){
    FileResource fr = new FileResource ();
    String msg = fr.asString();
    int [] k  = tryKeyLength(msg,5,'e');
    for(int i=0;i<5;i++)
      System.out.println(k[i]);
    VigenereCipher vc = new VigenereCipher(k);
    String decrypt = vc.decrypt(msg);
     System.out.println(decrypt);
    }
    
}
