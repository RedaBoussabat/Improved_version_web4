package ui.controller;

import domain.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final PersonService model = new PersonService();
    private final ControllerFactory controllerFactory = new ControllerFactory();


    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        if (command != null) {
            RequestHandler handler;
            try {
                handler = controllerFactory.getController(command, model);
                handler.handleRequest(request, response);
            } catch (Exception e) {
                List<String> errors = new ArrayList<>();
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                request.getRequestDispatcher(destination).forward(request, response);
            }
        } else {
            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        }
    }
}
