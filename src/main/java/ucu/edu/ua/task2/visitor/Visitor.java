package ucu.edu.ua.task2.visitor;

import ucu.edu.ua.task2.Group;
import ucu.edu.ua.task2.Task;

public interface Visitor<T> {
    void onGroupStart(Group<T> group);
    void onGroupEnd(Group<T> group);
    void onTask(Task<T> task);
    
}