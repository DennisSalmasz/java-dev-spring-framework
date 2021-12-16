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
}
