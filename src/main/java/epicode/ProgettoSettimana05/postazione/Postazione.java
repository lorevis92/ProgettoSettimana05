package epicode.ProgettoSettimana05.postazione;

import java.util.HashSet;
import java.util.Set;

import epicode.ProgettoSettimana05.edificio.Edificio;
import epicode.ProgettoSettimana05.prenotazione.Prenotazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Postazione {
	@Id
	@GeneratedValue
	private long postazione_id;
	private String descrizione;
	private int maxCapienza;

	@Enumerated(EnumType.ORDINAL)
	TipoPostazione tipo;

	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "postazione_edificio")
	private Edificio edificio;

	@OneToMany(mappedBy = "postazione")
	private Set<Prenotazione> postazioniEdificio = new HashSet<>();

	public Postazione(String descrizione, int maxCapienza, TipoPostazione tipo, Edificio edificio) {
		this.descrizione = descrizione;
		this.maxCapienza = maxCapienza;
		this.tipo = tipo;
		this.edificio = edificio;
	}
}