package com.roastlechon.games.sudoku;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.roastlechon.games.sudoku.business.GenerationAlgorithm;
import com.roastlechon.games.sudoku.view.Board;

public class Sudoku extends JFrame {

	private static final long serialVersionUID = 9179949591758990253L;
	final JButton generateButton = new JButton("Generate");
	final JButton finishButton = new JButton("Finish");
	JFormattedTextField timerField = new JFormattedTextField();
	final JLabel timerLabel = new JLabel("Time Elapsed");
	JPanel panel = new JPanel();
	Board board = new Board();
	int delay = 1000;
	int time = 1;
	
	final JFrame messageDialog = new JFrame();
		
	Timer timer;
	
	public Sudoku() {
		timerLabel.setLayout(null);
		timerLabel.setBounds(10, 200, 80, 20);
		
		timerField.setHorizontalAlignment(JFormattedTextField.CENTER);
		timerField.setLayout(null);
		timerField.setEnabled(true);
		timerField.setEditable(false);
		timerField.setBounds(10, 225, 60, 20);
		timerField.setValue("0");
		timerField.setForeground(Color.BLACK);
		
		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
		          timerField.setValue(time++);
			}
		});
		
		generateButton.setLayout(null);
		generateButton.setBounds(100, 200, 90, 20);
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishButton.setEnabled(true);
				panel.remove(board);
				board = new Board(new GenerationAlgorithm().puzzle);
				panel.add(board);
				panel.revalidate();
				panel.repaint();
				timerField.setValue("0");
				time = 1;
				timer.restart();
				transferFocus();
			}
		});
		
		finishButton.setLayout(null);
		finishButton.setBounds(100, 225, 90, 20);
		finishButton.setEnabled(false);
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (board.isValid()) {
					if (board.isComplete()) {
						finishButton.setEnabled(false);
						timer.stop();
						JOptionPane.showMessageDialog(messageDialog, "Congratulations, you finished the puzzle in " + timerField.getValue() + " seconds. Click Generate to play again.");
					} else {
						JOptionPane.showMessageDialog(messageDialog, "The sudoku puzzle is not complete. Please check the puzzle and click Finish.");
					}
				} else {
					JOptionPane.showMessageDialog(messageDialog, "The sudoku puzzle is not complete. Please check the puzzle and click Finish.");
				}
			}
		});
		
		panel.setLayout(null);
		panel.add(timerLabel);
		panel.add(timerField);
		panel.add(board);
		panel.add(generateButton);
		panel.add(finishButton);
		
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(204, 285);
		this.setLocationRelativeTo(null);
		this.setTitle("Sudoku");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Sudoku();
	}

	
=======
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
>>>>>>> github/master
}
