package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkef√∏lgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		KortSamling [] sortert = new KortSamling [samling.getAntalKort()];
			for(int kortNr=1; kortNr<samling.getAntalKort(); kortNr++) {
			int svar=sortert[kortNr].compareTo(sortert[kortNr-1]);
			kort temp= sortert[kortNr];
			if (svar==1) {
				 sortert[kortNr]=sortert[kortNr-1];
				 sortert[kortNr-1]= temp;
			 }
					
					
			//compareTo gir int, 0 hvis lik, -1 hvis mindre og 1 hvis st¯rre	
			}
		
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
	
		KortSamling [] stokket = new KortSamling[samling.getAllekort()];
		//int tall= (int)(random()*samling.getAntalKort);

		    private Random rand = new Random();

		    public int getRandArrayElement(){
		        return stokket[rand.nextInt(stokket.length)];
		        
		    }
		}
		
		

		
	}
	

