package Projekat;

import java.util.ArrayList;

public class XandOGame {
	
	private ArrayList<String> table = new ArrayList<String>();
	private Player nextPlayer;
	private Player PlayerX;
	private Player PlayerO;
	private int brojac;

	public XandOGame() {
		String polje = " ";
		for (int i = 0; i < 9; i++) {
			this.table.add(polje);
		}
		brojac = 0;
		/*
		 * 
		 * 
		table.add("x");
		table.add("0");
		table.add("x");
		table.add("0");
		table.add("x");
		table.add("0");
		table.add("x");
		table.add("x");
		table.add("0");
		*/
	}

	public XandOGame(Player playerX, Player playerO) {
		this();
		PlayerX = playerX;
		PlayerO = playerO;
		nextPlayer = playerX;		
	}

	public Player getPlayerX() {
		return PlayerX;
	}

	public void setPlayerX(Player playerX) {
		PlayerX = playerX;
	}

	public Player getPlayerO() {
		return PlayerO;
	}

	public void setPlayerO(Player playerO) {
		PlayerO = playerO;
	}

	public void print() {

		for (int i = 0; i < 9; i++) {
			System.out.print(this.table.get(i) + " | ");
			if (i % 3 == 2)
				System.out.println();
		}
		
		/*
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(this.table.get(i*3+j) + "|");
			}
			System.out.println();
		}
		*/
	}

	public void startGame() {
		for (int i = 0; i < table.size(); i++) {
			table.set(i, "");
		}
		this.nextPlayer = PlayerX;
		brojac = 0;
	}
		
	public boolean isGameOver() {
		/*if(brojac == table.size()) {
			return true;
		}else {
			return false;
		}*/
		
		return brojac == table.size();
	}
	
	public boolean isFieldFree(ArrayList<String> niz, int pozicija) {
		/*if (!niz.get(pozicija).equals("x") && !niz.get(pozicija).equals("o")) {
			return true;
		} else {
			return false;
		}*/
		
		return !niz.get(pozicija).equals("x") && !niz.get(pozicija).equals("o");
	}
	
	public void playNext() {
		if(this.nextPlayer == (PlayerX)) {
			this.nextPlayer = PlayerO;
		}
		else {
			this.nextPlayer = PlayerX;
		}
	}
	
	public void makeAMove(int pozicija) {
		boolean poljeJeSlobodno = this.isFieldFree(table, pozicija);
		
		if (poljeJeSlobodno) {
			if (this.nextPlayer == (PlayerX))
				table.set(pozicija, "x");
			else
				table.set(pozicija, "o");

			//table.set(pozicija, (this.nextPlayer == PlayerX ? "x" : "o"));	
			
			playNext();
			brojac++;
		}
		else {
			System.out.println("Debile, to polje je zauzeto");
		}
	}
	
//	public boolean isWinnerX___TEST() {
//		/* REDOVI - PRVA ITERACIJA KODA
//		if (table.get(0).equals("x") && table.get(1).equals("x") && table.get(2).equals("x"))
//			return true;
//		
//		if (table.get(3).equals("x") && table.get(4).equals("x") && table.get(5).equals("x"))
//			return true;
//		
//		if (table.get(6).equals("x") && table.get(7).equals("x") && table.get(8).equals("x"))
//			return true;
//		*/
//		
//		/* REDOVI - DRUGA ITERACIJA KODA
//		for (int i = 0; i < 3; i++) {
//			if (table.get(3*i + 0).equals("x") && table.get(3*i +1).equals("x") && table.get(3*i +2).equals("x"))
//				return true;			
//		}
//		*/
//		
//		/* REDOVI - TRECA ITERACIJA KODA */
//		for (int i = 0; i < 3; i++) {
//			boolean tacno = true;
//			for (int j = 0; j < 3; j++) {
//				tacno = tacno && table.get(3*i + j).equals("x");
//			}
//			if (tacno)
//				return true;
//		}
//			     j 0   j 1   j 2
//		// i 0 |  0     3     6
//		// i 1 |  1     4     7  
//		// i 2 |  2	    5     8 
//
//		/* KOLONE - PRVA ITERACIJA KODA 
//		if(table.get(0).equals("x") && table.get(3).equals("x") && table.get(6).equals("x"))
//			return true;
//		if(table.get(1).equals("x") && table.get(4).equals("x") && table.get(7).equals("x"))
//			return true;
//		if(table.get(2).equals("x") && table.get(5).equals("x") && table.get(8).equals("x"))
//			return true;
//		*/
//		
//		/* KOLONE - DRUGA ITERACIJA KODA 
//		for(int i = 0; i < 3; i++) {
//			if(table.get(i + 0 ).equals("x") && table.get(i + 3).equals("x") && table.get(i + 6).equals("x"))
//				return true;
//		}
//		*/
//
//		/* KOLONE - TRECA ITERACIJA KODA */
//		for(int i = 0; i < 3; i++) {
//			boolean win = true;
//			for(int j = 0; j < 3; j++) {
//				if(!table.get(i + j*3).equals("x")) 
//					win = false;
//			}
//			if (win)
//				return true;
//		}
//		
//
//		// 0 4 8
//		// 2 4 6
//		/* DIJAGONALE - PRVA ITERACIJA KODA 
//		if (table.get(0).equals("x") && table.get(4).equals("x") && table.get(8).equals("x")) {
//			return true;
//		}
//		if (table.get(2).equals("x") && table.get(4).equals("x") && table.get(6).equals("x")) {
//			return true;
//		}
//		*/
//
//		/* DIJAGONALE - DRUGA ITERACIJA KODA 
//		for (int i = 0; i < 2; i++) {
//			if (table.get(2*(1-i) + 0).equals("x") && table.get(2*(1-i) + 4).equals("x") && table.get(2*(1-i) + 8).equals("x")) {
//				return true;
//			}
//		}
//		*/
//
//		/* DIJAGONALE - TRECA ITERACIJA KODA */
//		for (int i = 0; i < 2; i++) {
//			boolean win = true;
//			for(int j = 0; j < 3; j ++ ) {
//				win = win && table.get(2*(1-i) + j * 4).equals("x");
//			}
//			if(win) {
//				return true;
//			}
//		}
//		// 0 -> 2 --> +2 (i=0) --> -i =  0 --> -i+1 = +1 --> 2*(1-i)
//		// 4 -> 4 -->  0 (i=1) --> -i = -1 --> -i+1 =  0 --> 
//		// 8 -> 6 --> -2 (i=2) --> -i = -2 --> -i+1 = -1 --> 
//		/*
//		int i = 0;
//		if (table.get(2*(1-i) + 0).equals("x") && table.get(2*(1-i) + 4).equals("x") && table.get(2*(1-i) + 8).equals("x")) {
//			return true;
//		}
//		table.get(2*(1-i) + 0).equals("x")
//		table.get(2*(1-i) + 4).equals("x")
//		table.get(2*(1-i) + 8).equals("x")
//		*/
//		
//		/*
//		int i = 0;
//		boolean win = true;
//		for(int j = 0; j < 3; j ++ ) {
//			win = win && table.get(2*(1-i) + j * 4).equals("x");
//		}
//		if(win) {
//			return true;
//		}
//		*/
//		
//		/*
//		int suma = nesto[0] + nesto[1] + nesto[2];		
//		int suma = 0;
//		for (int j = 0; j < 3; j++) {
//			suma = suma + nesto[j];
//		}
//		
//		int proizvod = nesto[0] * nesto[1] * nesto[2];		
//		int proizvod = 1;
//		for (int j = 0; j < 3; j++) {
//			proizvod = proizvod * nesto[j];
//		}
//		
//		boolean ili = nesto[0] || nesto[1] || nesto[2];		
//		boolean ili = false;
//		for (int j = 0; j < 3; j++) {
//			ili = ili || nesto[j];
//		}
//		
//		boolean and = nesto[0] && nesto[1] && nesto[2];		
//		boolean and = true;
//		for (int j = 0; j < 3; j++) {
//			and = and && nesto[j];
//		}
//		*/
//	}
	
