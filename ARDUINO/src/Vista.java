import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.SwingConstants;

import org.jfree.chart.JFreeChart;

import com.panamahitek.PanamaHitek_Arduino;

public class Vista {

	Controlador controlador = new Controlador();
	JFrame frmControl;
	private JTable table;
	JFreeChart Grafica;
	DefaultTableModel model = new DefaultTableModel(0, 0);

	JPanel panelConfg;
	JLabel lblNewLabel;
	JRadioButton rdbtnSensAlta;
	JRadioButton rdbtnSensMedio;
	JRadioButton rdbtnSensBajo;

	ButtonGroup groupSens;
	JLabel lblAjusteDeTiempo;
	JRadioButton rdbtnTmpReaccAlto;
	JRadioButton rdbtnTmpReaccMedio;
	JRadioButton rdbtnTmpReaccBajo;
	ButtonGroup groupTmpReacc;

	JButton btnAplicar;
	JButton btnConsultarHistorico;
	
	JPanel panelComportamientoSis;
	JPanel panelCtrlLuces;
	JLabel lblPalancaDeLuces;
	JRadioButton rdbtnAutomatico;
	JRadioButton rdbtnOff;
	JRadioButton rdbtnPosicion;
	JRadioButton rdbtnCruce;
	JRadioButton rdbtnLargas;
	ButtonGroup groupPalancaDeLuces;

	public PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();


	List<String> datos = new ArrayList<String>() {{add("fecha");}};

	/*PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino(); 
	SerialPortEventListener evento= new SerialPortEventListener(){
		@Override
		public void serialEvent(SerialPortEvent spe){
		}
	};*/


	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
		//gestionar();
		/*try {
			Arduino.arduinoRXTX("COM3", 9600, evento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


	}



	/**
	 * Initialize the contents of the frame.
	 */


