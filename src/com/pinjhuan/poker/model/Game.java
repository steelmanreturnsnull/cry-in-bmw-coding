package com.pinjhuan.poker.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
	
	private Map<String, Player> m_players;
	private Decks<Card> m_decks;
	private int m_reserved = 0;

	public int getReserved() {
		return m_reserved;
	}

	public void setReserved(int reserved) {
		this.m_reserved = reserved;
	}
	
	
	public Game(List<Player> players, Decks<Card> decks, int reserved) {
		this(players, decks);
		this.m_reserved = reserved;
	}

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
	
	public void dealUnreservedCardsToPlayer (Player p)
	{
		if (m_decks.remainingCards() > m_reserved)
			p.addCard(m_decks.dealCard());
	}
	
	public void dealUnreservedCards ()
	{
		while (m_decks.remainingCards() > m_reserved)
		{
			for (Player p : m_players.values())
			{
				dealUnreservedCardsToPlayer(p);
			}
		}
	}

	public void reset (List<Card> cards)
	{
		for (Player p : m_players.values())
		{
			p.reset();
		}
		m_decks.setCards(cards);
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
