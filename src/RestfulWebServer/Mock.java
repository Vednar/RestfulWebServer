package RestfulWebServer;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Mock {

    private static Map<Integer, User> users = new HashMap<>();
    private static int counter = 0;

    public static class Daemon implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
                for (Map.Entry<Integer, User> entry : users.entrySet()) {
                    if (entry.getValue().getStatus().toString().equals("online") &&
                            (new Date().getTime() - entry.getValue().getDate().getTime()) > 300_000) {
                        synchronized (users) {
                            entry.getValue().setStatus(new StringBuffer("away"));
                        }
                    }
                }
            } catch (java.lang.InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    Mock(){};

    public static int addUser(String name, String email, String phone) {
        counter++;
        if (phone != null) {
            users.put(counter, new User(counter, name, email, new StringBuffer("online"), new Date()));
        } else {
            users.put(counter, new User(counter, name, email, phone, new StringBuffer("online"), new Date()));
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return counter;
    }

    public static User getUser(int id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return users.get(id);
    }

    public static String changeStatus(int id, String status) {

        String old;
        try {
            old = users.get(id).getStatus().toString();
        } catch (NullPointerException e) {
            throw e;
        }
        users.get(id).setStatus(new StringBuffer(status));
        users.get(id).setDate(new Date());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return old;
    }


}
