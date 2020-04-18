package tetris.proj.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import tetris.proj.model.Block;
import tetris.proj.resource.R;

public class View implements ActionListener, R {

	MyFrame frame;
	Block block;
	int[][] newBlock;
	int[][] originBlock;
	int[][] nextBlock;
	int[][] originNext;
	TetrisThread thread = null;
	int removeRow;
	int removeStartRow;
	int currentScore;

	public View(MyFrame frame) {
		this.frame = frame;
		addEvent();
		block = new Block();
	}

	public boolean gameOver() {
		originBlock = block.getBlocks();
		for (int i = 1; i < originBlock[0].length - 1; i++) {
			if (originBlock[0][i] == 8) {
				return true;
			}
		}
		return false;
	}

	public void space() {
		originBlock = block.getBlocks();
		for (int i = 0; i < originBlock.length; i++) {
			for (int j = 0; j < originBlock[i].length; j++) {
				if (originBlock[i][j] != 8) {
					originBlock[i][j] = 0;
				}
			}
		}
		for (int k = 0; k < originBlock.length; k++) {
			for (int i = 0; i < newBlock.length; i++) {
				for (int j = 0; j < newBlock[i].length; j++) {
					if (originBlock[k + i][dMap.get("column") + j] == 8 && newBlock[i][j] != 0) {
						dMap.put("row", k - 1);
						return;
					}
				}
			}
		}
	}

	public void remove() {
		removeRow = 0;
		originBlock = block.getBlocks();
		for (int i = 0; i < originBlock.length - 1; i++) {
			if (originBlock[i][1] == 8 && originBlock[i][2] == 8 && originBlock[i][3] == 8 && originBlock[i][4] == 8
					&& originBlock[i][5] == 8 && originBlock[i][6] == 8 && originBlock[i][7] == 8
					&& originBlock[i][8] == 8 && originBlock[i][9] == 8 && originBlock[i][10] == 8) {
				originBlock[i][1] = 0;
				originBlock[i][2] = 0;
				originBlock[i][3] = 0;
				originBlock[i][4] = 0;
				originBlock[i][5] = 0;
				originBlock[i][6] = 0;
				originBlock[i][7] = 0;
				originBlock[i][8] = 0;
				originBlock[i][9] = 0;
				originBlock[i][10] = 0;
				removeRow++;
				removeStartRow = i;
			}
		}
		for (int i = removeStartRow; i > removeRow; i--) {
			for (int j = 1; j < originBlock[i].length - 1; j++) {
				originBlock[i][j] = originBlock[i - removeRow][j];
			}
		}
		for (int i = 0; i < removeRow; i++) {
			for (int j = 1; j < originBlock[i].length - 1; j++) {
				originBlock[i][j] = 0;
			}
		}
		currentScore += removeRow * 100;
		block.setBlocks(originBlock);
		frame.currentLab.setText(currentScore + "");
		new CheckView(frame).checkBlocks(block);
	}