	private void initialize() {
		frmControl = new JFrame();
		frmControl.setIconImage(Toolkit.getDefaultToolkit().getImage(Vista.class.getResource("/Images/coches-miniatura.jpg")));
		frmControl.setTitle("Ventana de Control");
		frmControl.setBounds(100, 100, 866, 562);
		frmControl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnEncender = new JButton("ENCENDER");
		btnEncender.setBounds(36, 55, 99, 23);
		btnEncender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*	try {
					Arduino.sendData("1");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	*/
			}
		});

		frmControl.getContentPane().setLayout(null);
		frmControl.getContentPane().add(btnEncender);

		JButton btnApagar = new JButton("APAGAR");
		btnApagar.setBounds(36, 99, 99, 23);
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*	try {
					Arduino.sendData("0");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	*/
			}
		});
		frmControl.getContentPane().add(btnApagar);

		panelConfg = new JPanel();
		panelConfg.setBounds(160, 27, 252, 176);
		panelConfg.setToolTipText("");
		panelConfg.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Configuraci\u00F3n de Luces", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmControl.getContentPane().add(panelConfg);

		lblNewLabel = new JLabel("Ajuste de Sensibilidad");
		lblNewLabel.setBounds(16, 30, 206, 14);

		rdbtnSensAlta = new JRadioButton("Alto");
		rdbtnSensAlta.setBounds(26, 51, 65, 23);

		rdbtnSensMedio = new JRadioButton("Medio");
		rdbtnSensMedio.setBounds(93, 51, 67, 23);
		rdbtnSensMedio.setSelected(true);

		rdbtnSensBajo = new JRadioButton("Bajo");
		rdbtnSensBajo.setBounds(175, 51, 65, 23);

		groupSens = new ButtonGroup();
		groupSens.add(rdbtnSensAlta);
		groupSens.add(rdbtnSensMedio);
		groupSens.add(rdbtnSensBajo);

		lblAjusteDeTiempo = new JLabel("Ajuste de Tiempo de Reacci\u00F3n");
		lblAjusteDeTiempo.setBounds(16, 81, 206, 14);

		rdbtnTmpReaccAlto = new JRadioButton("Alto");
		rdbtnTmpReaccAlto.setBounds(26, 102, 65, 23);

		rdbtnTmpReaccMedio = new JRadioButton("Medio");
		rdbtnTmpReaccMedio.setBounds(93, 102, 67, 23);
		rdbtnTmpReaccMedio.setSelected(true);

		rdbtnTmpReaccBajo = new JRadioButton("Bajo");
		rdbtnTmpReaccBajo.setBounds(175, 102, 65, 23);


		groupTmpReacc = new ButtonGroup();
		groupTmpReacc.add(rdbtnTmpReaccAlto);
		groupTmpReacc.add(rdbtnTmpReaccMedio);
		groupTmpReacc.add(rdbtnTmpReaccBajo);

		panelCtrlLuces = new JPanel();
		panelCtrlLuces.setVisible(false);
		panelComportamientoSis = new JPanel();
		panelComportamientoSis.setVisible(false);

		btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(134, 142, 88, 23);
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCtrlLuces.setVisible(true);
				panelComportamientoSis.setVisible(true);
				btnAplicar.setEnabled(false);
				rdbtnTmpReaccAlto.setEnabled(false);
				rdbtnTmpReaccMedio.setEnabled(false);
				rdbtnTmpReaccBajo.setEnabled(false);
				rdbtnSensAlta.setEnabled(false);
				rdbtnSensMedio.setEnabled(false);
				rdbtnSensBajo.setEnabled(false);

				if(rdbtnTmpReaccAlto.isSelected()){
					controlador.setReaccion(rdbtnTmpReaccAlto.getText());
				}
				else if(rdbtnTmpReaccMedio.isSelected()){
					controlador.setReaccion(rdbtnTmpReaccMedio.getText());
				}
				else if(rdbtnTmpReaccBajo.isSelected()){
					controlador.setReaccion(rdbtnTmpReaccBajo.getText());
				}

				if(rdbtnSensAlta.isSelected()){
					controlador.setSensibilidad(rdbtnSensAlta.getText());
				}
				else if(rdbtnSensMedio.isSelected()){
					controlador.setSensibilidad(rdbtnSensMedio.getText());
				}
				else if(rdbtnSensBajo.isSelected()){
					controlador.setSensibilidad(rdbtnSensBajo.getText());
				}
			}
		});
		panelConfg.setLayout(null);
		panelConfg.add(rdbtnSensAlta);
		panelConfg.add(rdbtnSensMedio);
		panelConfg.add(rdbtnSensBajo);
		panelConfg.add(lblNewLabel);
		panelConfg.add(rdbtnTmpReaccAlto);
		panelConfg.add(rdbtnTmpReaccMedio);
		panelConfg.add(rdbtnTmpReaccBajo);
		panelConfg.add(lblAjusteDeTiempo);
		panelConfg.add(btnAplicar);


		panelCtrlLuces.setBounds(14, 214, 398, 259);
		panelCtrlLuces.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Control de luces", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmControl.getContentPane().add(panelCtrlLuces);

		lblPalancaDeLuces = new JLabel("Palanca de luces");
		lblPalancaDeLuces.setBounds(10, 27, 125, 14);

		rdbtnOff = new JRadioButton("OFF");
		rdbtnOff.setBounds(10, 63, 125, 23);		

		rdbtnPosicion = new JRadioButton("POSICION");
		rdbtnPosicion.setBounds(10, 136, 116, 23);


		rdbtnCruce = new JRadioButton("CRUCE");
		rdbtnCruce.setBounds(10, 175, 116, 23);


		rdbtnAutomatico = new JRadioButton("AUTOMATICO");
		rdbtnAutomatico.setBounds(10, 99, 125, 23);


		rdbtnLargas = new JRadioButton("LARGAS");
		rdbtnLargas.setBounds(10, 211, 116, 23);


		groupPalancaDeLuces = new ButtonGroup();
		groupPalancaDeLuces.add(rdbtnOff);
		groupPalancaDeLuces.add(rdbtnPosicion);
		groupPalancaDeLuces.add(rdbtnCruce);
		groupPalancaDeLuces.add(rdbtnAutomatico);
		groupPalancaDeLuces.add(rdbtnLargas);

		JPanel panel = new JPanel();
		panel.setBounds(23, 80, 345, 97);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JLabel lblCompSisPos = new JLabel("");
		lblCompSisPos.setBounds(25, 11, 75, 73);
		panel.add(lblCompSisPos);
		lblCompSisPos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompSisPos.setIcon(new ImageIcon(Vista.class.getResource("/Images/luces-posicion-610x650.jpg")));
		lblCompSisPos.setVisible(false);
		JLabel lblCompSisCruce = new JLabel("");
		lblCompSisCruce.setBounds(147, 14, 75, 70);
		panel.add(lblCompSisCruce);
		lblCompSisCruce.setIcon(new ImageIcon(Vista.class.getResource("/Images/luces-carretera-cortas.jpg")));
		lblCompSisCruce.setVisible(false);
		JLabel lblCompSisLargas = new JLabel("");
		lblCompSisLargas.setBounds(248, 13, 75, 71);
		panel.add(lblCompSisLargas);
		lblCompSisLargas.setIcon(new ImageIcon(Vista.class.getResource("/Images/luces-carretera-largas.jpg")));
		lblCompSisLargas.setVisible(false);

		ActionListener slice= new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				AbstractButton aButton = (AbstractButton) actionEvent.getSource();

				if(aButton.getText().equals("OFF")){
					datos = controlador.invocarArduinoManual("0");
					/*for (int i=0; i<7; i++){
						table.setValueAt(datos.get(i), 0, i);
					}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6)  });
					lblCompSisPos.setVisible(false);
					lblCompSisCruce.setVisible(false);
					lblCompSisLargas.setVisible(false);
				}
				if(aButton.getText().equals("POSICION")){
					//encender solo luces de posicion
					datos = controlador.invocarArduinoManual("1");
					/*for (int i=0; i<7; i++){
					table.setValueAt(datos.get(i), 0, i);
				}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6)  });

					lblCompSisPos.setVisible(true);
					lblCompSisCruce.setVisible(false);
					lblCompSisLargas.setVisible(false);
				}
				if(aButton.getText().equals("CRUCE")){
					//encender luces de posicion y cortas
					datos = controlador.invocarArduinoManual("2");
					/*for (int i=0; i<7; i++){
					table.setValueAt(datos.get(i), 0, i);
				}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6)  });
					lblCompSisPos.setVisible(true);
					lblCompSisCruce.setVisible(true);
					lblCompSisLargas.setVisible(false);
				}
				int j =0;
				if(aButton.getText().equals("AUTOMATICO")){
					//activar modo automatico, cada x segundos, los segundos los marcamos nososotros en Java
					SerialPortEventListener evento =new SerialPortEventListener(){
						public void serialEvent(SerialPortEvent spe){
							if(Arduino.isMessageAvailable()== true){

								datos = controlador.invocarArduinoAutomatico("4");
								for (int i=0; i<7; i++){
									table.setValueAt(datos.get(i), 0, i);
								}

								/**cortas y posicion encendidas**/
								if(datos.get(5).equals("ON")){

									lblCompSisPos.setVisible(true);
									lblCompSisCruce.setVisible(true);
									lblCompSisLargas.setVisible(false);

									/*solo posicion encendidas*/
								}else{
									lblCompSisPos.setVisible(true);
									lblCompSisCruce.setVisible(false);
									lblCompSisLargas.setVisible(false);
								}


							}


							if (controlador.getReaccion().equalsIgnoreCase("Alto")){
								controlador.setReaccion("1");
							}else if (controlador.getReaccion().equalsIgnoreCase("Medio")){
								controlador.setReaccion("2");
							}else if (controlador.getReaccion().equalsIgnoreCase("Bajo")){
								controlador.setReaccion("4");
							}

							if(controlador.getReaccion().equalsIgnoreCase("1")){
								try {
									Thread.sleep (1000);
								} catch (Exception e) {
									// Mensaje en caso de que falle
								}
							}else if(controlador.getReaccion().equalsIgnoreCase("2")){
								try {
									Thread.sleep (2000);
								} catch (Exception e) {
									// Mensaje en caso de que falle
								}
							}else if(controlador.getReaccion().equalsIgnoreCase("4")){
								try {
									Thread.sleep (4000);
								} catch (Exception e) {
									// Mensaje en caso de que falle
								}
							}
						}

					};
				}

				if(aButton.getText().equals("LARGAS")){
					//encender luces de posicion y cortas y largas
					datos = controlador.invocarArduinoManual("3");
					/*for (int i=0; i<7; i++){
					table.setValueAt(datos.get(i), 0, i);
				}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6) });
					lblCompSisPos.setVisible(true);
					lblCompSisCruce.setVisible(true);
					lblCompSisLargas.setVisible(true);
				}
			}
		};

		rdbtnOff.addActionListener(slice);
		rdbtnPosicion.addActionListener(slice);
		rdbtnCruce.addActionListener(slice);
		rdbtnLargas.addActionListener(slice);
		rdbtnAutomatico.addActionListener(slice);

		JButton btnRafagaDeLargas = new JButton("Rafaga de Largas");
		btnRafagaDeLargas.setBounds(179, 136, 159, 23);
		btnRafagaDeLargas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelCtrlLuces.setLayout(null);
		panelCtrlLuces.add(lblPalancaDeLuces);
		panelCtrlLuces.add(rdbtnOff);
		panelCtrlLuces.add(rdbtnAutomatico);
		panelCtrlLuces.add(rdbtnPosicion);
		panelCtrlLuces.add(btnRafagaDeLargas);
		panelCtrlLuces.add(rdbtnCruce);
		panelCtrlLuces.add(rdbtnLargas);

		panelComportamientoSis.setBounds(437, 27, 390, 445);
		panelComportamientoSis.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Comportamiento del Sistema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmControl.getContentPane().add(panelComportamientoSis);

		btnConsultarHistorico = new JButton("Consultar Grafica");
		btnConsultarHistorico.setBounds(191, 403, 177, 23);
		btnConsultarHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** Abrimos una ventana nueva despues de  pulsar el boton consultar historico**/
				//Historico dialog = new Historico();
				//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				//dialog.setVisible(true);
			} /*lo elimino da error
				catch (Exception e) {
				e.printStackTrace();
			}*/
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 200, 345, 200);

		table = new JTable();
		String header[] = new String[] { "Fecha", "Hora", "Modo", 
				"Lum", "Posicion", "Cruce", "Largas" };
		model.setColumnIdentifiers(header);
		table.setModel(model);

		scrollPane.setViewportView(table);
		panelComportamientoSis.setLayout(null);
		panelComportamientoSis.add(panel);
		panelComportamientoSis.add(scrollPane);
		panelComportamientoSis.add(btnConsultarHistorico);
	}

	/**
	 * Launch the application.
	 */


	// Variables declaration - do not modify//GEN-BEGIN:variables


	// End of variables declaration//GEN-END:variables
}