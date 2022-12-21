package com.trungle.littlepetshop.controller.web;

import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.BreedRequest;
import com.trungle.littlepetshop.payload.HabitatRequest;
import com.trungle.littlepetshop.service.BreedService;
import com.trungle.littlepetshop.service.HabitatService;
import com.trungle.littlepetshop.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/breeds")
public class BreedWebController {
    @Autowired
    private BreedService breedService;

    @Autowired
    private KindService kindService;

    @Autowired
    private HabitatService habitatService;

    @GetMapping
    public ModelAndView getBreedsList() {
        ModelAndView modelAndView = new ModelAndView("/admin/breed/list");
        List<Breed> breeds = breedService.getBreedsList();
        modelAndView.addObject("breeds", breeds);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createBreed() {
        ModelAndView modelAndView = new ModelAndView("/admin/breed/form");
        List<Kind> kinds = kindService.getKindsList();
        List<Habitat> habitats = habitatService.getHabitatsList();

        modelAndView.addObject("breed", new BreedRequest());
        modelAndView.addObject("kinds", kinds);
        modelAndView.addObject("habitats", habitats);
        modelAndView.addObject("action", "create");

        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createBreed(
        @ModelAttribute BreedRequest body
    ) {
        breedService.createBreed(body);

        return new RedirectView("/breeds");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBreed(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView modelAndView = new ModelAndView("/admin/breed/form");
        Breed breed = breedService.getBreed(id);
        List<Kind> kinds = kindService.getKindsList();
        List<Habitat> habitats = habitatService.getHabitatsList();

        modelAndView.addObject("breed", breed);
        modelAndView.addObject("kinds", kinds);
        modelAndView.addObject("habitats", habitats);
        modelAndView.addObject("action", "edit");

        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public RedirectView updateHabitat(
        @PathVariable(name = "id") Long id,
        @ModelAttribute BreedRequest body
    ) {
        breedService.updateBreed(id, body);

        return new RedirectView("/breeds");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deleteBreed(
        @PathVariable(name = "id") Long id
    ) {
        breedService.deleteBreed(id);

        return new RedirectView("/breeds");
    }
}
