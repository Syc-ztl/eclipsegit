package com.sun.chenglixin.util;

import java.io.IOException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class  Smutil {
	 // 短信应用SDK AppID
    int appid = 1400263987; // 1400开头
    // 短信应用SDK AppKey
    String appkey ="59c92e658875f28a26bf8f2e07ecf3a2" ;
    // 短信模板ID，需要在短信应用中申请
    int templateId = 431578; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    // 签名
    String smsSign = "宽域信用"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
 
  
    public Msg sendMsg(String phone, long l) {
        Msg msg = new Msg();
        msg.setCode(1001);
        try {
            String[] params = {l + "", 15 + ""};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    templateId, params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            //System.out.println(result);
 
            JSONObject jsonObject = new JSONObject(result.toString());
            int recode = jsonObject.getInt("result");
            switch (recode) {
                case 0:
                    msg.setCode(1000);
                    msg.setMsg("短信验证码发送成功！");
                    success();
                    break;
                case 1016:
                    msg.setCode(1016);
                    msg.setMsg("手机号格式错误！");
                    break;
                case 1023:
                    msg.setCode(1023);
                    msg.setMsg("请在60s后重试！");//30s内短信已达上限！
                    break;
                case 1024:
                    msg.setCode(1024);
                    msg.setMsg("请在1小时后重试！");//1小时内短信已达上限
                    break;
                default:
                    msg.setCode(1001);
                    msg.setMsg("错误码" + recode + ",请带上您的错误码反馈给客服");
            }
 
 
            // msg.setMsg(result.toString());
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
            msg.setMsg("HTTP响应码错误");
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
            msg.setMsg("json解析错误！");
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
            msg.setMsg("网络IO错误！");
        }
        return msg;
    }
 
    public abstract void success();


}
