import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Historico extends JDialog {
	DefaultTableModel modelo = new DefaultTableModel();
	JTable table = new JTable(modelo);
	
	XYSeries Serie = new XYSeries("Luminosidad");
	XYSeriesCollection Coleccion = new XYSeriesCollection();
	JFreeChart Grafica;
	DefaultCategoryDataset Datos = new DefaultCategoryDataset();
	List<String> variablesToPlot = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	
	public List<String> getVariablesToPlot() {
		return variablesToPlot;
	}

	public void setVariablesToPlot(List<String> variablesToPlot) {
		
		int numCols = table.getModel().getColumnCount();
		Object [] fila = new Object[numCols];
		System.out.println(numCols);
		fila[0] = variablesToPlot.get(0);
		System.out.println(variablesToPlot.get(0));
		System.out.println("fila:"+fila[0]);
		fila[1] = variablesToPlot.get(1);
		System.out.println(variablesToPlot.get(1));
		System.out.println("fila:"+fila[1]);
		fila[2] = variablesToPlot.get(2);
		System.out.println(variablesToPlot.get(2));
		System.out.println("fila:"+fila[2]);
		fila[3] = variablesToPlot.get(3);
		System.out.println(variablesToPlot.get(3));
		System.out.println("fila:"+fila[3]);
		fila[4] = variablesToPlot.get(4);
		System.out.println(variablesToPlot.get(4));
		System.out.println("fila:"+fila[4]);
		fila[5] = variablesToPlot.get(5);
		System.out.println(variablesToPlot.get(5));
		System.out.println("fila:"+fila[5]);
		fila[6] = variablesToPlot.get(6);
		System.out.println(variablesToPlot.get(6));
		System.out.println("fila:"+fila[6]);
		((DefaultTableModel) table.getModel()).addRow(fila);
		
	/*	
	    for (int i=0; i<7; i++){
			table.setValueAt(variablesToPlot.get(i), 0, i);
		}
		Datos.addValue(1, table.getValueAt(0, 3).toString(), table.getValueAt(0, 1).toString());
	*/
		this.variablesToPlot = variablesToPlot;
	}

	/*	public static void main(String[] args) {
		try {
			Monitorizacion dialog = new Monitorizacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 */
	public Historico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Historico.class.getResource("/Images/coches-miniatura.jpg")));
		setTitle("Historico");
		setBounds(100, 100, 1000, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 46, 900, 163);
		
		
	//	Datos.addValue(1, table.getValueAt(0, 3).toString(), table.getValueAt(0, 1).toString());
		
		Grafica = ChartFactory.createLineChart("Luminosidad vs Tiempo", "Tiempo", "Luminosidad", Datos, PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel panelGrafica = new ChartPanel(Grafica);
		
		panelGrafica.setBounds(32, 230, 900, 300);
		panelGrafica.setBackground(Color.WHITE);		
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"Fecha", "Hora", "Modo", "Lum", "Posicion", "Cruce", "Largas"
				}
			));
		
		scrollPane.setViewportView(table);
		getContentPane().setLayout(null);
		getContentPane().add(panelGrafica);
		panelGrafica.setLayout(null);
		getContentPane().add(scrollPane);
		
	}
		
}