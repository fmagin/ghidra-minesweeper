package GhidraMineSweeper.game;

import docking.widgets.OptionDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel implements ActionListener{
	
	private final int totalMines;
	private Block[][] blocks;
	private Dimension gridSize;
	private int visibleBlocks;
	private MinesweeperProvider provider;

	//Block Types - Numbers correspond to mines around them, 9 is a mine.
	public Board(MinesweeperProvider provider) {
		this.provider = provider;
		gridSize = new Dimension(20,20);
		//setPreferredSize(new Dimension(800,600));
		setLayout(new GridLayout(gridSize.height,gridSize.width));
		
		totalMines = 20;
		visibleBlocks = gridSize.width * gridSize.height;

		blocks = new Block[gridSize.height][gridSize.width];
		for (int i = 0; i < gridSize.width; i++) {
			for (int j = 0; j < gridSize.height; j++) {
				blocks[i][j] = new Block(i,j);
				blocks[i][j].addActionListener(this);
				add(blocks[i][j]);
			}
		}

		addMines();
		
		setVisible(true);
	}
	private void resetGameBoard(){

		visibleBlocks = gridSize.width * gridSize.height;
		for (int i = 0; i < gridSize.width; i++) {
			for (int j = 0; j < gridSize.height; j++) {
				blocks[i][j].reset();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			showBlock((Block)(e.getSource()));
		} catch(Exception exc) {
			System.err.println(
				exc.getMessage()+"Board's ActionListener only for Block objects"
			);
		}
	}

	private void showBlock(Block block) {
		block.setEnabled(false);
		
		if (block.noMines())
			showNeighbours(block);
		else if (block.isMine())
			showGameOver();
		else
			block.setText(Integer.toString(block.getType()));
			
		visibleBlocks--;
		
		if (visibleBlocks == totalMines)
			showGameOver();
	}
	
	private void showMines() {
		for (Block[] rowBlocks : blocks) {
			for (Block block : rowBlocks) {
				if (block.isMine())
					block.setText("X");
			}
		}
	}
	
	private void showGameOver() {
		if (visibleBlocks != totalMines) { //Lose
			showMines();
			if (OptionDialog.showYesNoDialog(null,
					"Lost",
					"Want to try again?")
					== OptionDialog.OPTION_TWO) {
				provider.setVisible(false);
			}
		} else {
			if (OptionDialog.showYesNoDialog(null,
					"Won",
					"Another round?")
					== OptionDialog.OPTION_TWO) {
				provider.setVisible(false);
			}
		}
		resetGameBoard();
		addMines();
	}
	
	private void addMines() {
		int mineCount = 0;
		Random random = new Random();
		
		while (mineCount != totalMines) {
			int i = random.nextInt(blocks.length);
			int j = random.nextInt(blocks[0].length);
			if (!blocks[i][j].isMine()) {
				blocks[i][j].setMine();
				for (int row = i-1;row <= i+1; row++) {
					for (int col = j-1; col <= j+1; col++) {
						if (row == i && col == j)
							continue; //Skip Centre
						if (row < 0 || row > gridSize.height-1 ||
							col < 0 || col > gridSize.width-1
							)
							continue; //Out of Bounds
						if(!blocks[row][col].isMine())
							blocks[row][col].addMine();
					}
				}
				
				mineCount++;
			}
		}
	}
	
	public void showNeighbours(Block block) {
		int row = block.getRow();
		int col = block.getColumn();
		
		for (int i = row-1;i <= row+1; i++) {
			for (int j = col-1; j <= col+1; j++) {
				if (i == row && j == col)
					continue; //Skip Centre
				if (i < 0 || i > gridSize.height-1 || j < 0 || j > gridSize.width-1)
					continue; //Out of Bounds
				if(blocks[i][j].isEnabled())
					showBlock(blocks[i][j]);
			}
		}
	}
}
