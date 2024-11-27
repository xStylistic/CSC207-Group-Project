package entity;

import java.util.*;

import data_access.AnimalDataAccessObject;

/**
 * The animals in the program.
 */
public class AnimalFarm {
    private List<Animal> currentAnimals;
    private List<Animal> selectedAnimals;
    private Random rand = new Random();
    private List<String> availableAnimals;

    public AnimalFarm(String[] availableAnimals) {
        this.availableAnimals = Arrays.asList(availableAnimals);
        this.selectedAnimals = new ArrayList<>();
        this.currentAnimals = new ArrayList<Animal>();

        for (String animalsSpecies : this.availableAnimals) {
            final Map<String, List> listOfAnimalSameSpecies =
                    AnimalDataAccessObject.getAnimal(animalsSpecies.toLowerCase());
            for (String animalName : listOfAnimalSameSpecies.keySet()) {
                if (animalName != null) {
                    final Animal tempAnimal = new Animal(animalName, animalsSpecies,
                            (String) listOfAnimalSameSpecies.get(animalName).get(2),
                            (List<String>) listOfAnimalSameSpecies.get(animalName).get(0),
                            (String) listOfAnimalSameSpecies.get(animalName).get(1));

                    selectedAnimals.add(tempAnimal);
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
            final int index = rand.nextInt(selectedAnimals.size());
            final Animal animalToAdd = selectedAnimals.get(index);
            // Increase the number of the animal
            currentAnimals.add(animalToAdd);
        }
    }

    /**
     * Remove specific animals from the farm.
     * @param removeCount the number of animals to remove
     * @return List of removed animal names for tracking/notification purposes
     */
    public void removeAnimal(int removeCount) {
        if (!currentAnimals.isEmpty()) {
            for (int i = 0; i < removeCount; i++) {
                final int randomInt = rand.nextInt(currentAnimals.size());
                currentAnimals.remove(randomInt);
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

    public List<Animal> getCurrentAnimals() {
        return currentAnimals;
    }
}
