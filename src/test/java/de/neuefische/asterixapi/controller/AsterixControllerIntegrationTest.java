package de.neuefische.asterixapi.controller;

import de.neuefische.asterixapi.repository.AsterixRepo;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AsterixControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AsterixRepo asterixRepo;

    @Test
    @DirtiesContext
    void getAllCharacter() throws Exception {
        //GIVEN
//        Character c1 = new Character("1", "Asterix", 35, "Krieger");
//        asterixRepo.save(c1);

        //WHEN
//        mockMvc.perform(get("/api/asterix/characters"))
//                .andExpect(status().isOk());
//

        mockMvc.perform(get("api/asterix/characters"))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                            {
                              "id": "1",
                              "title": "apple"
                            }
                        ]
                        """));
    }






    }



    @Test
    @DirtiesContext
    void saveNewAsterixCharacter() {
    }

    @Test
    @DirtiesContext
    void updateAsterixCharacter() {
    }

    @Test
    @DirtiesContext
    void deleteCharacter() {
    }
}