/****************************************************************************

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
    @author T.Y.Shin (https://github.com/zeroreloaded)
    
******************************************************************************/
package net.aviation.yts.asterix;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;
import java.text.*;
import org.apache.log4j.Logger;

public class ASTERIXDecoder
{
	private Logger log = Logger.getLogger(ASTERIXDecoder.class);
    private Map<String, IASTERIXParser> map_asterix;
    private TargetAsterix target_asterix;
    private ASTERIXDecoderUtils asterixUtils = new ASTERIXDecoderUtils();
    
    public ASTERIXDecoder()
    {
    	log.info("Initializing ASTERIXDecoder.. ");
        initCategory();
        log.info("ASTERIXDecoder initialized. .. ");
    }
    
    private void initCategory()
    {
    	this.map_asterix = new HashMap<String, IASTERIXParser>();
    	TargetAsterix target_asterix;
    	
        try
        {
            JAXBContext context = JAXBContext.newInstance(TargetAsterix.class);
            Unmarshaller umarshaller = context.createUnmarshaller();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("conf/asterix.xml");
            target_asterix = (TargetAsterix)umarshaller.unmarshal(is); //new File("conf/asterix.xml"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	return;
       	}
        
        if(target_asterix == null) return;
        
        List<Asterix> list_asterix = target_asterix.getAsterixs();
        
        for(int i=0;i<list_asterix.size(); i++)
        {
            Asterix as = list_asterix.get(i);
            String category = as.getCategory();
            String file = as.getFile();
            IASTERIXParser ap = new ASTERIXParserImpl(category, file);
            
            this.map_asterix.put(category, ap);
            log.info("add parser for " + category + " from " + file);
        }
    }

    public List<Map<String, String>> decode(byte[] data)
    {
        try
        {
            if(data.length < 5) return null;
            
            String category = String.valueOf(data[0] & 0xff);;
            
            IASTERIXParser parser = map_asterix.get(category);
            
            if(parser == null) 
            {
                log.info("parser NOT FOUND for ASTERIX CAT " + category);
                return null;
            } 
            
            List<Map<String, String>> result = parser.parse(data);
			
            if(result == null) 
            {
            	log.info("Parse failed for ASTERIX CAT " + category);
            	return null;
            }
            
            return result;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    private void printMap(Map<String,String> map)
    {
    	if(map == null) return;
    	
    	Iterator<String> it = map.keySet().iterator();
                        
        while(it.hasNext())
        {
            String key = it.next();
            String value = map.get(key);
            log.info(key + " : " + value);
        } 
    	
    }
}