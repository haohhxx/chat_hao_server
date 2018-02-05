package org.haohhxx.wechat.entity;

/**
 * Created by hao on 16-11-2.
 */
public class TEXTmessage {

    private String ToUserName;

    @Override
    public String toString() {
        return "TEXTmessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId='" + MsgId + '\'' +
                '}';
    }

    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;
    private String MsgId;

    /**
     * 直接回答
     * @return
     */
    public String toReplyString() {
        StringBuilder sbre = new StringBuilder("<xml>\n");
        sbre.append("<ToUserName>");sbre.append(ToUserName);sbre.append("</ToUserName>\n");
        sbre.append("<FromUserName>");sbre.append(FromUserName);sbre.append("</FromUserName>\n");
        sbre.append("<CreateTime>");sbre.append(CreateTime);sbre.append("</CreateTime>\n");
        sbre.append("<MsgType>");sbre.append(MsgType);sbre.append("</MsgType>\n");
        sbre.append("<Content>");sbre.append(Content);sbre.append("</Content>\n");
        sbre.append("</xml>");
        return sbre.toString();
    }


    /**
     * 用户反转，返回输入
     * @return
     */
    public String toRepString() {
        StringBuilder sbre = new StringBuilder("<xml>\n");
        sbre.append("<ToUserName>");sbre.append(FromUserName);sbre.append("</ToUserName>\n");
        sbre.append("<FromUserName>");sbre.append(ToUserName);sbre.append("</FromUserName>\n");
        sbre.append("<CreateTime>");sbre.append(CreateTime);sbre.append("</CreateTime>\n");
        sbre.append("<MsgType>");sbre.append(MsgType);sbre.append("</MsgType>\n");
        sbre.append("<Content>");sbre.append(Content);sbre.append("</Content>\n");
        sbre.append("</xml>");
        return sbre.toString();
    }

    public TEXTmessage(){

    }

    public TEXTmessage(String toUserName, String fromUserName, String createTime, String msgType, String content, String msgId) {
        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        Content = content;
        MsgId = msgId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
