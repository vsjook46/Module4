/*
 *
 * Classname : Main
 *
 *  24 June 2020
 *
 * Created by Holovey Ivan
 *
 * Multi-threading VERSION
 *
 * 1. Use the file from the previous task  - logs.txt.
 * 2. Create a class that manages logs in this file.
 * 3. Create a method that finds all the ERROR logs
 * for a specific date and write them into a
 * specific file (name = ERROR  + Date  + .log).
 * 4. In your main class develop a functionality
 * to create  5 such a files for 5 different days.
 * Launch them in consistent way (one after another).
 * 5. Repeat the above  task in parallel way. Multi-threading.
 * 6. Compare the results.
 *
 * */

package com.company;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    /*
     * @param MyFirstThread - class for all the
     *                        ERROR logs for a specific date.
     *
     * @return - impl for using.
     */

    static class MyFirstThread extends Thread {

        @Override
        public void run() {
            LogsServiceImpl service1 = new LogsServiceImpl();
            try {
                service1.getLogsByDate("2019-10-14");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread extends Thread {

        private String date;

        MyThread(String date){
            this.date = date;
        }

        @Override
        public void run() {
            LogsServiceImpl service = new LogsServiceImpl();
            try {
                service.getLogsByDate(date);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        LogsServiceImpl service1 = new LogsServiceImpl();

        // 4. In your main class develop a functionality
        // to create  5 such a files for 5 different days.
        // Launch them in consistent way (one after another).

        /**
         * @param LocalDateTime start1 - an immutable time object.
         *
         * @return - starting time of operation.
         */

        LocalDateTime start1 = LocalDateTime.now();
        start1 = LocalDateTime.now();

        /**
         * @param getLogsByDate - a method that finds all the ERROR logs
         *                        from needed date.
         *
         * @return -  checkup by dates.
         */

        service1.getLogsByDate("2019-10-14");
        service1.getLogsByDate("2019-10-16");
        service1.getLogsByDate("2019-10-17");
        service1.getLogsByDate("2019-10-18");
        service1.getLogsByDate("2019-10-19");

        /**
         * @param LocalDateTime finish1 - an immutable time object.
         *
         * @return - the finishing time of operation.
         */

        LocalDateTime finish1 = LocalDateTime.now();
        finish1 = LocalDateTime.now();

        /**
         * @param ChronoUnit - date periods units.
         *
         * @return - time in ms.
         */

        System.out.println("Total duration in consistent way is "
                + ChronoUnit.MILLIS.between(start1
                , finish1) + " ms." + "\n");

        //----------- 5. Repeat the above  task in parallel way. ----------\\
        //------------ Multi-threading. -------------------------------------\\

        /*
         * @param LocalDateTime start1 - an immutable date-time object.
         *
         * @return - indicates the starting time of operation.
         */

        LocalDateTime start2 = LocalDateTime.now();
        start2 = LocalDateTime.now();
        /**
         * @param MyFirstThread - threads of execution in a program
         *                        that find all the ERROR logs.
         *
         * @return - checkup by dates.
         */

        new MyFirstThread().start();
        new MyThread("2019-10-16").start();
        new MyThread("2019-10-17").start();
        new MyThread("2019-10-18").start();
        new MyThread("2019-10-19").start();

        /**
         * @param LocalDateTime finish2 - an immutable time object.
         *
         * @return - the finishing time of operation.
         */

        LocalDateTime finish2 = LocalDateTime.now();
        finish2 = LocalDateTime.now();

        /**
         * @param ChronoUnit - an standard set of date periods units.
         *
         * @return - time in ms, needed for operation.
         */

        System.out.println("Total duration of threads is "
                + ChronoUnit.MILLIS.between(start2
                , finish2) + " ms." + "\n");

        //------------ 6. Compare the results. ------------------------------\\

        /**
         * @param if - used to compare times, spent for Consistent way
         *             and Multi-threading.
         *
         * @return - what way is faster.
         */

        if ((ChronoUnit.MILLIS.between(start1
                , finish1)
                < ChronoUnit.MILLIS.between(start2
                , finish2))) {
            System.out.println("Consistent way is faster for " +
                    ((ChronoUnit.MILLIS.between(start2
                            , finish2)
                            - ChronoUnit.MILLIS.between(start1
                            , finish1))) + " ms." + "\n");
        } else if ((ChronoUnit.MILLIS.between(start1
                , finish1)
                > ChronoUnit.MILLIS.between(start2
                , finish2))) {
            System.out.println("Multi-threading is faster for "
                    + ((ChronoUnit.MILLIS.between(start1
                    , finish1)
                    - ChronoUnit.MILLIS.between(start2
                    , finish2))) + " ms." +"\n");
        } else {
            System.out.println("Speed is equal." + "\n");
        }
    }
}
