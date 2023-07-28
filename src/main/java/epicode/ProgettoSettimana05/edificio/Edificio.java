package epicode.ProgettoSettimana05.edificio;

import java.util.HashSet;
import java.util.Set;

import epicode.ProgettoSettimana05.postazione.Postazione;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@ToString
@AllArgsConstructor
public class Edificio {
	@Id
	@GeneratedValue
	long edificio_id;
	private String nome;
	private String indirizzo;
	private String città;
	@OneToMany(mappedBy = "edificio")
	private Set<Postazione> postazioniEdificio = new HashSet<>();

	public Edificio(String nome, String indirizzo, String città) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.città = città;
	}
}
