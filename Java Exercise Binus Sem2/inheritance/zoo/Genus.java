package assignments.inheritance;

public class Genus
{
	private String genusName;

	public Genus(String g)
	{
		this.genusName = g;
	}

	public String getGenusName()
	{
		return this.genusName;
	}

	@Override
	public String toString()
	{
		return "Genus: " + this.getGenusName();
	}
}