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

import java.util.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TargetAsterix")
public class TargetAsterix
{
    private List<Asterix> asterixs;
    
    @XmlElement(name = "Asterix")
    public void setAsterixs(List<Asterix> asterixs) { this.asterixs = asterixs; }
    public List<Asterix> getAsterixs() { return this.asterixs; }
}