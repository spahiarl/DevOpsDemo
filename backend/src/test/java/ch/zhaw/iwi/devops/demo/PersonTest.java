package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPerson() {
        var persons1 = new Person(1, "name", "title", "description");
        assertEquals("title", persons1.getTitle());
        assertEquals("description", persons1.getDescription());
        assertEquals(1, persons1.getId());
    }

    @Test
    public void testPersonConstructor() {
        // Arrange
        int id = 1;
        String name = "John Doe";
        String title = "Engineer";
        String description = "Experienced software engineer";

        // Act
        Person person = new Person(id, name, title, description);

        // Assert
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(title, person.getTitle());
        assertEquals(description, person.getDescription());
    }

    @Test
    public void testSetId() {
        // Arrange
        int id = 1;
        Person person = new Person();

        // Act
        person.setId(id);

        // Assert
        assertEquals(id, person.getId());
    }

    @Test
    public void testSetName() {
        // Arrange
        String name = "John Doe";
        Person person = new Person();

        // Act
        person.setName(name);

        // Assert
        assertEquals(name, person.getName());
    }

    @Test
    public void testGetTitle() {
        // Arrange
        String title = "Engineer";
        Person person = new Person();

        // Act

        // Assert
        assertNull(person.getTitle());
        person.setTitle(title);
        assertEquals(title, person.getTitle());
    }

    @Test
    public void testGetDescription() {
        // Arrange
        String description = "Experienced software engineer";
        Person person = new Person();

        // Act

        // Assert
        assertNull(person.getDescription());
        person.setDescription(description);
        assertEquals(description, person.getDescription());
    }
    
}
