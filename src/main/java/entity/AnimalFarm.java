package entity;

import data_access.ApiAccess;
import java.util.*;

/**
 * The animals in the program.
 */
public class AnimalFarm {
    private Map<String, Integer> currentAnimals;
    private List<Animal> selectedAnimals;
    private Map<String, Animal> animalMap;
    Random rand = new Random();

    public AnimalFarm(List<String> selectedAnimalNames) {
        this.selectedAnimals = new ArrayList<>();
        this.currentAnimals = new HashMap<>();
        this.animalMap = new HashMap<>();

        for (String animalName : selectedAnimalNames) {
            Animal animal = (Animal) ApiAccess.getAnimal(animalName.toLowerCase());
            if (animal != null) {
                selectedAnimals.add(animal);
                currentAnimals.put(animal.getName(), 1);
                animalMap.put(animal.getName(), animal);
            } else {
                System.err.println("Animal not found or family does not match: " + animalName);
            }
        }
    }

    /**
     * Add a random animal from the selected animals.
     */
    public void addAnimal() {
        if (!selectedAnimals.isEmpty()) {
            int index = rand.nextInt(selectedAnimals.size());
            Animal animalToAdd = selectedAnimals.get(index);
            String name = animalToAdd.getName();

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
            List<String> animalNames = new ArrayList<>(currentAnimals.keySet());
            int index = rand.nextInt(animalNames.size());
            String name = animalNames.get(index);

            // Decrease the count of the animal
            int count = currentAnimals.get(name);
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
