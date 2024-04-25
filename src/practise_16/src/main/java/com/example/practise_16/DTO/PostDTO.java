package com.example.practise_16.DTO;

import com.example.practise_16.entity.Post;

public class PostDTO {
    int id;
    String text;
    String creationDate;
    int ownerId;

    public PostDTO(){}
    public PostDTO(Post post){
        this.text = post.getText();
        this.creationDate = post.getCreationDate();
        this.id = post.getId();
        this.ownerId = post.getOwner().getId();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
