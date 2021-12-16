package com.cyber.repository;

import com.cyber.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {

    //Display all regions in Canada
    List<Region> findByCountry(String country);

    //Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    //display all regions with country name including "United"
    List<Region> findByCountryContaining(String country);

    //display all regions with country name including "United" in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    //display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);
}
