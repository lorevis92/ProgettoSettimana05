package epicode.ProgettoSettimana05.edificio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.ProgettoSettimana05.edificio.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
