package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPerson() {
        var persons1 = new Person(1, "name", "title", "description");
        assertEquals("title", persons1.getTitle());
        assertEquals("description", persons1.getDescription());
        assertEquals(1, persons1.getId());
    }
    
}
