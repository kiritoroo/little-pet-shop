package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.payload.ApiResponse;

import java.util.List;

public interface HabitatService {
    List<Habitat> getHabitatsList();
    Habitat getHabitat(Long id);
    Habitat createHabitat(Habitat habitat);
    Habitat updateHabitat(Habitat habitat, Long id);
    ApiResponse deleteHabitat(Long id);
}
