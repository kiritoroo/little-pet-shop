package com.trungle.littlepetshop.controller.web;

import com.trungle.littlepetshop.model.Breed;
import com.trungle.littlepetshop.model.Pet;
import com.trungle.littlepetshop.payload.PetRequest;
import com.trungle.littlepetshop.service.BreedService;
import com.trungle.littlepetshop.service.PetService;
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
@RequestMapping("/pets")
public class PetWebController {
    @Autowired
    private PetService petService;

    @Autowired
    private BreedService breedService;

    @GetMapping
    public ModelAndView getPetsView() {
        ModelAndView modelAndView = new ModelAndView("admin/pet/list");
        List<Pet> pets = petService.getPetsList();
        modelAndView.addObject("pets", pets);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createpet() {
        ModelAndView modelAndView = new ModelAndView("admin/pet/form");
        List<Breed> breeds = breedService.getBreedsList();

        modelAndView.addObject("pet", new PetRequest());
        modelAndView.addObject("breeds", breeds);
        modelAndView.addObject("action", "create");
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createPet(
        @ModelAttribute PetRequest body
    ) {
        petService.createPet(body);

        return new RedirectView("/pets");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPet(
        @PathVariable(name = "id") Long id
    ) {
        ModelAndView modelAndView = new ModelAndView("admin/pet/form");
        Pet pet = petService.getPet(id);
        List<Breed> breeds = breedService.getBreedsList();

        modelAndView.addObject("pet", pet);
        modelAndView.addObject("breeds", breeds);

        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public RedirectView updatePet(
        @PathVariable(name = "id") Long id,
        @ModelAttribute PetRequest body
    ) {
        petService.updatePet(id, body);

        return new RedirectView("/pets");
    }

    @GetMapping("/delete/{id}")
    public RedirectView deletePet(
        @PathVariable(name = "id") Long id
    ) {
        petService.deletePet(id);

        return new RedirectView("/pets");
    }
}
