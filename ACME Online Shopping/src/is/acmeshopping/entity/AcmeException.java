package is.acmeshopping.entity;

public class AcmeException extends Exception{

	private static final long serialVersionUID = 1L;

	public AcmeException(String error)
	{
		super(error);
	}
}
