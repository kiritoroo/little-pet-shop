package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.exception.ResourceNotFoundException;
import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.KindRequest;
import com.trungle.littlepetshop.repository.KindRepository;
import com.trungle.littlepetshop.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindServiceImpl implements KindService {
    @Autowired
    private KindRepository kindRepository;

    @Override
    public List<Kind> getKindsList() {
        return kindRepository.findAll();
    }

    @Override
    public Kind getKind(Long id) {
        return kindRepository
            .findById(id)
            .orElseThrow(() ->
                ResourceNotFoundException.builder()
                    .resourceName("Kind")
                    .fieldName("ID")
                    .fieldValue(id)
                    .build()
            );
    }

    @Override
    public Kind createKind(KindRequest kindRequest) {
        Kind newKind = Kind.builder()
            .title(kindRequest.getTitle())
            .description(kindRequest.getDescription())
            .build();

        return kindRepository.save(newKind);
    }

    @Override
    public Kind upateKind(Long id, KindRequest kindRequest) {
        Kind updatedKind = this.getKind(id);

        updatedKind.setTitle(kindRequest.getTitle());
        updatedKind.setDescription(kindRequest.getDescription());

        return kindRepository.save(updatedKind);
    }

    @Override
    public ApiResponse deleteKind(Long id) {
        Kind deletedKind = this.getKind(id);

        kindRepository.delete(deletedKind);

        return ApiResponse.builder()
            .success(Boolean.TRUE)
            .message("Pet kind deleted success")
            .build();
    }
}
