package com.pinjhuan.poker.experiments;

import java.util.ArrayList;
import java.util.List;

import com.pinjhuan.poker.model.Card;
import com.pinjhuan.poker.model.Decks;
import com.pinjhuan.poker.model.Game;
import com.pinjhuan.poker.model.Player;

public class ExperimentUtil<T extends Card> {
	public static Game initFourPlayerGame (Card card) {
		List<Card> cards = card.initDeck();
		Decks<Card> deck = new Decks<Card>(cards);
		deck.shuffle();
		
		Player N = new Player("N");
		Player S = new Player("S");
		Player E = new Player("E");
		Player W = new Player("W");
		
		List<Player> players = new ArrayList<Player>();
		players.add(N);
		players.add(S);
		players.add(E);
		players.add(W);
		
		Game game = new Game(players, deck, 8);
		game.dealUnreservedCards();
	}
}
