package com.example.agri_back.repositories;

import com.example.agri_back.model.Cooperative;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CooperativeRepository extends JpaRepository<Cooperative,Long> {

    Cooperative findByCooperativeId(String cooperativeId);
}
