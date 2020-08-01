
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
        System.out.println("entries have status code greater than "+ num);
        for(LogEntry le: records){
           if(le.getStatusCode()>num)
               System.out.println(le);
        }
    }
    ArrayList uniqueIPVisitsOnDay(String someday){
     ArrayList<String> uniqueIPs = new ArrayList<String> ();
     String [] param = someday.split(" ");
     for(LogEntry le: records){
         String ipadr= le.getIpAddress();
          Date d = le.getAccessTime();
          String str = d.toString(); 
          String[] splited = str.split(" ");
          if(splited[1].equals(param[0]) && splited[2].equals(param[1])){
                    if(!uniqueIPs.contains(ipadr))
                        uniqueIPs.add(ipadr);
        
            }
         
        
        }
        
     return uniqueIPs;
    
    }
    int countUniqueIPsInRange (int low,int high){
        ArrayList<String> uniqueIPs = new ArrayList<String> ();
        for(LogEntry le: records){
        
        String ipadr= le.getIpAddress();
        if(!uniqueIPs.contains(ipadr) && le.getStatusCode()>=low && le.getStatusCode()<=high)
           uniqueIPs.add(ipadr);
        }  
         return uniqueIPs.size(); 
    
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
