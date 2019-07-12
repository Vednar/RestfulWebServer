package RestfulWebServer;

import java.util.Date;

public class User {
    private final long id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private StringBuffer status;
    private Date date;

    public User(long id, String name, String email, StringBuffer status, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = null;
        this.status = status;
        this.date = date;
    }

    public User(long id, String name, String email, String phoneNumber, StringBuffer status, Date date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.date = date;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public StringBuffer getStatus() {
        return status;
    }

    public void setStatus(StringBuffer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
