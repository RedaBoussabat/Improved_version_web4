package domain.db;

import domain.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {

    private Map<String, Person> persons = new HashMap<>();

    public PersonRepository() {
        // Persons
        Person test = new Person("Test", "TestTheSecond", "123", "t", "C001", LocalDate.now().minusDays(2));
        Person reda = new Person("Reda", "Boussabat", "123", "t", "C001", LocalDate.now());
        test.setStatus();

        add(test);
        add(reda);
    }

    public Person get(String personId) {
        if (personId == null) {
            throw new IllegalArgumentException("No id given");
        }
        return persons.get(personId);
    }

    public List<Person> getAll() {
        return new ArrayList<Person>(persons.values());
    }

    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("No person given");
        }
        if (persons.containsKey(person.getEmail())) {
            throw new IllegalArgumentException("User already exists");
        }
        persons.put(person.getEmail(), person);
    }

    public void changeStatus(String name) {
        String mail = "";
        for (Person person : persons.values()){
            if (person.getFirstName().equalsIgnoreCase(name)){
                mail = person.getEmail();
            }
        }
        persons.get(mail).setStatus();

    }

    public List<Person> getAllPositive() {
        List<Person> positives = new ArrayList<>();
        for (Person person : persons.values()){
            if(person.getStatus()){
                positives.add(person);
            }
        }
        return positives;
    }
}
