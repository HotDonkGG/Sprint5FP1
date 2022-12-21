package utility;

import service.HistoryManager;
import service.InMemoryHistoryManager;
import service.InMemoryTaskManager;
import service.TaskManager;

public class UtilityManagers {

    public static TaskManager getManager(HistoryManager historyManager){
        return new InMemoryTaskManager(historyManager);
    }

    public static HistoryManager getHistoryManager(){
        return new InMemoryHistoryManager();
    }

}