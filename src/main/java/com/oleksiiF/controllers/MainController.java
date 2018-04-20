package com.oleksiiF.controllers;

import com.oleksiiF.model.Data;
import com.oleksiiF.services.JSONServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by OleksiiF on 19.04.2018.
 */
@Controller
public class MainController {

    @Autowired
    JSONServiceImpl JSONServiceImpl;

    @RequestMapping("/hello")
    public String getForm(){
        return "save";
    }

    @RequestMapping("/result")
    public ModelAndView showHelloWorld(@RequestParam("source_url") String source) throws IOException {
        ModelAndView model = new ModelAndView("result");

        Data data = JSONServiceImpl.getJSONObjects(source);
        model.addObject("status", JSONServiceImpl.sendToDb(data));

        return model;
    }

}
