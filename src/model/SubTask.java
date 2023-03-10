package model;

import java.util.LinkedList;

public class SubTask extends Task {
    private Epic epic;

    public SubTask(String name, String description, TaskStatus status) {
        super(name, description, status);
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }
}