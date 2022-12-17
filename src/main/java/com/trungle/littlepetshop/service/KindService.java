package com.trungle.littlepetshop.service;

import com.trungle.littlepetshop.model.Kind;
import com.trungle.littlepetshop.payload.ApiResponse;

import java.util.List;

public interface KindService {
    List<Kind> getKindsList();
    Kind getKind(Long id);
    Kind createKind(Kind kind);
    Kind upateKind(Kind kind, Long id);
    ApiResponse deleteKind(Long id);
}
