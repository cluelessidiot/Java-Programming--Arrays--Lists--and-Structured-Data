
/**
 * Write a description of WordLength here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*; 
import java.util.*; 
public class WordLength {
 void countWordLengths(FileResource resource,int[] counts ){
     for (String word : resource.words()){
            int wordLength = word.length();
            char currChar = word.charAt(0);
            if (!Character.isLetter(currChar)) wordLength--;
            currChar = word.charAt( word.length()-1);
            if (!Character.isLetter(currChar)) wordLength--;
            if(wordLength>30)
               wordLength=30;
            counts[wordLength]++;   
            System.out.println(" Words of length "+ wordLength +" "+ word);
        }
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
  
 void  testCountWordLengths(){
    FileResource fr= new FileResource();
    int[] count=new int[31];
    countWordLengths(fr,count);
    System.out.println(indexOfMax(count));
    //String fileContent=fr.asString();
    //System.out.println(fileContent);
    
    
    }   
    
    
}
