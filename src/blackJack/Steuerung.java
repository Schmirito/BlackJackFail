package blackJack;

import java.util.ArrayList;
import java.util.Iterator;

public class Steuerung {

	private boolean versicherung = false;
	private final int MAXWERT = 21;
	private int auszahlung = 0;
	private String ergebnis = null;
	private boolean blackJack = false;
	private final int DECK_GROESSE = 52;					//Immer in 52er Schritten
	private final int KARTEN_EINER_FARBE = DECK_GROESSE/4;
	private boolean beendeSpiel = false;
	private boolean pausiert = true;
	public int spielerZaehler = 0;
	public String state = "default";
	
	public int spielerAnz = 4;
	
	String alleFarben[] = {"Pik","Herz","Karo","Kreuz"};
	public Spieler dieSpieler[] = {new Spieler("Spieler 1",500), new Spieler("Spieler 2",500), 
								   new Spieler("Spieler 3",500), new Spieler("Spieler 4",500)};
	public Dealer derDealer = new Dealer("Dealer");
	public Spieler momSpieler = dieSpieler[0];
	ArrayList<Karte> dieKarten = new ArrayList<>();
	ArrayList<Karte> dasDeck = new ArrayList<>();
	GUI dieGui;
	
	
	public Steuerung() {
		init();
		starteSpiel();
	}
	
	public Steuerung(GUI dieGui) {
		this.dieGui = dieGui;
	}

	public void starteSpiel() {
		while(!beendeSpiel) {
			
		}
	}
	public void austeilen() {
		for (int i = 0; i < 2; i++) {
			int randomZahl = (int) (Math.random()*dasDeck.size());
			for (int j = 0; j < dieSpieler.length; j++) {
				int randomZahl2 = (int) (Math.random()*dasDeck.size());
				dieSpieler[j].kartenWertGes += dasDeck.get(randomZahl2).wert;
				dasDeck.remove(randomZahl2);
			}
			if (i==0) {
				int wert = dasDeck.get(randomZahl).wert;
				derDealer.kartenWertGes += wert;
				derDealer.kartenWertOffen += wert;
				dasDeck.remove(randomZahl);
			}
			else {
				derDealer.kartenWertGes += dasDeck.get(randomZahl).wert;
				dasDeck.remove(randomZahl);
			}

		}
	}
	public void hit() {
		
	}
	public void doubleDown() {
		
	}
	public void versicherung() {
		
	}
	public void auszahlen(Spieler spieler,int auszahlung) {
		
	}
	public void init() {
		initDeck();
		//Ausgabe Deck in der Konsole zur überprüfung
//		for (int i = 0; i < dasDeck.size(); i++) {
//			System.out.println(dasDeck.get(i).bezeichnung);
//		}
	}
	public void initDeck() {
		for (int i = 1; i <= KARTEN_EINER_FARBE; i++) {
			for (int j = 0; j < alleFarben.length; j++) {
				dieKarten.add(new Karte(i,alleFarben[j]));
			}
		}
		for (int i = 0; i < DECK_GROESSE; i++) {
			int randomZahl = (int) (Math.random()*dieKarten.size());
			dasDeck.add(dieKarten.get(randomZahl));
			dieKarten.remove(randomZahl);
		}
	}
	public void setMomSpieler() {
		spielerZaehler++;
		momSpieler = dieSpieler[spielerZaehler];
		
	}
	public void dealerAlg() {
		if (derDealer.kartenWertGes < 17) {
			System.out.println("Dealer zieht erneut");
			derDealer.kartenWertGes += dasDeck.get((int) (Math.random()*dasDeck.size())+1).wert;
		}
	}
}