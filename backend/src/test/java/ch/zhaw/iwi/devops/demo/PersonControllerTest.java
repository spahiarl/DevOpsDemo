package ch.zhaw.iwi.devops.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PersonControllerTest {
    // Testfall für die Methode person()
    @Test
    public void testPerson() {
        PersonController controller = new PersonController();
        controller.init();

        List<PathListEntry<Integer>> persons = controller.person();
        Assertions.assertEquals(5, persons.size());

        // Überprüfen Sie die Details der ersten Person
        PathListEntry<Integer> firstPerson = persons.get(0);
        Assertions.assertEquals("Neuer Job", firstPerson.getName());
        Assertions.assertEquals("5 DevOps Engineers einstellen", firstPerson.getDetails().get(0));
        Assertions.assertEquals("5 DevOps Engineers einstellen", firstPerson.getTooltip());
    }

    // Testfall für die Methode ping()
    @Test
    public void testPing() {
        PersonController controller = new PersonController();
        controller.init();

        String expectedResponse = "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}";
        String pingResponse = controller.ping();
        Assertions.assertEquals(expectedResponse, pingResponse);
    }

    // Testfall für die Methode test()
    @Test
    public void testTest() {
        PersonController controller = new PersonController();
        controller.init();

        String expectedResponse = "Hello World app is up and running!";
        String testResponse = controller.test();
        Assertions.assertEquals(expectedResponse, testResponse);
    }
    
    @Test
    public void testGetAllPerson1() {
        PersonController controller = new PersonController();
        controller.init();
        Map<Integer, Person> allPersons = controller.getAllPerson();
        Assertions.assertEquals(5, allPersons.size());
    }

    @Test
    public void testGetAllPerson2() {
        PersonController controller = new PersonController();
        controller.init();

        Map<Integer, Person> expected = new HashMap<>();
        expected.put(1, new Person(1, "Barack Obama", "Neuer Job", "5 DevOps Engineers einstellen"));
        expected.put(2, new Person(2, "Donald Trump", "Geschäftsleitung", "Mit Präsentation von DevOps überzeugen"));
        expected.put(3, new Person(3, "Joe Biden", "Unit Tests", "Neues Projekt mit Unit Tests starten"));
        expected.put(4, new Person(4, "George W. Bush", "Deployment", "Jede Woche!"));
        expected.put(5, new Person(5, "Bill Clinton", "Organigramm", "Löschen"));


        Map<Integer, Person> actual = controller.getAllPerson();

        Assertions.assertEquals(expected.size(), actual.size());
        
        for (Integer id : expected.keySet()) {
            Assertions.assertTrue(actual.containsKey(id));
            Assertions.assertEquals(expected.get(id).getId(), actual.get(id).getId());
            Assertions.assertEquals(expected.get(id).getName(), actual.get(id).getName());
        }
    }

    @Test
    public void testGetPerson() {
        PersonController controller = new PersonController();
        controller.init();
        Integer id = 1;
        Person person = controller.getPerson(id);

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Barack Obama", person.getName());
    }

    @Test
    public void testCreatePerson() {
        PersonController controller = new PersonController();
        controller.init();

        Person newPerson = new Person(6, "Max Mustermann", "Test Engineer", "Testet alle Applikationen");
        controller.createPerson(newPerson);
        Assertions.assertEquals(6, controller.count());
        Person createdPerson = controller.getPerson(6);
        Assertions.assertNotNull(createdPerson);
        Assertions.assertEquals("Max Mustermann", createdPerson.getName());
    }

    @Test
    public void testUpdatePerson() {
        PersonController controller = new PersonController();
        controller.init();
        
        Person updatedPerson = new Person(2, "Donald Trump", "Arbeitslos", "Anwärter für zweite Amtszeit");
        controller.updatePerson(2, updatedPerson);
        Person person = controller.getPerson(2);
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Arbeitslos", person.getTitle());
        Assertions.assertEquals("Anwärter für zweite Amtszeit", person.getDescription());
    }

    @Test
    public void testDeletePerson() {
        PersonController controller = new PersonController();
        controller.init();

        Person deletedPerson = controller.deletePerson(3);
        Assertions.assertNotNull(deletedPerson);
        Assertions.assertEquals(4, controller.count());
        Person deletedPersonCheck = controller.getPerson(3);
        Assertions.assertNull(deletedPersonCheck);
    }

}