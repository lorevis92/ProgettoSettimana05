package epicode.ProgettoSettimana05.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import epicode.ProgettoSettimana05.configuration.BeanConfiguration;
import epicode.ProgettoSettimana05.edificio.Edificio;
import epicode.ProgettoSettimana05.postazione.Postazione;
import epicode.ProgettoSettimana05.postazione.TipoPostazione;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1)
public class RunnerPostazioni implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		// Da togliere!! serve solo come prova, più avanti lo recupero dal database
		Edificio edificio1 = (Edificio) ctx.getBean("creaEdificio");
		edificio1.setNome("Mariott Hotel London");
		edificio1.setIndirizzo("Random");
		edificio1.setCittà("Londra");

		// Creazione Postazioni
		Postazione postazione1 = (Postazione) ctx.getBean("creaPostazione");
		postazione1.setDescrizione("Sala riunioni Mariott Londra");
		postazione1.setTipo(TipoPostazione.SALARIUNIONI);
		postazione1.setMax_capienza(25);
//		postazione1.setEdificio(edificio1);
		log.info("\n" + postazione1.toString() + "\n");

		ctx.close();
	}

}
