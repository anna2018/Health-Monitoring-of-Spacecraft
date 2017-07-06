
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
public class Mainframe extends JFrame {
	private static final int DEFAULT_WIDTH = 700;
	private static final int DEFAULT_HEIGTH = 500;
	JDesktopPane desktop = new JDesktopPane();
	private JMenuBar menuBar;
	private JMenu startMenu;
	private JMenu DetectionMenu;
	private JMenu PredictionMenu;
	static String managerNo;
	
	private JToolBar toolBar;
	Font font=new Font("΢���ź�",2,15);//��������
	public Mainframe(String user) {
		startMenu = new JMenu("��ʼ");
		startMenu.setFont(font);
		startMenu.setForeground(Color.black);//���ñ�����ɫ
		DetectionMenu = new JMenu("�쳣��ѯ");
		DetectionMenu.setFont(font);
		DetectionMenu.setForeground(Color.black);//���ñ�����ɫ
		PredictionMenu = new JMenu("ʵʱԤ��");
		PredictionMenu.setFont(font);
		PredictionMenu.setForeground(Color.black);//���ñ�����ɫ
		menuBar = new JMenuBar();		
		toolBar = new JToolBar();	
        setTitle("�����쳣ʵʱ�����Ԥ��ϵͳ");
        add(desktop, BorderLayout.CENTER);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGTH);
		setLocation(50, 50);
		addMenu();
		loadBackgroundImage();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    managerNo=user;
	}
	private void addMenu(){	
		setJMenuBar(menuBar);
//		JMenuItem registerItem = new JMenuItem("����Ա��¼");
//		registerItem.setFont(font);
//		registerItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem startItem = new JMenuItem("����ϵͳ");
		startItem.setFont(font);
		startItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem closeItem = new JMenuItem("�ر�ϵͳ");
		closeItem.setFont(font);
		closeItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem newItem = new JMenuItem("��ʼ��ϵͳ");
		newItem.setFont(font);
		newItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem exitItem = new JMenuItem("�˳�ϵͳ");
		exitItem.setFont(font);
		exitItem.setForeground(Color.black);//���ñ�����ɫ
//		startMenu.add(registerItem);
		startMenu.add(startItem);
		startMenu.add(closeItem);
		startMenu.add(newItem);
		startMenu.add(exitItem);		
		menuBar.add(startMenu);
		
		JMenuItem detectionCurveItem = new JMenuItem("ʵʱ�쳣�÷�������ʾ");
		detectionCurveItem.setFont(font);
		detectionCurveItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem historyDetectionItem = new JMenuItem("��ʷ�쳣�÷ֲ�ѯ");
		historyDetectionItem.setFont(font);
		historyDetectionItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem detectionTimeItem = new JMenuItem("�쳣ʱ���ѯ");
		detectionTimeItem.setFont(font);
		detectionTimeItem.setForeground(Color.black);//���ñ�����ɫ
		DetectionMenu.add(detectionCurveItem);
		DetectionMenu.add(historyDetectionItem);
		DetectionMenu.add(detectionTimeItem);
		menuBar.add(DetectionMenu);

		
		JMenuItem predictionCurveItem = new JMenuItem("ʵʱԤ��ֵ������ʾ");
		predictionCurveItem.setFont(font);
		predictionCurveItem.setForeground(Color.black);//���ñ�����ɫ
		JMenuItem predictionValueItem = new JMenuItem("Ԥ��ֵ��ѯ");
		predictionValueItem.setFont(font);
		predictionValueItem.setForeground(Color.black);//���ñ�����ɫ
		PredictionMenu.add(predictionCurveItem);
		PredictionMenu.add(predictionValueItem);
		menuBar.add(PredictionMenu);
		
		
		
//		registerItem.addActionListener(myAction);
//		startItem.addActionListener(myAction);
//		closeItem.addActionListener(myAction);
//		newItem.addActionListener(myAction);
//		chPasswordItem.addActionListener(myAction);
//		exitItem.addActionListener(myAction);
//		
//		detectionCurveItem.addActionListener(myAction);
//		historyDetectionItem.addActionListener(myAction);
//		detectionTimeItem.addActionListener(myAction);
//		hotelSearch.addActionListener(myAction);
//		hotelSearchItem1.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				HotelSearch1 hotel = new HotelSearch1();
//				hotel.setLocation(100,100);
//			}        	
//        });
//		hotelSearchItem2.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				HotelSearch hotel = new HotelSearch();
//				hotel.setLocation(100,100);
//			}        	
//        });
//		guestStorageItem.addActionListener(myAction);
//		guestEditItem.addActionListener(myAction);
//		guestcloseItem.addActionListener(myAction);
//		guestSearch.addActionListener(myAction);
//		guestSearchItem1.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				GuestSearch1 guest = new GuestSearch1();
//				guest.setLocation(100,100);
//			}        	
//        });
//		guestSearchItem2.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				GuestSearch guest = new GuestSearch();
//				guest.setLocation(100,100);
//			}        	
//        });
//		predictionCurveItem.addActionListener(myAction);
//		predictionValueItem.addActionListener(myAction);
//		roomcloseItem.addActionListener(myAction);
//		roomSearch.addActionListener(myAction);
//		roomSearchItem1.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				RoomSearch1 room = new RoomSearch1();
//				room.setLocation(100,100);
//			}        	
//        });
//		roomSearchItem2.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				RoomSearch room = new RoomSearch();
//				room.setLocation(100,100);
//			}        	
//        });
//		typeStorageItem.addActionListener(myAction);
//		typeEditItem.addActionListener(myAction);
//		typecloseItem.addActionListener(myAction);
//		bookingStorageItem.addActionListener(myAction);
//		bookingEditItem.addActionListener(myAction);
//		bookingcloseItem.addActionListener(myAction);
//		bookingSearch.addActionListener(myAction);	
//		bookingSearchItem1.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				BookingSearch1 booking = new BookingSearch1();
//				booking.setLocation(100,100);
//			}        	
//        });
//		bookingSearchItem2.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				BookingSearch booking = new BookingSearch();
//				booking.setLocation(100,100);
//			}        	
//        });
//		orderStorageItem.addActionListener(myAction);
//		orderEditItem.addActionListener(myAction);
//		ordercloseItem.addActionListener(myAction);
//		orderSearch.addActionListener(myAction);	
//		orderSearchItem1.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				OrderSearch1 order = new OrderSearch1();
//				order.setLocation(100,100);
//			}        	
//        });
//		orderSearchItem2.addActionListener(new AbstractAction() {
//			public void actionPerformed(ActionEvent arg0) {
//				OrderSearch order = new OrderSearch();
//				order.setLocation(100,100);
//			}        	
//        });
	}
	protected void loadBackgroundImage(){
        ImageIcon icon = new ImageIcon(".\\images\\background.jpg");
        JLabel desk = new JLabel(icon);
        desk.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
        desktop.add(desk,new Integer(Integer.MIN_VALUE));
	}
	public static void main(String[] args) {
		Mainframe frame = new Mainframe("aaa");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.show();
    }
}

