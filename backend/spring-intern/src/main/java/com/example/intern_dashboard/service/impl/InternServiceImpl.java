package com.example.intern_dashboard.service.impl;

import com.example.intern_dashboard.dto.request.InternRequest;
import com.example.intern_dashboard.dto.response.ApiResponse;
import com.example.intern_dashboard.dto.response.InternResponse;
import com.example.intern_dashboard.entity.Intern;
import com.example.intern_dashboard.exception.ResourceNotFoundException;
import com.example.intern_dashboard.repository.InternRepository;
import com.example.intern_dashboard.service.InternService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternServiceImpl implements InternService {

    private final InternRepository internRepository;

    public InternServiceImpl(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    @Override
    public ApiResponse createIntern(InternRequest request) {

        Intern intern = new Intern();

        intern.setName(request.getName());
        intern.setEmail(request.getEmail());
        intern.setDepartment(request.getDepartment());
        intern.setCollege(request.getCollege());
        intern.setPhone(request.getPhone());
        intern.setJoiningDate(request.getJoiningDate());
        intern.setStatus(request.getStatus());

        internRepository.save(intern);

        return new ApiResponse("Intern added successfully");
    }

    @Override
    public List<InternResponse> getAllInterns() {

        return internRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public InternResponse getInternById(int id) {

        Intern intern = internRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Intern not found"));

        return mapToResponse(intern);
    }

    @Override
    public ApiResponse updateIntern(int id, InternRequest request) {

        Intern intern = internRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Intern not found"));

        intern.setName(request.getName());
        intern.setEmail(request.getEmail());
        intern.setDepartment(request.getDepartment());
        intern.setCollege(request.getCollege());
        intern.setPhone(request.getPhone());
        intern.setJoiningDate(request.getJoiningDate());
        intern.setStatus(request.getStatus());

        internRepository.save(intern);

        return new ApiResponse("Intern updated successfully");
    }

    @Override
    public ApiResponse deleteIntern(int id) {

        Intern intern = internRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Intern not found"));

        internRepository.delete(intern);

        return new ApiResponse("Intern deleted successfully");
    }

    @Override
    public List<InternResponse> searchInterns(String name) {

        return internRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private InternResponse mapToResponse(Intern intern) {

        return new InternResponse(
                intern.getId(),
                intern.getName(),
                intern.getEmail(),
                intern.getDepartment(),
                intern.getCollege(),
                intern.getPhone(),
                intern.getJoiningDate(),
                intern.getStatus()
        );
    }

    @Override
    public InternResponse updateIntern(

            Integer id,

            InternRequest dto

    ) {

        Intern intern = internRepository
                    .findById(id)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Intern not found"
                            )
                    );

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
}