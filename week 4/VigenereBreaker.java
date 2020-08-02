import java.util.*;
import edu.duke.*;
import java.io.StringReader;  
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
        FileResource fr = new FileResource ();
        String msg = fr.asString();
        fr = new FileResource ();
        HashSet <String> dict = readDictionary(fr);
        String decr = breakForLanguage(msg,dict);
       // String s =decr.Split(new [] { '\r', '\n' }).FirstOrDefault();
        System.out.println(decr.substring(0, 100));
    }
    HashSet readDictionary(FileResource fr){
    HashSet <String> dict = new HashSet <String> ();
    for (String line : fr.lines()) {
    dict.add(line.toLowerCase());
    
    }
    return dict;
    }
    String breakForLanguage(String encrypted,HashSet<String> dict){
    int maxKeyLength = 1;
    int wordCount = 0;
    String origMessage="";
    int [] q;
    for(int i=1;i<=100;i++){
    int [] k  = tryKeyLength(encrypted,i,'e');
    VigenereCipher vc = new VigenereCipher(k);
    String decrypt = vc.decrypt(encrypted);
    if(countWords(decrypt,dict)>wordCount){
      maxKeyLength = i;
      wordCount = countWords(decrypt,dict);
      origMessage = decrypt;
    }
    
    }
    int [] k=tryKeyLength(encrypted,maxKeyLength,'e');
    System.out.println(wordCount+"  WC  "+maxKeyLength+"  "+k[0]+" "+k[1]);
    return  origMessage;
    }
     int countWords(String message,HashSet<String> dict){
        String [] split = message.split("\\W+");
        int ct = 0;
        for(int i=0;i<split.length;i++){
          if(dict.contains(split[i].toLowerCase()))
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
