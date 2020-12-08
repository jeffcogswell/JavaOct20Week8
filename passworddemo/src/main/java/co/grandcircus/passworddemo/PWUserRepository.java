package co.grandcircus.passworddemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PWUserRepository extends JpaRepository<PWUser, Long> {
	
	PWUser findOneByEmail(String email);
}
