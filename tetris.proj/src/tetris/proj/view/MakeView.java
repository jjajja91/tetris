package tetris.proj.view;

public class MakeView extends View {

	int[][] one = { { 1, 1 }, { 1, 1 } };
	int[][] two = { { 2, 2, 2, 2 } };
	int[][] three = { { 3, 0 }, { 3, 3 }, { 0, 3 } };
	int[][] four = { { 0, 4 }, { 4, 4 }, { 4, 0 } };
	int[][] five = { { 0, 5, 0 }, { 5, 5, 5 } };
	int[][] six = { { 6, 0 }, { 6, 0 }, { 6, 6 } };
	int[][] seven = { { 0, 7 }, { 0, 7 }, { 7, 7 } };
	int[][] two2 = { { 2 }, { 2 }, { 2 }, { 2 } };
	int[][] three2 = { { 0, 3, 3 }, { 3, 3, 0 } };
	int[][] four2 = { { 4, 4, 0 }, { 0, 4, 4 } };
	int[][] five2 = { { 5, 0 }, { 5, 5 }, { 5, 0 } };
	int[][] five3 = { { 5, 5, 5 }, { 0, 5, 0 } };
	int[][] five4 = { { 0, 5 }, { 5, 5 }, { 0, 5 } };
	int[][] six2 = { { 6, 6, 6 }, { 6, 0, 0 } };
	int[][] six3 = { { 6, 6 }, { 0, 6 }, { 0, 6 } };
	int[][] six4 = { { 0, 0, 6 }, { 6, 6, 6 } };
	int[][] seven2 = { { 7, 0, 0 }, { 7, 7, 7 } };
	int[][] seven3 = { { 7, 7 }, { 7, 0 }, { 7, 0 } };
	int[][] seven4 = { { 7, 7, 7 }, { 0, 0, 7 } };

	public MakeView(MyFrame frame) {
		super(frame);
	}

	public int[][] spinBlock() {
		switch (dMap.get("check")) {
		case 1:
			return one;
		case 2:
			switch (dMap.get("spin")) {
			case 1:
				return two2;
			case 2:
				return two;
			case 3:
				return two2;
			case 4:
				return two;
			}
		case 3:
			switch (dMap.get("spin")) {
			case 1:
				return three2;
			case 2:
				return three;
			case 3:
				return three2;
			case 4:
				return three;
			}
		case 4:
			switch (dMap.get("spin")) {
			case 1:
				return four2;
			case 2:
				return four;
			case 3:
				return four2;
			case 4:
				return four;
			}
		case 5:
			switch (dMap.get("spin")) {
			case 1:
				return five;
			case 2:
				return five2;
			case 3:
				return five3;
			case 4:
				return five4;
			}
		case 6:
			switch (dMap.get("spin")) {
			case 1:
				return six;
			case 2:
				return six2;
			case 3:
				return six3;
			case 4:
				return six4;
			}
		case 7:
			switch (dMap.get("spin")) {
			case 1:
				return seven;
			case 2:
				return seven2;
			case 3:
				return seven3;
			case 4:
				return seven4;
			}
		}
		return null;
	}

	public int[][] makeBlocks() {

		int randNum = (int) (Math.random() * 7) + 1;

		switch (randNum) {
		case 1:
			return one;
		case 2:
			return two;
		case 3:
			return three;
		case 4:
			return four;
		case 5:
			return five;
		case 6:
			return six;
		case 7:
			return seven;
		}
		return null;
	}

}
