package com.example.intern_dashboard.controller;

import com.example.intern_dashboard.dto.request.InternRequest;
import com.example.intern_dashboard.dto.response.ApiResponse;
import com.example.intern_dashboard.dto.response.InternResponse;
import com.example.intern_dashboard.service.InternService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
public class InternController {

    private final InternService internService;

    public InternController(InternService internService) {
        this.internService = internService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createIntern(
            @RequestBody InternRequest request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(internService.createIntern(request));
    }

    @GetMapping
    public ResponseEntity<List<InternResponse>> getAllInterns() {

        return ResponseEntity.ok(internService.getAllInterns());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternResponse> getInternById(
            @PathVariable int id
    ) {

        return ResponseEntity.ok(internService.getInternById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteIntern(
            @PathVariable int id
    ) {

        return ResponseEntity.ok(
                internService.deleteIntern(id)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<InternResponse>> searchInterns(
            @RequestParam String name
    ) {

        return ResponseEntity.ok(
                internService.searchInterns(name)
        );
    }

    @PutMapping("/{id}")
        public ResponseEntity<InternResponse>
        updateIntern(
                @PathVariable Integer id,
                @RequestBody InternRequest dto
        ) {

        return ResponseEntity.ok(
                internService.updateIntern(id, dto)
        );

        }
}