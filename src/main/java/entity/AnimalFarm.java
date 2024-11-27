package entity;

import java.util.*;

import data_access.AnimalDataAccessObject;

/**
 * The animals in the program.
 */
public class AnimalFarm {
    private Map<String, Integer> currentAnimals;
    private List<Animal> selectedAnimals;
    private Map<String, Animal> animalMap;
    private Random rand = new Random();
    private List<String> availableAnimals;

    public AnimalFarm(String[] availableAnimals) {
        this.availableAnimals = Arrays.asList(availableAnimals);
        this.selectedAnimals = new ArrayList<>();
        this.currentAnimals = new HashMap<>();
        this.animalMap = new HashMap<>();

        for (String animalsSpecies : this.availableAnimals) {
            final Map<String, List> listOfAnimalSameSpecies =
                    AnimalDataAccessObject.getAnimal(animalsSpecies.toLowerCase());
            for (String animalName : listOfAnimalSameSpecies.keySet()) {
                if (animalName != null) {
                    final Animal tempAnimal = new Animal(animalName,
                            (String) listOfAnimalSameSpecies.get(animalName).get(2),
                            (List<String>) listOfAnimalSameSpecies.get(animalName).get(0),
                            (String) listOfAnimalSameSpecies.get(animalName).get(1));

                    selectedAnimals.add(tempAnimal);
                    animalMap.put(tempAnimal.getName(), tempAnimal);
                }
                else {
                    System.err.println("Animal not found or family does not match: " + animalName);
                }
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
     * @param removeCount the number of animals to remove
     */
    public void removeAnimal(int removeCount) {
        if (!currentAnimals.isEmpty()) {
            for (int i = 0; i < removeCount; i++) {
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
    }

    public List<String> getAvailableAnimals() {
        return availableAnimals;
    }
    
    public List<Animal> getSelectedAnimals() {
        return selectedAnimals;
    }

    public Map<String, Integer> getCurrentAnimals() {
        return currentAnimals;
    }

    public Map<String, Animal> getAnimalMap() {
        return animalMap;
    }
}
