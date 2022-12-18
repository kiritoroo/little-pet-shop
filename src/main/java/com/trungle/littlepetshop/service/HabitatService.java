package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.HabitatRequest;

import java.util.List;

public interface HabitatService {
    List<Habitat> getHabitatsList();
    Habitat getHabitat(Long id);
    Habitat createHabitat(HabitatRequest habitatRequest);
    Habitat updateHabitat(Long id, HabitatRequest habitatRequest);
    ApiResponse deleteHabitat(Long id);
}
