package epicode.ProgettoSettimana05.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import epicode.ProgettoSettimana05.edificio.Edificio;
import epicode.ProgettoSettimana05.postazione.Postazione;
import epicode.ProgettoSettimana05.prenotazione.Prenotazione;
import epicode.ProgettoSettimana05.user.User;

@Configuration
public class BeanConfiguration {
	@Bean
	public Edificio creaEdificio() {
		return new Edificio();
	}

	@Bean
	public User creaUtente() {
		return new User();
	}

	@Bean
	public Prenotazione creaPrenotzione() {
		return new Prenotazione();
	}

	@Bean
	public Postazione creaPostazione() {
		return new Postazione();
	}

}
