import java.util.Calendar;
import java.util.Date;
import com.panamahitek.PanamaHitek_Arduino;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
public class Controlador {

private String luces;

//Vista vista = new Vista();

/***** DATOS ******/
private Calendar calendario;
private String fecha;
private String hora;
private String modo;
private String luminosidad;
private String posicion;
private String largas;
private String cruce;
/*************/

private PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();
SerialPortEventListener evento= new SerialPortEventListener(){
	@Override
	public void serialEvent(SerialPortEvent spe){
	}
};

public String getLuces() {
	return luces;
}

public void setLuces(String luces) {
	this.luces = luces;
}

/******* LLAMAR AL ARDUINO Y ROLLOS *******/
public void invocarArduinoManual(String lucesEncender){
	
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
	
	int anyo = calendario.YEAR;
	int dia = calendario.DAY_OF_MONTH;
	int mes = calendario.MONTH;
	int horas = calendario.HOUR + 1;
	int minutos = calendario.MINUTE;
	int segundos = calendario.SECOND;
	
	fecha = anyo+"/"+mes+"/"+dia;
	hora = horas+":"+minutos+":"+segundos;
	modo = "MANUAL";
	luminosidad = "-";
	
	if(lucesEncender.equals("0")){
		posicion = "OFF";
		largas = "OFF";
		cruce = "OFF";
		vista.setFecha(fecha);
	}
}

public void invocarArduinoAutomatico(String lucesEncender){
	
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
}
/*** MODIFICAR LA INTERFAZ ****/

}