	public void repaint() {
		originBlock = block.getBlocks();
		for (int i = 0; i < originBlock.length; i++) {
			for (int j = 0; j < originBlock[i].length; j++) {
				if (originBlock[i][j] != 8) {
					originBlock[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < newBlock.length; i++) {
			for (int j = 0; j < newBlock[i].length; j++) {
				if (originBlock[dMap.get("row") + i][dMap.get("column") + j] != 8) {
					originBlock[dMap.get("row") + i][dMap.get("column") + j] = newBlock[i][j];
				}
			}
		}
		block.setBlocks(originBlock);
		new CheckView(frame).checkBlocks(block);
	}

	public boolean checkPoint() {
		originBlock = block.getBlocks();
		for (int i = 0; i < originBlock.length; i++) {
			for (int j = 0; j < originBlock[i].length; j++) {
				if (originBlock[i][j] != 8) {
					originBlock[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < newBlock.length; i++) {
			for (int j = 0; j < newBlock[i].length; j++) {
				if (originBlock[dMap.get("row") + i][dMap.get("column") + j] == 8 && newBlock[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void repaint2() {

		originBlock = block.getBlocks();
		for (int i = 0; i < originBlock.length; i++) {
			for (int j = 0; j < originBlock[i].length; j++) {
				if (originBlock[i][j] != 8) {
					originBlock[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < newBlock.length; i++) {
			for (int j = 0; j < newBlock[i].length; j++) {
				if (originBlock[dMap.get("row") + i][dMap.get("column") + j] != 8) {
					originBlock[dMap.get("row") + i][dMap.get("column") + j] = newBlock[i][j] == 0 ? 0 : 8;
				}
			}
		}
		block.setBlocks(originBlock);
		new CheckView(frame).checkBlocks(block);
		remove();
		if (gameOver()) {
		} else {
			start();
		}
	}

	public void start() {
		dMap.put("column", 4);
		dMap.put("row", 0);
		dMap.put("spin", 0);
		new CheckView(frame).checkBlocks(block);
		newBlock = nextBlock;
		nextBlock = new MakeView(frame).makeBlocks();
		originNext = block.getNextBlock();
		originBlock = block.getBlocks();
		for (int i = 0; i < newBlock.length; i++) {
			for (int j = 0; j < newBlock[i].length; j++) {
				originBlock[dMap.get("row") + i][dMap.get("column") + j] = newBlock[i][j];
				if (newBlock[i][j] != 0) {
					dMap.put("check", newBlock[i][j]);
				}
			}
		}
		block.setBlocks(originBlock);
		for (int i = 0; i < originNext.length; i++) {
			for (int j = 0; j < originNext[i].length; j++) {
				originNext[i][j] = 0;
			}
		}
		for (int i = 0; i < nextBlock.length; i++) {
			for (int j = 0; j < nextBlock[i].length; j++) {
				originNext[1 + i][1 + j] = nextBlock[i][j];
			}
		}
		block.setNextBlock(originNext);
		new CheckView(frame).checkBlocks(block);
		thread = new TetrisThread();
		thread.start();
	}

	public void addEvent() {

		frame.startBtn.addActionListener(this);
		frame.exitBtn.addActionListener(this);
		frame.logInBtn.addActionListener(this);
	}

	public void reset() {
		int[][] blocks = { { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 } };
		block.setBlocks(blocks);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == frame.signBtn) {
			// 컨트롤러에 보내서 dao에서 확인하고 생성
		} else if (e.getSource() == frame.logInBtn) {
			String id = JOptionPane.showInputDialog("아이디를 입력하세요");
			String password = JOptionPane.showInputDialog("비밀번호를 입력하세요");
			// 컨트롤러에 보내서 dao에서 확인
			frame.playTetris();
			JLabel idLab = new JLabel("" + id);
			idLab.setFont(new Font("나눔고딕", Font.BOLD, 14));
			frame.idPane.add(idLab);
		} else if (e.getSource() == frame.startBtn) {
			reset();
			newBlock = new MakeView(frame).makeBlocks();
			nextBlock = new MakeView(frame).makeBlocks();
			start();

			frame.moveBtn.requestFocus();
			frame.moveBtn.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						if (!gameOver()) {
							dMap.put("column", dMap.get("column") - 1);
							if (checkPoint()) {
								repaint();
							} else {
								dMap.put("column", dMap.get("column") + 1);
							}
						}
						break;
					case KeyEvent.VK_RIGHT:
						if (!gameOver()) {
							dMap.put("column", dMap.get("column") + 1);
							if (checkPoint()) {
								repaint();
							} else {
								dMap.put("column", dMap.get("column") - 1);
							}
						}
						break;
					case KeyEvent.VK_UP:
						if (!gameOver()) {
							dMap.put("spin", dMap.get("spin") + 1);
							newBlock = new MakeView(frame).spinBlock();
							if (dMap.get("spin") == 4) {
								dMap.put("spin", 0);
							}
						}
						break;
					case KeyEvent.VK_SPACE:
						if (!gameOver()) {
							space();
							repaint2();
						}

					}
				}
			});

		} else if (e.getSource() == frame.exitBtn) {
			System.exit(0);
		}

	}

	class TetrisThread extends Thread {

		public void run() {
			while (true) {
				try {
					sleep(1000);
					dMap.put("row", dMap.get("row") + 1);
					if (checkPoint()) {
						repaint();
					} else {
						dMap.put("row", dMap.get("row") - 1);
						repaint2();
						break;
					}
				} catch (InterruptedException e) {
					return;
				}

			}
		}
	}

}