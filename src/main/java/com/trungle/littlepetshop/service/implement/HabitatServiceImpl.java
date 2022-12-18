package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.exception.ResourceNotFoundException;
import com.trungle.littlepetshop.model.Habitat;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.HabitatRequest;
import com.trungle.littlepetshop.repository.HabitatRepository;
import com.trungle.littlepetshop.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatServiceImpl implements HabitatService {
    @Autowired
    private HabitatRepository habitatRepository;

    @Override
    public List<Habitat> getHabitatsList() {
       return habitatRepository.findAll();
    }

    @Override
    public Habitat getHabitat(Long id) {
        return habitatRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Habitat")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }

    @Override
    public Habitat createHabitat(HabitatRequest habitatRequest) {
        Habitat newHabitat = Habitat.builder()
            .title(habitatRequest.getTitle())
            .description(habitatRequest.getDescription())
            .build();

        return habitatRepository.save(newHabitat);
    }

    @Override
    public Habitat updateHabitat(Long id, HabitatRequest habitatRequest) {
        Habitat updatedHabitat = this.getHabitat(id);

        updatedHabitat.setTitle(habitatRequest.getTitle());
        updatedHabitat.setDescription(habitatRequest.getDescription());

        return habitatRepository.save(updatedHabitat);
    }

    @Override
    public ApiResponse deleteHabitat(Long id) {
        Habitat deletedHabitat = this.getHabitat(id);

        habitatRepository.delete(deletedHabitat);

        return ApiResponse.builder()
            .success(Boolean.TRUE)
            .message("Habitat deleted success")
            .build();
    }
}
