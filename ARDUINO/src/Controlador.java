import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.panamahitek.PanamaHitek_Arduino;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
public class Controlador {

	Historico historico = new Historico();
	private String luces;
	private String sensibilidad;
	int sensibilidadTop;
	int sensibilidadBot;
	private String reaccion;
	int treaccion;
	

	/***** DATOS ******/
	int anyo;
	int dia;
	int mes;
	int horas ;
	int minutos ;
	int segundos ;
	private Calendar calendario = new GregorianCalendar();
	private String fecha;
	private String hora;
	private String modo;
	private String luminosidad;
	private String posicion;
	private String largas;
	private String cruce;
	/*************/
/*
	private PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();
	SerialPortEventListener evento= new SerialPortEventListener(){
		@Override
		public void serialEvent(SerialPortEvent spe){
		}
	};
*/
	public String getLuces() {
		return luces;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public String getReaccion() {
		return reaccion;
	}
	
	public String getSensibilidad() {
		return sensibilidad;
	}

	public void setLuces(String luces) {
		this.luces = luces;
	}
	
	public void setSensibilidad(String sensibilidad) {
		this.sensibilidad = sensibilidad;
	}
	
	public void setReaccion(String reaccion) {
		this.reaccion = reaccion;
	}

	public List<String> invocarArduinoManual(String lucesEncender){
		List<String> datos = new ArrayList<String>();
/*
		try {
			Arduino.arduinoRXTX("COM3", 9600, evento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Arduino.sendData(lucesEncender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		if(lucesEncender.equals("0")){
			anyo = calendario.get(Calendar.YEAR);
			dia = calendario.get(Calendar.DAY_OF_MONTH);
			mes = calendario.get(Calendar.MONTH) +1;
			horas = calendario.get(Calendar.HOUR_OF_DAY) ;
			minutos = calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND);
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "-";//valor recibido por el arduino
			posicion = "OFF";
			largas = "OFF";
			cruce = "OFF";
			datos.add(fecha);
			datos.add(hora);
			datos.add(modo);
			datos.add(luminosidad);
			datos.add(posicion);
			datos.add(cruce);
			datos.add(largas);
		}
		if(lucesEncender.equals("1")){
			anyo = calendario.get(Calendar.YEAR);
			dia = calendario.get(Calendar.DAY_OF_MONTH);
			mes = calendario.get(Calendar.MONTH) +1;
			horas = calendario.get(Calendar.HOUR_OF_DAY) ;
			minutos = calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND);
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "-";//valor recibido por el arduino
			posicion = "ON";
			largas = "OFF";
			cruce = "OFF";
			datos.add(fecha);
			datos.add(hora);
			datos.add(modo);
			datos.add(luminosidad);
			datos.add(posicion);
			datos.add(cruce);
			datos.add(largas);
		}
		if(lucesEncender.equals("2")){
			anyo = calendario.get(Calendar.YEAR);
			dia = calendario.get(Calendar.DAY_OF_MONTH);
			mes = calendario.get(Calendar.MONTH) +1;
			horas = calendario.get(Calendar.HOUR_OF_DAY) ;
			minutos = calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND);
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "-";//valor recibido por el arduino
			posicion = "ON";
			largas = "OFF";
			cruce = "ON";
			datos.add(fecha);
			datos.add(hora);
			datos.add(modo);
			datos.add(luminosidad);
			datos.add(posicion);
			datos.add(cruce);
			datos.add(largas);
		}
		if(lucesEncender.equals("3")){
			anyo = calendario.get(Calendar.YEAR);
			dia = calendario.get(Calendar.DAY_OF_MONTH);
			mes = calendario.get(Calendar.MONTH) +1;
			horas = calendario.get(Calendar.HOUR_OF_DAY) ;
			minutos = calendario.get(Calendar.MINUTE);
			segundos = calendario.get(Calendar.SECOND);
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "-";//valor recibido por el arduino
			posicion = "ON";
			largas = "ON";
			cruce = "ON";
			datos.add(fecha);
			datos.add(hora);
			datos.add(modo);
			datos.add(luminosidad);
			datos.add(posicion);
			datos.add(cruce);
			datos.add(largas);
		}
		historico.setVariablesToPlot(datos);
		return datos;
	}

	public List<String> invocarArduinoAutomatico(String lucesEncender){
		List<String> datos = new ArrayList<String>();
		
		/**
		 * 1-. generar umbral a partir de la sensibilidad
		 * 2-. preguntar al arduino por la luminosidad ambiente -> devolverá la luminosidad ambiente
		 * 3-. decidir qué luz hay que encender -> enviar orden al arduino
		 * 4-. enviar a la vista los datos correspondientes ...
		 * 						- NOTA: la vista recibe los datos una vez se termina el método
		 * 5-. llamar al método cada 'reacción' segundos -> empezar en 2-.
		 */
		/*
		if (reaccion.equalsIgnoreCase("Alto")){
			treaccion=1;
		}else if (reaccion.equalsIgnoreCase("Medio")){
			treaccion=2;
		}else if (reaccion.equalsIgnoreCase("Bajo")){
			treaccion=4;
		}
		
		if (sensibilidad.equalsIgnoreCase("Alto")){
			sensibilidadTop=1000;
			sensibilidadBot=800;
		}else if (sensibilidad.equalsIgnoreCase("Medio")){
			sensibilidadTop=1000;
			sensibilidadBot=800;
		}else if (sensibilidad.equalsIgnoreCase("Bajo")){
			sensibilidadTop=1000;
			sensibilidadBot=800;
		}
		*/
		
/*
		try {
			Arduino.arduinoRXTX("COM3", 9600, evento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Arduino.sendData(lucesEncender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		return datos;
	}


}
