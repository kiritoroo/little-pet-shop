package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.repository.HabitatRepository;
import com.trungle.littlepetshop.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatServiceImpl implements HabitatService {
    @Autowired
    private HabitatRepository habitatRepo;

    @Override
    public List<Habitat> getHabitatsList() {
        return null;
    }

    @Override
    public Habitat getHabitat(Long id) {
        return null;
    }

    @Override
    public Habitat createHabitat(Habitat habitat) {
        return null;
    }

    @Override
    public Habitat updateHabitat(Habitat habitat, Long id) {
        return null;
    }

    @Override
    public ApiResponse deleteHabitat(Long id) {
        return null;
    }
}
