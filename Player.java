package Projekat;

public class Player {
/*Kreirati klasu Player koja ima:
ime i prezime
gettere i settere
konstuktore
metodu print, koja stampa ime i prezime igraca
*/
	private String punoIme;

public Player(String punoIme) {

	this.punoIme = punoIme;
}

public String getPunoIme() {
	return punoIme;
}

public void setPunoIme(String punoIme) {
	this.punoIme = punoIme;
}
	public void print () {
		System.out.println("Ime i prezime igraca: " + this.punoIme);
	}
}
