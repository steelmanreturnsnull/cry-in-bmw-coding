package com.pinjhuan.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
	
	private Map<String, Player> m_players;
	private Decks<Card> m_decks;
	
	
	
	public Game(List<Player> players, Decks<Card> decks) {
		m_players = new HashMap<String, Player>();
		for (Player p : players)
		{
			m_players.put(p.getName(), p);
		}
		this.m_decks = decks;
	}

	public Player getPlayerFromName (String name)
	{
		return m_players.get(name);
	}
	
	public void dealUnreservedCards (int reserved)
	{
		while (m_decks.remainingCards() > reserved)
		{
			for (Player p : m_players.values())
			{
				if (m_decks.remainingCards() > 0)
					p.addCard(m_decks.dealCard());
			}
		}
	}

	public void printGame ()
	{
		System.out.println("Game status:");
		System.out.println("Player current cards:");
		for (Player p : m_players.values())
		{
			p.printCurrentCards();
		}
	}
	
	
}
