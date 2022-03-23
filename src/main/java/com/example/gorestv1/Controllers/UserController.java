package com.example.gorestv1.Controllers;

import com.fredhopper.environment.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/user")


public class UserController {

    @Autowired
    Environment env;
    // /endpoint http://localhost:4444/api/user/token

    @GetMapping("/token")
    public String getToken () {
       // return env.getProperty("GOREST_TOKEN");
        return env.getValue("GOREST_TOKEN");
    }

    @GetMapping("/{id}")
    public Object getOneUser (@PathVariable ("id") String userId, RestTemplate restTemplate){
       String url = "https://gorest.co.in/public/v2/users/"+userId;
               return  restTemplate.getForObject(url, Object.class);
    }

    {
        try {
            String url = "https://gorest.co.in/public/v2/users/" + userId;
            String apiToken = env.getProperty(GO_REST_TOKEN);
        }
    }
}
