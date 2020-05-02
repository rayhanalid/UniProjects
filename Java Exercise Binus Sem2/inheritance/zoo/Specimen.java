package assignments.inheritance;

public class Specimen
{
	private String name;
	private int cageNumber;
	private Species toa;
	public Specimen( String a, int c, Species s)
	{
	setName(a);
	setCage(c);
	setTOA(s);
	}
	public void setName(String a){ name = a; }
	public void setCage(int c){ cageNumber = c; }
	public void setTOA(Species s){ toa = s; }
	public String getName(){ return name; }
	public int getCage(){ return cageNumber; }
	public Species getTOA(){ return toa; }
	public String toString()
	{
	return name + " is a " + toa + " in cage " + cageNumber;
	}
}
