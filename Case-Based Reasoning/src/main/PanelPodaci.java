package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelPodaci(){
		
		//ime pacijenta---------------------------------------------------------------------------
		JPanel imePanel = new JPanel();
		imePanel.setBackground(Color.lightGray);
		imePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		imePanel.setPreferredSize(new Dimension(300,10));
		imePanel.setMaximumSize(new Dimension(300,10));
		imePanel.setMinimumSize(new Dimension(300,10));
		
		JLabel ime = new JLabel("  Ime pacijenta:         ");
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
		JLabel prezime = new JLabel("                    Prezime pacijenta:    ");
		prezime.setPreferredSize(new Dimension(95,10));
		przTxt = new JTextField();
		przTxt.setPreferredSize(new Dimension(130,25));
		przTxt.setMinimumSize(new Dimension(130,25));
		przTxt.setMaximumSize(new Dimension(130,25));		
		imePanel.add(prezime);
		imePanel.add(przTxt);
		
		JPanel podPanel = new JPanel();
		podPanel.setBackground(Color.lightGray);
		podPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		podPanel.setPreferredSize(new Dimension(300,70));
		podPanel.setMaximumSize(new Dimension(300,70));
		podPanel.setMinimumSize(new Dimension(300,70));
		
		podPanel.setLayout(new BoxLayout(podPanel, BoxLayout.X_AXIS));
		
		JLabel pol = new JLabel("  Pol pacijenta:            ");
		podPanel.add(pol);
		Main.polTxt = new JComboBox();
		Main.polTxt.setModel(new DefaultComboBoxModel<String>(Main.pol.toArray(new String[0])));
		Main.polTxt.setPreferredSize(new Dimension(100,25));
		Main.polTxt.setMinimumSize(new Dimension(100,25));
		Main.polTxt.setMaximumSize(new Dimension(100,25));
		podPanel.add(Main.polTxt);
		
		JLabel pusac = new JLabel("           Pušač:   ");
		podPanel.add(pusac);		
		Main.pusac = new JCheckBox();
		Main.pusac.setBackground(Color.LIGHT_GRAY);
		podPanel.add(Main.pusac);
		
		JLabel sport = new JLabel("           Bavi se sportom:    ");
		podPanel.add(sport);
		Main.sportista = new JCheckBox();
		Main.sportista.setBackground(Color.LIGHT_GRAY);
		podPanel.add(Main.sportista);
		
		Main.panel.add(podPanel);
		
		//godine pacijenta-------------------------------------------------------------------------
		JPanel godinePanel = new JPanel();
		godinePanel.setBackground(Color.lightGray);
		godinePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        podPanel.setPreferredSize(new Dimension(300,70));
        podPanel.setMaximumSize(new Dimension(300,30));
        podPanel.setMinimumSize(new Dimension(300,50));
		
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
