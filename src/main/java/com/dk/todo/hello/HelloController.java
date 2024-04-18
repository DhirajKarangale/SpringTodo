package com.dk.todo.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController 
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("hello")
    @ResponseBody
    public String Hello()
    {
        return "What's up gamerz!!!";
    }

    @RequestMapping("get-html")
    @ResponseBody
    public String GetHTML()
    {
        StringBuffer sb = new StringBuffer();
        
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>To Do</title>");
        sb.append("</head>");
        sb.append("What's Up Gamerz!!!");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("get-html-jsp")
    public String GetHTMLJSP(@RequestParam String name, ModelMap model)
    {
        logger.info("===================== Request param: {}", name);
        model.put("name", name);
        return "hello";
    }
}