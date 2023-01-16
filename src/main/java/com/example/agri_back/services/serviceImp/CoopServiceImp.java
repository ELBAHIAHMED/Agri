package com.example.agri_back.services.serviceImp;

import com.example.agri_back.dto.CooperativeDto;
import com.example.agri_back.model.Cooperative;
import com.example.agri_back.repositories.CooperativeRepository;
import com.example.agri_back.services.CooperativeService;
import com.example.agri_back.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoopServiceImp implements CooperativeService {
    @Autowired
    Utils utils;
    @Autowired
    CooperativeRepository cooperativeRepository;


    @Override
    public CooperativeDto CreateCooperative(CooperativeDto cooperativeDto) {
        Cooperative cooperative = new Cooperative();
        BeanUtils.copyProperties(cooperativeDto,cooperative);
        cooperative.setCooperativeId(utils.generateUserId(12));
        Cooperative cooperative1 =cooperativeRepository.save(cooperative);
        CooperativeDto cooperativeDto1 = new CooperativeDto();
        BeanUtils.copyProperties(cooperative1,cooperativeDto1);
        return cooperativeDto1;
    }

    @Override
    public List<CooperativeDto> allCooperatives() {
        List<Cooperative> listCoop =cooperativeRepository.findAll();
        List<CooperativeDto> resultList = new ArrayList<>();
        for (Cooperative coop:listCoop){
            CooperativeDto cooperativeDto = new CooperativeDto();
            BeanUtils.copyProperties(coop,cooperativeDto);
            resultList.add(cooperativeDto);
        }

        return resultList;

    }


}
