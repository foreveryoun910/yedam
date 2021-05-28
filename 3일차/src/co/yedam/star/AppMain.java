package co.yedam.star;

public class AppMain {
	public static void main(String[] args) {
		
		StarApp star = new StarApp();
//		star.draw(7);
//		star.drawInvert(7);
//		
//		star.drawEq(11);
//		star.drawEqInvert(11);
		
		star.drawTitle("나무", 100);
		star.drawTree(1, 4);
		star.drawTree(2, 6);
		star.drawTree(4, 8);
	}
}
