
/**
 * Write a description of codon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import edu.duke.*;
import java.util.*;
public class codon {

    private HashMap<String,Integer> dnaCount;
    
    codon(){
    dnaCount = new HashMap<String,Integer> ();
    }
    
    void  buildCodonMap(int start,String dna){
     dnaCount.clear();
     for(int i=start;i<dna.length()-3;i=i+3){
        if(dnaCount.get(dna.substring(i,i+3))==null){
           dnaCount.put(dna.substring(i,i+3),1);
        
        }else{
        int k=dnaCount.get(dna.substring(i,i+3));
        dnaCount.put(dna.substring(i,i+3),k+1);
        }
        
        }
    }
    String  getMostCommonCodon(){
    int max=0;
    String maxCodon="";
    for (String key : dnaCount.keySet()) {
    int k=dnaCount.get(key);
    if(k>max){
       max=k;
       maxCodon=key;}
    }
    return maxCodon;
    }
  void printCodonCounts (int s,int e){
      int ct=0;
     for (String key : dnaCount.keySet()) {
    ct++;
         int k=dnaCount.get(key);
    if(k>=s && k<=e){
      System.out.println(key+" "+k);  
    }
    }
    System.out.println("Count ="+ct);
    }  
  void tester(){
    String a="ATTAATACTTTGTTTAACAGTAATTATTCAACTATTAAATATTTAAATAATTAAGTTATTAAACTATTAAGTACAGGGCCTGTATCTCTGATGCTGAACTATGATGTGTGACTTAAGCCCCCAAATACATCATGTTATTTGGATCCAAGGTGCTGCACAGAACGCTGACCCTCTCTAAGAGCTGGGTATTACT";
     buildCodonMap(1,a);
     System.out.println(getMostCommonCodon());
     printCodonCounts (6,6);
     //  buildCodonMap(1,a);
     //   printCodonCounts (1,1);
       // buildCodonMap(2,a);
         //printCodonCounts (4,4);
    }  
}
