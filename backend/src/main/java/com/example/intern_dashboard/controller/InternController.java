package com.example.intern_dashboard.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern_dashboard.dto.request.InternRequest;
import com.example.intern_dashboard.dto.response.InternResponse;
import com.example.intern_dashboard.enums.InternStatus;
import com.example.intern_dashboard.service.InternService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/interns")
@CrossOrigin(origins = "http://localhost:5173")
public class InternController {

    private final InternService internService;

    public InternController(
            InternService internService
    ) {
        this.internService = internService;
    }

    @GetMapping
    public ResponseEntity<Page<InternResponse>>
    getAllInterns(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction

    ) {

        return ResponseEntity.ok(
                internService.getAllInterns(
                        page,
                        size,
                        sortBy,
                        direction
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternResponse>
    getInternById(
            @PathVariable Integer id
    ) {

        return ResponseEntity.ok(
                internService.getInternById(id)
        );
    }

    @PostMapping
    public ResponseEntity<InternResponse>
    createIntern(

            @Valid
            @RequestBody InternRequest dto

    ) {

        InternResponse createdIntern =
                internService.createIntern(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdIntern);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternResponse>
    updateIntern(

            @PathVariable Integer id,

            @Valid
            @RequestBody InternRequest dto

    ) {

        InternResponse updatedIntern =
                internService.updateIntern(id, dto);

        return ResponseEntity.ok(updatedIntern);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deleteIntern(
            @PathVariable Integer id
    ) {

        internService.deleteIntern(id);

        return ResponseEntity.ok(
                "Intern deleted successfully"
        );
    }

    @GetMapping("/search")
    public ResponseEntity<Page<InternResponse>>
    searchInterns(

            @RequestParam String keyword,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction

    ) {

    return ResponseEntity.ok(

        internService.searchInterns(
                keyword,
                page,
                size,
                sortBy,
                direction
        )
    );
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<InternResponse>>
    filterInterns(

            @RequestParam(required = false)
            InternStatus status,

            @RequestParam(required = false)
            String department,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction

    ) {

        return ResponseEntity.ok(
                internService.filterInterns(
                        status,
                        department,
                        page,
                        size,
                        sortBy,
                        direction
                )
        );
    }
}