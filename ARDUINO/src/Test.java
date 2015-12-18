import java.awt.EventQueue;


public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frmControl.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		
		
		
	}
}
