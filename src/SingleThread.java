import java.awt.Color;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SingleThread {
	
	static final int yuzMetreIcinYolMaliyeti = 20000;
    static final int yuzMetreIcinKopruMaliyeti = 40000;
    static final int nehrinGenisligi = 600;
    static final int yatayMesafe = 800;
    static final int maxMaliyet=400000;
	
    public static double maliyetHesapla(double x) {
    	double kopruUzunlugu=Math.sqrt(nehrinGenisligi*nehrinGenisligi + x*x);
    	double yolUzunlugu=yatayMesafe-x;
    	double toplamMaliyet=(kopruUzunlugu/100)*yuzMetreIcinKopruMaliyeti+ (yolUzunlugu/100)*yuzMetreIcinYolMaliyeti;
    	return toplamMaliyet;
    }
    
    public static void main(String[] args) {
    	int x;
    	double minMaliyet=maxMaliyet;
		int enAzMaliyetGetirenYatayUzaklik=0;
		for(x=1; x<=yatayMesafe; x++) {
			double sonuc = maliyetHesapla(x);
			if(sonuc<minMaliyet) {
				minMaliyet=sonuc;
				enAzMaliyetGetirenYatayUzaklik=x;
			}
			else {
				break;
			}
		}
		
		double kopruUzunlugu=Math.sqrt(nehrinGenisligi*nehrinGenisligi + enAzMaliyetGetirenYatayUzaklik*enAzMaliyetGetirenYatayUzaklik);
    	double yolUzunlugu=yatayMesafe-enAzMaliyetGetirenYatayUzaklik;
    	System.out.println("-En dusuk maliyetli durum-");
    	System.out.println("Toplam yol uzunlugu: "+yolUzunlugu);
    	System.out.println("Toplam kopru uzunlugu: "+kopruUzunlugu);
    	System.out.println("Toplam Maliyet: "+minMaliyet+" dolar");
    	
    	
    	XYSeries yolMaliyet=new XYSeries("Toplam Maliyet (dolar)");
    	for(int i=0; i<=yatayMesafe; i+=1) {
    		yolMaliyet.add(i, maliyetHesapla(i));
    	}
    	
    	XYSeries optimumNokta = new XYSeries("Min Maliyet (Optimum Nokta) ("+minMaliyet+" $)");
        optimumNokta.add(enAzMaliyetGetirenYatayUzaklik, minMaliyet);
        
    	XYSeriesCollection grafikBilgisi=new XYSeriesCollection();
    	grafikBilgisi.addSeries(yolMaliyet);
    	grafikBilgisi.addSeries(optimumNokta);
    	
    	JFreeChart grafik=ChartFactory.createXYLineChart("Köprü Konumuna Göre Toplam Maliyet", "Köprü Konumu (metre)", "Toplam Maliyet (dolar)", grafikBilgisi);
    	XYPlot plot = grafik.getXYPlot();
    	plot.getRangeAxis().setRange(350000, plot.getRangeAxis().getUpperBound());
    	
    	XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.BLUE);
        render.setSeriesShapesVisible(0, false);
        render.setSeriesPaint(1, Color.RED);
        render.setSeriesShapesVisible(1, true);
        render.setSeriesShape(1, new Ellipse2D.Double(-5, -5, 10, 10));
    	
        plot.setRenderer(render);
        
    	JFrame grafikGoruntusu=new JFrame("Maliyet Grafiği");
    	grafikGoruntusu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	grafikGoruntusu.setSize(600, 500);
    	grafikGoruntusu.setLocationRelativeTo(null);
    	grafikGoruntusu.add(new ChartPanel(grafik));
    	grafikGoruntusu.setVisible(true);
	}

}