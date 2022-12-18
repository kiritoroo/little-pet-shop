package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.ApiResponse;
import com.trungle.littlepetshop.payload.KindRequest;

import java.util.List;

public interface KindService {
    List<Kind> getKindsList();
    Kind getKind(Long id);
    Kind createKind(KindRequest kindRequest);
    Kind upateKind(Long id, KindRequest kindRequest);
    ApiResponse deleteKind(Long id);
}
