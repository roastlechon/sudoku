package com.roastlechon.games.sudoku;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel {
	
	public Board(List<Square> squares) {
		setLayout(null);
		
		List<Square> zoneSquares1 = new ArrayList<Square>();
		List<Square> zoneSquares2 = new ArrayList<Square>();
		List<Square> zoneSquares3 = new ArrayList<Square>();
		List<Square> zoneSquares4 = new ArrayList<Square>();
		List<Square> zoneSquares5 = new ArrayList<Square>();
		List<Square> zoneSquares6 = new ArrayList<Square>();
		List<Square> zoneSquares7 = new ArrayList<Square>();
		List<Square> zoneSquares8 = new ArrayList<Square>();
		List<Square> zoneSquares9 = new ArrayList<Square>();
		
		for(int j = 0; j < 81; j++) {
			if(squares.get(j).zone == 1) {
				zoneSquares1.add(squares.get(j));
			} else if(squares.get(j).zone == 2) {
				zoneSquares2.add(squares.get(j));
			} else if(squares.get(j).zone == 3) {
				zoneSquares3.add(squares.get(j));
			} else if(squares.get(j).zone == 4) {
				zoneSquares4.add(squares.get(j));
			} else if(squares.get(j).zone == 5) {
				zoneSquares5.add(squares.get(j));
			} else if(squares.get(j).zone == 6) {
				zoneSquares6.add(squares.get(j));
			} else if(squares.get(j).zone == 7) {
				zoneSquares7.add(squares.get(j));
			} else if(squares.get(j).zone == 8) {
				zoneSquares8.add(squares.get(j));
			} else if(squares.get(j).zone == 9) {
				zoneSquares9.add(squares.get(j));				
			}
		}
		
		add(new Zone("1", zoneSquares1));
		add(new Zone("2", zoneSquares2));
		add(new Zone("3", zoneSquares3));
		add(new Zone("4", zoneSquares4));
		add(new Zone("5", zoneSquares5));
		add(new Zone("6", zoneSquares6));
		add(new Zone("7", zoneSquares7));
		add(new Zone("8", zoneSquares8));
		add(new Zone("9", zoneSquares9));
	}

}