package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonControllerTest {
    
    @Test
    public void testCreate() {
        PersonController controller = new PersonController();
        var person = new Person(1, "n", "t", "d");
        controller.createPerson(person);
        assertEquals(1, controller.count());
        assertEquals(1, controller.person().size());
    }

}
