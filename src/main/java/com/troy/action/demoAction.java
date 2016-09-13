package com.troy.action;

import com.troy.demo.*;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by zhangyongyu on 16/9/13.
 *
 * @parse com.troy.action
 */
@Controller
@RequestMapping("/demoAction")
public class demoAction {

    @RequestMapping("/demo8")
    public String demo8(HttpServletRequest request){

        demo8 d8 = new demo8();
        JSONObject msg = new JSONObject();

        String idurl = "500px145692245.jpg";

        File file = new File("/Users/zhangyongyu/Desktop/Exif/pic/" + idurl);

        try {
            JSONObject jsonObject = d8.exifRead(file);
            msg.put("Data", jsonObject);
            msg.put("status", "200");
            msg.put("message", "sucess");
        } catch (Exception e) {
            e.printStackTrace();
            msg.put("status", "500");
            msg.put("message", "erro:" + e.getMessage());
        }
        request.setAttribute("result", msg);
        return "json";

    }
}
