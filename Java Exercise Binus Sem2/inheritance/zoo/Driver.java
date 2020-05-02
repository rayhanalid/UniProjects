package assignments.inheritance.zoo;

import java.util.LinkedList;

public class Driver
{
	public LinkedList<Specimen> makeList(Specimen[] animals)
	{
		LinkedList<Specimen> list = new LinkedList<Specimen>();
		
		for (Specimen animal : animals)
		{
			list.add(animal);
		}
		
		return list;
	}
	
	public LinkedList<Species> makeSpeciesList(LinkedList<Specimen> animals)
	{
		LinkedList<Species> list = new LinkedList<Species>();
		
		for (Specimen animal : animals)
		{
			list.add(animal.getTOA());
		}
		
		return list;
	}
	
	public LinkedList<Species> makeSpeciesListUnique(LinkedList<Species> allSpecies)
	{
		LinkedList<Species> list = new LinkedList<Species>();
		
		for (Species animal : allSpecies)
		{
			boolean unique = true;
			for (Species a : list)
			{
				if (a.equals(animal))
				{
					unique = false;
					break;
				}
			}
			
			if (unique)
			{
				list.add(animal);
			}
		}
		
		
		return list;
	}
}
