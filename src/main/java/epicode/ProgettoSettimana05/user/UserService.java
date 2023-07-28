package epicode.ProgettoSettimana05.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.ProgettoSettimana05.user.dao.IUserDao;
import epicode.ProgettoSettimana05.user.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements IUserDao {
	@Autowired
	private UserRepository userRep;

	@Override
	public void save(User user) {
		userRep.save(user);
		log.info(user.getNome_cognome() + " salvato\n\n");
	}

}
