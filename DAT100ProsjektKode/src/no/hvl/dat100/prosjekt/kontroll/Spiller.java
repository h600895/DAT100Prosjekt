package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.modell.KortSamling;
import no.hvl.dat100.prosjekt.modell.KortUtils;
import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Abstrakt klasse som implementerer alle metodene i kontrakten (interfacet) ISpiller,
 * bortsett fra nesteHandling(). Dette er grunnen til at klassen er abstrakt.
 * For Ã¥ lage "virkelige" spillere, mÃ¥ vi arve fra denne klassen og implementere
 * nesteHandling (fra ISpiller).
 * 
 * Klassen har objektvariablene hand (Hand), antalltrekk (heltall) og spiller
 * (Spillere). Den har to konstruktÃ¸rer. Se beskrivelse av disse.
 * 
 */
public abstract class Spiller implements ISpiller {

	// hand for spilleren (samling)
	private KortSamling hand; 
	
	// antall trekk spilleren har gjort fra fra-bunken
	private int antalltrekk; 
	
	// hvem spilleren er (Nord,Syd,Ingen) - se oppramsklassen Spillere
	private Spillere spiller;

	/**
	 * Standard konstruktÃ¸r som oppretter en Spiller med en hÃ¥nd uten kort,
	 * antalltrekk som 0 og setter spiller til Spillere.INGEN.
	 */
	public Spiller() {
		
		antalltrekk = 0;
		hand = new KortSamling();
		spiller = Spillere.INGEN;
		
	}

	/**
	 * KonstruktÃ¸r der vi kan sette hvilken spiller det er (NORD, SYD eller
	 * INGEN).
	 * 
	 * @param spiller
	 *            hvilken spiller det er.
	 */
	public Spiller(Spillere spiller) {
		
		antalltrekk = 0;
		hand = new KortSamling();
		this.spiller = spiller;
	}

	public int getAntallKort() {
		
		return hand.getAntalKort();
	}

	public KortSamling getHand() {
		
		return hand;
	}

	public int getAntallTrekk() {
		
		return antalltrekk;
	}

	public Spillere hvem() {
		
		return spiller;
		
	}

	public void setAntallTrekk(int t) {
		
		antalltrekk = t;
	}

	public boolean erFerdig() {
		
		if (hand.getAntalKort() == 0) {
			return true;
		}
		return false;
 		
	}

	public void leggTilKort(Kort kort) {
		System.out.println(kort);
		hand.leggTil(kort);
		
	}

	public void fjernKort(Kort kort) {
		
		hand.fjern(kort);
		
	}

	public void fjernAlleKort() {
		
		hand.fjernAlle();
	}

	public void trekker(Kort kort) {
		
		hand.leggTil(kort);
		antalltrekk++;
		
	}
}
