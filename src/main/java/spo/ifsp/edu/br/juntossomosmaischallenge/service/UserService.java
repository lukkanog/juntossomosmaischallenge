package spo.ifsp.edu.br.juntossomosmaischallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import spo.ifsp.edu.br.juntossomosmaischallenge.api.exceptions.UserNotFoundException;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.pagination.UserPage;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.CsvUserHttpClient;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.JsonUserHttpClient;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces.repositories.IUserRepository;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IRegionService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserService;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserTypeService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;

    @Autowired
    private IRegionService _regionService;

    @Autowired
    private IUserTypeService _userTypeService;

    @Override
    public void insertInitialUsers() {
        var jsonHttpClient = new JsonUserHttpClient();
        var csvHttpClient = new CsvUserHttpClient();

        try {
            var usersFromJson = jsonHttpClient.getUsers();
            var usersFromCsv = csvHttpClient.getUsers();

            List<User> users = new ArrayList<User>();
            users.addAll(usersFromJson);
            users.addAll(usersFromCsv);

            for (User user : users) {
                var region = _regionService.getRegionByLocation(user.getLocation());
                var userType = _userTypeService.getUserTypeByCoordinates(user.getLocation().getCoordinates());

                user.getLocation().setRegion(region);
                user.setType(userType);
            }

            _userRepository.saveAll(users);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        return _userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        var user = _userRepository
                .findById(id)
                .orElse(null);

        if (user == null) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }

        return user;
    }

    @Override
    public UserPage<User> getUsers(Pageable pageable) {
        var page = _userRepository.findAll(pageable);
        return UserPage.of(page);
    }

    @Override
    public UserPage<User> getUsersFromType(Pageable pageable, UserType type) {
        var page = _userRepository.findAllByType(pageable, type);
        return UserPage.of(page);
    }

    @Override
    public UserPage<User> getUsersFromRegion(Pageable pageable, Region region) {
        var page = _userRepository.findAllByLocationRegion(pageable, region);
        return UserPage.of(page);
    }

    @Override
    public UserPage<User> getUsersFromTypeAndRegion(Pageable pageable, UserType type, Region region) {
        var page = _userRepository.findAllByTypeAndLocationRegion(pageable, type, region);
        return UserPage.of(page);
    }
}
