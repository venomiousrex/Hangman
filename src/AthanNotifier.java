
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hadida
 */
public class AthanNotifier {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) throws IOException {
      
        Document doc = null;
        
    
            //creates a doc, sets a user
            doc = Jsoup.connect("http://www.kitchenermasjid.com/").userAgent("Mozilla/17.0").get();
            
//            String title = doc.title();
            Element body =  doc.body();
            Elements links = null;
            
            //Access calender
            Calendar cal = Calendar.getInstance();
            //sets format (Hours, minutes, seconds)
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            System.out.println( "Time right now  " + sdf.format(cal.getTime()) );
            
            String converter  = body.text();
            int[] times = new int[5];
            String[] allLinks = {"td.odd", "td.even","tr.even"};
//            String[] checker = {"Fajr", "Asr", "Zhur","Maghrib", "Isha"};
            ArrayList<String> checker = new ArrayList<String>();
            checker.add("Fajr");
            checker.add("Asr");
            checker.add("Zhur");
            checker.add("Maghrib");
            checker.add("Isha");
            
            
           
            
           
           
              
       
           
//            Elements links2 = doc.select("td.even");
//            Elements links3 = doc.select("tr.even");
            
               for (int i = 0; i < allLinks.length; i++) {
              links = doc.select(allLinks[i]);
                 
            
            for (Element athan: links) {
               
                String text = athan.getAllElements().text();
                if(checker.contains(text)){
                    System.out.println("What");
                    
                   
                   
                }
                 System.out.println(text);
//                int x = Integer.parseInt(text);
//                System.out.println(x);
//                System.out.println(text);
                
                
                
                
                
                
                
            }
               }
            
//            System.out.println(links2.text());
//            System.out.println(links3.text());
                     
            
            StringBuilder test = new StringBuilder(links.text());
            
            
            
            
      
        
       
        
        
        
    }
    
    
    public static int timeConverter(int time, String pmAm){
        
        if(pmAm.equals("PM")){
            time = 12 + time;
            
        }
        
        return time;
        
        
        
        
    }
    
}