	public boolean isWinnerX() {		
		return isWinnerZnak("x");
	}
	
	public boolean isWinnerO() {
		return isWinnerZnak("o");
	}

	public boolean isWinnerZnak(String znakIgraca) {
		
		/* REDOVI - TRECA ITERACIJA KODA */
		for (int i = 0; i < 3; i++) {
			boolean tacno = true;
			for (int j = 0; j < 3; j++) {
				tacno = tacno && table.get(3*i + j).equals(znakIgraca);
			}
			if (tacno)
				return true;
		}

		/* KOLONE - TRECA ITERACIJA KODA */
		for(int i = 0; i < 3; i++) {
			boolean win = true;
			for(int j = 0; j < 3; j++) {
				if(!table.get(i + j*3).equals(znakIgraca)) 
					win = false;
			}
			if (win)
				return true;
		}
		//DIJAGONALA OD 2 4 6
		for (int i =0; i < 1; i++) {
			boolean win = true;
			for(int j = 0; j < 3; j++) {
				win = win && table.get(2 + j * 2).equals(znakIgraca);
			}
			if(win) {
				return true;
			}
			return false;
		}
		
			
		
		
		/* DIJAGONALA OD 0 4 8 */
		for (int i = 0; i < 1; i++) {
			boolean jeste = true;
			for(int j = 0; j < 3; j ++ ) {
				jeste = jeste && table.get(j * 4).equals(znakIgraca);
			}
				if (jeste) {
					return true;
				}
		}		return false;	
		
	}
	
	public boolean isValidMove(int pozicija) {
		if(pozicija >= 0 && pozicija <= 8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int gameScore() {
		if (this.isWinnerX()) {
			return 1;
		}
		else if (this.isWinnerO()) {
			return 2;
		}
		else {
			return 0;
		}
	}
}
// [0] [1]  O 
// [3]  X  [5]
// [6] [7] [8]

//[0] [1] [2]
//[3] [4] [5]
//[6] [7] [8]

//     (0) (1) (2) j
// (0)  0   1   2
// (1)  3   4   5 
// (2)  6   7   8
//  i
//  p = 3*i + 1*j
//  p = (X*i + b) + (Y*j + v)

//     (0) (1) (2) j
// (0)  0   3   6
// (1)  1   4   7 
// (2)  2   5   8
//  i
//  p = 1*i + 3*j

// 0 4 8
// 2 4 6

