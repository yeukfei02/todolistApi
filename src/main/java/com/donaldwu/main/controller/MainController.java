package com.donaldwu.main.controller;

import com.donaldwu.main.responsebody.MainResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/")
public class MainController {
    @RequestMapping(value="", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private MainResponseBody getMain() {
        MainResponseBody mainResponseBody = new MainResponseBody();
        mainResponseBody.setMessage("todolistApi");
        return mainResponseBody;
    }
}
