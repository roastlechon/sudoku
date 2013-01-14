package com.roastlechon.games.sudoku.model;

public class Square {
	
	public int row;
	public int col;
	public int zone;
	public int value;
	public int index;
	
	public Square() {
		
	}
	
	public Square(int index, int value) {
		int n = index + 1;
		this.index = index;
		this.value = value;
		row = getRow(n);
		col = getCol(n);
		zone = getZone(n);
	}
	
	private static int getCol(int index) {
		int row = 0;
		row = index % 9;
		
		if(row == 0) {
			row = 9;
		}
		
		return row;
	}
	
	private static int getRow(int index) {
		int col = 0;
		if(getCol(index) == 9) {
			col = index / 9;
		} else {
			col = index / 9 + 1;
		}
		
		return col;
	}
	
	private static int getZone(int index) {
		int zone = 0;
		
		int col = getCol(index);
		int row = getRow(index);
		
		if(col > 0 & col < 4 & row > 0 & row < 4) {
			zone = 1;
		} else if (col > 3 & col < 7 & row > 0 & row < 4 ) {
			zone = 2;
		} else if (col > 6 & col < 10 & row > 0 & row < 4 ) {
			zone = 3;
		} else if (col > 0 & col < 4 & row > 3 & row < 7 ) {
			zone = 4;
		} else if (col > 3 & col < 7 & row > 3 & row < 7 ) {
			zone = 5;
		} else if (col > 6 & col < 10 & row > 3 & row < 7 ) {
			zone = 6;
		} else if (col > 0 & col < 4 & row > 6 & row < 10 ) {
			zone = 7;
		} else if (col > 3 & col < 7 & row > 6 & row < 10 ) {
			zone = 8;
		} else if (col > 6 & col < 10 & row > 6 & row < 10 ) {
			zone = 9;
		}
		
		return zone;
	}
	
	public  void setValue(int value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		
		/*
		System.out.println("Index 6 is in column " + getCol(6));
		System.out.println("Index 9 is in column " + getCol(9));
		System.out.println("Index 10 is in column " + getCol(10));
		
		System.out.println("Index 5 is in row " + getRow(5));
		System.out.println("Index 36 is in row " + getRow(36));
		System.out.println("Index 9 is in row " + getRow(9));
		System.out.println("Index 10 is in row " + getRow(10));
		System.out.println("Index 22 is in row " + getRow(22));
		System.out.println("Index 81 is in row " + getRow(81));
		
		System.out.println("Index is 1 " + getZone(1));
		System.out.println("Index is 8 " + getZone(8));
		System.out.println("Index is 6 " + getZone(6));
		System.out.println("Index is 12 " + getZone(12));
		System.out.println("Index is 28 " + getZone(28));
		System.out.println("Index is 57 " + getZone(57));
		System.out.println("Index is 73 " + getZone(73));
		System.out.println("Index is 81 " + getZone(81));
		*/
		
		/*
		Square square = new Square(0, 4);
		System.out.println("Index 0, value 4 is column " + square.col);
		System.out.println("Index 0, value 4 is value " + square.value);
		System.out.println("Index 0, value 4 is row " + square.row);
		System.out.println("Index 0, value 4 is index " + square.index);
		*/
	}
	
	public boolean equals(Square square) {
		if (this.value == square.value){
			return true;
		} else {
			return false;
		}
		
	}
	
	public String toString() {
		return this.value + "";
	}
	
}
