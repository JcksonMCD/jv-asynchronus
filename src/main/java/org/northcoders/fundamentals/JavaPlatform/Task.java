package org.northcoders.fundamentals.JavaPlatform;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class Task implements Runnable {
    String name;
    LocalDateTime localDateTime;

    public Task(String name, LocalDateTime localDateTime) {
        this.name = name;
        this.localDateTime = localDateTime;
    }

    @Override
    public void run() {
        System.out.println(name + ": " + "is running at "+ localDateTime.getDayOfYear() + " " + localDateTime.getHour());
    }
}
