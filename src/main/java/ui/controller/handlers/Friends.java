package ui.controller.handlers;

import domain.model.Person;
import ui.controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Friends extends RequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String friend = request.getParameter("email");
        String report = getPersonService().get(friend).getFirstName() + " " + getPersonService().get(friend).getLastName();

        System.out.println(report);
        response.setContentType("text/plain");
        response.getWriter().write("" + report +"");
    }
}
