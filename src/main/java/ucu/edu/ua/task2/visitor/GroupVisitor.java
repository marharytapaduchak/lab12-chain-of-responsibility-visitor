package ucu.edu.ua.task2.visitor;

import ucu.edu.ua.task2.Group;
import ucu.edu.ua.task2.Task;

public class GroupVisitor<T> implements Visitor<T> {

    private final String headerKey;
    private final String headerValue;

    public GroupVisitor(String headerKey, String headerValue) {
        this.headerKey = headerKey;
        this.headerValue = headerValue;
    }

    @Override
    public void onGroupStart(Group<T> group) {
        group.setHeader(headerKey, headerValue);
    }

    @Override
    public void onGroupEnd(Group<T> group) {
        System.out.println("End group: " + group.getId());
    }

    @Override
    public void onTask(Task<T> task) {
        task.setHeader(headerKey, headerValue);
    }
}
