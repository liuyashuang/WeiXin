package com.liu.weixin.util;

import com.liu.weixin.po.TestMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws Exception{
        Map<String,String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream ins = request.getInputStream();
        Document document = reader.read(ins);
        Element root = document.getRootElement();
        List<Element> list = root.elements();
        for(Element e:list){
            map.put(e.getName(),e.getText());
        }
        ins.close();
        return map;
    }

    public static String textMessageToXMl(TestMessage testMessage){
        XStream xStream = new XStream();
        return xStream.toXML(testMessage);
    }
}
