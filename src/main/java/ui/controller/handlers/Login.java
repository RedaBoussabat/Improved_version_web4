package ui.controller.handlers;

import domain.model.Person;
import ui.controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends RequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "index.jsp";

        String mail = request.getParameter("mail");
        String password = request.getParameter("loginpass");

        Person person = getPersonService().CorrectPerson(mail, password);
        createSession(person, request, response);

        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void createSession(Person person, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("user", person);
    }
}
