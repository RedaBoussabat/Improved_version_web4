package domain.db;

import domain.model.Person;

public class test {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();

        Person t = personRepository.get("reda.boussabat@ucll.be");
        Person g = personRepository.get("eda.boussabat@ucll.be");

        System.out.println(personRepository.getAllDiffentRooms());
    }
}
