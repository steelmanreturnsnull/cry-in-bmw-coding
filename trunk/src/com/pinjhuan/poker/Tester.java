package com.pinjhuan.poker;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightyPointsCard card = new EightyPointsCard();
		List<Card> cards = card.initDeck();
		Decks<Card> deck = new Decks<Card>(cards);
		//deck.printDecks();
		deck.shuffle();
		//deck.printDecks();
		
		Player N = new Player("N");
		Player S = new Player("S");
		Player E = new Player("E");
		Player W = new Player("W");
		List<Player> ps = new ArrayList<Player>();
		ps.add(N);
		ps.add(S);
		ps.add(E);
		ps.add(W);
		
		Game game = new Game(ps, deck);
		game.printGame();
		game.dealUnreservedCards(8);
		game.printGame();

	}

}
