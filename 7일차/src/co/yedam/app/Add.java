package co.yedam.app;

public class Add {

	public static void main(String[] args) {

		String data1 = null;
		String data2 = null;

		try {
			data1 = args[0];
			data2 = args[1];

			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			System.out.println(value1 / value2);

		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자를 2개 입력하세요.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} //다중catch: try 한 덩어리에 catch 여러 개 넣을 수 있다.
	}

}
