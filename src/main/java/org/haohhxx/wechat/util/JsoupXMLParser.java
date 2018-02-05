package org.haohhxx.wechat.util;

import org.haohhxx.wechat.entity.TEXTmessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.servlet.ServletInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 2018/2/5.
 *
 */
public class JsoupXMLParser {

    public static String xmltext;

    public JsoupXMLParser() {
    }

    public static TEXTmessage parser(ServletInputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder xmlMess = new StringBuilder();
        String line = "";

        while((line = br.readLine()) != null) {
            xmlMess.append(line);
        }

        xmltext = xmlMess.toString();
        Document doc = Jsoup.parse(xmltext);
        return new TEXTmessage(doc.getElementsByTag("ToUserName").text()
                , doc.getElementsByTag("FromUserName").text()
                , doc.getElementsByTag("CreateTime").text()
                , doc.getElementsByTag("MsgType").text()
                , doc.getElementsByTag("Content").text()
                , doc.getElementsByTag("MsgId").text());
    }

}
