package com.example.jpamanytoone.repositories;

import com.example.jpamanytoone.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
}
