
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        //la.printAll();
        System.out.println( "---unique IPS "+la.countUniqueIPs ());
        //la.printAllHigherThanNum (400);
        System.out.println(la. uniqueIPVisitsOnDay("Sep 24").size());
       // System.out.println(la. uniqueIPVisitsOnDay("Sep 30").size());
        System.out.println(la.countUniqueIPsInRange(400,499)); 
       // System.out.println(la.countUniqueIPsInRange(300,399)); 
       HashMap<String,Integer> ipMap = la.countVisitsPerIP();
       System.out.println(la.mostNumberVisitsByIP(ipMap));
       ArrayList <String> ar =la.iPsMostVisits(ipMap);
       for(int i=0;i<ar.size();i++)
          System.out.println(ar.get(i));
          
       HashMap<String, ArrayList<String>> dMap = la.iPsForDays();
       for(String key:dMap.keySet()){
           System.out.println(key+" "+ dMap.get(key).size());
        }
        System.out.println("Most ip visit " + la.dayWithMostIPVisits(dMap));
        ArrayList <String> ipMost = la.iPsWithMostVisitsOnDay(dMap,"Sep 30");
        System.out.println("repeated ip oin day Sep 30 ");      
        for(int i=0;i<ipMost.size();i++)
          System.out.println(ipMost.get(i));
    }
}
