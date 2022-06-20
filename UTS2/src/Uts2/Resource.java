/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uts2;

/**
 *
 * @author mmahf
 */
public class Resource {
    String title, date_borowed, due_date;
    Boolean Borowed_status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_borowed() {
        return date_borowed;
    }

    public void setDate_borowed(String date_borowed) {
        this.date_borowed = date_borowed;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public Boolean getBorowed_status() {
        return Borowed_status;
    }

    public void setBorowed_status(Boolean Borowed_status) {
        this.Borowed_status = Borowed_status;
    }
}
