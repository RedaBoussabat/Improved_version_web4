package domain;

import domain.db.PersonRepository;
import domain.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private final PersonRepository repository = new PersonRepository();
    private List<Person> users = new ArrayList<>();

    public PersonService() {
    }

    public List<Person> getAll(){
        return repository.getAll();
    }

    public void addPerson(Person person) {
        repository.add(person);
    }

    public Person CorrectPerson(String mail, String password) {
        return repository.get(mail);
    }

    public void addUser(Person person){
        users.add(person);
    }

    public void changeStatus(String name) {
        repository.changeStatus(name);
    }

    public List<Person> getAllPositive() {
        return repository.getAllPositive();
    }

    public List<Person> searchRoom(String firstName, String lastName, LocalDate date) {
        return repository.searchRoom(firstName, lastName,date);
    }

    public List<Person> searchPerson(LocalDate date, String room) {
        return repository.searchPerson(date, room);
    }
}
