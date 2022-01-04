package com.cyber.conttoller;

import com.cyber.entity.Cinema;
import com.cyber.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
@Tag(name = "Cinema",description = "Cinema API") // swagger tag
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @GetMapping
    @Operation(summary = "Get all cinemas")
    public List<Cinema> readAll(){
        return cinemaRepository.findAll();
    }
}
