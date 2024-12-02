package entity;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void testGetName() {
        Animal dog = new Animal("Dog1", "dog", "dog family",
                List.of(new String[]{"Home", "School"}), "dogs can count");
        String name = dog.getName();
        assertEquals("Dog1", name);
    }

    @Test
    public void testGetTypeAnimal() {
        Animal dog = new Animal("Dog1", "dogType", "dog family",
                List.of(new String[]{"Home", "School"}), "dogs can count");
        String type = dog.getTypeAnimal();
        assertEquals("dogtype", type);
    }

    @Test
    public void testGetFamily() {
        Animal dog = new Animal("Dog1", "dogType", "dog family",
                List.of(new String[]{"Home", "School"}), "dogs can count");
        String family = dog.getFamily();
        assertEquals("dog family", family);
    }

    @Test
    public void testGetLocation() {
        Animal dog = new Animal("Dog1", "dogType", "dog family",
                List.of(new String[]{"Home", "School"}), "dogs can count");
        List<String> location = dog.getLocations();
        String[] expectedLocation = {"Home", "School"};
        assertEquals(Arrays.asList(expectedLocation), location);
    }

    @Test
    public void testFact() {
        Animal dog = new Animal("Dog1", "dogType", "dog family",
                List.of(new String[]{"Home", "School"}), "dogs can count");
        String fact = dog.getFact();
        assertEquals("dogs can count", fact);
    }

    @Test
    public void testCoordinate() {
        Animal dog = new Animal("Dog1", "dogType", "dog family",
                List.of(new String[]{"Home", "School"}), "dogs can count");
        double xCoord = dog.getxCoordinate();
        double yCoord = dog.getyCoordinate();
        assertTrue(xCoord >= 0 && yCoord >= 0);
    }
}
