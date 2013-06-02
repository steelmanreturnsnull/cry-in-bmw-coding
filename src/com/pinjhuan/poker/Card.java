package com.pinjhuan.poker;

import java.util.List;

public abstract class Card {
	
	public Card() {}
	
	public Card(int rank, Suit suit) {
		this.m_rank = rank;
		this.m_suit = suit;
	}

	protected int m_rank;
	protected static final int rank_min = Integer.MIN_VALUE;
	protected static final int rank_max = Integer.MAX_VALUE;
	
	protected Suit m_suit;
	
	
	public abstract List<Card> initDeck();
	
	public void printCard() 
	{
		String r = new String();
		switch (m_rank) 
		{
		case 10:
			r = "10";
			break;
		case 11:
			r = "J";
			break;
		case 12:
			r = "Q";
			break;
		case 13:
			r = "K";
			break;
		case 14:
			r = "A";
			break;
		default:
			r = String.valueOf(m_rank);
		}
		
		System.out.print(m_suit.toString() + r);
	}
}
