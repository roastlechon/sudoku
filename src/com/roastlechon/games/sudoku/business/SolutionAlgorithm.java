package com.roastlechon.games.sudoku.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.roastlechon.games.sudoku.model.Square;
import com.roastlechon.games.sudoku.view.Board;
import com.roastlechon.games.sudoku.view.Field;
import com.roastlechon.games.sudoku.view.Zone;

public class SolutionAlgorithm {

	public boolean valid = false;
	
	public SolutionAlgorithm(Board board) {
		List<Square> zoneSquares = new ArrayList<Square>();
		for (int i = 0; i < board.getComponents().length; i++) {
			Zone z = (Zone) board.getComponents()[i];
			for (int j = 0; j < z.getComponents().length; j++) {
				Field f = (Field) z.getComponents()[j];
				Square square = f.getSquare();
				if (f.getValue() == null || f.getValue().equals(0)) {
					this.valid = false;
					break;
				}
				String value = (String) f.getValue();
				square.setValue(Integer.valueOf(value));
				zoneSquares.add(square);
			}
		}
		
		this.valid = isValid(zoneSquares);
	}
	
	public boolean isValid(List<Square> zoneSquares) {
		if (areValidZones(zoneSquares) && areValidZones(zoneSquares) && areValidRows(zoneSquares)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean areValidZones(List<Square> zoneSquares) {
		boolean valid = true;
		List<Square> zoneSquares1 = new ArrayList<Square>();
		List<Square> zoneSquares2 = new ArrayList<Square>();
		List<Square> zoneSquares3 = new ArrayList<Square>();
		List<Square> zoneSquares4 = new ArrayList<Square>();
		List<Square> zoneSquares5 = new ArrayList<Square>();
		List<Square> zoneSquares6 = new ArrayList<Square>();
		List<Square> zoneSquares7 = new ArrayList<Square>();
		List<Square> zoneSquares8 = new ArrayList<Square>();
		List<Square> zoneSquares9 = new ArrayList<Square>();
		
		for (int i = 0; i < zoneSquares.size() && valid; i++) {
			Square zoneSquare = zoneSquares.get(i);
			if (zoneSquare.zone == 1) {
				zoneSquares1.add(zoneSquare);
				if (zoneSquares1.size() == 9) {
					valid = isUnique(zoneSquares1);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 2) {
				zoneSquares2.add(zoneSquare);
				if (zoneSquares2.size() == 9) {
					valid = isUnique(zoneSquares2);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 3) {
				zoneSquares3.add(zoneSquare);
				if (zoneSquares3.size() == 9) {
					valid = isUnique(zoneSquares3);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 4) {
				zoneSquares4.add(zoneSquare);
				if (zoneSquares4.size() == 9) {
					valid = isUnique(zoneSquares4);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 5) {
				zoneSquares5.add(zoneSquare);
				if (zoneSquares5.size() == 9) {
					valid = isUnique(zoneSquares5);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 6) {
				zoneSquares6.add(zoneSquare);
				if (zoneSquares6.size() == 9) {
					valid = isUnique(zoneSquares6);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 7) {
				zoneSquares7.add(zoneSquare);
				if (zoneSquares7.size() == 9) {
					valid = isUnique(zoneSquares7);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 8) {
				zoneSquares8.add(zoneSquare);
				if (zoneSquares8.size() == 9) {
					valid = isUnique(zoneSquares8);
					if (!valid) {
						return false;
					}
				}
			}
			if (zoneSquare.zone == 9) {
				zoneSquares9.add(zoneSquare);
				if (zoneSquares9.size() == 9) {
					valid = isUnique(zoneSquares9);
					if (!valid) {
						return false;
					}
				}
			}
			
		}
		return valid;
	}
	
	public boolean areValidRows(List<Square> rowSquares) {
		boolean valid = true;
		List<Square> rowSquares1 = new ArrayList<Square>();
		List<Square> rowSquares2 = new ArrayList<Square>();
		List<Square> rowSquares3 = new ArrayList<Square>();
		List<Square> rowSquares4 = new ArrayList<Square>();
		List<Square> rowSquares5 = new ArrayList<Square>();
		List<Square> rowSquares6 = new ArrayList<Square>();
		List<Square> rowSquares7 = new ArrayList<Square>();
		List<Square> rowSquares8 = new ArrayList<Square>();
		List<Square> rowSquares9 = new ArrayList<Square>();
		
		for (int i = 0; i < rowSquares.size() && valid; i++) {
			Square rowSquare = rowSquares.get(i);
			if (rowSquare.zone == 1) {
				rowSquares1.add(rowSquare);
				if (rowSquares1.size() == 9) {
					valid = isUnique(rowSquares1);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 2) {
				rowSquares2.add(rowSquare);
				if (rowSquares2.size() == 9) {
					valid = isUnique(rowSquares2);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 3) {
				rowSquares3.add(rowSquare);
				if (rowSquares3.size() == 9) {
					valid = isUnique(rowSquares3);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 4) {
				rowSquares4.add(rowSquare);
				if (rowSquares4.size() == 9) {
					valid = isUnique(rowSquares4);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 5) {
				rowSquares5.add(rowSquare);
				if (rowSquares5.size() == 9) {
					valid = isUnique(rowSquares5);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 6) {
				rowSquares6.add(rowSquare);
				if (rowSquares6.size() == 9) {
					valid = isUnique(rowSquares6);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 7) {
				rowSquares7.add(rowSquare);
				if (rowSquares7.size() == 9) {
					valid = isUnique(rowSquares7);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 8) {
				rowSquares8.add(rowSquare);
				if (rowSquares8.size() == 9) {
					valid = isUnique(rowSquares8);
					if (!valid) {
						return false;
					}
				}
			}
			if (rowSquare.zone == 9) {
				rowSquares9.add(rowSquare);
				if (rowSquares9.size() == 9) {
					valid = isUnique(rowSquares9);
					if (!valid) {
						return false;
					}
				}
			}
			
		}
		return valid;
	}
	
	public boolean areValidCols(List<Square> colSquares) {
		boolean valid = true;
		List<Square> colSquares1 = new ArrayList<Square>();
		List<Square> colSquares2 = new ArrayList<Square>();
		List<Square> colSquares3 = new ArrayList<Square>();
		List<Square> colSquares4 = new ArrayList<Square>();
		List<Square> colSquares5 = new ArrayList<Square>();
		List<Square> colSquares6 = new ArrayList<Square>();
		List<Square> colSquares7 = new ArrayList<Square>();
		List<Square> colSquares8 = new ArrayList<Square>();
		List<Square> colSquares9 = new ArrayList<Square>();
		
		for (int i = 0; i < colSquares.size() && valid; i++) {
			Square colSquare = colSquares.get(i);
			if (colSquare.zone == 1) {
				colSquares1.add(colSquare);
				if (colSquares1.size() == 9) {
					valid = isUnique(colSquares1);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 2) {
				colSquares2.add(colSquare);
				if (colSquares2.size() == 9) {
					valid = isUnique(colSquares2);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 3) {
				colSquares3.add(colSquare);
				if (colSquares3.size() == 9) {
					valid = isUnique(colSquares3);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 4) {
				colSquares4.add(colSquare);
				if (colSquares4.size() == 9) {
					valid = isUnique(colSquares4);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 5) {
				colSquares5.add(colSquare);
				if (colSquares5.size() == 9) {
					valid = isUnique(colSquares5);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 6) {
				colSquares6.add(colSquare);
				if (colSquares6.size() == 9) {
					valid = isUnique(colSquares6);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 7) {
				colSquares7.add(colSquare);
				if (colSquares7.size() == 9) {
					valid = isUnique(colSquares7);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 8) {
				colSquares8.add(colSquare);
				if (colSquares8.size() == 9) {
					valid = isUnique(colSquares8);
					if (!valid) {
						return false;
					}
				}
			}
			if (colSquare.zone == 9) {
				colSquares9.add(colSquare);
				if (colSquares9.size() == 9) {
					valid = isUnique(colSquares9);
					if (!valid) {
						return false;
					}
				}
			}
			
		}
		return valid;
	}
	
	public boolean isUnique(List<Square> zoneSquares) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < zoneSquares.size(); i++) {
			list.add(zoneSquares.get(i).value);
		}
		
		Set<Integer> set = new HashSet<Integer>(list);
		if (set.size() < zoneSquares.size()) {
			return false;
		} else {
			return true;
		}
	}
	
	
	

}
