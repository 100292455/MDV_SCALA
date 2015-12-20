import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JTable;

import com.panamahitek.PanamaHitek_Arduino;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
public class Controlador {

	private String luces;
	private String sensibilidad;
	int sensibilidadTop;
	int sensibilidadBot;
	private String reaccion;
	int treaccion;
	PanamaHitek_Arduino Arduino;


	/***** DATOS ******/
	String anyo;
	String dia;
	String mes;
	String horas ;
	String minutos ;
	String segundos ;
	String mili;
	private String fecha;
	private String hora;
	private String modo;
	private String luminosidad;
	private String posicion;
	private String largas;
	private String cruce;
	/*************/

	/*private PanamaHitek_Arduino Arduino = new PanamaHitek_Arduino();
	SerialPortEventListener evento= new SerialPortEventListener(){
		@Override
		public void serialEvent(SerialPortEvent spe){
		}
	};*/

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
		
		if (sensibilidad.equalsIgnoreCase("Alto")){
			sensibilidadTop=800;
			sensibilidadBot=750;
		}else if (sensibilidad.equalsIgnoreCase("Medio")){
			sensibilidadTop=500;
			sensibilidadBot=450;
		}else if (sensibilidad.equalsIgnoreCase("Bajo")){
			sensibilidadTop=300;
			sensibilidadBot=250;
		}
		
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
			Calendar calendario = Calendar.getInstance();

