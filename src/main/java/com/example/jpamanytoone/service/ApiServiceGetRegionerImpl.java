package com.example.jpamanytoone.service;

import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner {
    private final RestTemplate restTemplate;
    public ApiServiceGetRegionerImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Autowired
    RegionRepository regionRepository;
    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(region -> regionRepository.save(region));
    }

    @Override
    public List<Region> getRegioner() {
    List<Region> lst = new ArrayList<>();
    ResponseEntity<List<Region>> regionResponse =
            restTemplate.exchange(regionUrl,
                    HttpMethod.GET, null, new      ParameterizedTypeReference<List<Region>>(){

                    });
    List<Region> regioner = regionResponse.getBody();
    saveRegioner(regioner);
    return regioner;




        }

}



