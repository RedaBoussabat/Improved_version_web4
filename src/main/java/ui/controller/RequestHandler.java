package ui.controller;

import domain.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class RequestHandler {

    private PersonService personService;

    public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public void setModel (PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }






}
