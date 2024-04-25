package com.example.practise_15.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="post_text")
    private String text;
    @Column(name = "creation_date")
    private String creationDate;

    public String getText() {
        return text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public int getId(){
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
