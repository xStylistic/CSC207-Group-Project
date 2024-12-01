package entity;

import java.util.List;

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
        this.xCoordinate = 100 + Math.random() * 723;
        this.yCoordinate = 440 + Math.random() * 10;
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

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", family='" + family + '\'' + ", locations=" + locations
                + ", fact='" + fact + '\'' + '}';
    }
}
