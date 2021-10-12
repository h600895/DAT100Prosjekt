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
		
		Kort[] sortert = samling.getAllekort();
		Kort[] erSortert = sortert;
		
//		for(int i = 0; i < sortert.length; i++) {
//			System.out.println(sortert[i]);
//		}
		
		
		for(int kortNr=1; kortNr < samling.getAntalKort(); kortNr++) {
			int svar=sortert[kortNr].compareTo(sortert[kortNr-1]);
			//System.out.println(svar);
			
			
			if (svar < 0) {
				 Kort temp = sortert[kortNr];
				 sortert[kortNr]=sortert[kortNr-1];
				 sortert[kortNr-1]= temp;
				 kortNr = 1;
			 	}
			
		
						
				//compareTo gir int, 0 hvis lik, -1 hvis mindre og 1 hvis st¯rre	
			}
		for(int i = 0; i < sortert.length; i++) {
			System.out.println(sortert[i]);
		}
		samling.fjernAlle();
		for(Kort kort : sortert) {
			samling.leggTil(kort);
		}
		
		//Fjern alle og legg til den nye kortstokken heller
			}
		
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		Kort[] ikkeStokket = samling.getAllekort();
		samling.fjernAlle();
		Random rand = new Random();
		
		for (int i = 0; i < ikkeStokket.length; i++) {
			int randomIndexToSwap = rand.nextInt(ikkeStokket.length);
			Kort temp = ikkeStokket[randomIndexToSwap];
			ikkeStokket[randomIndexToSwap] = ikkeStokket[i];
			ikkeStokket[i] = temp;
		}
		
		for(Kort kort: ikkeStokket) {
			samling.leggTil(kort);
		}
		
		
		
		
		
	}
		
		
	
		/*KortSamling [] stokket = new KortSamling[samling.getAllekort()];
		//int tall= (int)(random()*samling.getAntalKort);

		    Random rand = new Random();

		    int getRandArrayElement(){
		        return stokket[rand.nextInt(stokket.length)];
		        
		    }
		}
		
		

		*/
	}
	

