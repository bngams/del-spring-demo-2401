package it.addon.bigdata.demospring.controllers;

import it.addon.bigdata.demospring.entities.User;
import it.addon.bigdata.demospring.repositories.UserRepository;
import it.addon.bigdata.demospring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // @Controller + @ResponseBody
@RequestMapping("/demo-rest") // prefixe commun pour toutes les URLs
public class DemoRestController {

    @Autowired // preferer via constructeur
    private UserService userSrv;

    @GetMapping("/hello")
    public String hello() {
       return "Hello world";
    }
    @GetMapping("/hello-bis")
    public String helloBis() {
        return "Hello world !!";
    }


    @GetMapping("/hello/param") // /hello/param?name=Boris&id=12
    public String helloWithPathParam(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello/name/{param}") // /hello/Boris
    public String helloWithPathVariable(@PathVariable("param") String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello")
    public String helloWithPost(@RequestBody() String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello/json")
    public String helloWithPostJSON(@RequestBody() User user) {
        return "Hello" + user.getUsername();
    }

    @PostMapping("/hello/json/return")
    public ResponseEntity<User> helloWithPostJSONReturnJSON(@RequestBody() User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user")
    public User insertUser(@RequestBody() User user) {
        return this.userSrv.add(user);
    }

    // PUT @PutMapping <=> POST @PostMapping

    // DELETE @PathVariable / @RequestParam <=> GET

    // @RequestHeader("token") String token
}
