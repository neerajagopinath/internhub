package com.example.intern_dashboard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern_dashboard.entity.Intern;
import com.example.intern_dashboard.enums.InternStatus;

public interface InternRepository
        extends JpaRepository<Intern, Integer> {

    List<Intern> findByNameContainingIgnoreCaseAndIsDeletedFalse(
            String keyword
    );

    Page<Intern> findByIsDeletedFalse(
            Pageable pageable
    );

    Page<Intern> findByStatusAndIsDeletedFalse(
            InternStatus status,
            Pageable pageable
    );

    Page<Intern> findByDepartmentContainingIgnoreCaseAndIsDeletedFalse(
            String department,
            Pageable pageable
    );

    Page<Intern>
    findByStatusAndDepartmentContainingIgnoreCaseAndIsDeletedFalse(
            InternStatus status,
            String department,
            Pageable pageable
    );
}