package spo.ifsp.edu.br.juntossomosmaischallenge.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.helpers.RegionHelper;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.helpers.UserTypeHelper;
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
    @ApiOperation(value = "Retorna todos os usuários cadastrados")
    public List<User> get() {
        var users = _userService.getUsers();
        return users;
    }

    @GetMapping()
    @ApiOperation(value = "Retorna uma lista de usuários paginada.")
    public Page<User> get(
        @RequestParam(value = "page", required = true, defaultValue = "1") Integer page,
        @RequestParam(value = "size", required = true, defaultValue = "10") Integer size,
        @RequestParam(value = "types", required = false) String types,
        @RequestParam(value = "regions", required = false) String regions
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);

        List<UserType> typesToFilter = types != null ? UserTypeHelper.getUserTypesByString(types) : null;
        List<Region> regionsToFilter = regions != null ? RegionHelper.getRegionsByString(regions) : null;
        
        if (regionsToFilter != null && typesToFilter != null) {
            return _userService.getUsersFromTypesAndRegions(pageable, typesToFilter, regionsToFilter);
        }

        if (typesToFilter != null && regionsToFilter == null) {
            return _userService.getUsersFromTypes(pageable, typesToFilter);
        }

        if (regionsToFilter != null && typesToFilter == null) {
            return _userService.getUsersFromRegions(pageable, regionsToFilter);
        }

        return _userService.getUsers(pageable);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um usuário específico.")
    public User get(@PathVariable Long id) {
        return _userService.getUserById(id);
    }
}
