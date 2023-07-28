package epicode.ProgettoSettimana05.prenotazione;

import java.time.LocalDate;

import epicode.ProgettoSettimana05.postazione.Postazione;
import epicode.ProgettoSettimana05.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
	@Id
	@GeneratedValue
	private long prenotazione_id;
	LocalDate dataPrenotazione;

	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "prenotazione_postazione")
	Postazione postazione;

	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "prenotazione_user")
	User user;
}
