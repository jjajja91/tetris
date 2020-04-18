package tetris.proj;

import tetris.proj.view.MyFrame;
import tetris.proj.view.View;

public class Controller {

	public void play() {
		
		MyFrame frame = new MyFrame();
		new View(frame);

	}

}
