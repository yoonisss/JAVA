package Test;

	
	
	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;  
	  
	class QuizEx1 extends JFrame implements ActionListener  
	{  
		
		  

		
	    JLabel l;  
	    JRadioButton jb[]=new JRadioButton[10];  // 10개의 라디오 버튼 생성
	    JButton b1,b2;  
	    ButtonGroup bg;  
	    int count=0,current=0,x=1,y=1,now=0;  
	    int m[]=new int[10];                    //문제 10개
	    
	    QuizEx1(String s)  
	    {  
	        super(s);  
	        l=new JLabel();  
	        add(l);  
	        bg=new ButtonGroup();     // 버튼 그룹 생성
	        for(int i=0;i<5;i++)     // 버튼그룹에 라디오 버튼 붙이기
	        {  
	            jb[i]=new JRadioButton();     
	            add(jb[i]);  
	            bg.add(jb[i]);  
	        }  
	        b1=new JButton("다음");               // 다음 버튼
	        b2=new JButton("패스");               // 패스 버튼
	        b1.addActionListener(this);  
	        b2.addActionListener(this);  
	        add(b1); add(b2);  
	        set();  
	        l.setBounds(400,75,250,50);           // 문제번호 위치 (가로, 세로, 폭, 높이)
	        jb[0].setBounds(400,125,180,20);       // 보기 1번
	        jb[1].setBounds(400,145,180,20);      // 보기 2번
	        jb[2].setBounds(400,165,180,20);      // 보기 3번 
	        jb[3].setBounds(400,185,180,20);      // 보기 4번
	        b1.setBounds(190,380,100,30);        // 다음 버튼 위치
	        b2.setBounds(440,380,100,30);        // 패스 버튼 위치
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 프로그램 종료
	        setLayout(null);  
	        setLocation(250,100);    // 실행시 창 위치
	        setVisible(true);        // 화면 출력
	        setSize(800,600);        // 창 크기
	    }  
	    public void actionPerformed(ActionEvent e)  
	    {  
	        if(e.getSource()==b1)      // 다음 버튼이 클릭되면
	        {  
	            if(check())  
	                count=count+1;    // 문항번호 증가
	            current++;  
	            set();    
	            if(current==9)       // 마지막 문제면
	            {  
	                b1.setEnabled(false);  
	                b2.setText("결과");     // 패스버튼 결과버튼으로 바꿈
	            }  
	        }  
	        if(e.getActionCommand().equals("패스"))  
	        {  
	            JButton bk=new JButton("패스"+x);   // 패스+번호 생성
	            bk.setBounds(690,50+30*x,80,30);  // 패스+x버튼 위치
	            add(bk);  
	            bk.addActionListener(this);  
	            m[x]=current;  
	            x++;  
	            current++;  
	            set();    
	            if(current==9)  
	                b2.setText("결과");  
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
	            JOptionPane.showMessageDialog(this,"총 "+count+" 문제를 맞추셨습니다. ");   // 메시지 박스에 정답수 표시
	            System.exit(0);                                     // 프로그램 종료
	        }  
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
	    public static void main(String s[])  
	    {  
	        new QuizEx1("Quiz");  
	    }  
	}  


