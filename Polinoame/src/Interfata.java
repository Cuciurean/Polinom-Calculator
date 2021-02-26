import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interfata extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pol1;
	String pol2;
	
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	
	private JLabel label = new JLabel("Polinom1");
	private JLabel label1 = new JLabel("Polinom2");
	private JLabel label2 = new JLabel("Rezultat1");
	private JLabel label3 = new JLabel("Rezultat2");
	private JTextField tf = new JTextField(30);
	private JTextField tf1 = new JTextField(30);
	private JTextField tf2 = new JTextField(30);
	private JTextField tf3 = new JTextField(30);
	
	private JButton bt = new JButton("ok");
	private JButton bt1 = new JButton("ok");
	private JButton btn = new JButton("Adunare");
	private JButton btn1 = new JButton("Scadere");
	private JButton btn2 = new JButton("Inmultire");
	private JButton btn3 = new JButton("Impartire");
	private JButton btn4 = new JButton("Derivare");
	private JButton btn5 = new JButton("Integrare");
	
	public Interfata()
	{
		
		
		panel1.add(label);
		panel1.add(tf);
		panel1.add(bt);
		
		panel1.add(label1);
		panel1.add(tf1);
		panel1.add(bt1);
		
		panel.add(btn) ;
		panel.add(btn1) ;
		panel.add(btn2) ;
		panel.add(btn3) ;
		panel.add(btn4) ;
		panel.add(btn5) ;
		
		panel3.add(label2);
		panel3.add(tf2);
		panel3.add(label3);
		panel3.add(tf3);
		
		bt.addActionListener(new Listenok());
		bt1.addActionListener(new Listenok2());
		btn.addActionListener(new Listenadd());
		btn1.addActionListener(new Listenscz());
		btn5.addActionListener(new ListenIntegrare());
		btn4.addActionListener(new ListenDerivare());
		btn2.addActionListener(new ListenInmultire());
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Operatii cu polinoame");
		frame.setSize(1000,400);
		
		frame.getContentPane().add(BorderLayout.BEFORE_FIRST_LINE, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.AFTER_LAST_LINE, panel3);
		
		frame.setVisible(true);
       
	}
	
	class Listenok implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
		pol1 = tf.getText();
		Polinom p = new Polinom(pol1);
		tf.setText(p.toString());
		}
	}
	
	class Listenok2 implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
		pol1 = tf1.getText();
		Polinom p1 = new Polinom(pol1);
		tf1.setText(p1.toString());
		}
	}
	
	class Listenadd implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			pol1 = tf.getText();
			pol2 = tf1.getText();
			Polinom p1 = new Polinom(pol1);
			Polinom p2 = new Polinom(pol2);
			Polinom r1 = new Polinom(pol1);
			Polinom r2 = new Polinom(pol2);
			r1=r1.Adunare(p2);
			tf2.setText(r1.toString());
	
		}
	}
	
	class Listenscz implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			pol1 = tf.getText();
			pol2 = tf1.getText();
			Polinom p1 = new Polinom(pol1);
			Polinom p2 = new Polinom(pol2);
			Polinom r1 = new Polinom(pol1);
			Polinom r2 = new Polinom(pol2);
			r1=r1.Scadere(p2);
			tf2.setText(r1.toString());
	
	
		}
	}
	
	class ListenInmultire implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			pol1 = tf.getText();
			pol2 = tf1.getText();
			Polinom p1 = new Polinom(pol1);
			Polinom p2 = new Polinom(pol2);
			Polinom r1 = new Polinom(pol1);
			Polinom r2 = new Polinom(pol2);
			r1=r1.Inmultire(p2);
			tf2.setText(r1.toString());
	
		}
	}
	
	class ListenIntegrare implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
		pol1 = tf.getText();
		Polinom r1 = new Polinom(pol1);
		r1=r1.Integrare();
		tf2.setText(r1.toString());
		}
	}
	
	class ListenDerivare implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
		pol1 = tf.getText();
		Polinom r2 = new Polinom(pol1);
		r2=r2.Derivare();
		tf2.setText(r2.toString());
		}
	}
	
}
