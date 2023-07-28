package epicode.ProgettoSettimana05.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.ProgettoSettimana05.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
