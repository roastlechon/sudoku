package com.roastlechon.games.sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import com.roastlechon.games.sudoku.model.Square;

public class Field extends JFormattedTextField {
	
	private static final long serialVersionUID = 8031599756854199153L;
	
	Border border = BorderFactory.createEmptyBorder();
	Square square;
	
	public Field() {
		super(getMaskFormatter());
		Dimension dimension = new Dimension(20, 20);
		this.setPreferredSize(dimension);
		this.setHorizontalAlignment(JFormattedTextField.CENTER);
		this.setFocusable(false);
		this.setEditable(false);
		this.setBackground(new Color(240, 240, 240));
		this.setBorder(border);
	}
	
	public Field(Square square) {
		super(getMaskFormatter());
		
		this.square = square;
		Dimension dimension = new Dimension(20, 20);
		this.setPreferredSize(dimension);
		this.setHorizontalAlignment(JFormattedTextField.CENTER);
		
		if(square.value == 0) {
			this.setValue(null);
			this.setBorder(border);
			this.addKeyListener(new KeyListener() {

				public void keyPressed(KeyEvent arg0) {
					
				}

				public void keyReleased(KeyEvent arg0) {
					setCaretPosition(0);
				}

				public void keyTyped(KeyEvent arg0) {
					setCaretPosition(0);
					transferFocus();
				}
				
			});
		} else {
			this.setValue(String.valueOf(square.value));
			this.setFocusable(false);
			this.setEditable(false);
			this.setBackground(new Color(240, 240, 240));
			this.setBorder(border);
		}
	}
	
	public static MaskFormatter getMaskFormatter() {
		MaskFormatter fieldFormat = null;
		try {
			fieldFormat  = new MaskFormatter("*");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fieldFormat.setValidCharacters("123456789 ");
		fieldFormat.setInvalidCharacters("0");
		return fieldFormat;
	}
	
	public Square getSquare() {
		return this.square;
	}

}
