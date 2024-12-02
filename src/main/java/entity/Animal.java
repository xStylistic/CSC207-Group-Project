package entity;

import java.util.List;

import data_access.Constants;

/**
 * Blueprint for the animal object.
 */
public class Animal {
    private String name;
    private String typeAnimal;
    private String family;
    private List<String> locations;
    private String fact;
    private double xCoordinate;
    private double yCoordinate;

    public Animal(String name, String typeAnimal, String family, List<String> locations, String fact) {
        this.name = name;
        this.typeAnimal = typeAnimal;
        this.family = family;
        this.locations = locations;
        this.fact = fact;
        this.xCoordinate = Constants.HUNDRED + Math.random() * Constants.SEVENHUNDREDTWENTYTHREE;
        this.yCoordinate = Constants.FOURFORTY + Math.random() * Constants.TEN;
    }

    public String getName() {
        return name;
    }

    public String getTypeAnimal() {
        return typeAnimal.toLowerCase();
    }

    public String getFamily() {
        return family;
    }

    public List<String> getLocations() {
        return locations;
    }

    public String getFact() {
        return fact;
    }

    /**
     * Gets the x coordinate.
     * @return the x coordinate.
     */
    public double getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Gets the y coordinate.
     * @return the x coordinate.
     */
    public double getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", family='" + family + '\'' + ", locations=" + locations
                + ", fact='" + fact + '\'' + '}';
    }
}
