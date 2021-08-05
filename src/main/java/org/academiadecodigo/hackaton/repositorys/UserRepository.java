package org.academiadecodigo.hackaton.repositorys;

import org.academiadecodigo.hackaton.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
