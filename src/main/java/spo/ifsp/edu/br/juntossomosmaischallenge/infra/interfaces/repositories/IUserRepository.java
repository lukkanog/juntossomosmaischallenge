package spo.ifsp.edu.br.juntossomosmaischallenge.infra.interfaces.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spo.ifsp.edu.br.juntossomosmaischallenge.domain.User;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.Region;
import spo.ifsp.edu.br.juntossomosmaischallenge.domain.enums.UserType;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    Page<User> findAllByTypeIn(Pageable pageable, List<UserType> types);
    Page<User> findAllByLocationRegionIn(Pageable pageable, List<Region> regions);
    Page<User> findAllByTypeInAndLocationRegionIn(Pageable pageable, List<UserType> types, List<Region> regions);
}
