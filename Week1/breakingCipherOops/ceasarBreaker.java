
/**
 * Write a description of ceasarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*; 
import java.util.*;
public class ceasarBreaker {
void countLetters(String string,int[] count){
for(int i=0;i<string.length();i++)
   if( Character.isLetter(string.charAt(i)))
      count[Character.toLowerCase(string.charAt(i))-'a']++;
}
  int  indexOfMax (int [] counts){
    int max=0;
    int maxIndex=0;
    for(int i=0;i<counts.length;i++){
    if(counts[i]>max)
       {
        max=counts[i];
        maxIndex=i;
        }
       
    
    }
    return maxIndex;
    }
    
   String halfOfString (String str,int start){
    String newstr="";
    for(int i=start;i<str.length();i=i+2){
    newstr=newstr+str.charAt(i);
    }
    return newstr;
    } 
   String decrypt(String msg){
    cesarCipher cc=new cesarCipher();
    int [] freq=new int[26];
    countLetters(msg,freq);
    int maxKey=indexOfMax(freq);
    int dkey=maxKey-4;
    if(maxKey<4)
       dkey=26-(4-maxKey);
       
    System.out.println("key;"+dkey);   
    return cc.encrypt(msg,26-dkey);
    
    
    } 
       String decryptTwoKeys(String msg){
           String p1=halfOfString(msg,0);
            String p2=halfOfString(msg,1);
             System.out.println(decrypt(p1));
             System.out.println(decrypt(p2));
              String s1=decrypt(p1);
              String s2=decrypt(p2);
              String newstr="";
        for(int i=0;i<s1.length();i++){
             if(i<s2.length())
               {
                newstr=newstr+s1.charAt(i);
                newstr=newstr+s2.charAt(i);
                }
               else
                 newstr=newstr+s1.charAt(i);
                 
    }
    System.out.println("Ans :"+newstr);
    return newstr;
    } 
  void testDecrypt(){
   FileResource fr= new FileResource();  
   String sr=fr.asString();
   System.out.println(sr);
    cesarCipher cc=new cesarCipher();
    String ecr=cc.encrypt(sr,3);
     System.out.println(ecr);
     System.out.println(decrypt(ecr));
    //int [] count= new int[26];
    //countLetters("aaaaaaaaaaaammmmmmmmmmmmmmmmzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz",count);
    //System.out.println((char)('a'+indexOfMax(count)));
    }  
    
}
