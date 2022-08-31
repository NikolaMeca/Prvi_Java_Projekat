package Projekat;

import java.util.ArrayList;
import java.util.Scanner;

public class MainXandO {

	public static void main(String[] args) {
		Player x = new Player("Marko Maric");
		Player o = new Player("Nikola Nikolic");
		ArrayList<String> table = new ArrayList<String>();
		Scanner s =new Scanner(System.in);
		XandOGame igraj = new XandOGame(x, o);
		igraj.startGame();
		while(!igraj.isGameOver() && !igraj.isWinnerX() && !igraj.isWinnerO()) {
			System.out.println("Unesite poziciju");
			int pozicija = s.nextInt();
			igraj.makeAMove(pozicija);
			igraj.print();
		}
		System.out.println("Pobednik je: " + igraj.gameScore());
				
		
		
		
	}

}
