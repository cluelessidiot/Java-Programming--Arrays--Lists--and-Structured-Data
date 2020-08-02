import java.util.*;
import edu.duke.*;
import java.io.*;  
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
    void a(){
    String s="sss";
    for(int i=0;i<s.length();i++){
        char q= s.charAt(i); 
        System.out.println(q-'a');
    }
    }
    char mostCommonCharIn(HashSet<String> dict){
    int [] a= new int [26];
    for (String s : dict) {
        s=s.toLowerCase();
       // System.out.println(s);
      for(int i=0;i<s.length();i++){
        char q= s.charAt(i); 
        //System.out.println(q);
        if(q<='z' && q>='a')
        a[q-'a']++;
    }
    }
    int ct=0;
    int index=0;
    for(int i=0;i<26;i++){
    if(a[i]>ct){
    ct=a[i];
    index=i;
    }
    }
    char f=(char)('a'+ index);
    return f;
    }
     void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> languages){
        int cmax=0;
        String elang="";
        String d="";
        char cchar='a';
        
         for(String lang:languages.keySet()){
           HashSet<String> dict = languages.get(lang);
            char cw = mostCommonCharIn(dict);
            String decr = breakForLanguage(encrypted,dict,cw,lang);
            int countWord = countWords(decr,dict);
            if(countWord>cmax){
            cmax=countWord;
            elang=lang;
            d=decr;
            cchar=cw;
            }
        }
         System.out.println(elang+" language words no: "+cmax+"common char is "+cchar);
         System.out.println(d.substring(0, 100));
        }
    public void breakVigenere () {
        FileResource fr = new FileResource ();
        String msg = fr.asString();
        HashSet<String> dict;
       // fr = new FileResource ();
       HashMap<String,HashSet<String>> mdict = new HashMap<String,HashSet<String>>();
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           FileResource fr1 = new FileResource (f);
           String fname = f.getName();
            dict = readDictionary(fr1);
           mdict.put(fname,dict);
       }
       breakForAllLangs(msg,mdict);
       // HashSet <String> dict = readDictionary(fr);
        //String decr = breakForLanguage(msg,dict);
       // String s =decr.Split(new [] { '\r', '\n' }).FirstOrDefault();
       // System.out.println(decr.substring(0, 100));
    }
    HashSet readDictionary(FileResource fr){
    HashSet <String> dict = new HashSet <String> ();
    for (String line : fr.lines()) {
    //System.out.println("D  "+line);
        dict.add(line.toLowerCase());
    
    }
    return dict;
    }
    String breakForLanguage(String encrypted,HashSet<String> dict,char common,String lang){
    int maxKeyLength = 1;
    int wordCount = 0;
    String origMessage="";
    int [] q;
    for(int i=1;i<=100;i++){
    int [] k  = tryKeyLength(encrypted,i,common);
    VigenereCipher vc = new VigenereCipher(k);
    String decrypt = vc.decrypt(encrypted);
    if(countWords(decrypt,dict)>wordCount){
      maxKeyLength = i;
      wordCount = countWords(decrypt,dict);
      origMessage = decrypt;
    }
    
    }
    int [] k=tryKeyLength(encrypted,maxKeyLength,common);
    System.out.println(wordCount+"  WC  "+maxKeyLength+"  "+k[0]+" "+k[1]+" "+lang);
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
