package it.addon.bigdata.demospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Component
public class DemoController {

    // brancher notre methode sur l'URL /demo/hello
    @RequestMapping(method = RequestMethod.GET, path = "/demo/hello")
    @ResponseBody // pas de template HTML, renvoyer directement le return dans la respon
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/demo/html")
    public String html() {
        // passer des données à la page etc...
        return "demo";
    }
}
