 import edu.duke.*;
import java.util.*;

public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private Random myRandom;
    private HashMap  <String,ArrayList<String>> myMap;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLib(){
        initializeFromSource();
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource();
        myRandom = new Random();
    }
    
    private void initializeFromSource() {
                String currentDirectory = System.getProperty("user.dir");
        System.out.println("The current working directory is " + currentDirectory);
        myMap = new HashMap <String,ArrayList<String>> ();
        adjectiveList= readIt("data/adjective.txt"); 
        myMap.put("adjective",adjectiveList);
        nounList = readIt("data/noun.txt");
        myMap.put("noun",nounList);
        colorList = readIt("data/color.txt");
        myMap.put("color",colorList);
        countryList = readIt("data/country.txt");
        myMap.put("country",countryList);
        nameList = readIt("data/name.txt");      
        myMap.put("name",nameList);
        animalList = readIt("data/animal.txt");
        myMap.put("animal",animalList);
        timeList = readIt("data/timeframe.txt");
        myMap.put("timeframe",timeList);
        verbList = readIt("data/verb.txt");
        myMap.put("verb",verbList);
        fruitList = readIt("data/fruit.txt");
        myMap.put("fruit",fruitList);
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(myMap.get("country"));
        }
        if (label.equals("color")){
            return randomFrom(myMap.get("color"));
        }
        if (label.equals("noun")){
            return randomFrom(myMap.get("noun"));
        }
        if (label.equals("name")){
            return randomFrom(myMap.get("name"));
        }
        if (label.equals("adjective")){
            return randomFrom(myMap.get("adjective"));
        }
        if (label.equals("animal")){
            return randomFrom(myMap.get("animal"));
        }
        if (label.equals("timeframe")){
            return randomFrom(myMap.get("timeframe"));
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if (label.equals("verb")){
            return randomFrom(myMap.get("verb"));
        }
        if (label.equals("fruit")){
            return randomFrom(myMap.get("fruit"));
        }
        return "**UNKNOWN**";
    }
    void totalWordsInMap (){
    for(String Word:myMap.keySet()){
    System.out.println(Word +"has "+ myMap.get(Word).size() +" elements");
    
    }}
    void totalWordsConsidered(){
    int ct=0;
    for(String Word:myMap.keySet()){
        ct=ct+ myMap.get(Word).size();}
         System.out.println("total words is "+ct);
    }
    
    
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
    }
    


}


