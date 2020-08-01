
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry> ();
     }
        
     public void readFile() {
         FileResource fr= new FileResource();
         records.clear();
         WebLogParser parser = new WebLogParser ();
         for(String lines: fr.lines()){
            //System.out.println(lines);
            records.add(parser.parseEntry(lines));
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
