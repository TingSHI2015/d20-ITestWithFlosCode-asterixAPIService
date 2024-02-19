package de.neuefische.asterixapi.controller;

import de.neuefische.asterixapi.model.AsterixCharacter;
import de.neuefische.asterixapi.repository.AsterixRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixRepo repo;
    @GetMapping("/characters")
    public List<AsterixCharacter> getAllCharacter(){
        return repo.findAll();
    }
}
