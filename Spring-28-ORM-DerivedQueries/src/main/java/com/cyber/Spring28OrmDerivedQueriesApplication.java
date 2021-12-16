package com.cyber;

import com.cyber.entity.Region;
import com.cyber.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Spring28OrmDerivedQueriesApplication {

    @Autowired
    RegionRepository regionRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring28OrmDerivedQueriesApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){
        System.out.println("-----------------Region start----------------");
        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-----------------Region end----------------");
    }

}
