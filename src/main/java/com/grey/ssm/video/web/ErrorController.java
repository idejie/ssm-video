package com.grey.ssm.video.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ErrorController {
    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView handle(HttpServletRequest request)
    {
        System.out.println("ERROR");
        ModelAndView modelAndView = new ModelAndView("error");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        modelAndView.addObject("map", map);

        return modelAndView;
    }
}
