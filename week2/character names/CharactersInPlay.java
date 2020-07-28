
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CharactersInPlay {
private ArrayList<String> characterNames;
private ArrayList<Integer> counts;
void CharactersInPlay(){
characterNames = new ArrayList <String>();
counts = new ArrayList <Integer>();
}
void findUnique(){
    CharactersInPlay ();
    characterNames.clear();
    counts.clear();
    FileResource fr = new FileResource();
    for(String s:fr.lines()){
        //s=s.toLowerCase();
        int k=s.indexOf('.');
        if(k!=-1){
        String charPlay = s.substring(0,k);
        int index=characterNames.indexOf(charPlay);
        if(index==-1){
         characterNames.add(charPlay);
         counts.add(1);
        }else{
         int k1=counts.get(index);
         counts.set(index,k1+1);
        }
        }
        }
    
    }
int  findIndexOfMax(){
    int max=0;
    int maxIndex=-1;
for(int i=0;i<characterNames.size();i++){
    if(counts.get(i)>max){
    maxIndex=i;
    max=counts.get(i);
    }
}
return maxIndex;
}    
void tester(){
 //WordFrequencies obj = new WordFrequencies();    
findUnique();    
for(int i=0;i<characterNames.size();i++){
    
if(counts.get(i)>10 && counts.get(i)<15)    
System.out.println(characterNames.get(i)+" has count "+counts.get(i));
}

System.out.println("max index is "+ counts.get(findIndexOfMax())+" word is  "+characterNames.get(findIndexOfMax()));
}
void good(){
System.out.println("dddd");
}
}    
  
    
    
  
