package epicode.ProgettoSettimana05.edificio.dao;

import epicode.ProgettoSettimana05.edificio.Edificio;

public interface IEdificioDao {
	public void save(Edificio edificio);

	public Edificio findById(long id);
}

