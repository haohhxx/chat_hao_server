package util;

import config.staticEnvir;
import entity.SearchResult;
import entity.TEXTmessage;

import java.util.ArrayList;

/**
 * Created by hao on 16-11-2.
 */
public class Replier {

    public static TEXTmessage searchReply(TEXTmessage tmessin) {
        TEXTmessage reply_message = new TEXTmessage();
        System.out.println("Content-----"+tmessin.getContent());
        ArrayList<SearchResult> sre_list = staticEnvir.searcher.search(tmessin.getContent());
        StringBuilder replytext = new StringBuilder();
        for(int i = 0;i<Math.min(sre_list.size(),10);i++){
//        for(SearchResult sre:sre_list){
            SearchResult sre = sre_list.get(i);
            replytext.append(sre.getNameString()+"  ");
            replytext.append(sre.getURLString()+"\n");
        }
        reply_message.setFromUserName(tmessin.getToUserName());
        reply_message.setToUserName(tmessin.getFromUserName());
        reply_message.setCreateTime(tmessin.getCreateTime());
        reply_message.setContent(replytext.toString());
        reply_message.setMsgType(tmessin.getMsgType());
        reply_message.setMsgId(tmessin.getMsgId());
        return reply_message;
    }

}
