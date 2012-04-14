package com.roastlechon.games.sudoku;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Board extends JPanel {
	
	public Board() {
		setLayout(null);
		
		add(new Zone("a1"));
		add(new Zone("a2"));
		add(new Zone("a3"));
		add(new Zone("b1"));
		add(new Zone("b2"));
		add(new Zone("b3"));
		add(new Zone("c1"));
		add(new Zone("c2"));
		add(new Zone("c3"));
		
	}

}