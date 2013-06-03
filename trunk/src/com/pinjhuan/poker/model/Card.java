package com.pinjhuan.poker.model;

import java.util.List;

public abstract class Card implements Comparable<Card>{
	
	public Card() {}
	
	public Card(int rank, Suit suit) {
		this.m_rank = rank;
		this.m_suit = suit;
	}

	protected int m_rank;
	protected static final int RANK_MIN = Integer.MIN_VALUE;
	protected static final int RANK_MAX = Integer.MAX_VALUE;
	
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
	
	@Override
    public int compareTo(Card other){
		if (this.m_suit.compareTo(other.m_suit)!= 0)
			return this.m_suit.compareTo(other.m_suit);
		else
			return this.m_rank - other.m_rank;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (m_rank != other.m_rank)
			return false;
		if (m_suit != other.m_suit)
			return false;
		return true;
	}
	
	
}
