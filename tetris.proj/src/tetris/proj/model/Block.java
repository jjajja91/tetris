package tetris.proj.model;

public class Block {

	int[][] nextBlock = new int[5][5];
	{
		for (int i = 0; i < nextBlock.length; i++) {
			for (int j = 0; j < nextBlock[i].length; j++) {
				nextBlock[i][j] = 0;
			}
		}
	}

	int[][] blocks = {
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,0,0,0,0,0,0,0,0,0,0,8},
		{8,8,8,8,8,8,8,8,8,8,8,8}
	};

	public int[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(int[][] blocks) {
		this.blocks = blocks;
	}

	public int[][] getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int[][] nextBlock) {
		this.nextBlock = nextBlock;
	}

}
