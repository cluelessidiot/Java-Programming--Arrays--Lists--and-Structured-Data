
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
     HashMap <String,Integer> countVisitsPerIP(){
        HashMap <String,Integer> counts = new HashMap <String,Integer> ();
        for(LogEntry le: records){
         String ip = le.getIpAddress();
         if(!counts.containsKey(ip)){
            counts.put(ip,1);
            }
            else{
              counts.put(ip,counts.get(ip)+1);
            }
        
        }
        return counts;
        
        }
      int  mostNumberVisitsByIP( HashMap <String,Integer>  counts){
        int max=0;
        for(String key:counts.keySet()){
        if(counts.get(key)>max)
          max=counts.get(key);
        }
        return max;
        }
        ArrayList  iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dMap,String D){
        
        ArrayList<String> list = dMap.get(D);
        HashMap <String,Integer> ipMap = new  HashMap <String,Integer> ();
        for(int i=0;i<list.size();i++) {
        if(!ipMap.containsKey(list.get(i))){
          ipMap.put(list.get(i),1);
        }
        else{
        ipMap.put(list.get(i),ipMap.get(list.get(i))+1);
        }
        }
        return iPsMostVisits(ipMap);
        }
        
        
        ArrayList iPsMostVisits( HashMap <String,Integer>  counts){
        int k=mostNumberVisitsByIP(counts);
        ArrayList<String> ip = new ArrayList<String> ();
        for(String key:counts.keySet()){
        if(counts.get(key)==k)
          ip.add(key);
        }
        return ip;
        }
        String dayWithMostIPVisits( HashMap<String, ArrayList<String>> dMap){
        int max=0;
        String str="";
        for(String key:dMap.keySet()){
           
           if(dMap.get(key).size()>max){
            max=dMap.get(key).size();
            str=key;
            }
            
        }
        return str;
        }
        HashMap<String, ArrayList<String>> iPsForDays(){
            HashMap<String, ArrayList<String>> li = new HashMap<String, ArrayList<String>> ();
            for(LogEntry le: records){
                String ipadr= le.getIpAddress();
                Date d = le.getAccessTime();
                String str = d.toString(); 
                String[] splited = str.split(" ");
                String D = splited[1]+" "+splited[2];
                if(!li.containsKey(D)){
                 ArrayList <String> list = new ArrayList<String> ();
                 list.add(ipadr);
                 li.put(D,list);
                }
                else{
                ArrayList <String> list = li.get(D);
                list.add(ipadr);
                
                }
            
            }
            return li;
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
