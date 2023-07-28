package epicode.ProgettoSettimana05.postazione.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.ProgettoSettimana05.postazione.Postazione;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PostazioneService implements IPostazioneDao {

	@Autowired
	private PostazioneRepository postazioneRep;

	@Override
	public void save(Postazione postazione) {
		postazioneRep.save(postazione);
		log.info(postazione.getTipo() + " salvato\n\n");
	}

}
