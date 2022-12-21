import model.Epic;
import model.SubTask;
import model.Task;
import model.TaskStatus;
import service.HistoryManager;
import service.TaskManager;
import utility.UtilityManagers;

public class Main {
    public static void main(String[] args) {
        HistoryManager historyManager = UtilityManagers.getHistoryManager();
        TaskManager taskManager = UtilityManagers.getManager(historyManager);

        Task task1 = new Task( "Задача спринт 5", "тестовое задание", TaskStatus.NEW);
        Task task2 = new Task( "Задача 2 спринт 5", "тестовое задание 2", TaskStatus.NEW);
        Task task3 = new Task( "Задача 3 спринт 5", "тестовое задание 2", TaskStatus.NEW);
        Task task4 = new Task( "Задача 4 спринт 5", "тестовое задание 2", TaskStatus.NEW);
        SubTask subTask10 = new SubTask("Подзадача 1 спринт 5", "сделать что-то 1", TaskStatus.NEW);
        SubTask subTask11 = new SubTask("Подзадача 2 спринт 5", "сделать что-то 2", TaskStatus.NEW);
        SubTask subTask12 = new SubTask("Подзадача 3 спринт 5", "сделать что-то 3", TaskStatus.NEW);

        Epic epic1 = taskManager.addEpic(new Epic("Эпик1", "Описание эпика1"));
        Epic epic2 = taskManager.addEpic(new Epic("Эпик2", "Описание эпика2"));
        epic1.getSubTaskList().add(subTask12);
        epic1.getSubTaskList().add(subTask11);
        epic1.getSubTaskList().add(subTask10);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);

        taskManager.getTaskById(task1.getId());
        taskManager.getTaskById(task2.getId());
        taskManager.getTaskById(task3.getId());
        taskManager.getTaskById(task4.getId());
        System.out.println(historyManager.getHistory());
        taskManager.getTaskById(task1.getId());
        System.out.println(historyManager.getHistory());
        taskManager.getTaskById(task3.getId());
        System.out.println(historyManager.getHistory());
        historyManager.remove(1);
        System.out.println(historyManager.getHistory());
    }
}