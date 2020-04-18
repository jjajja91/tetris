package tetris.proj.view;

import java.awt.Color;

import tetris.proj.model.Block;

public class CheckView extends View {

	public CheckView(MyFrame frame) {
		super(frame);
	}

	public void checkBlocks(Block block) {

		for (int i = 0; i < block.getBlocks().length - 1; i++) {
			for (int j = 1; j < block.getBlocks()[i].length - 1; j++) {
				switch (block.getBlocks()[i][j]) {
				case 0:
					frame.btns[i][j - 1].setVisible(false);
					break;
				case 1:
					frame.btns[i][j - 1].setBackground(Color.ORANGE);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 2:
					frame.btns[i][j - 1].setBackground(Color.PINK);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 3:
					frame.btns[i][j - 1].setBackground(Color.BLUE);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 4:
					frame.btns[i][j - 1].setBackground(Color.RED);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 5:
					frame.btns[i][j - 1].setBackground(Color.GREEN);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 6:
					frame.btns[i][j - 1].setBackground(Color.YELLOW);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 7:
					frame.btns[i][j - 1].setBackground(Color.CYAN);
					frame.btns[i][j - 1].setVisible(true);
					break;
				case 8:
					frame.btns[i][j - 1].setBackground(Color.LIGHT_GRAY);
					frame.btns[i][j - 1].setVisible(true);
					break;
				}
			}
		}

		for (int i = 0; i < block.getNextBlock().length; i++) {
			for (int j = 0; j < block.getNextBlock()[i].length; j++) {
				switch (block.getNextBlock()[i][j]) {
				case 0:
					frame.nextBtns[i][j].setVisible(false);
					break;
				case 1:
					frame.nextBtns[i][j].setBackground(Color.ORANGE);
					frame.nextBtns[i][j].setVisible(true);
					break;
				case 2:
					frame.nextBtns[i][j].setBackground(Color.PINK);
					frame.nextBtns[i][j].setVisible(true);
					break;
				case 3:
					frame.nextBtns[i][j].setBackground(Color.BLUE);
					frame.nextBtns[i][j].setVisible(true);
					break;
				case 4:
					frame.nextBtns[i][j].setBackground(Color.RED);
					frame.nextBtns[i][j].setVisible(true);
					break;
				case 5:
					frame.nextBtns[i][j].setBackground(Color.GREEN);
					frame.nextBtns[i][j].setVisible(true);
					break;
				case 6:
					frame.nextBtns[i][j].setBackground(Color.YELLOW);
					frame.nextBtns[i][j].setVisible(true);
					break;
				case 7:
					frame.nextBtns[i][j].setBackground(Color.CYAN);
					frame.nextBtns[i][j].setVisible(true);
					break;
				}
			}
		}
	}
}
