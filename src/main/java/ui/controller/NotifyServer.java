package ui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.PersonService;
import domain.model.Person;
import org.json.JSONException;
import org.json.JSONObject;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ServerEndpoint("/notify")
public class NotifyServer {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private PersonService model = new PersonService();


    @OnOpen
    public void onOpen(Session session) throws JsonProcessingException {
        List<Person> personList = model.getAllPositive();
        System.out.println(personList);
        System.out.println("Session nr." + session.getId() + "has opened a connection");

        try {
            session.getBasicRemote().sendText(this.toJSON(personList));
        } catch (IOException e){
            e.printStackTrace();
        }
        sessions.add(session);

    }

    @OnMessage
    public void onMessage(String message, Session session) throws JSONException, IOException {
        System.out.println("Message from session nr.: " + session.getId() + message);
        JSONObject object = new JSONObject(message);
        if (object.has("name") && object.has("date")){
            String name = object.getString("name");
            String date = object.getString("date");

            if (!name.trim().equals("")){
                changeStatus(name);
                sendMessageToAll(message);
            }
        }
    }


    @OnClose
    public void onClose(Session session){
        System.out.println("Chat session nr." + session.getId() + " has ended");
        sessions.remove(session);
    }

    private void sendMessageToAll(String message) throws IOException {
        for (Session s : sessions) {
            s.getBasicRemote().sendText(message);
        }
    }

    public void changeStatus(String name){
        this.model.changeStatus(name);
    }

    private String toJSON (List<Person> personList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(personList);
    }



}
