package com.roastlechon.games.sudoku.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.roastlechon.games.sudoku.model.Square;


public class Zone extends JPanel {
	
	private static final long serialVersionUID = 2314295662030027490L;
	private int x;
	private int y;
	
	Border border = BorderFactory.createLineBorder(Color.GRAY);
	
	private int h = 60;
	private int w = 60;
	
	public Zone(String position) {
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < 9; i++) {
			add(new Field());
		}
		setPosition(position);
		setBounds(x, y, h, w);
	}
	
	public Zone(String position, List<Square> zoneSquares) {
		setLayout(new GridLayout(3,3));
		
		for(int i = 0; i < 9; i++) {
			add(new Field(zoneSquares.get(i)));
		}
		
		setPosition(position);
		setBorder(border);
		setBounds(x, y, h, w);
	}
	
	private void setPosition(String position) {
		if(position.equals("1")) {
			x = 10;
			y = 10;
		}
		if(position.equals("2")) {
			x = 9 + w;
			y = 10;
		}
		if(position.equals("3")) {
			x = 8 + w + w;
			y = 10;
		}
		if(position.equals("4")) {
			x = 10;
			y = 9 + h;
		}
		if(position.equals("5")) {
			x = 9 + w;
			y = 9 + h;
		}
		if(position.equals("6")) {
			x = 8 + w + w;
			y = 9 + h;
		}
		if(position.equals("7")) {
			x = 10;
			y = 8 + h + h;
		}
		if(position.equals("8")) {
			x = 9 + w;
			y = 8 + h + h;
		}
		if(position.equals("9")) {
			x = 8 + w + w;
			y = 8 + h + h;
		}
	}

}
