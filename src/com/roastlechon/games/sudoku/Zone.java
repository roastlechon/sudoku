package com.roastlechon.games.sudoku;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class Zone extends JPanel {
	
	private int x;
	private int y;
	
	private int h = 60;
	private int w = 60;
	
	public Zone(String position) {
		setLayout(new GridLayout(3,3));
		add(new Field());
		add(new Field());
		add(new Field());
		add(new Field());
		add(new Field());
		add(new Field());
		add(new Field());
		add(new Field());
		add(new Field());
		
		setPosition(position);
		
		setBounds(x, y, h, w);
	}
	
	private void setPosition(String position) {
		if(position.equals("a1")) {
			x = 10;
			y = 10;
		}
		if(position.equals("a2")) {
			x = 10 + w;
			y = 10;
		}
		if(position.equals("a3")) {
			x = 10 + w + w;
			y = 10;
		}
		if(position.equals("b1")) {
			x = 10;
			y = 10 + h;
		}
		if(position.equals("b2")) {
			x = 10 + w;
			y = 10 + h;
		}
		if(position.equals("b3")) {
			x = 10 + w + w;
			y = 10 + h;
		}
		if(position.equals("c1")) {
			x = 10;
			y = 10 + h + h;
		}
		if(position.equals("c2")) {
			x = 10 + w;
			y = 10 + h + h;
		}
		if(position.equals("c3")) {
			x = 10 + w + w;
			y = 10 + h + h;
		}
	}

}
