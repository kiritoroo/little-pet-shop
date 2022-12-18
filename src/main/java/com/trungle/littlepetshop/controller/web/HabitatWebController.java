package com.trungle.littlepetshop.controller.web;

import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.payload.HabitatRequest;
import com.trungle.littlepetshop.service.HabitatService;
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
@RequestMapping("/habitats")
public class HabitatWebController {
    @Autowired
    private HabitatService habitatService;

    @GetMapping
    public ModelAndView getHabitatsList() {
        ModelAndView modelAndView = new ModelAndView("/admin/habitat/list");
        List<Habitat> habitats = habitatService.getHabitatsList();
        modelAndView.addObject("habitats", habitats);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createHabitat() {
        ModelAndView modelAndView = new ModelAndView("/admin/habitat/form");
        modelAndView.addObject("habitat", new HabitatRequest());
        modelAndView.addObject("action", "create");

        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createHabitat(
        @ModelAttribute HabitatRequest body
    ) {
        habitatService.createHabitat(body);

        return new RedirectView("/habitats");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editHabitat(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView modelAndView = new ModelAndView("/admin/habitat/form");
        Habitat habitat = habitatService.getHabitat(id);
        modelAndView.addObject("habitat", habitat);
        modelAndView.addObject("action", "edit");

        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public RedirectView updateHabitat(
        @PathVariable(name = "id") Long id,
        @ModelAttribute HabitatRequest body
    ) {
        habitatService.updateHabitat(id, body);

        return new RedirectView("/habitats");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteHabitat(
        @PathVariable(name = "id") Long id
    ) {
        habitatService.deleteHabitat(id);

        return new RedirectView("/habitats");
    }
}
