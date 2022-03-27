package com.example.gorestv1.Controllers;

import com.example.gorestv1.models.UserModel;
import com.fredhopper.environment.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user")


public class UserController {

    @Autowired
    Environment env;
    // /endpoint http://localhost:4444/api/user/token

    @GetMapping("/token")
    public String getToken() {
        // return env.getProperty("GOREST_TOKEN");
        return env.getValue("GOREST_TOKEN");
    }

    @GetMapping ("/firstpage")
    public Object getFirstPage (RestTemplate restTemplate) {
    String url = "http://gorest.co.in/public/v2/users/";

    
    }
}

    @GetMapping("/{id}")
    public Object getOneUser(@PathVariable("id") String userId, RestTemplate restTemplate) {
        String url = "https://gorest.co.in/public/v2/users/" + userId;
        return restTemplate.getForObject(url, Object.class);
    }

    var user
    UserModel =restTemplate.getForObject(url,UserModel .class);

    assert user !=null;
    System.out.println("Report: \n"+user.generateReport());

    return user;
    catch (Exception exception)

    {
        System.out.println(exception.getClass());
        return exception.getMessage();


        try {
            String url = "https://gorest.co.in/public/v2/users/" + userId;
            String apiToken = env.getProperty(GO_REST_TOKEN);
            url += "?access-token=" + token

        }
    @DeleteMapping("/{id}")
public Object deleteOneUser(
        @PathVariable ("id") String userId,
        RestTemplate restTemplate

            )}
try

    {
        String url = "https://gorest.co.in/public/v2/users/" + userId;
        String token = env.getProperty("GO_REST_TOKEN");
        url += "?access=token" + token;
        restTemplate.delete(url);

        return "successfully deleted";

    }catch (HttpClientErrorException.NotFound exception )

    {

        return "user could not be deleted";
    }catch HttpClientErrorException.Unauthorized exception)

    {

        return "you are not authorized";

    }catch (Exception exception){
    System.out.println(exception.getClass());
    return exception.getMessage();
}

@PostMapping("/qp")
public Object postUserQueryParam(
        @RequestParam ("name") String name,
        @RequestParam ("email") String email,
        @RequestParam ("gender") String gender,
        @RequestParam ("status") String status,
        RestTemplate restTemplate

){
    try{

       String url = "https://gorest.co.in/public/v2/users/";
       String token = env.getProperty("GO_REST_TOKEN");
       url += "?access=token" - token;



    }

}