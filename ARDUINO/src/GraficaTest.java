import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraficaTest extends JFrame{
	public GraficaTest(List<Coordenadas> coordenadas){
		Graficas GraficaPrueba= new Graficas("Luminosidad vs Tiempo");
		int ano[] = new int[coordenadas.size()];
		int mes[] = new int[coordenadas.size()];
		int dia[] = new int[coordenadas.size()];
		int hora[] = new int[coordenadas.size()];
		int min[] = new int[coordenadas.size()];
		int sec[] = new int[coordenadas.size()];
		int mili[] = new int[coordenadas.size()];
		double y[] = new double[coordenadas.size()];
		for(int i=0; i<coordenadas.size(); i++){
			ano[i] = coordenadas.get(i).getAno();
			mes[i] = coordenadas.get(i).getMes();
			dia[i] = coordenadas.get(i).getDia();
			hora[i] = coordenadas.get(i).getHora();
			min[i] = coordenadas.get(i).getMinutos();
			sec[i] = coordenadas.get(i).getSegundos();
			mili[i] = coordenadas.get(i).getMili();
			y[i] = Double.parseDouble(coordenadas.get(i).getLuminosidad());
		}
		
		// double x[]={1,2,3,4,5,6,7,8};
		//  double y[]={10,20,30,10,50,60,70,80};
		GraficaPrueba.agregarGrafica("Tiempo vs Luminosidad", y, ano, mes, dia, hora, min, sec, mili, coordenadas.get(0).getUmbralSuperior(), coordenadas.get(0).getUmbralInferior());
		JPanel panel=GraficaPrueba.obtenerPanel();
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(panel);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new GraficaTest(null);

	}

}