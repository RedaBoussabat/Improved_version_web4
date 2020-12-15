package domain.db;

import domain.model.Person;

import java.time.LocalDate;
import java.util.*;

public class PersonRepository {

    private Map<String, Person> persons = new HashMap<>();

    public PersonRepository() {
        // Persons
        Person test = new Person("Test", "TestTheSecond", "123", "t", "C001", LocalDate.now().minusDays(2));
        Person reda = new Person("Reda", "Boussabat", "123", "t", "C003", LocalDate.now());
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

    public List<Person> getTwenty() {
        List<Person> twenty = new ArrayList<>();

        if (this.persons.size() > 20) {
            for (int i = (this.persons.size() - 20); i < this.persons.size(); i++) {
                twenty.add(this.persons.get(i));
            }
        } else {
            return new ArrayList<Person>(persons.values());
        }
        return twenty;
        /*return new ArrayList<Person>(persons.values());*/
    }

    public void add(Person person) {
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

    public List<Person> searchRoom(String firstName, String lastName, LocalDate date) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()){
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)){
                if (date.isAfter(person.getDate())) {
                    result.add(person);
                }
            }
        }
        return result;
    }

    public List<Person> searchPerson(LocalDate date, String room) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()){
            if (person.getDate().equals(date) && person.getRoom().trim().equalsIgnoreCase(room)){
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> giveTopThree(){
        ArrayList<Person> people = new ArrayList<>();
        for (int i = (this.persons.size() - 20); i < this.persons.size(); i++) {
            people.add(this.persons.get(i));
        }
        return people;
    }

    public Set<String> getAllDiffentRooms(){
        Set<String> rooms = new HashSet<>();
        for (Person person : getTwenty()){
            rooms.add(person.getRoom());
        }
        return rooms;
    }


}
