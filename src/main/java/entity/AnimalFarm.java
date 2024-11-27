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

            final Set<String> animalNames = new HashSet<>(Arrays.asList(
                    "alpaca",
                    "bear",
                    "chicken",
                    "cow",
                    "farm",
                    "flamingo",
                    "fox",
                    "pig",
                    "rabbit",
                    "tiger"
            ));

            while (!animalNames.contains(animalToAdd.getName().toLowerCase())) {
                index = rand.nextInt(selectedAnimals.size());
                animalToAdd = selectedAnimals.get(index);
                name = animalToAdd.getName();
            }

            // Increase the number of the animal
            currentAnimals.put(name, currentAnimals.getOrDefault(name, 0) + 1);
        }
    }

    /**
     * Remove specific animals from the farm.
     * @param removeCount the number of animals to remove
     * @return List of removed animal names for tracking/notification purposes
     */
    public void removeAnimal(int removeCount) {
        // Safety check - if there are no animals or invalid removeCount, return empty list
        if (currentAnimals.isEmpty() || removeCount <= 0) {
            return;
        }

        // Create a list to track available animals for removal
        List<String> availableForRemoval = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : currentAnimals.entrySet()) {
            // Add each animal name according to its current count
            for (int i = 0; i < entry.getValue(); i++) {
                availableForRemoval.add(entry.getKey());
            }
        }

        // Remove animals while we still have animals available and haven't hit our target
        int animalsRemoved = 0;
        while (!availableForRemoval.isEmpty() && animalsRemoved < removeCount) {
            int index = rand.nextInt(availableForRemoval.size());
            String nameToRemove = availableForRemoval.get(index);

            // Update the currentAnimals map
            int currentCount = currentAnimals.get(nameToRemove);
            if (currentCount > 1) {
                currentAnimals.put(nameToRemove, currentCount - 1);
            } else {
                currentAnimals.remove(nameToRemove);
            }

            // Remove one instance of this animal from available pool
            availableForRemoval.remove(index);

            animalsRemoved++;
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
