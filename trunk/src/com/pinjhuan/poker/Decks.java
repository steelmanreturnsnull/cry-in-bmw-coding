package com.pinjhuan.poker;

import java.util.Collections;
import java.util.List;

public class Decks <T extends Card> 
{
	private List<T> m_cards;

	public List<T> getCards() {
		return m_cards;
	}

	public Decks (List<T> cards) {
		m_cards = cards;
	}
	
	public void printDecks () {
		System.out.println();
		int i = 1;
		int cards_per_line = 13;
		for (T t : m_cards) {
			t.printCard();
			if (i % cards_per_line== 0)
				System.out.println();
			else
				System.out.print("\t");
			i++;
		}
		System.out.println();
	}
	
	public void shuffle()
	{
		Collections.shuffle(m_cards);
	}
	
	public int remainingCards ()
	{
		return m_cards.size();
	}
	
	public T dealCard ()
	{
		return m_cards.remove(m_cards.size() - 1);
	}
}
