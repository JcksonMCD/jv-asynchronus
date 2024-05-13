package org.northcoders.fundamentals.JavaPlatform;
import java.sql.Time;
import java.time.*;
import java.sql.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class TaskScheduler {

    /*
    Create a task scheduler that allows users to schedule tasks to be executed at specific times.
    Each task is to be represented by a simple Runnable object. Your task scheduler should use an
    ExecutorService to manage the execution of tasks concurrently.

    Implement a main method to demonstrate the functionality of your TaskScheduler class.
    Create multiple tasks and schedule them to be executed at different times.
    Print messages to indicate when each task starts and finishes execution using the LocalDateTime API.
     */

    static List<Task> taskList;

    public static void main(String[] args) {
        Date date = new Date(271381);
        Time time = new Time(1245);
        scheduleTask("Washing", date, time);

        isTimeToRun();

    }

    public static void scheduleTask(String taskName, LocalDateTime localDateTime){
        Task task = new Task(taskName, localDateTime);
        taskList.add(task);
    }

    private static void isTimeToRun(){
        ExecutorService test = Executors.newSingleThreadExecutor();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 =
                LocalDateTime.of(2024, 5, 13, 16, 57, 0, 640000);

        for (Task t : taskList){
            int timeTillExecution =  Integer.parseInt(t.time.toString()) - now.getHour();
            Future<String> task = test.submit(() -> {
                try {
                    Thread.sleep(timeTillExecution);
                    t.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return t.name;
            });
        }

        test.shutdown();
    }
}
