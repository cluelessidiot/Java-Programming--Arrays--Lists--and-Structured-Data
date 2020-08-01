
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
     void printAllHigherThanNum (int num){
        
        for(LogEntry le: records){
           if(le.getStatusCode()>num)
               System.out.println(le);
        }
    }
     public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<String> ();
        for(LogEntry le: records){
        
        String ipadr= le.getIpAddress();
        if(!uniqueIPs.contains(ipadr))
           uniqueIPs.add(ipadr);
        }  
         return uniqueIPs.size();  
        }
        
           
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
