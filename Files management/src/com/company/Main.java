/*
 *
 * Classname Main
 *
 *  20 June 2020
 *
 * Copyright Holovey Ivan
 *
 *  Module 4 task 1
 *
 * 1. Parse the file logs.txt (see the attachment).
 * 2. Calculate the total number of logs (lines).
 * 3. Calculate the total  number of  ERROR logs. Use previous skills - String.split
 * 4. Calculate the total number of ERROR logs. Use Files.lines.
 * 5. Compare two results.
 */
package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();

        // 1. Parse the file logs.txt
        String myString = new String(Files.readAllBytes(Paths
                .get("/Пользователи/MyPC/Desktop/logs.txt")));
        //***************************************

        // 2. Calculate the total number of logs (lines).
        String[] lines = myString.split("\\n");
        System.out.println(lines.length);
        //***************************************

        // 3. Calculate the total  number of  ERROR logs. Use previous skills - String.split
        int errorLinesCount = 0;

        for (int i = 0; i < lines.length ; i++) {

            if (lines[i].contains("ERROR")){
                errorLinesCount++;
            }

        }
        System.out.println(errorLinesCount);
        LocalDateTime finish = LocalDateTime.now();

        int time1 = (int) ChronoUnit.MILLIS.between(start, finish);
        System.out.println(ChronoUnit.MILLIS.between(start, finish) + " ms");
        //***************************************

        // 4. Calculate the total number of ERROR logs. Use Files.lines.
        start = LocalDateTime.now();
        final long errors = Files.lines(Paths.get("/Пользователи/MyPC/Desktop/logs.txt"))
                .filter(line -> line.contains("ERROR"))
                .count();

        System.out.println(errors);
        finish = LocalDateTime.now();

        int time2 = (int) ChronoUnit.MILLIS.between(start, finish);
        System.out.println(ChronoUnit.MILLIS.between(start, finish) + " ms");
        //***************************************

        // 5. Compare two results.
        if (time1 > time2) {
            System.out.println("Method Files.lines is quicker!");
        } else {
            System.out.println("Method Files.lines is slower!");
        }

    }
}
