package com.example.practise_24.DTO;

import com.example.practise_24.entity.Post;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return id == postDTO.id &&
                ownerId == postDTO.ownerId &&
                Objects.equals(text, postDTO.text) &&
                Objects.equals(creationDate, postDTO.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, creationDate, ownerId);
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
