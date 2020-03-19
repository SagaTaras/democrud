package com.example.demo.controller;

import com.example.demo.utils.UrlModifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setup")
public class SetupController {

    private UrlModifier urlModifier;

    public SetupController(UrlModifier urlModifier) {
        this.urlModifier = urlModifier;
    }

    @GetMapping("/setSuffixForMariaDB")
    public String setSuffixForMariaDB(Model theModel) {
        urlModifier.setSuffixForMariaDB();
        return "redirect:/employees/list";
    }

    @GetMapping("/setSuffixForPostgres")
    public String setSuffixForPostgres(Model theModel) {
        urlModifier.setSuffixForPostgres();
        return "redirect:/employees/list";
    }
}
