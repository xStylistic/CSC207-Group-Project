package entity;

import java.util.List;

public class Animal {
    private String name;
    private String family;
    private List<String> locations;
    private String fact;

    public Animal(String name, String family, List<String> locations, String fact) {
        this.name = name;
        this.family = family;
        this.locations = locations;
        this.fact = fact;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", family='" + family + '\'' + ", locations=" + locations
                + ", fact='" + fact + '\'' + '}';
    }
}
