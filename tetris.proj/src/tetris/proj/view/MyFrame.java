package tetris.proj.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel contentPane = null;
	JPanel contentPane2 = null;
	JPanel tetrisPane;
	JPanel nextPane;
	JPanel nextPane2;
	JPanel infoPane;
	JPanel titlePane;
	JPanel titlePane2;
	JPanel btnPane;

	JPanel idPane = new JPanel(new FlowLayout());
	JPanel recordPane = new JPanel(new FlowLayout());
	JPanel bestPane = new JPanel(new FlowLayout());
	JPanel currentPane = new JPanel(new FlowLayout());

	JButton[][] btns = new JButton[20][10];
	JButton[][] nextBtns = new JButton[5][5];

	JLabel titleLabel = new JLabel("TETRIS");
	JLabel nextLabel = new JLabel("NEXT");
	JLabel infoLabel = new JLabel("INFO");
	JLabel idLabel = new JLabel("ID: ");
	JLabel recordLabel = new JLabel("RECORD: ");
	JLabel bestLabel = new JLabel("MY BEST: ");
	JLabel currentLabel = new JLabel("CURRENT: ");
	JLabel currentLab = new JLabel("0");

	JLabel t = new JLabel("T");
	JLabel e = new JLabel("E");
	JLabel t2 = new JLabel("T");
	JLabel r = new JLabel("R");
	JLabel i = new JLabel("I");
	JLabel s = new JLabel("S");

	JButton startBtn = new JButton("시작");
	JButton exitBtn = new JButton("종료");
	JButton moveBtn = new JButton();
	JButton signBtn = new JButton("회원가입");
	JButton logInBtn = new JButton("로그인");

	public void playTetris() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane2.setVisible(false);
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);

		moveBtn.setVisible(true);

		tetrisPane = new JPanel(new GridLayout(20, 10, 0, 0));

		for (int i = 0; i < btns.length; i++) {
			for (int j = 0; j < btns[i].length; j++) {
				btns[i][j] = new JButton("");
				tetrisPane.add(btns[i][j]);
				btns[i][j].setVisible(false);
			}
		}

		btns[0][3].setBackground(Color.PINK);
		btns[0][3].setVisible(true);
		btns[0][4].setBackground(Color.PINK);
		btns[0][4].setVisible(true);
		btns[0][5].setBackground(Color.PINK);
		btns[0][5].setVisible(true);
		btns[0][6].setBackground(Color.PINK);
		btns[0][6].setVisible(true);

		tetrisPane.setBounds(100, 120, 300, 600);
		LineBorder tetrisLine = new LineBorder(Color.GRAY, 5);
		tetrisPane.setBorder(tetrisLine);

		titleLabel.setFont(new Font("나눔고딕", Font.BOLD, 50));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlePane = new JPanel();
		titlePane.add(titleLabel);
		titlePane.setBounds(350, 0, 200, 100);

		nextPane = new JPanel(new BorderLayout());
		nextPane2 = new JPanel(new GridLayout(5, 5, 0, 0));

		for (int i = 0; i < nextBtns.length; i++) {
			for (int j = 0; j < nextBtns[i].length; j++) {
				nextBtns[i][j] = new JButton("");
				nextPane2.add(nextBtns[i][j]);
				nextBtns[i][j].setVisible(false);
			}
		}

		nextBtns[1][1].setBackground(Color.ORANGE);
		nextBtns[1][1].setVisible(true);
		nextBtns[1][2].setBackground(Color.ORANGE);
		nextBtns[1][2].setVisible(true);
		nextBtns[2][1].setBackground(Color.ORANGE);
		nextBtns[2][1].setVisible(true);
		nextBtns[2][2].setBackground(Color.ORANGE);
		nextBtns[2][2].setVisible(true);

		nextLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
		nextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nextPane.add(nextLabel, "North");
		nextPane.add(nextPane2);
		nextPane.setBounds(550, 120, 120, 140);
		LineBorder nextLine = new LineBorder(Color.GRAY, 5);
		nextPane.setBorder(nextLine);

		infoPane = new JPanel(new GridLayout(5, 1, 0, 0));

		infoLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("나눔고딕", Font.BOLD, 14));
		recordLabel.setFont(new Font("나눔고딕", Font.BOLD, 14));
		bestLabel.setFont(new Font("나눔고딕", Font.BOLD, 14));
		currentLabel.setFont(new Font("나눔고딕", Font.BOLD, 14));

		idPane.add(idLabel);
		recordPane.add(recordLabel);
		bestPane.add(bestLabel);
		currentPane.add(currentLabel);
		currentLab.setFont(new Font("나눔고딕", Font.BOLD, 14));
		currentPane.add(currentLab);

		infoPane.add(infoLabel);
		infoPane.add(idPane);
		infoPane.add(recordPane);
		infoPane.add(bestPane);
		infoPane.add(currentPane);
		infoPane.setBounds(510, 420, 200, 300);
		LineBorder infoLine = new LineBorder(Color.GRAY, 5);
		infoPane.setBorder(infoLine);

		btnPane = new JPanel(new FlowLayout());
		startBtn.setBackground(Color.LIGHT_GRAY);
		startBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		exitBtn.setBackground(Color.LIGHT_GRAY);
		exitBtn.setFont(new Font("나눔고딕", Font.BOLD, 20));
		btnPane.add(startBtn);
		btnPane.add(exitBtn);
		btnPane.setBounds(350, 800, 200, 200);

		contentPane.add(titlePane);
		contentPane.add(tetrisPane);
		contentPane.add(nextPane);
		contentPane.add(infoPane);
		contentPane.add(btnPane);
		contentPane.add(moveBtn);
		setSize(900, 900);

		setVisible(true);
	}

	public MyFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane2 = new JPanel();
		contentPane2.setLayout(null);
		contentPane2.setSize(900, 900);

		signBtn.setBackground(Color.LIGHT_GRAY);
		signBtn.setFont(new Font("나눔고딕", Font.BOLD, 40));
		logInBtn.setBackground(Color.LIGHT_GRAY);
		logInBtn.setFont(new Font("나눔고딕", Font.BOLD, 40));
		signBtn.setBounds(350, 500, 200, 100);
		logInBtn.setBounds(350, 650, 200, 100);

		titlePane2 = new JPanel(new FlowLayout());
		t.setFont(new Font("나눔고딕", Font.BOLD, 150));
		t.setForeground(Color.RED);
		e.setFont(new Font("나눔고딕", Font.BOLD, 150));
		e.setForeground(Color.ORANGE);
		t2.setFont(new Font("나눔고딕", Font.BOLD, 150));
		t2.setForeground(Color.YELLOW);
		r.setFont(new Font("나눔고딕", Font.BOLD, 150));
		r.setForeground(Color.GREEN);
		i.setFont(new Font("나눔고딕", Font.BOLD, 150));
		i.setForeground(Color.CYAN);
		s.setFont(new Font("나눔고딕", Font.BOLD, 150));
		s.setForeground(Color.BLUE);
		titlePane2.add(t);
		titlePane2.add(e);
		titlePane2.add(t2);
		titlePane2.add(r);
		titlePane2.add(i);
		titlePane2.add(s);
		titlePane2.setBounds(200, 170, 500, 170);
		titlePane2.setBackground(Color.BLACK);

		contentPane2.setBackground(Color.BLACK);
		contentPane2.add(titlePane2);
		contentPane2.add(signBtn);
		contentPane2.add(logInBtn);
		add(contentPane2);
		setSize(900, 900);

		setVisible(true);

	}

}
