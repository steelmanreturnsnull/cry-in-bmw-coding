package com.pinjhuan.poker.experiments;

public abstract class Experiments {

	protected int m_total_decks_generated;
	protected int m_decks_used;
	
	private void init()
	{
		m_total_decks_generated = 0;
		m_decks_used = 0;
	}
	
	public abstract void conduct();

	public void doExperiment()
	{
		init();
		conduct();
	}

}
