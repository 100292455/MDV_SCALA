import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Historico extends JDialog {
	private JTable table;
	

	

	/**
	 * Launch the application.
	 */
	
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
		setBounds(100, 100, 725, 479);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 46, 646, 163);
		
		JPanel panelGrafica = new JPanel();
		panelGrafica.setBounds(248, 227, 430, 181);
		panelGrafica.setBackground(Color.WHITE);
		
		
		
		

		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha", "Hora", "Lum", "Modo", "Posicion", "Cruce", "Largas"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(null);
		getContentPane().add(panelGrafica);
		panelGrafica.setLayout(null);
		getContentPane().add(scrollPane);
		
		

		
	}
		
}