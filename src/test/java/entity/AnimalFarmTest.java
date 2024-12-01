package entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalFarmTest {
    @Test
    public void testAddAnimal() {
        String[] animals = {
                "pig",
                "alpaca",
                "horse",
                "cow",
                "chicken",
                "fox",
                "bear",
                "tiger",
                "flamingo",
                "rabbit",
        };
        AnimalFarm farm = new AnimalFarm(animals);
        assertEquals(0, farm.getCurrentAnimals().size());
        farm.addAnimal();
        assertEquals(1, farm.getCurrentAnimals().size());
    }

    @Test
    public void testRemoveAnimal() {
        String[] animals = {
                "pig",
                "alpaca",
                "horse",
                "cow",
                "chicken",
                "fox",
                "bear",
                "tiger",
                "flamingo",
                "rabbit",
        };
        AnimalFarm farm = new AnimalFarm(animals);
        assertEquals(0, farm.getCurrentAnimals().size());
        farm.addAnimal();
        assertEquals(1, farm.getCurrentAnimals().size());
        farm.removeAnimal(1);
        assertEquals(0, farm.getCurrentAnimals().size());
    }
}
