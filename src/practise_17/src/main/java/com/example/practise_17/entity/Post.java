package com.example.practise_17.entity;

import com.example.practise_17.DTO.PostDTO;
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

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User owner;

    public Post(){}

    public Post(PostDTO postdto){
        this.text = postdto.getText();
        this.creationDate = postdto.getCreationDate();
        this.id = postdto.getId();
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

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