			anyo = Integer.toString(calendario.get(Calendar.YEAR));
			dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
			mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
			horas = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) ;
			minutos = Integer.toString(calendario.get(Calendar.MINUTE));
			segundos = Integer.toString(calendario.get(Calendar.SECOND));
			mili = Integer.toString(calendario.get(Calendar.MILLISECOND));
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "10";//valor recibido por el arduino
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
			datos.add(anyo);
			datos.add(mes);
			datos.add(dia);
			datos.add(horas);
			datos.add(minutos);
			datos.add(segundos);
			datos.add(mili);
			datos.add(Integer.toString(sensibilidadTop));
			datos.add(Integer.toString(sensibilidadBot));
			
		}
		if(lucesEncender.equals("1")){
			Calendar calendario = Calendar.getInstance();

			anyo = Integer.toString(calendario.get(Calendar.YEAR));
			dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
			mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
			horas = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) ;
			minutos = Integer.toString(calendario.get(Calendar.MINUTE));
			segundos = Integer.toString(calendario.get(Calendar.SECOND));
			mili = Integer.toString(calendario.get(Calendar.MILLISECOND));
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "20";//valor recibido por el arduino
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
			datos.add(anyo);
			datos.add(mes);
			datos.add(dia);
			datos.add(horas);
			datos.add(minutos);
			datos.add(segundos);
			datos.add(mili);
			datos.add(Integer.toString(sensibilidadTop));
			datos.add(Integer.toString(sensibilidadBot));
		}
		if(lucesEncender.equals("2")){
			Calendar calendario = Calendar.getInstance();

			anyo = Integer.toString(calendario.get(Calendar.YEAR));
			dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
			mes = Integer.toString(calendario.get(Calendar.MONTH)+1) ;
			horas = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) ;
			minutos = Integer.toString(calendario.get(Calendar.MINUTE));
			segundos = Integer.toString(calendario.get(Calendar.SECOND));
			mili = Integer.toString(calendario.get(Calendar.MILLISECOND));
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "30";//valor recibido por el arduino
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
			datos.add(anyo);
			datos.add(mes);
			datos.add(dia);
			datos.add(horas);
			datos.add(minutos);
			datos.add(segundos);
			datos.add(mili);
			datos.add(Integer.toString(sensibilidadTop));
			datos.add(Integer.toString(sensibilidadBot));
		}
		if(lucesEncender.equals("3")){
			Calendar calendario = Calendar.getInstance();

			anyo = Integer.toString(calendario.get(Calendar.YEAR));
			dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
			mes = Integer.toString(calendario.get(Calendar.MONTH)+1) ;
			horas = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) ;
			minutos = Integer.toString(calendario.get(Calendar.MINUTE));
			segundos = Integer.toString(calendario.get(Calendar.SECOND));
			mili = Integer.toString(calendario.get(Calendar.MILLISECOND));
			fecha = anyo+"/"+mes+"/"+dia;
			hora = horas+":"+minutos+":"+segundos;
			modo = "MANUAL";
			luminosidad = "40";//valor recibido por el arduino
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
			datos.add(anyo);
			datos.add(mes);
			datos.add(dia);
			datos.add(horas);
			datos.add(minutos);
			datos.add(segundos);
			datos.add(mili);
			datos.add(Integer.toString(sensibilidadTop));
			datos.add(Integer.toString(sensibilidadBot));
		}
		return datos;
	}

	public List<String> invocarArduinoAutomatico(String lucesEncender){
		List<String> datos = new ArrayList<String>();

		Calendar calendario = Calendar.getInstance();

		anyo = Integer.toString(calendario.get(Calendar.YEAR));
		dia = Integer.toString(calendario.get(Calendar.DAY_OF_MONTH));
		mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
		horas = Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) ;
		minutos = Integer.toString(calendario.get(Calendar.MINUTE));
		segundos = Integer.toString(calendario.get(Calendar.SECOND));
		mili = Integer.toString(calendario.get(Calendar.MILLISECOND));
		fecha = anyo+"/"+mes+"/"+dia;
		hora = horas+":"+minutos+":"+segundos;
		modo = "AUTOMATICO";

		/**
		 * 1-. generar umbral a partir de la sensibilidad
		 * 2-. preguntar al arduino por la luminosidad ambiente -> devolverá la luminosidad ambiente
		 * 3-. decidir qué luz hay que encender -> enviar orden al arduino
		 * 4-. enviar a la vista los datos correspondientes ...
		 * 						- NOTA: la vista recibe los datos una vez se termina el método
		 * 5-. llamar al método cada 'reacción' segundos -> empezar en 2-.
		 */

		/*if (reaccion.equalsIgnoreCase("Alto")){
		treaccion=1;
	}else if (reaccion.equalsIgnoreCase("Medio")){
		treaccion=2;
	}else if (reaccion.equalsIgnoreCase("Bajo")){
		treaccion=4;
	}*/

		int luminosidadArduino=0;
		try {
			luminosidadArduino= Arduino.receiveData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sensibilidad.equalsIgnoreCase("Alto")){
			sensibilidadTop=800;
			sensibilidadBot=750;
		}else if (sensibilidad.equalsIgnoreCase("Medio")){
			sensibilidadTop=500;
			sensibilidadBot=450;
		}else if (sensibilidad.equalsIgnoreCase("Bajo")){
			sensibilidadTop=300;
			sensibilidadBot=250;
		}

		if(luminosidadArduino >= sensibilidadTop){
			posicion = "ON";
			largas = "OFF";
			cruce = "ON";
		}
		else if(luminosidadArduino >= sensibilidadTop && luminosidadArduino < sensibilidadBot){
			posicion = "ON";
			largas = "OFF";
			cruce = "ON";
		}
		else if(luminosidadArduino <= sensibilidadBot){
			posicion = "ON";
			largas = "OFF";
			cruce = "OFF";
		}
		
		
		datos.add(fecha);
		datos.add(hora);
		datos.add(modo);
		datos.add(Integer.toString(luminosidadArduino));
		datos.add(posicion);
		datos.add(cruce);
		datos.add(largas);
		datos.add(anyo);
		datos.add(mes);
		datos.add(dia);
		datos.add(horas);
		datos.add(minutos);
		datos.add(segundos);
		datos.add(mili);
		datos.add(Integer.toString(sensibilidadTop));
		datos.add(Integer.toString(sensibilidadBot));

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