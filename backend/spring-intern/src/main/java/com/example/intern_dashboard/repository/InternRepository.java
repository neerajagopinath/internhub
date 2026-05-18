package com.example.intern_dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern_dashboard.entity.Intern;

public interface InternRepository
        extends JpaRepository<Intern, Integer> {

    List<Intern> findByNameContainingIgnoreCase(String name);

}