import java.awt.List;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.Gson;



public class Google_Search {

	
	public ArrayList<String> contents;
	
	public Google_Search()
	{
		contents = new ArrayList<String>();
	}
 
    public ArrayList<String> GetGoogleResults(String term) throws Exception
    { 
        String google; String charset = "UTF-8"; 
        URL url; 
        Reader reader; 
        Google results;
 
        google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&rsz=8&q=";
 
        url = new URL(google + URLEncoder.encode(term, charset));
        reader = new InputStreamReader(url.openStream(), charset);
        results = new Gson().fromJson(reader, Google.class);
        
       contents.clear();
        if(results.getResponseData()!=null)
        {
            for(int i=0;i<results.getResponseData().getResults().size();i++)
            {
            	contents.add(results.getResponseData().getResults().get(i).getContent().toLowerCase());   	
            }         
        }
        
        return contents; 
    }
}
