#### ASTERIXDecoder
> ASTERIXDecoder is a java library for decoding/parsing of byte array data which is compliant with EUROCONTROL's ASTERIX specification.

#### Features
* Easy to use
* Intuitive/Simple API
* Do not need extra 3rd party library

 #### How to use
<pre>
1. Add library to your CLASSPATH and declare Import Library

    import net.aviation.yts.asterix;
</pre>

<pre>
2. Create decoder instance of ASTERIXDecoder class

    ASTERIXDecoder decoder = new ASTERIXDecoder();

</pre>

<pre>
3. Call decode method and decoder instance returns object of <code>List<Map<String,String>></code>

    byte[] data = .. ; // Data you want to decode 
    List<Map<String,String>> result = decoder.decode(data);

</pre>
