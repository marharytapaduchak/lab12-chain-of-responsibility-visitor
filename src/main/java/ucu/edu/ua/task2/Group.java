package ucu.edu.ua.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import ucu.edu.ua.task2.visitor.GroupVisitor;
import ucu.edu.ua.task2.visitor.Visitor;

public class Group<T> extends Task<T> {
    public String groupUuid;
    private List<Task<T>> tasks = new ArrayList<>();

    public Group<T> addTask(Task<T> task) {
        tasks.add(task);
        return this;
    }

    @Override
    public void freeze() {
        super.freeze();
        if (groupUuid == null) {
            groupUuid = UUID.randomUUID().toString();
            setHeader("group_id", groupUuid);
        }
        for (Task<T> task : tasks) {
            task.freeze();
        }
    }

    @Override
    public void apply(T arg) {
        this.freeze();
        if (tasks.isEmpty()) {
            return;
        }
        String groupId = getHeader("group_id");
        if (groupId != null) {
            GroupVisitor<T> stampingVisitor =
                    new GroupVisitor<>("group_id", groupId);
            stamp(stampingVisitor);
        }
        tasks = Collections.unmodifiableList(tasks);
        for (Task<T> task : tasks) {
            task.apply(arg);
        }
    }

    @Override
    public void stamp(Visitor<T> visitor) {
        visitor.onGroupStart(this);
        for (Task<T> task : tasks) {
            task.stamp(visitor);
        }
        visitor.onGroupEnd(this);
    }

    public List<Task<T>> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public String getGroupUuid() {
        return groupUuid;
    }
}
