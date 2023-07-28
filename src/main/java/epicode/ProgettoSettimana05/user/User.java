package epicode.ProgettoSettimana05.user;

import java.util.HashSet;
import java.util.Set;

import epicode.ProgettoSettimana05.prenotazione.Prenotazione;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class User {
	@Id
	String user_name;
	String nome_cognome;
	String mail;
	@OneToMany(mappedBy = "user")
	private Set<Prenotazione> postazioniEdificio = new HashSet<>();

}
