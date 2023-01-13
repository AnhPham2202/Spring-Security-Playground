package na.pham.securityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/string")
    public String getString() {
        return "Helloworld";
    }
}
