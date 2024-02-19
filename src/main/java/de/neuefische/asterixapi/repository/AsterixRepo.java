package de.neuefische.asterixapi.repository;

import de.neuefische.asterixapi.model.AsterixCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AsterixRepo extends MongoRepository<AsterixCharacter, String> {
}
