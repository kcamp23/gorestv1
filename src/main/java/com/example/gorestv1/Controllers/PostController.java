package com.careerdevs.userrestapi.controllers;


import com.careerdevs.userrestapi.models.CommentModel;
import com.careerdevs.userrestapi.models.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    Environment env;

    @GetMapping ("/firstpage")
    public PostModel[] getFirstPage(RestTemplate restTemplate){
        String apiKey = env.getProperty("GOREST_TOKEN");
        String url = "https://gorest.co.in/public/v2/posts" + "?access-token="+apiKey;
        PostModel[] post = restTemplate.getForObject(url,PostModel[].class);

        return post;
    }

    @GetMapping("/{id}")
    public ResponseEntity postHandler (RestTemplate restTemplate, @PathVariable("id") int postId){
        String apiKey = env.getProperty("GOREST_TOKEN");
        try{
            PostModel requestData = restTemplate.getForObject("https://gorest.co.in/public/v2/posts/" + postId+"?access-token="+apiKey, PostModel.class);
            return new ResponseEntity(requestData, HttpStatus.OK);
        }catch(Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost (RestTemplate restTemplate, @PathVariable("id") int postId){
        String apiKey = env.getProperty("GOREST_TOKEN");
        try{
            String url = "https://gorest.co.in/public/v2/posts/" + postId+"?access-token="+apiKey;
            PostModel deletedPost = restTemplate.getForObject(url, PostModel.class);
            restTemplate.delete(url);

            return new ResponseEntity<>(deletedPost,HttpStatus.OK);
        }catch(Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    @PostMapping
    public ResponseEntity<Object> postPost (
            RestTemplate restTemplate,
            @RequestBody PostModel newPost
    )
    {
        String apiKey = env.getProperty("GOREST_TOKEN");
        try{
            String url = "https://gorest.co.in/public/v2/posts/?access-token="+apiKey;

            HttpEntity<PostModel> request = new HttpEntity<>(newPost);
            PostModel createPost = restTemplate.postForObject(url, request, PostModel.class);

            return new ResponseEntity<>(createPost,HttpStatus.CREATED);
        }catch(Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping
    public ResponseEntity<Object> putPost(
            RestTemplate restTemplate,
            @RequestBody PostModel updatePost
    )
    {
        String apiKey = env.getProperty("GOREST_TOKEN");
        try{
            String url = "https://gorest.co.in/public/v2/posts/"+ updatePost.getId()+"?access-token="+apiKey;

            HttpEntity<PostModel> request = new HttpEntity<>(updatePost);
            ResponseEntity<PostModel> response = restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    request,
                    PostModel.class);

            return new ResponseEntity<>(response.getBody(),HttpStatus.CREATED);
        }catch(Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }






}
