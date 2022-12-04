package spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long > {
    Optional<User> findById(Long id);
}
