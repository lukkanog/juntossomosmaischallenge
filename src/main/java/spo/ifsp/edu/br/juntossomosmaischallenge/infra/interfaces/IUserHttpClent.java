package spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;

import java.util.List;

public interface IUserHttpClent {
    List<User> getUsers() throws Exception;
}
