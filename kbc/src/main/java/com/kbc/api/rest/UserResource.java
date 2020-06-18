package com.kbc.api.rest;

import com.kbc.domain.User;
import com.kbc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/example/v1/users")
public class UserResource {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserResource.class);

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user,
                            HttpServletRequest request, HttpServletResponse response) {
        User createdUser = this.userService.createUser(user);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdUser.getUserid()).toString());
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<User> getAllUsers(HttpServletRequest request, HttpServletResponse response){

        return this.userService.getAllUser();
    }
}
