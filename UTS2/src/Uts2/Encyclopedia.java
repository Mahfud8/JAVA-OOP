/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Uts2;

import java.util.Scanner;

/**
 *
 * @author mmahf
 */
public class Encyclopedia extends Print {
   int volume, isbn;
   String title, author;

    public Encyclopedia(int volume, int isbn, String title, String author) {
        this.volume = volume;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
   

    

    public Encyclopedia(int volume) {
        this.volume = volume;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
   
 
}
