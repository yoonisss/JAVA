package Test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiztest {



		private JFrame frame;

		private int index; // 현재 인덱스 저장용
		private static final String[] IMAGES = { // 이미지 경로 문자열로 저장
				"src/img/img1.jpg",
				"src/img/img2.jpg",
				"src/img/img3.jpg",
				"src/img/img4.jpg",
				"src/img/img5.jpg",
				"src/img/img6.jpg",
				"src/img/img7.jpg",
				"src/img/img8.jpg",
				"src/img/img9.jpg",
				"src/img/img10.jpg"
		};

		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
		Quiztest window = new Quiztest();
		window.frame.setVisible(true);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		});
		}


		public Quiztest() {
		initialize();
		}




		private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Font font = new Font("굴림", Font.BOLD, 30);

		JLabel lblImage = new JLabel();
		lblImage.setBounds(50, 50, 300, 300);

		lblImage.setIcon(new ImageIcon(IMAGES[index]));
		frame.getContentPane().add(lblImage);

		JButton btnPrev = new JButton("다음");
		btnPrev.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
		if(index > 0) {                                    // 현재 인덱스가 0보다 크면
		index--;                                           // 인덱스를 감소
		}else {                                            // 현재 인덱스가 0이면
		index = IMAGES.length -1;                          // 배열의 가장 큰 인덱스 번호로 변경
		}
		lblImage.setIcon(new ImageIcon(IMAGES[index]));  // 버튼 누를때마다 다음 이미지로 이동
		}
		});
		btnPrev.setFont(font);
		btnPrev.setBounds(190, 380, 120, 50);
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton("패스");
		btnNext.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
		if(index < IMAGES.length -1) {                    // 마지막 인덱스보다 작은 경우
		index++;                                          // 인덱스 증가
		}else {                                           // 현 인덱스가 문자열의 길이가 -1이 되는 경우
		index = 0;                                        // 인덱스를 0으로 초기화(0번으로 변경)
		}
		lblImage.setIcon(new ImageIcon(IMAGES[index]));
				
		}
		});
		btnNext.setFont(font);
		btnNext.setBounds(440, 380, 120, 50); //패스 버튼 위치
		frame.getContentPane().add(btnNext);
		}
	
	
	}
