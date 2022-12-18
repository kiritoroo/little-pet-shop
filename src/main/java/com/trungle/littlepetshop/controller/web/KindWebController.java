package com.trungle.littlepetshop.controller.web;

import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.KindRequest;
import com.trungle.littlepetshop.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/kinds")
public class KindWebController {
    @Autowired
    private KindService kindService;

    @GetMapping
    public ModelAndView getKindsList() {
        ModelAndView modelAndView = new ModelAndView("/admin/kind/list");
        List<Kind> kinds = kindService.getKindsList();
        modelAndView.addObject("kinds", kinds);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createKind() {
        ModelAndView modelAndView = new ModelAndView("/admin/kind/form");
        modelAndView.addObject("kind", new KindRequest());
        modelAndView.addObject("action", "create");

        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createKind(
        @ModelAttribute KindRequest body
    ) {
        kindService.createKind(body);

        return new RedirectView("/kinds");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editKind(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView modelAndView = new ModelAndView("/admin/kind/form");
        Kind kind = kindService.getKind(id);
        modelAndView.addObject("kind", kind);
        modelAndView.addObject("action", "edit");

        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public RedirectView updateKind(
        @PathVariable(name = "id") Long id,
        @ModelAttribute KindRequest body
    ) {
        kindService.upateKind(id, body);

        return new RedirectView("/kinds");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteKind(
        @PathVariable(name = "id") Long id
    ) {
        kindService.deleteKind(id);

        return new RedirectView("/kinds");
    }
}
