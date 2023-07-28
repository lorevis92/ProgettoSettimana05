package epicode.ProgettoSettimana05.exceptions;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(long id) {
		super("Item with id " + id + " not found!");
	}

}
