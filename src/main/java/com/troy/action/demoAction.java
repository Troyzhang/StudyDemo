package com.troy.action;

import com.alibaba.fastjson.JSONObject;
import com.troy.demo.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyongyu on 16/9/13.
 *
 * @parse com.troy.action
 */
@Controller
@RequestMapping("/demoAction")
public class demoAction {

    @RequestMapping("/demo8")
    public String demo8(HttpServletRequest request,
                        @RequestParam(value = "input", defaultValue = "") String input){

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



    @RequestMapping(value = "/datong/vote")//大通投票
    public String changeCount(HttpServletRequest request ,
                              @RequestParam(value = "resId" ,defaultValue = "") String resId){

        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        jsonObject.put("status" , "200");
        jsonObject.put("message", "sucess");
        try {
            LineIterator in = FileUtils.lineIterator(new File("datong.txt"), "UTF-8");
            List<String> list = new ArrayList<String>();
            while (in.hasNext()) {
                String ids = in.nextLine();
                list.add(ids);
            }
            in.close();

            boolean temp = false;
            for (String rid : list){
                if (!resId.contains(rid)) {
                    continue;
                }else {
                    temp = true;
                    break;
                }
            }
            if (temp == false) throw new Exception(resId + " 不是大通作品id!");

            jsonObject.put("Data", "success");

        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status" , "500");
            jsonObject.put("message", e.getMessage());
        }
        request.setAttribute("result", jsonObject.toJSONString());
        return "json";
    }
}
