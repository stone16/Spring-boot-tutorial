package com.llchen.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController Spring MVC can autodetect the controller using its built-in scanning features and automatically configure web routes.
 * ALso tells to write the text directly into HTTP response body.
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Welcome!";
    }

}
