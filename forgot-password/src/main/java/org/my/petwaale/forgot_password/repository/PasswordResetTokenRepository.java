package org.my.petwaale.forgot_password.repository;

import java.util.Optional;

import org.my.petwaale.forgot_password.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>
{
	 Optional<PasswordResetToken> findByToken(String token);
}
