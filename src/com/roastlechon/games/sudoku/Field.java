package com.roastlechon.games.sudoku;

import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class Field extends JFormattedTextField {
	
	public Field(int value) {
		super(getMaskFormatter());
		Dimension dimension = new Dimension(20, 20);
		setPreferredSize(dimension);
		setHorizontalAlignment(JFormattedTextField.CENTER);
		setValue(value);
	}
	
	public static MaskFormatter getMaskFormatter() {
		MaskFormatter fieldFormat = null;
		try {
			fieldFormat  = new MaskFormatter("#");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fieldFormat.setInvalidCharacters("0");
		return fieldFormat;
	}

}
