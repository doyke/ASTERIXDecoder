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
           
    }
}
 
