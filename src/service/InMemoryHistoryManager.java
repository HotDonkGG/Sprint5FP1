package service;

import collection.CustomLinkedList;
import model.Task;

import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final CustomLinkedList history = new CustomLinkedList();

    @Override
    public List<Task> getHistory() {
        return history.getTasks();
    }

    @Override
    public void addHistory(Task task) {
        history.linkLast(task);
    }

    @Override
    public void remove(int id) {
        history.removeNode(id);
    }
}