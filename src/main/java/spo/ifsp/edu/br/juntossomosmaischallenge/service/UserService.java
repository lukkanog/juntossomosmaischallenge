package spo.ifsp.edu.br.juntossomosmaischallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.CsvUserHttpClient;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.JsonUserHttpClient;
import spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces.repositories.IUserRepository;
import spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces.IUserService;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;

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
    public Page<User> getUsers(Pageable pageable) {
        return _userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long id) {
        return _userRepository
                .findById(id)
                .orElse(null);
    }
}
