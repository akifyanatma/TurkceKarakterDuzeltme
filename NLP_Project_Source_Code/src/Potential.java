import java.util.ArrayList;
import java.util.List;


public class Potential {
	
	public List<Integer> turkishCharIndexList;
	public List<String> potentials;
	
	public Potential()
	{
		turkishCharIndexList = new ArrayList<Integer>();
		potentials = new ArrayList<String>();
	}
	
	public List<String> createPotentials(String pWord)
	{
		potentials.clear();
		findTurkishCharIndex(pWord);
		int potentialCount = (int)Math.pow(2,turkishCharIndexList.size());
		
		for(int i=0; i<potentialCount; i++)
		{
			potentials.add(pWord);
		}
		
		for(int i=0; i < turkishCharIndexList.size(); i++)
		{
			for(int j=0; j<potentialCount; j++)
			{
				potentials.set(j, editChar(i,j));
			}	
		}
		
		return potentials;
	}


	public String editChar(int pCharOrder, int pPotentialOrder)
	{
		String handlingPotential = potentials.get(pPotentialOrder);
		
		int width =  potentials.size() / ((int)Math.pow(2, pCharOrder+1)); 
		int division = pPotentialOrder / width;
		
		if(division%2 == 0)
		{
			if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'c')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'c'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'C')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'C'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'g')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'g'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'G')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'G'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'i')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'i'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'I')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'I'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'o')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'o'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'O')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'O'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 's')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'s'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'S')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'S'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'u')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'u'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'U')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'U'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
		}
		else
		{
			if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'c')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'C')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'g')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'G')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'i')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'I')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'o')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'O')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 's')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'S')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'u')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
			else if(handlingPotential.charAt(turkishCharIndexList.get(pCharOrder)) == 'U')
			{
				handlingPotential = handlingPotential.substring(0, turkishCharIndexList.get(pCharOrder))+'�'+handlingPotential.substring(turkishCharIndexList.get(pCharOrder)+1);
			}
		}
				
		return handlingPotential;
	}





	//Bu fonksiyon kendisine parametre olarak gecirilen string icindeki turkce karakter ile degistirilebilecek olan 
	//karakterlerin index lerini bulur ve bu indexlerin listesini geri dondurur.
	public void findTurkishCharIndex(String pWord)
	{
		turkishCharIndexList.clear();
		
		for(int i=0; i<pWord.length(); i++)
		{
			if(pWord.charAt(i) == 'c' || pWord.charAt(i) == '�' || pWord.charAt(i) == 'C' || pWord.charAt(i) == '�')
			{
				turkishCharIndexList.add(i);
			}
			else if(pWord.charAt(i) == 'g' || pWord.charAt(i) == '�' || pWord.charAt(i) == 'G' || pWord.charAt(i) == '�')
			{
				turkishCharIndexList.add(i);
			}
			else if(pWord.charAt(i) == '�' || pWord.charAt(i) == 'i' || pWord.charAt(i) == 'I' || pWord.charAt(i) == '�')
			{
				turkishCharIndexList.add(i);
			}
			else if(pWord.charAt(i) == 'o' || pWord.charAt(i) == '�' || pWord.charAt(i) == 'O' || pWord.charAt(i) == '�')
			{
				turkishCharIndexList.add(i);
			}
			else if(pWord.charAt(i) == 's' || pWord.charAt(i) == '�' || pWord.charAt(i) == 'S' || pWord.charAt(i) == '�')
			{
				turkishCharIndexList.add(i);
			}
			else if(pWord.charAt(i) == 'u' || pWord.charAt(i) == '�' || pWord.charAt(i) == 'U' || pWord.charAt(i) == '�')
			{
				turkishCharIndexList.add(i);
			}
		}
	}


}
