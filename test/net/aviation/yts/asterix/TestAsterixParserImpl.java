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
 
import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;
//import net.aviation.tys.asterix.*;

public class TestAsterixParserImpl 
{
    @BeforeClass
    public static void runOnceBeforeClass() 
    {
    }

    @AfterClass
    public static void runOnceAfterClass() 
    {
    }

    @Before
    public void runBeforeTestMethod() 
    {
    }

    @After
    public void runAfterTestMethod() 
    {
    }

    @Test
    public void TestParse_CATA10()
    {
    	String data_file = "conf/asterix_cat10.ast";
    	byte[] data = null;
    	
    	try
        {
            FileInputStream fis = new FileInputStream(new File(data_file));
            byte[] buf = new byte[4096];
            int read = fis.read(buf);
            
            data = new byte[read];
            
            System.arraycopy(buf, 0, data, 0, read);
            fis.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    	ASTERIXDecoder decoder = new ASTERIXDecoder();
    	
        List<Map<String, String>> result = decoder.decode(data);
        
        assertNotNull(result);
        assertEquals(12, result.size());
        
        Map<String,String> map = result.get(0);
        
        //String ti = map.get("TARGETIDENTIFICATION");
        
        //assertEquals("DLH001", ti.trim());
        //assertEquals("NV31", ti.trim());
    }
    
    @Test
    public void TestParse_CATA11()
    {
    	String data_file = "conf/asterix_cat11.ast";
    	byte[] data = null;
    	
    	try
        {
            FileInputStream fis = new FileInputStream(new File(data_file));
            byte[] buf = new byte[4096];
            int read = fis.read(buf);
            
            data = new byte[read];
            
            System.arraycopy(buf, 0, data, 0, read);
            fis.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    	ASTERIXDecoder decoder = new ASTERIXDecoder();
    	
        List<Map<String, String>> result = decoder.decode(data);
        
        assertNotNull(result);
        assertEquals(17, result.size());
        
        Map<String,String> map = result.get(0);
        
        //String ti = map.get("TARGETIDENTIFICATION");
        
        //assertEquals("DLH001", ti.trim());
        //assertEquals("NV31", ti.trim());
    }
    
    /*
    @Test
    public void TestParsePacket()
    {
        int len = 1377;
        byte[] real_data = new byte[len];
            
        System.arraycopy(data, 0, real_data, 0, len);
            
        List<Map<String, String>> result = parser.parsePacket(real_data);
        
        assertNotNull(result);
        assertEquals(1, result.size());
        
        Map<String,String> map = result.get(0);
        
        String ti = map.get("TARGETIDENTIFICATION");
        
        //assertEquals("DLH001", ti.trim());
    }
    
    @Test
    public void TestMakeUAP()
    {
        int len = 54;
        int body_len = len - 3;
        byte[] body_data = new byte[body_len];
        
        System.arraycopy(data, 3, body_data, 0, body_len);
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        
        int to_read = body_len;
        Map<Integer, DataItem> uap = new LinkedHashMap<Integer, DataItem>();
        int idx = parser.makeUAP(to_read, 0, body_data, uap);
        
        assertFalse(uap.isEmpty());
        //assertEquals(14, uap.size());
    }
    
    @Test
    public void TestMakeMap()
    {
        int len = 54;
        int body_len = len - 3;
        byte[] body_data = new byte[body_len];
        
        System.arraycopy(data, 3, body_data, 0, body_len);
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        
        int to_read = body_len;
        Map<Integer, DataItem> uap = new LinkedHashMap<Integer, DataItem>();
        int idx = parser.makeUAP(to_read, 0, body_data, uap);
        
        int offset = idx + 1;
        int new_len = body_len - offset;
        byte[] real_data = new byte[new_len];
        System.arraycopy(body_data, body_len-new_len, real_data, 0, new_len);
        
        Map<String, String> result_map = new HashMap<String, String>();
        
        int data_index = parser.makeMap(result_map, uap, real_data);
        
        //assertFalse(result_map.isEmpty());
        //assertEquals(14, uap.size());
    }
    
    @Test
    public void TestParserNull()
    {
        List<Map<String, String>> result = parser.parse(null);
        
        assertNull(result);
    }
    
    @Test
    public void TestParserEmptyData()
    {
        List<Map<String, String>> result = parser.parse(new byte[0]);
        
        assertNull(result);
        //assertTrue(result.isEmpty());
    }
    */
}
 