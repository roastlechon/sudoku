package com.roastlechon.games.sudoku;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import javax.swing.JFrame;

public class Sudoku extends JFrame {
	
	Integer zone[] = {1, 9, 3, 5};
	int test[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public Sudoku() {
		add(new Board());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(205, 320);
		setLocationRelativeTo(null);
		setTitle("Sudoku");
		setResizable(false);
		setVisible(true);
		
		//System.out.println(getRandomNumber(zone));
		//System.out.println(Arrays.asList(zone).indexOf(4));
		generate();
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
	
	
	public void generate() {
		List<Square> squares = new ArrayList<Square>();
		List<Integer[]> available = new ArrayList<Integer[]>();
		for(int x = 0; x < 81; x++) {
			Integer[] numbers = new Integer[9];
			for(int z = 0; z < 9; z++) {
				numbers[z] = z + 1;
				//System.out.println(z);
			}
			//System.out.println(Arrays.toString(numbers));
			available.add(numbers);
		}
		
		//System.out.println(Arrays.toString(available.get(0)));
		//System.out.println(available.get(0).length);
		//System.out.println(Arrays.toString(ArrayUtils.remove(available.get(0), 0)));
		//System.out.println(ArrayUtils.remove(available.get(0), 0).length);
		/*
		squares.add(new Square(1, 1));
		squares.add(new Square(2, 2));
		squares.add(new Square(3, 3));
		squares.add(new Square(4, 4));
		squares.add(new Square(5, 5));
		squares.add(new Square(6, 6));
		squares.add(new Square(7, 7));
		squares.add(new Square(8, 8));
		squares.add(new Square(9, 9));
		squares.add(new Square(10, 8));
		squares.add(new Square(11, 6));
		System.out.println("Added squares to empty array.");
		System.out.println("Index for square 0 is: " + squares.get(0).index);
		System.out.println("Index for square 1 is: " + squares.get(1).index);
		System.out.println("Index for square 2 is: " + squares.get(2).index);
		System.out.println("Index for square 3 is: " + squares.get(3).index);
		System.out.println("Index for square 4 is: " + squares.get(4).index);
		System.out.println("Index for square 5 is: " + squares.get(5).index);
		System.out.println("Index for square 6 is: " + squares.get(6).index);
		System.out.println("Index for square 7 is: " + squares.get(7).index);
		System.out.println("Index for square 8 is: " + squares.get(8).index);
		System.out.println("Index for square 9 is: " + squares.get(9).index);
		System.out.println("Index for square 10 is: " + squares.get(10).index);


		squares.remove(0);
		*/
		
		int i = 0; // index of fields
		while (i < 81) {
			
			System.out.println("---------------------------------------------------------------Loop 1 to 81: " + i);
			
			System.out.println("Available squares at position " + i + ": " + available.get(i).length);
			if(available.get(i).length != 0) {
				
				// random value
				Integer n = getRandomNumber(available.get(i));
				System.out.println("Test number value: " + n);

				System.out.println("Random number from available array: " + Arrays.asList(available.get(i)).toString() + ": " + n);
				
				// index of random number
				int l = Arrays.asList(available.get(i)).indexOf(n);
				
				if(validSquare(squares, new Square(i, n)) == true) {
					squares.add(new Square(i, n));
					
					System.out.println("Valid square.");
					System.out.println("Value added: " + squares.get(i).value);
					
					available.set(i, ArrayUtils.remove(available.get(i), l));
					
					i++;
					
				} else {
					System.out.println("Not a valid square.");
					
					available.set(i, ArrayUtils.remove(available.get(i), l));
					
					System.out.println("Available array: " + Arrays.asList(available.get(i)).toString());
				}
			} else {
				System.out.println("No available numbers for square");
				
				Integer[] numbers = new Integer[9];
				for(int z = 0; z < 9; z++) {
					numbers[z] = z + 1;
					//System.out.println(z);
				}
				available.set(i, numbers);
				int p = i - 1;
				squares.remove(p);
				i--;
			}
		}
		
		for(int j = 0; j < 80; j++) {
			System.out.println(squares.get(j).value);
		}
	
	}
	
	public boolean validSquare(List<Square> squares, Square square) {
		for(int i = 0; i < squares.size(); i++) {
			int m = i + 1;
			if(squares.get(i).row == square.row | squares.get(i).col != square.col | 
					squares.get(i).zone != square.zone) {
				if(squares.get(i).value == square.value) {
					return false;
				}
				
			}
			
		}
		return true;
	}

}
