package use_case.data_access;

import use_case.animalDatatAccess.AnimalDataAccessInteractor;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AnimalDataAccessTest {

    @Test
    public void testAnimalList() {
        Map<String, List<Object>> recievedAnimals = AnimalDataAccessInteractor.getAnimal("tiger");
        String[] animals = {"Sumatran Tiger", "White Tiger", "Indochinese Tiger", "Saber-Toothed Tiger",
                "Malayan Tiger", "South China Tiger", "Bengal Tiger", "Tiger", "Siberian Tiger"};
        List<String> expectedAnimals = Arrays.asList(animals);
        List<String> realAnimals = new ArrayList();
        for (String animal: recievedAnimals.keySet()) {
            realAnimals.add(animal);
        }
        assertEquals(expectedAnimals, realAnimals);
    }

    @Test
    public void testAnimalLocation() {
        Map<String, List<Object>> recievedAnimals = AnimalDataAccessInteractor.getAnimal("pig");
        List<String> location = (List) recievedAnimals.get("Pig").get(0);
        String[] locationPig = {"Asia","Eurasia","Europe","North-America"};
        List<String> expectedLocation = Arrays.asList(locationPig);
        assertEquals(location, expectedLocation);
    }

    @Test
    public void animalNotInAvailableAnimals() {
        Map<String, List<Object>> recievedAnimals = AnimalDataAccessInteractor.getAnimal("cat");
        assertEquals(new HashMap<String, List<Object>>(), recievedAnimals);
    }

    @Test
    public void instaniateAPI() {
        assertThrows(AssertionError.class, () -> {
            new AnimalDataAccessInteractor();
        });
    }

}
