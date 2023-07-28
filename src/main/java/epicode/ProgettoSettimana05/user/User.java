package epicode.ProgettoSettimana05.user;

import java.util.HashSet;
import java.util.Set;

import epicode.ProgettoSettimana05.prenotazione.Prenotazione;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	String userName;
	String nomeCognome;
	String mail;
	@OneToMany(mappedBy = "user")
	private Set<Prenotazione> postazioniEdificio = new HashSet<>();

}
