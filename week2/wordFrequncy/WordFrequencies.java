package wordFrequncy;


/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {
private ArrayList <String> myWords ;
private ArrayList <Integer> myFreqs;
public WordFrequencies(){
 myWords = new ArrayList <String>();
  myFreqs = new ArrayList <Integer> ();
}
void findUnique(){
    myWords.clear();
    myFreqs.clear();
    FileResource fr = new FileResource();
    for(String s:fr.words()){
        s=s.toLowerCase();
        int index=myWords.indexOf(s);
        if(index== -1){
        myWords.add(s);
        myFreqs.add(1);
        }
        else{
        int k=myFreqs.get(index);
         myFreqs.set(index,k+1);
        }
    
    }
}
int  findIndexOfMax(){
    int max=0;
    int maxIndex=-1;
for(int i=0;i<myWords.size();i++){
    if(myFreqs.get(i)>max){
    maxIndex=i;
    max=myFreqs.get(i);
    }
}
return maxIndex;
}
void tester(){
 //WordFrequencies obj = new WordFrequencies();    
findUnique();    
for(int i=0;i<myWords.size();i++){
System.out.println(myWords.get(i)+" has count "+myFreqs.get(i));
}

System.out.println("max index is "+ myFreqs.get(findIndexOfMax())+" word is  "+myWords.get(findIndexOfMax()));
}
void good(){
System.out.println("dddd");
}
}
