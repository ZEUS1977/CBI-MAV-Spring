package online.flussibancari.cbi.gui;

import javax.swing.JFrame;

public class MAVFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -926366557290604269L;

	public  static void main(String[] args){

		JFrame frame = new JFrame("FrameDemo");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.getContentPane().add("Convertitore Excel CBI MAV", border);
		
		frame.pack();
		
		frame.setVisible(true);
	}
}
