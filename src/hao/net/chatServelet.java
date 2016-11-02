package hao.net;

import entity.TEXTmessage;
import util.JsoupXMLParser;
import util.Replier;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//继承于httpservelet
public class chatServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        //super.doGet(request, response);
        //AppSecret = eae2fdbacd734e100617558ba9d9c340
        String encodingAesKey = "LW9i1CUOKvcXaagzHOBoOWzBdKsWpGGl8Us3OfMHjl4";
        String token = "123456";
        request.setCharacterEncoding("UTF-8");
        String echostr = request.getParameter("echostr");
//        String grant_type = request.getParameter("grant_type");
//        String appid = request.getParameter("appid");
//        String secret = request.getParameter("secret");


//        WXBizMsgCrypt pc = null;
//        try {
//            pc = new WXBizMsgCrypt(token, encodingAesKey, appid);
//        } catch (AesException e) {
//            e.printStackTrace();
//        }
////
//        String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
//        System.out.println("解密后明文: " + result2);

        PrintWriter out = response.getWriter();
        out.println(echostr);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        ServletInputStream in = request.getInputStream();
        TEXTmessage tmess = JsoupXMLParser.parser(in);
        TEXTmessage reply = Replier.searchReply(tmess);

        System.out.println(reply.toString());
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(reply.toReplyString());
    }

}