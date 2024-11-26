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
        List<String> recievedAnimals = AnimalDataAccessObject.getAnimal("tiger");
        String[] animals = {"Bengal Tiger", "Indochinese Tiger", "Malayan Tiger", "Saber-Toothed Tiger", "Siberian Tiger", "South China Tiger", "Sumatran Tiger", "Tiger", "White Tiger"};
        List<String> expectedAnimals = Arrays.asList(animals);
        assertEquals(recievedAnimals, expectedAnimals);
    }

    @Test
    public void testAnimalLocation() {
        List<String> recievedAnimals = AnimalDataAccessObject.getAnimal("pig");
        Map<String, List> animalList = AnimalDataAccessObject.getAnimalsList();
        List location = animalList.get("pig");
        String[] locationPig = {"Asia","Eurasia","Europe","North-America"};
        List expectedLocation = Arrays.asList(locationPig);
        assertEquals(location, expectedLocation);
    }

    @Test
    public void animalNotInAvailbleAnimals() {
        List<String> recievedAnimals = AnimalDataAccessObject.getAnimal("cat");
        Map<String, List> animalList = AnimalDataAccessObject.getAnimalsList();
        assertEquals(null, animalList);
    }

}
