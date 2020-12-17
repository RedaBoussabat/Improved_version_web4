package domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

    private String firstName, lastName, gsm, email, password, room;
    private LocalDate date;
    private boolean status;

    public Person(String firstName, String lastName, String gsm, String password, String room, LocalDate date) {
        setFirstName(firstName);
        setLastName(lastName);
        setGsm(gsm);
        setPassword(password);
        setEmail();
        setRoom(room);
        setDate(date);
        status = false;
    }

    public Person(String firstName, String lastName, String password) {
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        status = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase()+ "@ucll.be";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus() {
        status = true;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void changeEmail(String thisUserEmail) {
        this.email = thisUserEmail;
    }
}
