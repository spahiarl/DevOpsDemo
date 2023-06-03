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
        int id = 1;
        String name = "John Doe";
        String title = "Engineer";
        String description = "Experienced software engineer";
        Person person = new Person(id, name, title, description);
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(title, person.getTitle());
        assertEquals(description, person.getDescription());
    }

    @Test
    public void testSetId() {
        int id = 1;
        Person person = new Person();
        person.setId(id);
        assertEquals(id, person.getId());
    }

    

}
