package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PersonController {

    private Map<Integer, Person> persons = new HashMap<Integer, Person>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.persons.put(1,new Person(1, "Barack Obama", "Neuer Job", "5 DevOps Engineers einstellen"));
        this.persons.put(2,new Person(2, "Donald Trump", "Geschäftsleitung", "Mit Präsentation von DevOps überzeugen"));
        this.persons.put(3,new Person(3, "Joe Biden", "Unit Tests", "Neues Projekt mit Unit Tests starten"));
        this.persons.put(4,new Person(4, "George W. Bush", "Deployment", "Jede Woche!"));
        this.persons.put(5,new Person(5, "Bill Clinton", "Organigramm", "Löschen"));
        System.out.println("Init Data");
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World app is up and running!";
    }

    @GetMapping("/services/ping")
    public String ping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin"+ "\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1" + "\"}";
    }

    @GetMapping("/count")
    public int count() {
        return this.persons.size();
    }

    @GetMapping("/services/person")
    public List<PathListEntry<Integer>> person() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var person : this.persons.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(person.getId(), "personKey§");
            entry.setName(person.getTitle());
            entry.getDetails().add(person.getDescription());
            entry.setTooltip(person.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Integer id) {
        return this.persons.get(id);
    }


    @PostMapping("/person")
    public void createPerson(@RequestBody Person person) {
        var newId = this.persons.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1; 
        person.setId(newId);
        this.persons.put(newId, person);
    }

    @PutMapping("/person/{key}")
    public void updatePerson(@PathVariable Integer key, @RequestBody Person person) {
        person.setId(key); 
        this.persons.put(key, person);
    }
    

    @DeleteMapping("/person/{id}")
    public Person deletePerson(@PathVariable Integer id) {
        return this.persons.remove(id);
    }


}
