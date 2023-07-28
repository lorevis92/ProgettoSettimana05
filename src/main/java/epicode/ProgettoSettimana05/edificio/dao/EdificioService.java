package epicode.ProgettoSettimana05.edificio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.ProgettoSettimana05.edificio.Edificio;
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

}
