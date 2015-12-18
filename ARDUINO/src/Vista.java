import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
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

public class Vista {
	
	Controlador gestor = new Controlador();
	JFrame frmControl;
	private JTable table;
	JFreeChart Grafica;
	
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
		
	JPanel panelCtrlLuces;
	JLabel lblPalancaDeLuces;
	JRadioButton rdbtnAutomatico;
	JRadioButton rdbtnOff;
	JRadioButton rdbtnPosicion;
	JRadioButton rdbtnCruce;
	JRadioButton rdbtnLargas;
	ButtonGroup groupPalancaDeLuces;
	
	JButton btnConsultarHistorico;
	
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
		
		rdbtnTmpReaccBajo = new JRadioButton("Bajo");
		rdbtnTmpReaccBajo.setBounds(175, 102, 65, 23);
		
		
		groupTmpReacc = new ButtonGroup();
		groupTmpReacc.add(rdbtnTmpReaccAlto);
		groupTmpReacc.add(rdbtnTmpReaccMedio);
		groupTmpReacc.add(rdbtnTmpReaccBajo);
		
		btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(134, 142, 88, 23);
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		panelCtrlLuces = new JPanel();
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
		
		ActionListener slice= new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				AbstractButton aButton = (AbstractButton) actionEvent.getSource();
				
				if(aButton.getText().equals("OFF")){
				gestor.setLuces("0");
				
				String luces =gestor.getLuces();
				System.out.println(luces);
				}
				if(aButton.getText().equals("POSICION")){
					//encender solo luces de posicion
					gestor.setLuces("1");

					String luces =gestor.getLuces();
					System.out.println(luces);
				}
				if(aButton.getText().equals("CRUCE")){
					//encender luces de posicion y cortas
					gestor.setLuces("2");

					String luces =gestor.getLuces();
					System.out.println(luces);
				}
				if(aButton.getText().equals("AUTOMATICO")){
					//activar modo automatico
					gestor.setLuces("4");

					String luces =gestor.getLuces();
					System.out.println(luces);
				}
				if(aButton.getText().equals("LARGAS")){
					//encender luces de posicion y cortas y largas
					gestor.setLuces("3");

					String luces =gestor.getLuces();
					System.out.println(luces);
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
		
		JPanel panelComportamientoSis = new JPanel();
		panelComportamientoSis.setBounds(437, 27, 390, 445);
		panelComportamientoSis.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Comportamiento del Sistema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmControl.getContentPane().add(panelComportamientoSis);
		
		btnConsultarHistorico = new JButton("Consultar Historico");
		btnConsultarHistorico.setBounds(191, 403, 177, 23);
		btnConsultarHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/** Abrimos una ventana nueva despues de  pulsar el boton consultar historico**/
				Historico dialog = new Historico();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} /*lo elimino da error
				catch (Exception e) {
				e.printStackTrace();
			}*/
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 245, 345, 43);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 80, 345, 97);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblCompSisPos = new JLabel("");
		lblCompSisPos.setBounds(25, 11, 75, 73);
		panel.add(lblCompSisPos);
		lblCompSisPos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompSisPos.setIcon(new ImageIcon(Vista.class.getResource("/Images/luces-posicion-610x650.jpg")));
		
		JLabel lblCompSisCruce = new JLabel("");
		lblCompSisCruce.setBounds(147, 14, 75, 70);
		panel.add(lblCompSisCruce);
		lblCompSisCruce.setIcon(new ImageIcon(Vista.class.getResource("/Images/luces-carretera-cortas.jpg")));
		
		JLabel lblCompSisLargas = new JLabel("");
		lblCompSisLargas.setBounds(248, 13, 75, 71);
		panel.add(lblCompSisLargas);
		lblCompSisLargas.setIcon(new ImageIcon(Vista.class.getResource("/Images/luces-carretera-largas.jpg")));

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Fecha", "Hora", "Modo", "Lum", "Posicion", "Largas", "Cruce"
			}
		));
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
