package com.example.agri_back.services;

import com.example.agri_back.dto.CooperativeDto;

import java.util.List;

public interface CooperativeService {

    CooperativeDto CreateCooperative(CooperativeDto cooperativeDto);

    List<CooperativeDto> allCooperatives();
}
