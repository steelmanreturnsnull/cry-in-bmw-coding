package com.pinjhuan.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private String name = null;
	private List<Card> current_cards = null;
	private List<Card> all_cards = null;

	public String getName() {
		return name;
	}

	public Player(String name) {
		super();
		this.name = name;
		current_cards = new ArrayList<Card> ();
		all_cards = new ArrayList<Card> ();
	}
	
	public void addCard (Card c) {
		current_cards.add(c);
		all_cards.add(c);
	}
	
	public void reset () {
		current_cards.clear();
		all_cards.clear();
	}
	
	public void printCurrentCards () {
		System.out.print(name + ": ");
		Collections.sort(current_cards);
		for (Card c : current_cards)
		{
			c.printCard();
			System.out.print("\t");
		}
		System.out.println();
	}
	
	
	

	boolean hasAParticularCard (Card c) {
		return current_cards.contains(c);
	}
	
	boolean hasNParticularCard (Card c, int n) {
		int count = 0;
		for (Card card : current_cards)
		{
			if (card.equals(c))
				count ++;
		}
		return (count >= n);

	}
}
