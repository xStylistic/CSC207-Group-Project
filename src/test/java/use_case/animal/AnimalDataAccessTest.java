package use_case.animal;

import data_access.AnimalDataAccessObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AnimalDataAccessTest {

    @Test
    public void testAnimalList() {
        Map<String, List<Object>> recievedAnimals = AnimalDataAccessObject.getAnimal("tiger");
        String[] animals = {"Bengal Tiger", "Indochinese Tiger", "Malayan Tiger", "Saber-Toothed Tiger",
                "Siberian Tiger", "South China Tiger", "Sumatran Tiger", "Tiger", "White Tiger"};
        List<String> expectedAnimals = Arrays.asList(animals);
        assertEquals(recievedAnimals, expectedAnimals);
    }

    @Test
    public void testAnimalLocation() {
        Map<String, List<Object>> recievedAnimals = AnimalDataAccessObject.getAnimal("pig");
        List<String> location = (List) recievedAnimals.get("pig").get(1);
        String[] locationPig = {"Asia","Eurasia","Europe","North-America"};
        List<String> expectedLocation = Arrays.asList(locationPig);
        assertEquals(location, expectedLocation);
    }

    @Test
    public void animalNotInAvailableAnimals() {
        Map<String, List<Object>> recievedAnimals = AnimalDataAccessObject.getAnimal("cat");
        assertNull(recievedAnimals);
    }

}
