package com.roastlechon.games.sudoku;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import javax.swing.JFrame;

public class Sudoku extends JFrame {
	
	public Sudoku() {
		List<Square> squares = generate();
		
		add(new Board(squares));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(205, 320);
		setLocationRelativeTo(null);
		setTitle("Sudoku");
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Sudoku();
	}

	public int getRandomNumber(Integer[] available) {
		int random = 0;
		Random r = new Random();
		random = r.nextInt(available.length);
		return available[random];
	}
	
	
	public List<Square> generate() {
		List<Square> squares = new ArrayList<Square>();
		List<Integer[]> available = new ArrayList<Integer[]>();
		for(int x = 0; x < 81; x++) {
			Integer[] numbers = new Integer[9];
			for(int z = 0; z < 9; z++) {
				numbers[z] = z + 1;
			}
			available.add(numbers);
		}
		
		int i = 0; // index of fields
		while (i < 81) {
			
			if(available.get(i).length != 0) {
				
				// random value
				Integer n = getRandomNumber(available.get(i));
							
				// index of random number
				int l = Arrays.asList(available.get(i)).indexOf(n);
				
				Square square = new Square(i, n);
				
				if(validSquare(squares, square) == true) {
					squares.add(square);
					
					available.set(i, ArrayUtils.remove(available.get(i), l));
					
					i++;
				} else {
					available.set(i, ArrayUtils.remove(available.get(i), l));
				}
			} else {
				Integer[] numbers = new Integer[9];
				
				for(int z = 0; z < 9; z++) {
					numbers[z] = z + 1;
				}
				
				available.set(i, numbers);
				
				i--;
				
				squares.remove(i);
			}
		}
		return squares;
	}
	
	public boolean validSquare(List<Square> squares, Square square) {
		for(int i = 0; i < squares.size(); i++) {
			int m = i + 1;
			if(squares.get(i).row == square.row | squares.get(i).col == square.col | 
					squares.get(i).zone == square.zone) {
				if(squares.get(i).value == square.value) {
					return false;
				}
			}
		}
		return true;
	}
}
