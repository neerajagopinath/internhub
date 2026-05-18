package com.example.intern_dashboard.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.intern_dashboard.dto.request.InternRequest;
import com.example.intern_dashboard.dto.response.InternResponse;
import com.example.intern_dashboard.entity.Intern;
import com.example.intern_dashboard.enums.InternStatus;
import com.example.intern_dashboard.exception.ResourceNotFoundException;
import com.example.intern_dashboard.repository.InternRepository;
import com.example.intern_dashboard.service.InternService;

@Service
public class InternServiceImpl implements InternService {

    private final InternRepository internRepository;

    public InternServiceImpl(
            InternRepository internRepository
    ) {
        this.internRepository = internRepository;
    }

    @Override
    public Page<InternResponse> getAllInterns(
            int page,
            int size,
            String sortBy,
            String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable =
                PageRequest.of(page, size, sort);

        Page<Intern> internPage =
                internRepository.findByIsDeletedFalse(pageable);

        List<InternResponse> responses =
                internPage.getContent()
                        .stream()
                        .map(this::mapToResponse)
                        .toList();

        return new PageImpl<>(
                responses,
                pageable,
                internPage.getTotalElements()
        );
    }

    @Override
    public InternResponse getInternById(
            Integer id
    ) {

        Intern intern = internRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Intern not found"
                        )
                );

        if (Boolean.TRUE.equals(intern.getIsDeleted())) {

            throw new ResourceNotFoundException(
                    "Intern not found"
            );
        }

        return mapToResponse(intern);
    }

    @Override
    public InternResponse createIntern(
            InternRequest dto
    ) {

        Intern intern = new Intern();

        intern.setName(dto.getName());
        intern.setEmail(dto.getEmail());
        intern.setDepartment(dto.getDepartment());
        intern.setCollege(dto.getCollege());
        intern.setPhone(dto.getPhone());
        intern.setJoiningDate(dto.getJoiningDate());
        intern.setStatus(dto.getStatus());

        Intern savedIntern =
                internRepository.save(intern);

        return mapToResponse(savedIntern);
    }

    @Override
    public InternResponse updateIntern(
            Integer id,
            InternRequest dto
    ) {

        Intern intern = internRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Intern not found"
                        )
                );

        if (Boolean.TRUE.equals(intern.getIsDeleted())) {

            throw new ResourceNotFoundException(
                    "Intern not found"
            );
        }

        intern.setName(dto.getName());
        intern.setEmail(dto.getEmail());
        intern.setDepartment(dto.getDepartment());
        intern.setCollege(dto.getCollege());
        intern.setPhone(dto.getPhone());
        intern.setJoiningDate(dto.getJoiningDate());
        intern.setStatus(dto.getStatus());

        Intern updatedIntern =
                internRepository.save(intern);

        return mapToResponse(updatedIntern);
    }

    @Override
    public void deleteIntern(
            Integer id
    ) {

        Intern intern = internRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Intern not found"
                        )
                );

        if (Boolean.TRUE.equals(intern.getIsDeleted())) {

            throw new ResourceNotFoundException(
                    "Intern not found"
            );
        }

        intern.setIsDeleted(true);

        internRepository.save(intern);
    }

    @Override
    public List<InternResponse> searchInterns(
            String keyword
    ) {

        return internRepository
                .findByNameContainingIgnoreCaseAndIsDeletedFalse(keyword)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public Page<InternResponse> filterInterns(
            InternStatus status,
            String department,
            int page,
            int size,
            String sortBy,
            String direction
    ) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable =
                PageRequest.of(page, size, sort);

        Page<Intern> internPage;

        if (status != null && department != null) {

            internPage =
                    internRepository
                            .findByStatusAndDepartmentContainingIgnoreCaseAndIsDeletedFalse(
                                    status,
                                    department,
                                    pageable
                            );

        } else if (status != null) {

            internPage =
                    internRepository.findByStatusAndIsDeletedFalse(
                            status,
                            pageable
                    );

        } else if (department != null) {

            internPage =
                    internRepository
                            .findByDepartmentContainingIgnoreCaseAndIsDeletedFalse(
                                    department,
                                    pageable
                            );

        } else {

            internPage =
                    internRepository.findByIsDeletedFalse(pageable);
        }

        List<InternResponse> responses =
                internPage.getContent()
                        .stream()
                        .map(this::mapToResponse)
                        .toList();

        return new PageImpl<>(
                responses,
                pageable,
                internPage.getTotalElements()
        );
    }

    private InternResponse mapToResponse(
            Intern intern
    ) {

        InternResponse response =
                new InternResponse();

        response.setId(intern.getId());
        response.setName(intern.getName());
        response.setEmail(intern.getEmail());
        response.setDepartment(intern.getDepartment());
        response.setCollege(intern.getCollege());
        response.setPhone(intern.getPhone());
        response.setJoiningDate(intern.getJoiningDate());
        response.setStatus(intern.getStatus());

        return response;
    }
}