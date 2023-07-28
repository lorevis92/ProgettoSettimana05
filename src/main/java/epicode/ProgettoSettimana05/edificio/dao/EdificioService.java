package epicode.ProgettoSettimana05.edificio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.ProgettoSettimana05.edificio.Edificio;
import epicode.ProgettoSettimana05.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService implements IEdificioDao {

	@Autowired
	private EdificioRepository edificioRep;

	@Override
	public void save(Edificio edificio) {
		edificioRep.save(edificio);
		log.info(edificio.getNome() + " salvato\n\n");
	}

	public Edificio findById(long id) throws ItemNotFoundException {
//		Optional<User> user = usersRepo.findById(id);
//
//		if (user.isPresent()) {
//			return user.get();
//		} else {
//			throw new ItemNotFoundException(id);
//		}
		return edificioRep.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
	}

}
