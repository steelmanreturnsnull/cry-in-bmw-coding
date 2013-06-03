package com.pinjhuan.poker.model;

import java.util.ArrayList;
import java.util.List;

public class StandardJokerCard extends Card {
	
	public StandardJokerCard() {}

	public StandardJokerCard(int rank, Suit suit) {
		super(rank, suit);
	}

	// ranges from 2 to 14 (2,...,10,J,Q,K,A)
	// for joker, 2 for black, 3 for red
	protected static final int RANK_MIN = 2;
	protected static final int RANK_MAX = 14;

	protected static final int BLACK_JOKER_RANK = 2;
	protected static final int RED_JOKER_RANK = 3;
	
	@Override
	public List<Card> initDeck() 
	{
		List<Card> cards = new ArrayList<Card> ();
		for (Suit s : Suit.values()) 
		{
			for (int r = RANK_MIN ; r <= RANK_MAX ; r++) 
			{
				if (!s.equals(Suit.JOKER))
					cards.add(new StandardJokerCard(r, s));
			}
		}
		cards.add(new StandardJokerCard(BLACK_JOKER_RANK, Suit.JOKER));
		cards.add(new StandardJokerCard(RED_JOKER_RANK, Suit.JOKER));
		return cards;
	}



}
