package com.example.intern_dashboard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern_dashboard.entity.Intern;
import com.example.intern_dashboard.enums.InternStatus;

public interface InternRepository
        extends JpaRepository<Intern, Integer> {

    Page<Intern>
    findByNameContainingIgnoreCaseAndIsDeletedFalse(
            String keyword,
            Pageable pageable
    );

    Page<Intern> findByIsDeletedFalse(
            Pageable pageable
    );

    Page<Intern> findByStatusAndIsDeletedFalse(
            InternStatus status,
            Pageable pageable
    );

    Page<Intern>
    findByDepartmentContainingIgnoreCaseAndIsDeletedFalse(
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