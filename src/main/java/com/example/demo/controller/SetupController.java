package com.example.demo.controller;

import com.example.demo.utils.UrlModifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/setup")
public class SetupController {

    private UrlModifier urlModifier;

    public SetupController(UrlModifier urlModifier) {
        this.urlModifier = urlModifier;
    }

    @GetMapping("/setSuffixForMariaDB")
    public ModelAndView setSuffixForMariaDB(Model theModel) {
        urlModifier.setSuffixForMariaDB();
        ModelAndView mv = new ModelAndView("redirect:/employees/list");
        return mv;
    }

    @GetMapping("/setSuffixForPostgres")
    public ModelAndView setSuffixForPostgres(Model theModel) {
        urlModifier.setSuffixForPostgres();
        ModelAndView mv = new ModelAndView("redirect:/employees/list");
        return mv;
    }
}
