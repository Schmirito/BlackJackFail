package blackJack;

public class Spieler {
	public String name;
	public int geld;
	public int kartenWertGes;
	public int einsatz;
	
	public Spieler(String name, int startgeld) {
		this.name = name;
		geld = startgeld;
	}
	
}
