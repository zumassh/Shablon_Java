package com.example.practise_24.DTO;

import com.example.practise_24.entity.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDTO {
    int id;
    String firstName;
    String lastName;
    String middleName;
    String birthDate;
    List<PostDTO> posts;

    public UserDTO(){}

    public UserDTO(User user){
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.middleName = user.getMiddleName();
        this.birthDate = user.getBirthDate();
        this.id = user.getId();
        if (user.getPosts() != null)
            this.posts = user.getPosts().stream().map(post -> new PostDTO(post)).collect(Collectors.toList());
    }

    public List<PostDTO> getPosts(){
        return posts;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id &&
                Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(middleName, userDTO.middleName) &&
                Objects.equals(birthDate, userDTO.birthDate) &&
                Objects.equals(posts, userDTO.posts); // Assuming PostDTO properly overrides equals()
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, birthDate, posts);
    }
}
