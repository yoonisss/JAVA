package Test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class QuizEx2 {

	
	



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
	    QuizEx2 window = new QuizEx2();
		window.frame.setVisible(true);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		});
		}


		public QuizEx2() {
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
		 JLabel l;  
		    JRadioButton jb[]=new JRadioButton[10];  // 10개의 라디오 버튼 생성
		    JButton btnPrev,btnNext;  
		    ButtonGroup bg;  
		    int count=0,current=0,x=1,y=1,now=0;  
		    int m[]=new int[10];                    //문제 10개
		    
		    QuizEx2(String s)  
		    {  
		        super();  
		        l=new JLabel();  
		        add(l);  
		        bg=new ButtonGroup();     // 버튼 그룹 생성
		        for(int i=0;i<5;i++)     // 버튼그룹에 라디오 버튼 붙이기
		        {  
		            jb[i]=new JRadioButton();     
		            add(jb[i]);  
		            bg.add(jb[i]);  
		        }  
		       
		        set();  
		        l.setBounds(400,75,250,50);           // 문제번호 위치 (가로, 세로, 폭, 높이)
		        jb[0].setBounds(400,125,180,20);       // 보기 1번
		        jb[1].setBounds(400,145,180,20);      // 보기 2번
		        jb[2].setBounds(400,165,180,20);      // 보기 3번 
		        jb[3].setBounds(400,185,180,20);      // 보기 4번
		        btnPrev.setBounds(190,380,100,30);        // 다음 버튼 위치
		        btnNext.setBounds(440,380,100,30);        // 패스 버튼 위치
	
		    }  
		    private void add(JLabel l2) {
				// TODO Auto-generated method stub
				
			}


			private void add(JRadioButton jb2) {
				// TODO Auto-generated method stub
				
			}


			public void actionPerformed(ActionEvent e)  
		    {  
		        if(e.getSource()==btnPrev)      // 다음 버튼이 클릭되면
		        {  
		            if(check())  
		                count=count+1;    // 문항번호 증가
		            current++;  
		            set();    
		            if(current==9)       // 마지막 문제면
		            {  
		            	btnPrev.setEnabled(false);  
		                btnNext.setText("결과");     // 패스버튼 결과버튼으로 바꿈
		            }  
		        }  
		        if(e.getActionCommand().equals("패스"))  
		        {  
		            JButton bk=new JButton("패스"+x);   // 패스+번호 생성
		            bk.setBounds(690,50+30*x,80,30);  // 패스+x버튼 위치
		            add(bk);  
		            bk.addActionListener((ActionListener) this);  
		            m[x]=current;  
		            x++;  
		            current++;  
		            set();    
		            if(current==9)  
		            	btnNext.setText("결과");  
		            setVisible(false);  
		            setVisible(true);  
		        }  
		        for(int i=0,y=1;i<x;i++,y++)  
		        {  
		        if(e.getActionCommand().equals("패스"+y))  // 패스 버튼이 눌리면
		        {  
		            if(check())  
		                count=count+1;  
		            now=current;                        // 문항 번호 수정
		            current=m[y];  
		            set();  
		            ((JButton)e.getSource()).setEnabled(false);   //눌려진 패스버튼 클릭불가로 수정 
		            current=now;  
		        }  
		        }  
		      
		        if(e.getActionCommand().equals("결과"))  // 결과버튼이 눌리면
		        {  
		            if(check())  
		                count=count+1;  
		            current++;  
		            JOptionPane.showMessageDialog(btnPrev, this,"총 "+count+" 문제를 맞추셨습니다. ", count);   // 메시지 박스에 정답수 표시
		            System.exit(0);                                     // 프로그램 종료
		        }  
		    }  
		    private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}


			private void add(JButton bk) {
				// TODO Auto-generated method stub
				
			}


			void set()                                                  // 문제보이기 함수
		    {   
		        jb[4].setSelected(true);                              // 보이지 않는 버튼에 체크
		        
		        if(current==0)  
		        {  
		        	l.setText("1. 다음 동물의 이름으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① 표범");
		            jb[1].setText("② 고양이");
		            jb[2].setText("③ 스라소니");
		            jb[3].setText("④ 여우");   
		            
		        }  
		        if(current==1)  
		        {  
		        	l.setText("2. 다음 동물의 학명으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① Vulpes vulpes peculiosa");
		            jb[1].setText("② Lynx lynx");
		            jb[2].setText("③ Lutra lutra");
		            jb[3].setText("④ Eremias argus"); 
		        }  
		        if(current==2)  
		        {  
		        	l.setText("3. 다음 동물이 속하는 과를 고르세요. ");  
		            jb[0].setText("① 개과");
		            jb[1].setText("② 고양이과");
		            jb[2].setText("③ 족제비과");
		            jb[3].setText("④ 오리과 "); 
		        }  
		        if(current==3)  
		        {  
		        	l.setText("4. 다음 동물의 설명으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① 멸종위기 야생 생물 1급");
		            jb[1].setText("② 멸종위기 야생 생물 2급");
		            jb[2].setText("③ 국가적색목록 위기");
		            jb[3].setText("④ 관계없음"); 
		        }  
		        if(current==4)  
		        {  
		        	l.setText("5. 다음 동물이 속하는 과를 고르세요. ");  
		            jb[0].setText("① 개과");
		            jb[1].setText("② 고양이과");
		            jb[2].setText("③ 족제비과");
		            jb[3].setText("④ 오리과 "); 
		        }  
		        
		        if(current==5)  
		        {  
		        	l.setText("6. 다음 동물의 이름으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① 수달");
		            jb[1].setText("② 개리");
		            jb[2].setText("③ 붉은 해오라기");
		            jb[3].setText("④ 저어새");   
		        }  
		        
		        
		        if(current==6)  
		        {  
		        	l.setText("7. 다음 동물의 학명으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① Anser cygnoides");
		            jb[1].setText("② Platalea minor");
		            jb[2].setText("③ Kaloula borealis");
		            jb[3].setText("④ Gorsachius goisagi"); 
		        	
		        	
		        }
		        
		        
		        if(current==7)  
		        {  
		        	l.setText("8. 다음 동물의 설명으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① 멸종위기 야생 생물 1급");
		            jb[1].setText("② 멸종위기 야생 생물 2급");
		            jb[2].setText("③ 국가적색목록 취약");
		            jb[3].setText("④ 관계없음");
		        }  
		        
		        
		        if(current==8)  
		        {  
		        	l.setText("9. 다음 동물의 이름으로 옳은 것을 고르세요. ");  
		            jb[0].setText("① 금개구리");
		            jb[1].setText("② 수원청개구리");
		            jb[2].setText("③ 표범장지뱀");
		            jb[3].setText("④ 맹꽁이");     
		        }  
		        
		        
		        
		        if(current==9)  
		        {  
		        	l.setText("10. 다음 동물이 속하는 과를 고르세요. ");  
		            jb[0].setText("① 뱀과");
		            jb[1].setText("② 도롱뇽과");
		            jb[2].setText("③ 장지뱀과");
		            jb[3].setText("④ 개구리과");   
					 
		        }  
		        
		        
		     
		        
		        l.setBounds(400,75,250,50);           //  다음 문제 생성
		        for(int i=0,j=0;i<=90;i+=30,j++)  
		            jb[j].setBounds(400,125+i,200,20);
		    }
		        
		    boolean check()         //정답 체크 함수
		    {  
		        if(current==0)                         // 문제 번호
		            return(jb[2].isSelected());       // 정답 번호 jb[0]-1, jb[1]-2, jb[2]-3, jb[3]- 4
		        if(current==1)  
		            return(jb[0].isSelected());  
		        if(current==2)  
		            return(jb[1].isSelected());  
		        if(current==3)  
		            return(jb[1].isSelected());  
		        if(current==4)  
		            return(jb[2].isSelected());  
		        if(current==5)                         
		            return(jb[3].isSelected());       
		        if(current==6)  
		            return(jb[0].isSelected());  
		        if(current==7)  
		            return(jb[1].isSelected());  
		        if(current==8)  
		            return(jb[3].isSelected());  
		        if(current==9)  
		            return(jb[2].isSelected());  
		        return false;  
		    }  
		    public static void main1(String s[])  
		    {  
		        new QuizEx2();  
		    }  
		}  
	
	


