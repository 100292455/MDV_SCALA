import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.panamahitek.PanamaHitek_Arduino;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
public class Controlador {

	private String luces;

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

	public void setLuces(String luces) {
		this.luces = luces;
	}

	/******* LLAMAR AL ARDUINO Y ROLLOS *******/
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
			luminosidad = "-";
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
			luminosidad = "-";
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
			luminosidad = "-";
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
			luminosidad = "-";
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
		return datos;
	}

	public void invocarArduinoAutomatico(String lucesEncender){
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
	}

	/*** MODIFICAR LA INTERFAZ ****/

}
