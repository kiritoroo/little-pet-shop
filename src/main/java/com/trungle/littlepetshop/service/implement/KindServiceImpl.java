package com.trungle.littlepetshop.service.implement;

import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.ApiResponse;
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
        return null;
    }

    @Override
    public Kind getKind(Long id) {
        return null;
    }

    @Override
    public Kind createKind(Kind kind) {
        return null;
    }

    @Override
    public Kind upateKind(Kind kind, Long id) {
        return null;
    }

    @Override
    public ApiResponse deleteKind(Long id) {
        return null;
    }
}
