package entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testGetName() {
        User user1 = new User("user one", "123456");
        assertEquals("user one", user1.getName());
    }

    @Test
    public void testGetPassword() {
        User user1 = new User("user one", "123456");
        assertEquals("123456", user1.getPassword());
    }
}
