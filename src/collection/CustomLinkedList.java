package collection;

import model.Task;

import java.util.*;

public class CustomLinkedList { //перенёс, написал кастомлинкедлист, касаемо ноды не увидел в тз где она должна быть

    private Map<Long, Integer> map = new HashMap(); //изменил модификаторы доступа

    private List<Task> list = new LinkedList();

    public void linkLast(Task task) {
        Integer elementIndex = map.get(task.getId()); // есть ли элемент в списке
        if (elementIndex == null) {
            map.put(task.getId(), list.size());
            list.add(task);
        } else {
            list.remove(elementIndex.intValue()); // нет, нельзя не приводить, т.к. не будет работать
            list.add(task);
            upDateMap();
        }
    }

    private void upDateMap() {
        map.clear();
        for (int i = 0; i < list.size(); i++) {
            Task task = list.get(i);
            Long id = task.getId();
            map.put(id, i);
        }
    }

    public List<Task> getTasks() {
        return new ArrayList<>(list);
    }

    public void removeNode(Task task) {
        Integer elementIndex = map.get(task.getId());
        if (elementIndex != null) {
            list.remove(elementIndex.intValue());
            upDateMap();
        }
    }

    public void removeNode(Long id) {
        Integer elementIndex = map.get(id);
        if (elementIndex != null) {
            list.remove(elementIndex.intValue());
            upDateMap();
        }
    }

    public void removeNode(int id) {
        if (id < 0 || list.size() < id) return;
        list.remove(id);
        upDateMap();
    }
}
