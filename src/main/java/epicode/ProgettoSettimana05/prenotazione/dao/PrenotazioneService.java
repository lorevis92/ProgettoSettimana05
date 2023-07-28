package epicode.ProgettoSettimana05.prenotazione.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.ProgettoSettimana05.prenotazione.Prenotazione;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Service
@Slf4j
public class PrenotazioneService implements IPrenotazioneDao {
	@Autowired
	private PrenotazioneRepository prenotazioneRep;

	@Override
	public void save(Prenotazione prenotazione) {
		prenotazioneRep.save(prenotazione);
		log.info("prenotazione salvata\n\n");
	}

}
