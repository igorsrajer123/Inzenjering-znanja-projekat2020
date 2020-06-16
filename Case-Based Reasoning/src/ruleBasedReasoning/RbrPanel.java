package ruleBasedReasoning;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
		
	//	rbrPanel.add(Box.createVerticalStrut(10));
		
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
		
		JPanel podaciPanel4 = new JPanel();
		podaciPanel4.setBackground(new Color(204,153,255));
		podaciPanel4.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel4.setPreferredSize(new Dimension(1000,80));
		podaciPanel4.setMaximumSize(new Dimension(1000,80));
		podaciPanel4.setMinimumSize(new Dimension(1000,80));
		podaciPanel4.setLayout(new BoxLayout(podaciPanel4, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel4);
		
		JPanel podaciPanel5 = new JPanel();
		podaciPanel5.setBackground(new Color(204,153,255));
		podaciPanel5.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel5.setPreferredSize(new Dimension(1000,80));
		podaciPanel5.setMaximumSize(new Dimension(1000,80));
		podaciPanel5.setMinimumSize(new Dimension(1000,80));
		podaciPanel5.setLayout(new BoxLayout(podaciPanel5, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel5);
		
		JPanel podaciPanel6 = new JPanel();
		podaciPanel6.setBackground(new Color(204,153,255));
		podaciPanel6.setBorder(BorderFactory.createLineBorder(Color.black));
		podaciPanel6.setPreferredSize(new Dimension(1000,100));
		podaciPanel6.setMaximumSize(new Dimension(1000,100));
		podaciPanel6.setMinimumSize(new Dimension(1000,100));
		podaciPanel6.setLayout(new BoxLayout(podaciPanel6, BoxLayout.X_AXIS));
		rbrPanel.add(podaciPanel6);
			
			
		//==========================================================================================
		
		JLabel ime = new JLabel("    Ime pacijenta: ");
		JTextField imeTxt = new JTextField();
		imeTxt.setPreferredSize(new Dimension(130,25));
		imeTxt.setMinimumSize(new Dimension(130,25));
		imeTxt.setMaximumSize(new Dimension(130,25));	
		
		JLabel prz = new JLabel("    Prezime pacijenta: ");
		JTextField przTxt = new JTextField();
		przTxt.setPreferredSize(new Dimension(130,25));
		przTxt.setMinimumSize(new Dimension(130,25));
		przTxt.setMaximumSize(new Dimension(130,25));	
		
		JLabel god = new JLabel("    Godine pacijenta: ");
		JTextField godTxt = new JTextField();
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
		Main.pusac = new JCheckBox();
		Main.pusac.setBackground(new Color(204,153,255));
		
		JLabel sport = new JLabel(" Bavi se sportom: ");
		Main.sportista = new JCheckBox();
		Main.sportista.setBackground(new Color(204,153,255));
		
		JLabel simp = new JLabel("    Simptomi pacijenta: ");
		Main.simpTxt2 = new JComboBox();
		Main.simpTxt2.setBackground(new Color(204,153,255));
		Main.simpTxt2.setModel(new DefaultComboBoxModel<String>(Main.simptomi2.toArray(new String[0])));
		Main.simpTxt2.setPreferredSize(new Dimension(140,25));
		Main.simpTxt2.setMinimumSize(new Dimension(140,25));
		Main.simpTxt2.setMaximumSize(new Dimension(140,25));
		
		JButton btnSimp = new JButton("Predložene bolesti>>");
		btnSimp.setBackground(new Color(204,153,255));
		btnSimp.setPreferredSize(new Dimension(155,25));
		btnSimp.setMinimumSize(new Dimension(100,25));
		btnSimp.setMaximumSize(new Dimension(155,25));
		
		combo = new JComboBox();
		combo.setBackground(new Color(204,153,255));
		combo.setPreferredSize(new Dimension(150,25));
		combo.setMinimumSize(new Dimension(150,25));
		combo.setMaximumSize(new Dimension(150,25));
		combo.setVisible(true);
		
		JLabel lek = new JLabel("    Preporučeni lekovi: ");
		JButton btnLek = new JButton(">>");
		btnLek.setBackground(new Color(204,153,255));
		btnLek.setPreferredSize(new Dimension(55,25));
		btnLek.setMinimumSize(new Dimension(55,25));
		btnLek.setMaximumSize(new Dimension(55,25));
				
		JLabel procedura = new JLabel("    Preporučene procedure: ");
		JButton btnProc = new JButton(">>");
		btnProc.setBackground(new Color(204,153,255));
		btnProc.setPreferredSize(new Dimension(55,25));
		btnProc.setMinimumSize(new Dimension(55,25));
		btnProc.setMaximumSize(new Dimension(55,25));

		comboLek = new JComboBox();
		comboLek.setBackground(new Color(204,153,255));
		comboLek.setPreferredSize(new Dimension(150,25));
		comboLek.setMinimumSize(new Dimension(150,25));
		comboLek.setMaximumSize(new Dimension(150,25));
		comboLek.setVisible(true);
		
		comboProc = new JComboBox();
		comboProc.setBackground(new Color(204,153,255));
		comboProc.setPreferredSize(new Dimension(150,25));
		comboProc.setMinimumSize(new Dimension(150,25));
		comboProc.setMaximumSize(new Dimension(150,25));
		comboProc.setVisible(true);
		
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
		podaciPanel3.add(Main.pusac);
		podaciPanel3.add(Box.createHorizontalStrut(50));
		podaciPanel3.add(sport);
		podaciPanel3.add(Box.createHorizontalStrut(10));
		podaciPanel3.add(Main.sportista);	
		podaciPanel4.add(simp);
		podaciPanel4.add(Box.createHorizontalStrut(5));
		podaciPanel4.add(Main.simpTxt2);
		podaciPanel4.add(Box.createHorizontalStrut(5));
		podaciPanel4.add(btnSimp);
		podaciPanel4.add(Box.createHorizontalStrut(5));
		podaciPanel4.add(combo);
		podaciPanel5.add(lek);
		podaciPanel5.add(Box.createHorizontalStrut(5));
		podaciPanel5.add(btnLek);
		podaciPanel5.add(Box.createHorizontalStrut(5));
		podaciPanel6.add(procedura);
		podaciPanel6.add(Box.createHorizontalStrut(5));
		podaciPanel6.add(btnProc);
		podaciPanel6.add(Box.createHorizontalStrut(5));
		podaciPanel5.add(comboLek);
		podaciPanel6.add(comboProc);
		//-------------------------------------------------------------------------------------------		
	}

}
