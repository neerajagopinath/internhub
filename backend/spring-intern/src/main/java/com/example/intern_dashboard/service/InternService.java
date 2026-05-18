package com.example.intern_dashboard.service;

import com.example.intern_dashboard.dto.request.InternRequest;
import com.example.intern_dashboard.dto.response.ApiResponse;
import com.example.intern_dashboard.dto.response.InternResponse;

import java.util.List;

public interface InternService {

    ApiResponse createIntern(InternRequest request);

    List<InternResponse> getAllInterns();

    InternResponse getInternById(int id);

    ApiResponse updateIntern(int id, InternRequest request);

    ApiResponse deleteIntern(int id);

    List<InternResponse> searchInterns(String name);

    InternResponse updateIntern(Integer id, InternRequest dto);
}