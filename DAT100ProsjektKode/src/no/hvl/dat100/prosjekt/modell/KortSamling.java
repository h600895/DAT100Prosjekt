package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for aa lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene.
 * Naar programmet er ferdig settes denne til 13, men under utvikling / testing
 * kan det vaere praktisk aa ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	public KortSamling() {
		// lager en tom kortsamling med plass til MAKS_KORT
		samling = new Kort[MAKS_KORT];
		antall = 0;
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke vare full.
	 * Kortene ligger sammenhengende fra starten av tabellen. Kan fa tilgang til
	 * antallet ved a bruke metoden getAntallKort(). Metoden er forst og fremst ment
	 * a brukes i testklasser. Om man trenger kortene utenfor, anbefales metoden
	 * getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {

		return samling;

	}

	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {

		return antall;
	}

	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {

		if (antall == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) { // legg til kort i bunken p� bordet, fra samling
		samling[antall] = kort;
		antall++;
	}

	public void leggTilAlle() {
		
		int teller = 0;
		antall = 0;
		for (Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				samling[teller] = new Kort(f, i);						
				teller++;
				antall++;
			}
		}
	}

	public void fjernAlle() {
		
		samling = new Kort[MAKS_KORT];
		antall = 0;

	}

	public void skrivUtAlle() {
		System.out.println("-----------");
		for (int i = 0; i < antall; i++) {
			System.out.println(i + ": " + samling[i]);
		}
		System.out.println("-----------");
	}

	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga
	 *         er tom, returneres null.
	 */
	public Kort seSiste() {

		if (antall == 0) {
			return null;
		}
		return samling[antall-1];
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres null.
	 */
	public Kort taSiste() {
		
		Kort kort = seSiste();
		fjern(kort);
		return kort;
	}

	/**
	 * Undersoker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {

		for (int i = 0; i < samling.length; i++) {
			
			if (kort == null) {
				return false;
			}
			else if(kort.equals(samling[i])) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Fjernar et kort fra samlinga. Dersom kortet ikke finnest i samlinga, skjer
	 * ingenting med samilingen
	 * 
	 * @param kort kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *             ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */

	public boolean fjern(Kort kort) {

		for (int i = 0; i < samling.length; i++) {
			if (samling[i] == kort && kort != null) {
				samling[i] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
		// ma hente antall kort og lage en tabell med lengde av dette

		Kort[] alleKort = new Kort[getAntalKort()];

		//skrivUtAlle();
		for (int i = 0; i < antall; i++) {
			alleKort[i] = samling[i];
		}

		return alleKort;
	}

}