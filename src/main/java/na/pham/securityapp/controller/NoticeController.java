package na.pham.securityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class NoticeController {

    @GetMapping("/notice")
    public String getNotices() {
        return "Here are the notices details from the DB";
    }

    @PostMapping("/notice")
    public String demo(@RequestBody Date date) {
        System.out.println(date);
        return "ok";
    }
}