package spo.ifsp.edu.br.juntossomosmaischallenge.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private IUserService _userService;

    @Autowired
    public UsersController(IUserService userService) {
        _userService = userService;
        _userService.insertInitialUsers();
    }

    @GetMapping("/all")
    public List<User> get() {
        var users = _userService.getUsers();
        return users;
    }

    @GetMapping()
    public @ResponseBody Page<User> get(
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size,
            @RequestParam(value = "type", required = false) String type
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);

        if (type != null) {
            UserType userTypeToFilter = UserType.valueOf(type.toUpperCase());
            return _userService.getUsersFromType(pageable, userTypeToFilter);
        }

        return _userService.getUsers(pageable);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return _userService.getUserById(id);
    }
}
