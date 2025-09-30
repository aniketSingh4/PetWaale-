package org.my.petwaale.authservice.repository;

import java.util.Optional;

import org.my.petwaale.authservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>
{
	Optional<Users> findByUsername(String username);

}
