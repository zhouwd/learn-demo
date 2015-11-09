package com.joe.fop;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
public class FOP {
    public static void main(String[] args) throws Exception{
        new FOP().run();
        System.out.println("success");
    }
    public void run() throws Exception{
        File fo=new File("D:\\newtst\\helloworld.fo");
        File pdf=new File("D:\\newtst\\helloworld.pdf");
        convertFO2PDF(fo,pdf);
    }
    public void convertFO2PDF(File fo, File pdf) throws Exception {
        //Construct driver
        FopFactory factory=FopFactory.newInstance();
        FOUserAgent userAgent=factory.newFOUserAgent();
        OutputStream out=null;
        out=new FileOutputStream(pdf);
        out=new BufferedOutputStream(out);
        Fop fop=factory.newFop(MimeConstants.MIME_PDF,userAgent,out);
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        Source source=new StreamSource(fo);
        Result res=new SAXResult(fop.getDefaultHandler());
        transformer.transform(source,res);
        out.close();
    }
}