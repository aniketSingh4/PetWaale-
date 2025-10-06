package org.my.petwaale.authservice.repository;

import java.util.Optional;

import org.my.petwaale.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long>
{
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);

}
