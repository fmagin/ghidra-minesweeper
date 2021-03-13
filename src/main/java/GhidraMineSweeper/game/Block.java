package GhidraMineSweeper.game;

import javax.swing.*;
import java.awt.*;

public class Block extends JButton{
	
	private int row, col;
	private int type;
	
	public Block(int row, int col) { 
		setPreferredSize(new Dimension(24,24));
		setMargin(new Insets(1,1,1,1));
		
		this.row = row;
		this.col = col;
		
		this.type = 0;
	}
	
	public void setMine() { type = 9; }
	
	public boolean isMine() { return type == 9; }
	
	public boolean noMines() { return type == 0; }

	public void addMine() { type++; }
	
	public int getRow() { return row; }
	public int getColumn() { return col; }

	public int getType() { return type; }

	public void reset() {
		this.type = 0;
		this.setText(null);
		this.setEnabled(true);
	}
}
