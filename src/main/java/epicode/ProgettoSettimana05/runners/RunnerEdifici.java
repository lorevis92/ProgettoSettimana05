package epicode.ProgettoSettimana05.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import epicode.ProgettoSettimana05.configuration.BeanConfiguration;
import epicode.ProgettoSettimana05.edificio.Edificio;
import epicode.ProgettoSettimana05.edificio.dao.IEdificioDao;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(3)
public class RunnerEdifici implements CommandLineRunner {
	@Autowired
	private IEdificioDao edificioDao;

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
	

		ctx.close();
	}

}
