package spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.pagination.UserPage;

import java.util.List;

public interface IUserService {
    void insertInitialUsers();
    List<User> getUsers();
    UserPage<User> getUsers(Pageable pageable);
    User getUserById(Long id);
}
