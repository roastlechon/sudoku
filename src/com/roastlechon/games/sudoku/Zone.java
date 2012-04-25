package com.roastlechon.games.sudoku;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

public class Zone extends JPanel {
	
	private int x;
	private int y;
	
	private int h = 60;
	private int w = 60;
	
	public Zone(String position, List<Square> zoneSquares) {
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < 9; i++) {
			add(new Field(zoneSquares.get(i).value));
		}
		
		setPosition(position);
		
		setBounds(x, y, h, w);
	}
	
	private void setPosition(String position) {
		if(position.equals("1")) {
			x = 10;
			y = 10;
		}
		if(position.equals("2")) {
			x = 10 + w;
			y = 10;
		}
		if(position.equals("3")) {
			x = 10 + w + w;
			y = 10;
		}
		if(position.equals("4")) {
			x = 10;
			y = 10 + h;
		}
		if(position.equals("5")) {
			x = 10 + w;
			y = 10 + h;
		}
		if(position.equals("6")) {
			x = 10 + w + w;
			y = 10 + h;
		}
		if(position.equals("7")) {
			x = 10;
			y = 10 + h + h;
		}
		if(position.equals("8")) {
			x = 10 + w;
			y = 10 + h + h;
		}
		if(position.equals("9")) {
			x = 10 + w + w;
			y = 10 + h + h;
		}
	}

}
