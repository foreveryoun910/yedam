package co.board.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


/*
 * https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=dksl0991&logNo=221042506249
 */
public class testGUI extends JPanel {
	
	//----------변수선언----------
	JComboBox cbMenu, cbCustomer;	//콤보박스 메뉴, 고객
	JTextArea txtMaterial;	//메모
	JTextField txtPrice, txtPhone, txtAddress;	//가격, 연락처, 주소
	JButton btnOrder, btnClose;	//주문, 종료
	
	
	//----------생성자----------
	public testGUI() {
		design();
	}
	
	
	//----------주문정보 대화상자 화면 디자인 메서드----------
	public void design() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//주문정보 패널, JPanel을 customerPn으로 객체 생성
		JPanel customerPn = new JPanel(new GridLayout(4,2));
		
		//테두리 "주문"
		customerPn.setBorder(new TitledBorder(new TitledBorder("주문"), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.LEFT));
		
		JPanel pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pn4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//콤보박스(메뉴)
		String cbMenuArr[] = {"선택", "치킨", "피자", "중식", "한식"};
		cbMenu = new JComboBox(cbMenuArr);
		cbMenu.setPreferredSize(new Dimension(150, 20)); //콤보박스 사이즈 조절
		customerPn.add(cbMenu);
		
		//콤보박스(고객)
		String cbCustomerArr[] = {"", "윤두준", "양요섭", "이기광"};
		cbCustomer = new JComboBox(cbCustomerArr);
		cbCustomer.setPreferredSize(new Dimension(150, 20));
		customerPn.add(cbCustomer);
		
		//텍스트
		txtPrice = new JTextField("", 13);	//가격
		txtPhone = new JTextField("", 13);	//연락처
		txtAddress = new JTextField("", 32);	//주소
		txtMaterial = new JTextArea(2, 30);	//메모
		
		//메모에 스크롤바 기능 추가
		JScrollPane scroll = new JScrollPane(txtMaterial);
		txtMaterial.setBackground(Color.LIGHT_GRAY);
		
		//입력창 비활성화(메모 불가능 상태)
		txtPrice.setEditable(false);
		txtPhone.setEditable(false);
		txtAddress.setEditable(false);
		txtMaterial.setEditable(false);
		
//		txtPrice.setEditable(true);	//입력창 활성화
		
		pn1.add(new JLabel("메뉴: "));
		pn1.add(cbMenu);
		pn1.add(new JLabel(" 고객: "));
		pn1.add(cbCustomer);
		
		pn2.add(new JLabel("가격: "));
		pn2.add(txtPrice);
		pn2.add(new JLabel("연락처: "));
		pn2.add(txtPhone);
		
		pn3.add(new JLabel("주소: "));
		pn3.add(txtAddress);
		
		pn4.add(new JLabel("메모: "));
		pn4.add(scroll);
		
		
		//버튼(JButton)
		JPanel bottomPn1 = new JPanel();
		bottomPn1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnOrder = new JButton("주문");
		bottomPn1.add(btnOrder);
		btnClose = new JButton("종료");
		bottomPn1.add(btnClose);
		
		
		//화면상에 보여주도록
		customerPn.add(pn1);
		customerPn.add(pn2);
		customerPn.add(pn3);
		customerPn.add(pn4);
		this.add(customerPn);	//주문 테두리를 보여준다???
		this.add(bottomPn1);
	}
	
	
	
	
	
	public static void main(String[] args) {
		//----------화면(창)----------//
		testGUI bookCustomer = new testGUI();
		JFrame frame = new JFrame("주문");
		frame.getContentPane().add(bookCustomer);	//JFrame + JPanel(화면디자인)
		frame.setBounds(200, 300, 430, 450);	//x, y, w, h
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//x버튼 클릭시 종료
		
		//----------화면(끝)----------//
	}
	

}
