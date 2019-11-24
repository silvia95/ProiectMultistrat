package com.project.comit.entities.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.comit.entities.IEntityController;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController implements IEntityController<User, Long> {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@RequestBody User user) {
        userService.insert(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @RequestMapping(value = "/delete/{accountId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("accountId") Long userId) {
        userService.deleteById(userId);
    }
}