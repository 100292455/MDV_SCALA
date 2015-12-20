
public class Coordenadas {
	
	public Coordenadas() {
		super();
	}

	private int ano;
	private int mes;
	private int dia;
	private int hora; 
	private int minutos;
	private int segundos;
	private int milisegundos;
	private double umbralSuperior;

	public void setUmbralInferior(double umbralInferior) {
		this.umbralInferior = umbralInferior;
	}

	private double umbralInferior;

	private String luminosidad;
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getMili() {
		return segundos;
	}

	public void setMili(int mili) {
		this.milisegundos = mili;
	}
	
	public String getLuminosidad() {
		return luminosidad;
	}

	public void setLuminosidad(String luminosidad) {
		this.luminosidad = luminosidad;
	}
	
	public double getUmbralSuperior() {
		return umbralSuperior;
	}

	public void setUmbralSuperior(double umbralSuperior) {
		this.umbralSuperior = umbralSuperior;
	}

	public double getUmbralInferior() {
		return umbralInferior;
	}
	
}
