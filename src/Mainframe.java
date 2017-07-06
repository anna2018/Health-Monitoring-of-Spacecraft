
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
	Font font=new Font("微软雅黑",2,15);//设置字体
	public Mainframe(String user) {
		startMenu = new JMenu("开始");
		startMenu.setFont(font);
		startMenu.setForeground(Color.black);//设置背景颜色
		DetectionMenu = new JMenu("异常查询");
		DetectionMenu.setFont(font);
		DetectionMenu.setForeground(Color.black);//设置背景颜色
		PredictionMenu = new JMenu("实时预测");
		PredictionMenu.setFont(font);
		PredictionMenu.setForeground(Color.black);//设置背景颜色
		menuBar = new JMenuBar();		
		toolBar = new JToolBar();	
        setTitle("卫星异常实时检测与预测系统");
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
//		JMenuItem registerItem = new JMenuItem("管理员登录");
//		registerItem.setFont(font);
//		registerItem.setForeground(Color.black);//设置背景颜色
		JMenuItem startItem = new JMenuItem("开启系统");
		startItem.setFont(font);
		startItem.setForeground(Color.black);//设置背景颜色
		JMenuItem closeItem = new JMenuItem("关闭系统");
		closeItem.setFont(font);
		closeItem.setForeground(Color.black);//设置背景颜色
		JMenuItem newItem = new JMenuItem("初始化系统");
		newItem.setFont(font);
		newItem.setForeground(Color.black);//设置背景颜色
		JMenuItem exitItem = new JMenuItem("退出系统");
		exitItem.setFont(font);
		exitItem.setForeground(Color.black);//设置背景颜色
//		startMenu.add(registerItem);
		startMenu.add(startItem);
		startMenu.add(closeItem);
		startMenu.add(newItem);
		startMenu.add(exitItem);		
		menuBar.add(startMenu);
		
		JMenuItem detectionCurveItem = new JMenuItem("实时异常得分曲线显示");
		detectionCurveItem.setFont(font);
		detectionCurveItem.setForeground(Color.black);//设置背景颜色
		JMenuItem historyDetectionItem = new JMenuItem("历史异常得分查询");
		historyDetectionItem.setFont(font);
		historyDetectionItem.setForeground(Color.black);//设置背景颜色
		JMenuItem detectionTimeItem = new JMenuItem("异常时间查询");
		detectionTimeItem.setFont(font);
		detectionTimeItem.setForeground(Color.black);//设置背景颜色
		DetectionMenu.add(detectionCurveItem);
		DetectionMenu.add(historyDetectionItem);
		DetectionMenu.add(detectionTimeItem);
		menuBar.add(DetectionMenu);

		
		JMenuItem predictionCurveItem = new JMenuItem("实时预测值曲线显示");
		predictionCurveItem.setFont(font);
		predictionCurveItem.setForeground(Color.black);//设置背景颜色
		JMenuItem predictionValueItem = new JMenuItem("预测值查询");
		predictionValueItem.setFont(font);
		predictionValueItem.setForeground(Color.black);//设置背景颜色
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

