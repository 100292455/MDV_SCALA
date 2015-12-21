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
import javax.swing.Timer;

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

	Timer Reloj;
	int autoBool;
	int encontrado = 0;
	String posAux ;
	String cruAux ;
	String larAux ;
	int reaccionInt;
	int datoRecibido=0;
	int datoRecibido1=0;

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

	List<Coordenadas> coordenadas = new ArrayList();

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

				/**llama a la incializacion del arduino solo para crearlo un vez tras pulsar el boton de aplicar*/
				controlador.inicializarArduino();
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
					reaccionInt = 4000;
					controlador.setReaccion(rdbtnTmpReaccAlto.getText());
				}
				else if(rdbtnTmpReaccMedio.isSelected()){
					reaccionInt = 2000;
					controlador.setReaccion(rdbtnTmpReaccMedio.getText());
				}
				else if(rdbtnTmpReaccBajo.isSelected()){
					reaccionInt = 1000;
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
					autoBool = 0;
					//preguntamos por el valor LDR
					try {
						controlador.Arduino.sendData("5");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//guardamos el valor del ldr enviado por el arduino
					try {
						datoRecibido = controlador.Arduino.receiveData();
						datoRecibido=datoRecibido*4;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					datos = controlador.invocarArduinoManual("0", datoRecibido);
					/*for (int i=0; i<7; i++){
						table.setValueAt(datos.get(i), 0, i);
					}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6)  });
					lblCompSisPos.setVisible(false);
					lblCompSisCruce.setVisible(false);
					lblCompSisLargas.setVisible(false);
					Coordenadas coord = new Coordenadas();

					int ano = Integer.parseInt(datos.get(7));
					int mes = Integer.parseInt(datos.get(8));
					int dia = Integer.parseInt(datos.get(9));
					int horas = Integer.parseInt(datos.get(10)); 
					int minutos = Integer.parseInt(datos.get(11));
					int segundos = Integer.parseInt(datos.get(12));

					double sensibilidadTop = Double.parseDouble(datos.get(14));
					double sensibilidadBot = Double.parseDouble(datos.get(15));

					coord.setAno(ano);
					coord.setDia(dia);
					coord.setHora(horas);
					coord.setMes(mes);
					coord.setMinutos(minutos);
					coord.setSegundos(segundos);
					coord.setLuminosidad(datos.get(3));
					coord.setUmbralSuperior(sensibilidadTop);
					coord.setUmbralInferior(sensibilidadBot);
					coordenadas.add(coord);		
					encontrado = 0;
				}
				if(aButton.getText().equals("POSICION")){
					autoBool = 0;
					//encender solo luces de posicion
					//preguntamos por el valor LDR
					try {
						controlador.Arduino.sendData("5");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//guardamos el valor del ldr enviado por el arduino
					try {
						datoRecibido = controlador.Arduino.receiveData();
						datoRecibido=datoRecibido*4;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					datos = controlador.invocarArduinoManual("1",datoRecibido);
					/*for (int i=0; i<7; i++){
					table.setValueAt(datos.get(i), 0, i);
				}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6)  });

					lblCompSisPos.setVisible(true);
					lblCompSisCruce.setVisible(false);
					lblCompSisLargas.setVisible(false);
					Coordenadas coord = new Coordenadas();

					int ano = Integer.parseInt(datos.get(7));
					int mes = Integer.parseInt(datos.get(8));
					int dia = Integer.parseInt(datos.get(9));
					int horas = Integer.parseInt(datos.get(10)); 
					int minutos = Integer.parseInt(datos.get(11));
					int segundos = Integer.parseInt(datos.get(12));

					double sensibilidadTop = Double.parseDouble(datos.get(14));
					double sensibilidadBot = Double.parseDouble(datos.get(15));

					coord.setAno(ano);
					coord.setDia(dia);
					coord.setHora(horas);
					coord.setMes(mes);
					coord.setMinutos(minutos);
					coord.setSegundos(segundos);
					coord.setLuminosidad(datos.get(3));
					coord.setUmbralSuperior(sensibilidadTop);
					coord.setUmbralInferior(sensibilidadBot);
					coordenadas.add(coord);		
					encontrado = 0;
				}
				if(aButton.getText().equals("CRUCE")){
					autoBool = 0;
					//encender luces de posicion y cortas
					//preguntamos valor LDR
					try {
						controlador.Arduino.sendData("5");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//guardamos el valor del ldr enviado por el arduino
					try {
						datoRecibido = (controlador.Arduino.receiveData());
						datoRecibido=datoRecibido*4;

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					datos = controlador.invocarArduinoManual("2",datoRecibido);
					/*for (int i=0; i<7; i++){
					table.setValueAt(datos.get(i), 0, i);
				}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6)  });
					lblCompSisPos.setVisible(true);
					lblCompSisCruce.setVisible(true);
					lblCompSisLargas.setVisible(false);
					Coordenadas coord = new Coordenadas();

					int ano = Integer.parseInt(datos.get(7));
					int mes = Integer.parseInt(datos.get(8));
					int dia = Integer.parseInt(datos.get(9));
					int horas = Integer.parseInt(datos.get(10)); 
					int minutos = Integer.parseInt(datos.get(11));
					int segundos = Integer.parseInt(datos.get(12));

					double sensibilidadTop = Double.parseDouble(datos.get(14));
					double sensibilidadBot = Double.parseDouble(datos.get(15));

					coord.setAno(ano);
					coord.setDia(dia);
					coord.setHora(horas);
					coord.setMes(mes);
					coord.setMinutos(minutos);
					coord.setSegundos(segundos);
					coord.setLuminosidad(datos.get(3));
					coord.setUmbralSuperior(sensibilidadTop);
					coord.setUmbralInferior(sensibilidadBot);
					coordenadas.add(coord);	
					encontrado = 0;
				}
				if(aButton.getText().equals("AUTOMATICO")&&autoBool == 0){
					autoBool = 1;
					ActionListener taskPerformer = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent evt) {
							if(autoBool == 1){

								try {
									controlador.Arduino.sendData("5");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								//guardamos el valor del ldr enviado por el arduino
								try {
									datoRecibido = controlador.Arduino.receiveData();
									datoRecibido = datoRecibido*4;									
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}

								datos = controlador.invocarArduinoAutomatico("4", datoRecibido);
								
								if(encontrado == 0){
									posAux = datos.get(4);
									cruAux = datos.get(5);
									larAux = datos.get(6);
									
									model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
											datos.get(3), datos.get(4), datos.get(5), datos.get(6) });

									if(datos.get(4).equals("ON")){
										lblCompSisPos.setVisible(true);
									}else {
										lblCompSisPos.setVisible(false);
									}
									if(datos.get(5).equals("ON")){
										lblCompSisCruce.setVisible(true);
									}else {
										lblCompSisCruce.setVisible(false);
									}
									if(datos.get(6).equals("ON")){
										lblCompSisLargas.setVisible(true);
									}else {
										lblCompSisLargas.setVisible(false);
									}
									
									encontrado = 1;
								}else{
									if (posAux.equals(datos.get(4)) && cruAux.equals(datos.get(5)) && larAux.equals(datos.get(6))){
										
									}else{
										encontrado = 0;
									}
								}

								Coordenadas coord = new Coordenadas();

								int ano = Integer.parseInt(datos.get(7));
								int mes = Integer.parseInt(datos.get(8));
								int dia = Integer.parseInt(datos.get(9));
								int horas = Integer.parseInt(datos.get(10)); 
								int minutos = Integer.parseInt(datos.get(11));
								int segundos = Integer.parseInt(datos.get(12));
								int mili = Integer.parseInt(datos.get(13));

								double sensibilidadTop = Double.parseDouble(datos.get(14));
								double sensibilidadBot = Double.parseDouble(datos.get(15));

								coord.setAno(ano);
								coord.setDia(dia);
								coord.setHora(horas);
								coord.setMes(mes);
								coord.setMinutos(minutos);
								coord.setSegundos(segundos);
								coord.setMili(mili);
								coord.setUmbralSuperior(sensibilidadTop);
								coord.setUmbralInferior(sensibilidadBot);
								coord.setLuminosidad(datos.get(3));
								coordenadas.add(coord);		

							}
						}
					};

					Reloj=new Timer(reaccionInt,taskPerformer);
					Reloj.start();
				}

				if(aButton.getText().equals("LARGAS")){
					autoBool = 0;
					try {
						controlador.Arduino.sendData("5");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//guardamos el valor del ldr enviado por el arduino
					try {
						datoRecibido = controlador.Arduino.receiveData();
						datoRecibido = datoRecibido*4;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					datos = controlador.invocarArduinoManual("3", datoRecibido);
					/*for (int i=0; i<7; i++){
					table.setValueAt(datos.get(i), 0, i);
				}*/
					model.addRow(new Object[] { datos.get(0), datos.get(1), datos.get(2),
							datos.get(3), datos.get(4), datos.get(5), datos.get(6) });
					lblCompSisPos.setVisible(true);
					lblCompSisCruce.setVisible(true);
					lblCompSisLargas.setVisible(true);
					Coordenadas coord = new Coordenadas();

					int ano = Integer.parseInt(datos.get(7));
					int mes = Integer.parseInt(datos.get(8));
					int dia = Integer.parseInt(datos.get(9));
					int horas = Integer.parseInt(datos.get(10)); 
					int minutos = Integer.parseInt(datos.get(11));
					int segundos = Integer.parseInt(datos.get(12));
					int mili = Integer.parseInt(datos.get(13));

					double sensibilidadTop = Double.parseDouble(datos.get(14));
					double sensibilidadBot = Double.parseDouble(datos.get(15));

					coord.setAno(ano);
					coord.setDia(dia);
					coord.setHora(horas);
					coord.setMes(mes);
					coord.setMinutos(minutos);
					coord.setSegundos(segundos);
					coord.setMili(mili);
					coord.setUmbralSuperior(sensibilidadTop);
					coord.setUmbralInferior(sensibilidadBot);
					coord.setLuminosidad(datos.get(3));
					coordenadas.add(coord);		
					encontrado = 0;
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
				if(coordenadas.isEmpty()) {
				}else{
					new GraficaTest(coordenadas);
				}
			} 
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