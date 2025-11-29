package ucu.edu.ua.task2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

public class GroupTest {

    @Test
    public void testAutomaticStamping() {
        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(x -> {}));
        group.addTask(new Signature<>(x -> {}));

        group.apply(5);

        String groupId = group.getHeader("group_id");
        assertNotNull(groupId);

        for (Task<Integer> task : group.getTasks()) {
            assertEquals(groupId, task.getHeader("group_id"));
        }
    }

    @Test
    public void testExecutionOrder() {
        AtomicInteger sum = new AtomicInteger(0);

        Group<Integer> group = new Group<>();
        group.addTask(new Signature<>(x -> sum.addAndGet(x)));
        group.addTask(new Signature<>(x -> sum.addAndGet(x * 2)));

        group.apply(3);

        assertEquals(3 + 6, sum.get());
    }
}
