package exam01;

import java.util.ArrayList;

public class Q4 {

	public static void main(String[] args) {
		String[] arr = {"010102-2", "991012-1", "960304-1", "881012-2",
				"040403-1"};
		
		ArrayList<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i].substring(0, 2);
			if (temp.charAt(0) != '0') {
				temp = "19" + temp;
				int age = 2021 - (Integer.parseInt(temp));
				li.add(age);
			} else {
				temp = "20" + temp;
				int age = 2021 - (Integer.parseInt(temp));
				li.add(age);
			}
		}
//		System.out.println(li);
		int teen = 0;
		int twenty = 0;
		int thrity = 0;
		int fourty = 0;

		int male=0;
		int female=0;
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i].substring(7, 8);
			if (temp.charAt(0) == '1') {
				male++;
			} else if(temp.charAt(0) == '2') {
				female++;
			}
		}
		
		for (int i = 0; i < li.size(); i++) {
			if (li.get(i) >= 40) {
				fourty++;
			} else if (li.get(i) >= 30) {
				thrity++;
			} else if (li.get(i) >= 20) {
				twenty++;
			} else {
				teen++;
			}
		}	
		System.out.println("남 " + male+"  "+"여 "+female);
		System.out.println("10대 " + teen+"명");
		System.out.println("20대 "+twenty+"명");
		System.out.println("30대 "+thrity+"명");
		System.out.println("40대 "+fourty+"명");
	}

}
