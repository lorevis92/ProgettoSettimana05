package epicode.ProgettoSettimana05.prenotazione;

import java.time.LocalDate;

import epicode.ProgettoSettimana05.postazione.Postazione;
import epicode.ProgettoSettimana05.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prenotazione {
	@Id
	@GeneratedValue
	private long prenotazione_id;
	LocalDate data_prenotazione;

	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "prenotazione_postazione")
	Postazione postazione;

	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "prenotazione_user")
	User user;
}
