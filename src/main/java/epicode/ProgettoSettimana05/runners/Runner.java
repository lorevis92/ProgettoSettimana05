package epicode.ProgettoSettimana05.runners;

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
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
	@Autowired
	private IEdificioDao edificioDao;

	@Autowired
	private IPostazioneDao postazioneDao;

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		// Costuzione Edifici
		Edificio edificio1 = Edificio.builder().città("Roma").indirizzo("Via della Vittoria 44").nome("Imperial")
				.build();
		Edificio edificio2 = Edificio.builder().città("Londra").indirizzo("Reggent Street 12")
				.nome("Mariott Hotel London").build();

		// Salvataggio edifici a Database
//		edificioDao.save(edificio1);
//		edificioDao.save(edificio2);

		// Creazione Postazioni
		Postazione postazione1 = (Postazione) ctx.getBean("creaPostazione");
		postazione1.setDescrizione("Sala riunioni Mariott Londra");
		postazione1.setTipo(TipoPostazione.SALARIUNIONI);
		postazione1.setMax_capienza(25);
		postazione1.setEdificio(edificio1);
		log.info("\n" + postazione1.toString() + "\n");
//		postazioneDao.save(postazione1);


		ctx.close();

	}

}
