import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class parse_info {
    
	String wPage;
	
	ArrayList <gameNotification> events;
	
	public parse_info(String wPage){
		this.wPage = wPage;
		events = new ArrayList<gameNotification>();
	}
	
	public void parseSite() throws Exception {
    
		
		
	    String sb = new String();
		URL espn = new URL(wPage);
		BufferedReader in = new BufferedReader(
					new InputStreamReader(
					espn.openStream()));
	
		String inputLine;
		
	
		while ((inputLine = in.readLine()) != null) {
		    sb+=inputLine;
		}
		
		//System.out.println(sb);
		
		
		
		
		String startParse = "<tr class=\"even\"><td valign=top width=50 style=\"text-align:center;\">12:00";
		
		int startIndex = sb.indexOf(startParse);
		startIndex += startParse.length()-5;
		
		events.add(new gameNotification());
		
	    System.out.println(sb.substring(startIndex,startIndex+5));
	    
	    events.get(events.size()-1).time = sb.substring(startIndex,startIndex+5);
	    
	    startParse = "</td><td colspan=3 style=\"text-align:center;\"><b>";
	    
	    startIndex = sb.indexOf(startParse);
		startIndex += startParse.length();
	    
		sb = sb.substring(startIndex,sb.length());
		
		int stopIndex = sb.indexOf("</b>");
		
		System.out.println(sb.substring(0,stopIndex));
		events.get(events.size()-1).event = sb.substring(0,stopIndex);
		
		sb = sb.substring(stopIndex,sb.length());
		
		//System.out.println(sb);
		
		int temp = 30;
		int bold = 0;
		
		while(temp>0){
			temp--;
			bold=0;
			
			events.add(new gameNotification());
			//////////////////
			//START GET TIME//
		    //////////////////
			
		    startParse = "<td valign=top width=50 style=\"text-align:center;\">";
		    
		    startIndex = sb.indexOf(startParse);
			startIndex += startParse.length();
		    
			sb = sb.substring(startIndex,sb.length());
			
			stopIndex = sb.indexOf("</td>");
			
			//System.out.println(sb.substring(0,stopIndex));
			events.get(events.size()-1).time = sb.substring(0,stopIndex);
			
			///////////////////
			//STOP GET TIME////
		    ///////////////////
			
			/////////////////////
			//START GET Message//
		    /////////////////////
			
			startParse = "<td valign=top style=\"text-align:center;\" NOWRAP>0-0</td><td valign=top style=\"text-align:left;\">";
			startIndex = sb.indexOf(startParse);
			
			if(startIndex==-1){
				bold=1;
				startParse = "<td valign=top style=\"text-align:left;\"><B>";
				startIndex = sb.indexOf(startParse);
			}
			
			
			startIndex += startParse.length();
			
			
			sb = sb.substring(startIndex,sb.length());
			
			if(bold==0){
				stopIndex = sb.indexOf("</td>");
			}
			else{
				stopIndex = sb.indexOf("</B></td>");
			}
			//System.out.println(sb.substring(0,stopIndex));
			events.get(events.size()-1).event = sb.substring(0,stopIndex);
			
		}
		
		SpeechRender speech = new SpeechRender();
		speech.startProgram(events);
	 
    }
}