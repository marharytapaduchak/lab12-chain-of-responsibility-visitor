package ucu.edu.ua.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import ucu.edu.ua.task2.visitor.Visitor;

public abstract class Task<T> {
    private String id;
    private Map<String, String> headers;

    public abstract void apply(T arg);

    public void freeze() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public void setHeader(String header, String headerValue) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put(header, headerValue);
    }

    public String getHeader(String header) {
        return headers == null ? null : headers.get(header);
    }
    

    public abstract void stamp(Visitor<T> visitir);
}
