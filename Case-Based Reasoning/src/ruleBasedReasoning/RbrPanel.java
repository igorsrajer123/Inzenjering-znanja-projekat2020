package ruleBasedReasoning;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;


@SuppressWarnings("serial")
public class RbrPanel extends JPanel{
	
	public static JPanel rbrPanel;
	@SuppressWarnings("rawtypes")
	public static JComboBox combo;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox comboLek;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox comboProc;
	
	public static JPanel podaciPanel4;
	public static JPanel podaciPanel5;
	public static JPanel podaciPanel6;
	
	public static JTextField godTxt;
	public static JTextField imeTxt;
	public static JTextField przTxt;
	
	public static AddBolest bolestPanel;
	public static AddLek lekPanel;
	public static AddProcedure procPanel;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RbrPanel() {
		
		rbrPanel = new JPanel();
		rbrPanel.setVisible(false);
		rbrPanel.setLayout(new BoxLayout(rbrPanel, BoxLayout.Y_AXIS));
		rbrPanel.setBackground(Color.green);
		rbrPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		rbrPanel.setPreferredSize(new Dimension(1000,500));
		rbrPanel.setMinimumSize(new Dimension(1000,500));
		Main.frame.getContentPane().add(rbrPanel, "West");
		
		//---------------------------------------------------------------------
		//panel sa podacima		
		
		JPanel podaciPanel = new JPanel();
		podaciPanel.setBackground(new Color(204,153,255));
		podaciPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel.setPreferredSize(new Dimension(1000,80));
		podaciPanel.setMaximumSize(new Dimension(1000,80));
		podaciPanel.setMinimumSize(new Dimension(1000,80));
		podaciPanel.setLayout(new BoxLayout(podaciPanel, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel);
	
		JPanel podaciPanel1 = new JPanel();
		podaciPanel1.setBackground(new Color(204,153,255));
		podaciPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel1.setPreferredSize(new Dimension(1500,80));
		podaciPanel1.setMaximumSize(new Dimension(1500,80));
		podaciPanel1.setMinimumSize(new Dimension(1500,80));
		podaciPanel1.setLayout(new BoxLayout(podaciPanel1, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel1);
				
		JPanel podaciPanel2 = new JPanel();
		podaciPanel2.setBackground(new Color(204,153,255));
		podaciPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel2.setPreferredSize(new Dimension(1000,80));
		podaciPanel2.setMaximumSize(new Dimension(1000,80));
		podaciPanel2.setMinimumSize(new Dimension(1000,80));
		podaciPanel2.setLayout(new BoxLayout(podaciPanel2, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel2);
		
		JPanel podaciPanel3 = new JPanel();
		podaciPanel3.setBackground(new Color(204,153,255));
		podaciPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel3.setPreferredSize(new Dimension(1000,80));
		podaciPanel3.setMaximumSize(new Dimension(1000,80));
		podaciPanel3.setMinimumSize(new Dimension(1000,80));
		podaciPanel3.setLayout(new BoxLayout(podaciPanel3, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel3);
		
		bolestPanel = new AddBolest();
		lekPanel = new AddLek();
		procPanel = new AddProcedure();
		//==========================================================================================
		
		JLabel ime = new JLabel("    Ime pacijenta: ");
		imeTxt = new JTextField();
		imeTxt.setPreferredSize(new Dimension(130,25));
		imeTxt.setMinimumSize(new Dimension(130,25));
		imeTxt.setMaximumSize(new Dimension(130,25));	
		
		JLabel prz = new JLabel("    Prezime pacijenta: ");
		przTxt = new JTextField();
		przTxt.setPreferredSize(new Dimension(130,25));
		przTxt.setMinimumSize(new Dimension(130,25));
		przTxt.setMaximumSize(new Dimension(130,25));	
		
		JLabel god = new JLabel("    Godine pacijenta: ");
		godTxt = new JTextField();
		godTxt.setPreferredSize(new Dimension(130,25));
		godTxt.setMinimumSize(new Dimension(130,25));
		godTxt.setMaximumSize(new Dimension(130,25));	
		
		JLabel pol = new JLabel("    Pol pacijenta: ");
		Main.polTxt2 = new JComboBox();
		Main.polTxt2.setBackground(new Color(204,153,255));
		Main.polTxt2.setModel(new DefaultComboBoxModel<String>(Main.pol2.toArray(new String[0])));
		Main.polTxt2.setPreferredSize(new Dimension(100,25));
		Main.polTxt2.setMinimumSize(new Dimension(100,25));
		Main.polTxt2.setMaximumSize(new Dimension(100,25));
		
		JLabel pusac = new JLabel("    		Pušač: ");
		Main.pusac2 = new JCheckBox();
		Main.pusac2.setBackground(new Color(204,153,255));
		
		JLabel sport = new JLabel(" Bavi se sportom: ");
		Main.sportista2 = new JCheckBox();
		Main.sportista2.setBackground(new Color(204,153,255));
		
		podaciPanel.add(ime);
		podaciPanel.add(Box.createHorizontalStrut(30));
		podaciPanel.add(imeTxt);
		podaciPanel.add(Box.createHorizontalStrut(30));
		podaciPanel1.add(prz);
		podaciPanel1.add(Box.createHorizontalStrut(5));
		podaciPanel1.add(przTxt);
		podaciPanel2.add(god);
		podaciPanel2.add(Box.createHorizontalStrut(13));
		podaciPanel2.add(godTxt);
		podaciPanel2.add(Box.createHorizontalStrut(25));
		podaciPanel2.add(pol);
		podaciPanel2.add(Box.createHorizontalStrut(10));
		podaciPanel2.add(Main.polTxt2);	
		podaciPanel3.add(Box.createHorizontalStrut(35));
		podaciPanel3.add(pusac);
		podaciPanel3.add(Box.createHorizontalStrut(10));
		podaciPanel3.add(Main.pusac2);
		podaciPanel3.add(Box.createHorizontalStrut(50));
		podaciPanel3.add(sport);
		podaciPanel3.add(Box.createHorizontalStrut(10));
		podaciPanel3.add(Main.sportista2);	
	}
}
