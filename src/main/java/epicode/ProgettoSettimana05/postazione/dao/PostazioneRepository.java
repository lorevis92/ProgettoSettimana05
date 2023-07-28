package epicode.ProgettoSettimana05.postazione.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.ProgettoSettimana05.postazione.Postazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

}
