package com.example.intern_dashboard.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.intern_dashboard.dto.request.InternRequest;
import com.example.intern_dashboard.dto.response.InternResponse;
import com.example.intern_dashboard.enums.InternStatus;

public interface InternService {

    Page<InternResponse> getAllInterns(
            int page,
            int size,
            String sortBy,
            String direction
    );

    InternResponse getInternById(Integer id);

    InternResponse createIntern(InternRequest dto);

    InternResponse updateIntern(
            Integer id,
            InternRequest dto
    );

    void deleteIntern(Integer id);

    List<InternResponse> searchInterns(String keyword);

    Page<InternResponse> filterInterns(
            InternStatus status,
            String department,
            int page,
            int size,
            String sortBy,
            String direction
    );
}