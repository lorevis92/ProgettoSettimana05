package epicode.ProgettoSettimana05.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import epicode.ProgettoSettimana05.configuration.BeanConfiguration;
import epicode.ProgettoSettimana05.edificio.Edificio;
import epicode.ProgettoSettimana05.edificio.dao.IEdificioDao;
import epicode.ProgettoSettimana05.postazione.Postazione;
import epicode.ProgettoSettimana05.postazione.TipoPostazione;
import epicode.ProgettoSettimana05.postazione.dao.IPostazioneDao;
import epicode.ProgettoSettimana05.prenotazione.Prenotazione;
import epicode.ProgettoSettimana05.prenotazione.dao.IPrenotazioneDao;
import epicode.ProgettoSettimana05.user.User;
import epicode.ProgettoSettimana05.user.dao.IUserDao;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
	@Autowired
	private IEdificioDao edificioDao;

	@Autowired
	private IPostazioneDao postazioneDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IPrenotazioneDao prenotazioneDao;

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		// Costuzione Edifici
		Edificio edificio1 = Edificio.builder().città("Roma").indirizzo("Via della Vittoria 44").nome("Imperial")
				.build();
		Edificio edificio2 = Edificio.builder().città("Londra").indirizzo("Reggent Street 12")
				.nome("Mariott Hotel London").build();

		// Salvataggio edifici a Database
		edificioDao.save(edificio1);
		edificioDao.save(edificio2);

		// Richiamo di un edificio datol'Id
		Edificio edificioTrovato = edificioDao.findById(1); // non da problemi --> nel momento in cui creol'edifico, ma
															// quando ne faccio la stampa aconsole manda tutto in
															// errore.
		log.info(edificioTrovato.toString());

		// Creazione Postazioni
		Postazione postazione1 = Postazione.builder().descrizione("Sala riunioni Mariott Londra").edificio(edificio2)
				.max_capienza(25).tipo(TipoPostazione.SALARIUNIONI).build();

		// Salvataggio postazioni a Database --> funziona solo se lancio il salvataggio
		// insieme al salvataggio dell'edificio. Ovviamente non è la condizione in cui
		// voglio lavorare; Soluzione: invocare dal db un edificio esistente e passare
		// quello comeparametro (PROBLEMA: come si legge a riga 45, non riesco ad
		// attivare la funzionalità
		// correttamente!!)
		postazioneDao.save(postazione1);
		
		// Creazione utenti
		User user1 = User.builder().user_name("utente1").nome_cognome("Utente Solitario")
				.mail("utentesolitario.gmail.com").build();
		log.info(user1.toString());

		// Salva utenti a Database
		userDao.save(user1);

		// Creazione prenotazioni
		Prenotazione prenotazione1 = Prenotazione.builder().user(user1).postazione(postazione1)
				.data_prenotazione(LocalDate.now().plusDays(7)).build();
		log.info(prenotazione1.toString());

		// Salva prenotazioni a Database
		prenotazioneDao.save(prenotazione1);

		ctx.close();

	}

}
