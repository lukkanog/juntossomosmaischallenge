package spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;

import java.util.List;

public interface IUserHttpClient {
    List<User> getUsers() throws Exception;
}
