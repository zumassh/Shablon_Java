package com.example.practise_22.Service;

import com.example.practise_22.DTO.PostDTO;
import com.example.practise_22.DTO.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class FileService {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @Async
    @Scheduled(fixedDelay = 1000000)
    public void backupData(){
        System.out.println("backup");
        clear();
        saveDataToFiles();
    }

    public void clear(){
        System.out.println("clear");
        try {
            FileWriter fileWriter = new FileWriter("C:/Users/User/IdeaProjects/шаблоны/practise/src/practise_22/Files/posts.txt", false);
            fileWriter.write("");
            fileWriter.close();

            fileWriter = new FileWriter("C:/Users/User/IdeaProjects/шаблоны/practise/src/practise_22/Files/users.txt", false);
            fileWriter.write("");
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public void saveDataToFiles(){
        System.out.println("save");
        try {
            FileWriter fileWriter = new FileWriter("C:/Users/User/IdeaProjects/шаблоны/practise/src/practise_22/Files/posts.txt", false);
            List<PostDTO> postDTOList = postService.getAllPost();
            for (PostDTO post: postDTOList) {
                fileWriter.write(post.toString() + "\n");
            }
            fileWriter.close();

            fileWriter = new FileWriter("C:/Users/User/IdeaProjects/шаблоны/practise/src/practise_22/Files/users.txt", false);
            List<UserDTO> userDTOList = userService.getAllUser();
            for (UserDTO user: userDTOList){
                fileWriter.write(user.toString() + "\n");
            }
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}