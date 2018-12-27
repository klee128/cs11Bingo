package winter18.assignment3;

public class Bingo {
	int numPlayers;
	Player[] aPlayer;
	Card[] aCard;
	//creates a new bingo gaem
	public Bingo(Player[] players) {
		numPlayers = players.length;
		aPlayer = players;
	}
	public String play(int number) {
		for (int n = 0; n < numPlayers; n++) {
			aPlayer[n].markNumber(number);
		}
		for (int n = 0; n < numPlayers; n++) {
			String s;
			
			if (aPlayer[n].isWinner()) {
				
				for (int j = n+1; j < numPlayers; j++) {
					if (aPlayer[j].isWinner()) {
						
						for (int k = j+1; k < numPlayers; k++) {
							if (aPlayer[k].isWinner()) {
								for (int l = k+1; l < numPlayers; l++) {
									if (aPlayer[l].isWinner()) {
										s = aPlayer[n].getName() + " " + aPlayer[j].getName() + " " + aPlayer[k].getName()+ " " + aPlayer[l].getName();
										return s.substring(0,s.length());
									}
								}
								s = aPlayer[n].getName() + " " + aPlayer[j].getName() + " " + aPlayer[k].getName();
								return s.substring(0,s.length());
							}
						}
						
						s = aPlayer[n].getName() + " " + aPlayer[j].getName();
						return s.substring(0,s.length());
					}
				}
				
				s = aPlayer[n].getName();
				return s.substring(0, s.length());	
				}
			}
		
		return "";
}
}

class Card {
	int[][] input = new int[5][5];
	
	//method to input Card
	public Card(int[][] numbers) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					input[i][j] = numbers[i][j];
	        }
	    }
    }
	
	//finds out what number is in a certain row and column
	public int getNumber(int Row, int Column) {
		//System.out.println("getNumber: "+input[Row][Column]);
		return input[Row][Column];
    }
	
	//checks if number at certain row and column is marked
	public boolean isMarked(int row, int column) {
		if (input[row][column] == 100) {
			//System.out.println(input[row][column] + " is true");
			return true;
		}
		else
			return false;	
	}
	
	public int[][] currentInput() {
		return this.input;
	}
	//if number at certain row and column is called, marks that spot
	public void markNumber(int number) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (input[i][j] == number) {
					input[i][j] = 100;
				}
			}
		}
	}
	
	
}
//end of class Card


class Player {
	String playerName;
	Card[] playerCard;
	public Player(String name, Card[] cards) {
		playerName = name;
		playerCard = cards;
	}
	
	public String getName() {
		//System.out.println("Player name: " + playerName);
		return playerName;
	}
	
	public Card[] getCards() {
		//System.out.println("Player card: " + playerCard);
		return playerCard;
	}
	
	public boolean isWinner() {
		boolean winner = false;
		
		for (int x = 0; x < playerCard.length; x++) {
			for (int i = 0; i < 5; i++) {
				int a = 0;
				for (int j =0;j<5;j++) {
					if (playerCard[x].getNumber(i,j) == 100) {
						a++;
					}
					if (a == 5) {
						winner = true;
					}
				}
			}
		}
		//System.out.println("isWinner is " + winner);
		return winner;
		}
		
	
	public void markNumber(int number) {
		for (int x = 0; x < playerCard.length; x++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (playerCard[x].getNumber(i, j) == number) {
						playerCard[x].currentInput()[i][j] = 100;
					}
				}
			}
		}
	}
}


