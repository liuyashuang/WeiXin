package com.liu.weixin.mvc;

import com.liu.weixin.util.CheckUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/Weixin")
public class weixinServlet{
    @RequestMapping(value="/dowx",method= RequestMethod.GET)
    public void getSignature(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value="signature") String signature,
                               @RequestParam(value = "timestamp") String timestamp,
                               @RequestParam(value = "nonce") String nonce,
                               @RequestParam (value = "echostr") String echostr){
        try (PrintWriter out = response.getWriter()) {
            if(CheckUtil.checkSignature(signature,timestamp,nonce)){
                out.print(echostr);
                out.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setMessage(){

    }
}
