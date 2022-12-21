package com.trungle.littlepetshop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexWebController {
    @GetMapping("/")
    public RedirectView indexView() {
        return new RedirectView("/pets");
    }
}
