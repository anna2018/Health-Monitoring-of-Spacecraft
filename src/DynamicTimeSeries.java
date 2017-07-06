
import javax.swing.*;
import javax.swing.Timer;

import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.*;
import java.io.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.*;

class DataPoint {
	
}

@SuppressWarnings("serial")
public class DynamicTimeSeries extends JApplet {

	JFreeChart chart1;
	static int num = 0;
	static List<Double> data1 = new ArrayList<>();
	//static List<Integer> data2 = new ArrayList<>();
	static TimeSeries timeseries1 = new TimeSeries("Data1"); 
	//static TimeSeries timeseries2 = new TimeSeries("Data2"); 
	Minute m=new Minute();
	static Millisecond ms = new Millisecond();
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
	public static void direction() throws Exception {
		File directory = new File("");//����Ϊ�� 
		String courseFile = directory.getCanonicalPath() ; 
		System.out.println(courseFile); 
	}
	public DynamicTimeSeries(){
		init();
	}
	public void init(){
		getInfo();

		updateDataset();
		
		XYDataset dataset1 = new TimeSeriesCollection(timeseries1); 
		//XYDataset dataset2 = new TimeSeriesCollection(timeseries2); 
		
		chart1 = ChartFactory.createTimeSeriesChart( 
				"Outlier", // ͼ�����  
				"time", // Ŀ¼�����ʾ��ǩ--����  
				"range", // ��ֵ�����ʾ��ǩ--����  
				dataset1, // ���ݼ�  
				false,
				false, // �Ƿ����ɹ���  
				false // �Ƿ�����URL����  
				); 
		
//		chart2 = ChartFactory.createTimeSeriesChart( 
//				"ECG2", // ͼ�����  
//				"time", // Ŀ¼�����ʾ��ǩ--����  
//				"range", // ��ֵ�����ʾ��ǩ--����  
//				dataset2, // ���ݼ�  
//				false,
//				false, // �Ƿ����ɹ���  
//				false // �Ƿ�����URL����  
//				); 
		
		double[] min = new double[2];
		double[] max = new double[2];
		min[0] = min[1] = Double.MAX_VALUE;
		max[0] = max[1] = Double.MIN_VALUE;
		
		for(int i=0; i<data1.size(); i++){
			double value1 = data1.get(i);
			//int value2 = data2.get(i);
			if(value1 < min[0]) min[0] = value1;
			//if(value2 < min[1]) min[1] = value2;
			if(value1 > max[0]) max[0] = value1;
			//if(value2 > max[1]) max[1] = value2;
		}
		System.out.println(min[0]+"\t"+max[0]+"\t"+min[1]+"\t"+max[1]);

		
		XYPlot plot1 = (XYPlot) chart1.getPlot();
		DateAxis xAxis1 = (DateAxis) plot1.getDomainAxis();
//		XYPlot plot2 = (XYPlot) chart2.getPlot();
//		DateAxis xAxis2 = (DateAxis) plot2.getDomainAxis();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		xAxis1.setTickUnit(new DateTickUnit(DateTickUnitType.SECOND, 1, formatter));
//		xAxis2.setTickUnit(new DateTickUnit(DateTickUnitType.SECOND, 1, formatter));
		NumberAxis yAxis1 = (NumberAxis) plot1.getRangeAxis();
//		NumberAxis yAxis2 = (NumberAxis) plot2.getRangeAxis();
		yAxis1.setRange(min[0], max[0]);
//		yAxis2.setRange(min[1], max[1]);
		
//		xAxis.setAutoTickUnitSelection(false);
		
//		xAxis.setTimeline(new TimeLine());
		
		
		
		getContentPane().setLayout(new GridLayout(1,1));
		ChartPanel chartPanel1 = new ChartPanel(chart1);
//		chartPanel.setPreferredSize(new java.awt.Dimension(800,250));    
//		ChartPanel chartPanel2 = new ChartPanel(chart2);
//		chartPanelxxx.setPreferredSize(new java.awt.Dimension(800,500));   
		
		getContentPane().add(chartPanel1);
//		getContentPane().add(chartPanel2);
		(new DataGenerator()).start();
	}

	class DataGenerator extends Timer implements ActionListener {
		private static final long serialVersionUID = 3977867288743720504L;
		String equID;
		int totalTask;
		String[][] strTask;
		
		public void actionPerformed(ActionEvent actionevent) {
			addTotalObservation();
		}
		
		DataGenerator() {
			super(10, null);
			addActionListener(this);
			System.out.println("super");
		}
		
	}
	
	private void addTotalObservation() {
		//�����µ����ݼ�
		updateDataset();
		chart1.getXYPlot().setDataset(new TimeSeriesCollection(timeseries1));
		
//		chart2.getXYPlot().setDataset(new TimeSeriesCollection(timeseries2));

		if (chart1 != null) {
			chart1.fireChartChanged();
		}
//		if (chart2 != null) {
//			chart2.fireChartChanged();
//		}
	}
	
	public static void updateDataset(){
		if(num > 0){
			timeseries1.delete(0, 0);
			//timeseries2.delete(0, 0);
			long t = ms.getFirstMillisecond()+8;
			Date date = new Date(t);
			ms = new Millisecond(date);
			timeseries1.add(ms, data1.get(num));
			//timeseries2.add(ms, data2.get(num));
			//System.out.println(data2.get(num));
			num++;
		} 
		else{
			for( ; num<200; num++){
				long t = ms.getFirstMillisecond()+8;
				Date date = new Date(t);
				ms = new Millisecond(date);
				timeseries1.add(ms, data1.get(num));
				//timeseries2.add(ms, data2.get(num));
				//System.out.println(data2.get(num));
			}
		}
	}
	
	public void paint(Graphics g) {
		if (chart1 != null) {
			chart1.draw((Graphics2D) g, getBounds());
		}
//		if(chart2 != null) {
//			chart2.draw((Graphics2D) g, getBounds());
//		}
	}
	
	public static void getInfo(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("D:\\resultD.txt"));
			String get = null;
			while((get=br.readLine()) != null){
				//String[] tokens = get.split("\t");
				data1.add(Double.parseDouble(get));
				//data2.add(Integer.parseInt(tokens[1]));
			}
			br.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public static void main(String[] args){
		System.out.println("ssssssssssssssssss");
		DynamicTimeSeries a=new DynamicTimeSeries();
	}
}

