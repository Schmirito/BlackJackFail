package blackJack;

public class Karte {
	public int wert;
	public String farbe;
	public String bezeichnung;
	
	public Karte(int wert, String farbe) {
		this.wert = wert;
		this.farbe = farbe;
		
		switch (wert) {
		case 1:
			bezeichnung = "Ass "+farbe;
			break;
		case 11:
			bezeichnung = "Bube "+farbe;
			break;
		case 12:
			bezeichnung = "Dame "+farbe;
			break;
		case 13:
			bezeichnung = "Koenig "+farbe;
			break;
		default:
			bezeichnung = wert+" "+farbe;
			break;
		}
		
	}
	public int getKartenWert() {
		return wert;
	}
	public String getKartenFarbe() {
		return farbe;
	}
	public String getKartenBezeichnung() {
		return bezeichnung;
	}
	
}
