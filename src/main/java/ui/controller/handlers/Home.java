package ui.controller.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.model.Person;
import ui.controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Home extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Person> twenty = getPersonService().getAll();
            String personJSON = this.toJSON(twenty);
            response.setContentType("application/json");
            response.getWriter().write(personJSON);
        } catch (Exception e){
            List<Person> twenty = getPersonService().getAll();
            String personJSON = this.toJSON(twenty);
            response.setContentType("application/json");
            response.getWriter().write(personJSON);
        }
    }

    private String toJSON(List<Person> persons) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(persons);
    }
}
