package example5;

import java.sql.Date;

public class Res2 {
    private String name;
    private Date date;
    private String phone;

    public Res2(String name, Date date, String phone) {
        this.name = name;
        this.date = date;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }
}
