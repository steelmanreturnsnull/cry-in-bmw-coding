package com.pinjhuan.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name = null;
	private List<Card> current_cards = null;
	

	public String getName() {
		return name;
	}

	public Player(String name) {
		super();
		this.name = name;
		current_cards = new ArrayList<Card> ();
	}
	
	public void addCard (Card c) {
		current_cards.add(c);
	}
	
	public void printCurrentCards () {
		System.out.print(name + ": ");
		for (Card c : current_cards)
		{
			c.printCard();
			System.out.print("\t");
		}
		System.out.println();
	}
}
