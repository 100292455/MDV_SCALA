import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Graficas {
	JFreeChart grafica;
	JFreeChart grafica2;
	TimeSeriesCollection dataset  = new TimeSeriesCollection();
	String titulo;
	String tx;
	String ty;

	public Graficas (String titulo){
		this.titulo=titulo;
		grafica=ChartFactory.createTimeSeriesChart(titulo, "Hora", "Luminosidad", dataset,true, true, false);
		grafica2=ChartFactory.createTimeSeriesChart(titulo, "Hora", "Luminosidad", dataset,true, true, false);
	}

	public void agregarGrafica(String id, double [] y, int[] ano, int[] mes, int[] dia, int[] hora, int[] min, int[] sec, int[] mili, double Umbralmax, double Umbralmin){
		TimeSeries pop = new TimeSeries("Tiempo vs Luminosidad");
		TimeSeries pop2 = new TimeSeries("Umbral Superior");
		TimeSeries pop3 = new TimeSeries("Umbral Inferior");
		int n =y.length;

		for (int i = 0; i < n; i++) {
			pop.addOrUpdate(new Second(sec[i], min[i], hora[i], dia[i], mes[i], ano[i]), y[i]);
			pop2.addOrUpdate(new Second(sec[i], min[i], hora[i], dia[i], mes[i], ano[i]), Umbralmax);
			pop3.addOrUpdate(new Second(sec[i], min[i], hora[i], dia[i], mes[i], ano[i]), Umbralmin);
		}

		dataset.addSeries(pop);
		dataset.addSeries(pop2);
		dataset.addSeries(pop3);
	}

	public JPanel obtenerPanel(){
		return new ChartPanel(grafica);
	}
}
