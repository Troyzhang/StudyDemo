package com.troy.action;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangyongyu on 16/9/13.
 *
 * @parse com.troy.controller
 */
@Controller
@RequestMapping("/frist")
public class FristAction {

    @RequestMapping("/a")
    public String a(HttpServletRequest request){
        JSONObject msg = new JSONObject();
        try {

            int sum = 0;
            for (int i = 0; i < 100; i++){
                sum+=i;
            }

            msg.put("Data",sum);
            msg.put("status", "200");
            msg.put("message", "sucess");
        } catch (Exception e){
            e.printStackTrace();
            msg.put("status", "500");
            msg.put("message", "erro:" + e.getMessage());
            msg.put("data", new JSONArray());
        }
        request.setAttribute("result", msg);
        return "json";
    }
}
