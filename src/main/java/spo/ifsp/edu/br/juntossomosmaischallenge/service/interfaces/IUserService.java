package spo.ifsp.edu.br.juntossomosmaischallenge.service.interfaces;

import org.springframework.data.domain.Pageable;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.pagination.UserPage;

import java.util.List;

public interface IUserService {
    void insertInitialUsers();
    List<User> getUsers();
    UserPage<User> getUsers(Pageable pageable);
    UserPage<User> getUsersFromType(Pageable pageable, UserType type);
    UserPage<User> getUsersFromRegion(Pageable pageable, Region region);
    User getUserById(Long id);
}
