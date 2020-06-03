package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPodaci extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JTextField imeTxt;
	
	public static JTextField przTxt;

	public PanelPodaci(){
		//ime pacijenta---------------------------------------------------------------------------
		JPanel imePanel = new JPanel();
		imePanel.setBackground(Color.lightGray);
		imePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		imePanel.setPreferredSize(new Dimension(300,10));
		imePanel.setMaximumSize(new Dimension(300,10));
		imePanel.setMinimumSize(new Dimension(300,10));
		
		JLabel ime = new JLabel("  Ime pacijenta:            ");
		ime.setPreferredSize(new Dimension(95,10));
		imeTxt = new JTextField();
		imeTxt.setPreferredSize(new Dimension(130,10));
		imeTxt.setMinimumSize(new Dimension(130,20));
		imeTxt.setMaximumSize(new Dimension(130,25));
		
		imePanel.setLayout(new BoxLayout(imePanel, BoxLayout.X_AXIS));
		imePanel.add(ime);
		imePanel.add(imeTxt);	
		Main.panel.add(imePanel);
		
	//prezime pacijenta------------------------------------------------------------------------
		JPanel prezimePanel = new JPanel();
		prezimePanel.setBackground(Color.lightGray);
		prezimePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		prezimePanel.setPreferredSize(new Dimension(300,70));
		prezimePanel.setMaximumSize(new Dimension(300,70));
		prezimePanel.setMinimumSize(new Dimension(300,70));
		
		JLabel prezime = new JLabel("  Prezime pacijenta:    ");
		prezime.setPreferredSize(new Dimension(95,10));
		przTxt = new JTextField();
		przTxt.setPreferredSize(new Dimension(130,25));
		przTxt.setMinimumSize(new Dimension(130,25));
		przTxt.setMaximumSize(new Dimension(130,25));
		
		prezimePanel.setLayout(new BoxLayout(prezimePanel, BoxLayout.X_AXIS));
		prezimePanel.add(prezime);
		prezimePanel.add(przTxt);
		Main.panel.add(prezimePanel);
		
	//godine pacijenta-------------------------------------------------------------------------
		JPanel godinePanel = new JPanel();
		godinePanel.setBackground(Color.lightGray);
		godinePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		prezimePanel.setPreferredSize(new Dimension(300,70));
		prezimePanel.setMaximumSize(new Dimension(300,30));
		prezimePanel.setMinimumSize(new Dimension(300,50));
		
		JLabel god = new JLabel("  Godine pacijenta:      ");
		god.setPreferredSize(new Dimension(130,10));
		Main.godTxt = new JTextField();
		Main.godTxt.setPreferredSize(new Dimension(130,25));
		Main.godTxt.setMinimumSize(new Dimension(130,25));
		Main.godTxt.setMaximumSize(new Dimension(130,25));
		
		godinePanel.setLayout(new BoxLayout(godinePanel, BoxLayout.X_AXIS));
		godinePanel.add(god);
		godinePanel.add(Main.godTxt);
		Main.panel.add(godinePanel);
	}
}
