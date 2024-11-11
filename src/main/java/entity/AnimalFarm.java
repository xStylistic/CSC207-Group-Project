package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import data_access.ApiAccess;

/**
 * The animals in the program.
 */
public class AnimalFarm {
    private Map<String, Integer> currentAnimals;
    private List<Animal> selectedAnimals;
    private Map<String, Animal> animalMap;
    private Random rand = new Random();

    public AnimalFarm(List<String> selectedAnimalNames) {
        this.selectedAnimals = new ArrayList<>();
        this.currentAnimals = new HashMap<>();
        this.animalMap = new HashMap<>();

        for (String animalName : selectedAnimalNames) {
            final Animal animal = (Animal) ApiAccess.getAnimal(animalName.toLowerCase());
            if (animal != null) {
                selectedAnimals.add(animal);
                currentAnimals.put(animal.getName(), 1);
                animalMap.put(animal.getName(), animal);
            }
            else {
                System.err.println("Animal not found or family does not match: " + animalName);
            }
        }
    }

    /**
     * Add a random animal from the selected animals.
     */
    public void addAnimal() {
        if (!selectedAnimals.isEmpty()) {
            final int index = rand.nextInt(selectedAnimals.size());
            final Animal animalToAdd = selectedAnimals.get(index);
            final String name = animalToAdd.getName();

            // Increase the number of the animal
            currentAnimals.put(name, currentAnimals.getOrDefault(name, 0) + 1);
        }
    }

    /**
     * Remove an animal from the farm.
     */
    public void removeAnimal() {
        if (!currentAnimals.isEmpty()) {
            // Get a list of animal names currently on the farm
            final List<String> animalNames = new ArrayList<>(currentAnimals.keySet());
            final int index = rand.nextInt(animalNames.size());
            final String name = animalNames.get(index);

            // Decrease the count of the animal
            final int count = currentAnimals.get(name);
            if (count > 1) {
                currentAnimals.put(name, count - 1);
            }
            else {
                currentAnimals.remove(name);
            }
        }
    }

    public Map<String, Integer> getCurrentAnimals() {
        return currentAnimals;
    }

    public Map<String, Animal> getAnimalMap() {
        return animalMap;
    }
}
