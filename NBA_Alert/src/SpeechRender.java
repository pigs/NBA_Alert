import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class SpeechRender {

	public void SpeechReader(){
		
	}
	
	public void startProgram(ArrayList<gameNotification> event) throws ClientProtocolException, IOException{
		String message;
		
		for(int i=0;i<event.size()-1;i++){
			message = event.get(i).time+","+event.get(i).event;
			System.out.println(message);
			
			playAudio(message);
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	private void playAudio(String message) throws ClientProtocolException, IOException {

      DefaultHttpClient httpclient = new DefaultHttpClient();
      try {
      

          HttpResponse response;
          HttpEntity entity;


          HttpPost httpost = new HttpPost("http://192.20.225.36/tts/cgi-bin/nph-talk");
          
          List <NameValuePair> nvps = new ArrayList <NameValuePair>();
          nvps.add(new BasicNameValuePair("voice", "crystal"));
          nvps.add(new BasicNameValuePair("txt", message));

          httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

          response = httpclient.execute(httpost);
          entity = response.getEntity();
      
          InputStream instream = entity.getContent();
          
          BufferedReader reader = new BufferedReader(
                  new InputStreamReader(instream));
          // do something useful with the response
          String temp;
          
          temp = reader.readLine();
          temp = reader.readLine();    
   
          int startIndex = temp.lastIndexOf("<A HREF=\"");
          startIndex += 8;
        	  
          int stopIndex = temp.lastIndexOf(">here</A>");
        	  
          temp = "http://192.20.225.36/"+temp.substring(startIndex+1,stopIndex-1);
          System.out.println(temp);
          
          downloadFile(temp);
          
          if(message.contains("misses")){
        	  AePlayWave aw = new AePlayWave( "misses.wav" );
              aw.start();  
          }
          
          if(message.contains("makes free throw")){
        	  AePlayWave aw = new AePlayWave( "makes1.wav" );
              aw.start();  
          }
          
          if(message.contains("makes")&&!message.contains("makes")){
        	  AePlayWave aw = new AePlayWave( "makes3.wav" );
              aw.start();  
          }
          
          if(message.contains("steals")){
        	  AePlayWave aw = new AePlayWave( "steals.wav" );
              aw.start();  
          }
          
          if(message.contains("jumper")){
        	  AePlayWave aw = new AePlayWave( "makes2.wav" );
              aw.start();  
          }
          
          if(message.contains("foul")&&message.contains("timeout")&&message.contains("traveling")){
        	  AePlayWave aw = new AePlayWave("traveling.wav");
              aw.start();  
          }
          
          if(message.contains("shot clock turnover")){
        	  AePlayWave aw = new AePlayWave( "shotclock.wav" );
              aw.start();  
          }
          
          
          try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          AePlayWave aw = new AePlayWave( "downloaded.wav" );
          aw.start(); 

          

      } finally {
          // When HttpClient instance is no longer needed,
          // shut down the connection manager to ensure
          // immediate deallocation of all system resources
          httpclient.getConnectionManager().shutdown();
      }
  }
  
  static private void downloadFile(String urlPath) throws IOException{
  

	    URL u = new URL(urlPath);
	    URLConnection uc = u.openConnection();
	    String contentType = uc.getContentType();
	    int contentLength = uc.getContentLength();
	    if (contentType.startsWith("text/") || contentLength == -1) {
	      throw new IOException("This is not a binary file.");
	    }
	    InputStream raw = uc.getInputStream();
	    InputStream in = new BufferedInputStream(raw);
	    byte[] data = new byte[contentLength];
	    int bytesRead = 0;
	    int offset = 0;
	    while (offset < contentLength) {
	      bytesRead = in.read(data, offset, data.length - offset);
	      if (bytesRead == -1)
	        break;
	      offset += bytesRead;
	    }
	    in.close();

	    if (offset != contentLength) {
	      throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes");
	    }

	    String filename = "downloaded.wav";
	    FileOutputStream out = new FileOutputStream(filename);
	    out.write(data);
	    out.flush();
	    out.close();
	  }  
  
  
}