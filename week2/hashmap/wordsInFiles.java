
/**
 * Write a description of wordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import java.io.*;
public class wordsInFiles {

    private HashMap <String,ArrayList<String>> filenameWord;
    public wordsInFiles(){
    filenameWord = new HashMap<String,ArrayList<String>> ();
    }
    
    void formFile(){
    filenameWord.clear();
    DirectoryResource dr = new DirectoryResource();
    for(File f: dr.selectedFiles()){
     addWords(f);
    }
    }
   void addWords(File f){
    FileResource fr = new FileResource(f);
    String fname = f.getName();
    for(String word: fr.words()){
    word=word.toLowerCase();
    if(!filenameWord.containsKey(word)){
     ArrayList<String> list = new ArrayList<String>();
     list.add(fname);
     filenameWord.put(word,list);
    }
    else{
    ArrayList<String> list = filenameWord.get(word);
    if(!list.contains(fname)){
      list.add(fname);
      filenameWord.put(word,list);
    }
    }
    }
    }
    
    int maxNumber(){
    int max=0;
    for(String word:filenameWord.keySet()){
    ArrayList<String> list= filenameWord.get(word);
    if(list.size()>max)
      max=list.size();
    
    }
    return max;
    }
    
    
    ArrayList<String>  wordsInNumFiles (int number){
    ArrayList<String> Rlist = new ArrayList<String>();
    for(String word:filenameWord.keySet()){
     ArrayList<String> list= filenameWord.get(word);
     if(list.size()==number){
        Rlist.add(word);
        }
    }
    return Rlist;
    }
    
         void printFilesIn(String word){
        ArrayList<String> fileNames = filenameWord.get(word);
        for (int index = 0; index < fileNames.size(); index++) {
            System.out.println(fileNames.get(index));
        }
        
   }
   void test(){
    formFile();
    int maximum = maxNumber();
    ArrayList<String> TestList = wordsInNumFiles(4);
    System.out.println("The maximum number of files word is in: "+maximum +" and there are "+TestList.size());
    for (int k =0;k< TestList.size(); k++)
    {
      System.out.println("All the words in the files "+TestList.get(k)+"");
    }
    System.out.println("\t");
    
    for (int k =0;k <TestList.size();k++){
        System.out.println("Filenames where the words are ");
        printFilesIn(TestList.get(k));
    }
    }
}
