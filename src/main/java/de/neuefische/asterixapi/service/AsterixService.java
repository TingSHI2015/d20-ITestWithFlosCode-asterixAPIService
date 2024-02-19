package de.neuefische.asterixapi.service;

import de.neuefische.asterixapi.model.AsterixCharacter;
import de.neuefische.asterixapi.model.AsterixCharacterDto;
import de.neuefische.asterixapi.repository.AsterixRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AsterixService {

    private final AsterixRepo repo;
    private final IdService idService;

    public List<AsterixCharacter> findAllCharacters() {
        return repo.findAll();
    }


    public AsterixCharacter saveNewAsterixCharacter(AsterixCharacterDto asterixCharacter) {
        AsterixCharacter newCharacter = new AsterixCharacter(
                idService.generateRandomId(),
                asterixCharacter.name(),
                asterixCharacter.age(),
                asterixCharacter.profession());
        repo.save(newCharacter);
        return repo.findById(newCharacter.id()).orElseThrow();
    }

    public AsterixCharacter updateCharacterById(String id, AsterixCharacterDto asterixCharacter) {
        if (repo.existsById(id)){
            AsterixCharacter newCharacter = new AsterixCharacter(
                    id,
                    asterixCharacter.name(),
                    asterixCharacter.age(),
                    asterixCharacter.profession());
            repo.save(newCharacter);
            return repo.findById(id).orElseThrow();
        }else {
            throw new NoSuchElementException("No Char found with Id:" + id);
        }
    }

    public boolean deleteCharById(String id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
           return true;
        }else {
            throw new NoSuchElementException("No Char found with Id:" + id);
        }

    }
}
