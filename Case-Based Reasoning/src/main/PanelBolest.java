package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cbr.DiseaseApplication;

public class PanelBolest extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox combo;
	public static JPanel simptomiPanel;
	public static JPanel bolestPanel;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PanelBolest(){
		
		//simptom pacijenta----------------------------------------------------------------------
		simptomiPanel = new JPanel();
		simptomiPanel.setBackground(Color.lightGray);
		simptomiPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		simptomiPanel.setPreferredSize(new Dimension(300,70));
		simptomiPanel.setMaximumSize(new Dimension(300,70));
		simptomiPanel.setMinimumSize(new Dimension(300,70));
		
		JLabel simp = new JLabel("  Simptomi pacijenta: ");
		simp.setPreferredSize(new Dimension(95,10));
		Main.simpTxt = new JComboBox();
		Main.simpTxt.setBackground(Color.LIGHT_GRAY);
		Main.simpTxt.setModel(new DefaultComboBoxModel<String>(Main.simptomi.toArray(new String[0])));
		Main.simpTxt.setPreferredSize(new Dimension(140,25));
		Main.simpTxt.setMinimumSize(new Dimension(140,25));
		Main.simpTxt.setMaximumSize(new Dimension(140,25));
		
		final JButton btnSimp = new JButton("Predložene bolesti>>");
		btnSimp.setBackground(Color.LIGHT_GRAY);
		btnSimp.setPreferredSize(new Dimension(155,25));
		btnSimp.setMinimumSize(new Dimension(100,25));
		btnSimp.setMaximumSize(new Dimension(155,25));
						
		combo = new JComboBox();
		combo.setBackground(Color.LIGHT_GRAY);
		combo.setPreferredSize(new Dimension(160,25));
		combo.setMinimumSize(new Dimension(160,25));
		combo.setMaximumSize(new Dimension(160,25));
		combo.setVisible(false);
		
		JLabel labela = new JLabel("Unesite ispravne simptome!");
		labela.setForeground(Color.RED);
		labela.setVisible(false);
		
		simptomiPanel.setLayout(new BoxLayout(simptomiPanel, BoxLayout.X_AXIS));
		simptomiPanel.add(simp);
		simptomiPanel.add(Main.simpTxt);
		simptomiPanel.add(Box.createHorizontalStrut(5));
		simptomiPanel.add(btnSimp);
		simptomiPanel.add(Box.createHorizontalStrut(5));
		simptomiPanel.add(combo);
		simptomiPanel.add(labela);
		Main.panel.add(simptomiPanel);
		
		//bolest pacijenta--------------------------------------------------------------------------
		bolestPanel = new JPanel();
		bolestPanel.setBackground(Color.lightGray);
		bolestPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bolestPanel.setPreferredSize(new Dimension(300,70));
		bolestPanel.setMaximumSize(new Dimension(300,30));
		bolestPanel.setMinimumSize(new Dimension(300,50));
		
		JLabel bol = new JLabel("  Bolest pacijenta:      ");
		bol.setPreferredSize(new Dimension(95,10));
		Main.bolTxt = new JTextField();
		Main.bolTxt.setPreferredSize(new Dimension(160,25));
		Main.bolTxt.setMinimumSize(new Dimension(160,25));
		Main.bolTxt.setMaximumSize(new Dimension(160,25));
		
		bolestPanel.setLayout(new BoxLayout(bolestPanel, BoxLayout.X_AXIS));
		bolestPanel.add(bol);
		bolestPanel.add(Main.bolTxt);
		Main.panel.add(bolestPanel);
		
		btnSimp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(Main.simpTxt.getSelectedItem()=="" || Main.godTxt.getText().isEmpty() || Main.polTxt.getSelectedItem() == ""){
					combo.setVisible(false);
					Main.bolesti.clear();
					Main.bolTxt.setText(null);
					JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
				}
				else {
					Main.bolesti.clear();
					
					DiseaseApplication disease = new DiseaseApplication();
					
					if(Main.pusac.isSelected() && Main.sportista.isSelected())
					disease.runDiseaseApp("",Main.simpTxt.getSelectedItem().toString(), Integer.parseInt(Main.godTxt.getText()),
								Main.polTxt.getSelectedItem().toString(), "da", "da");
					
					else if(!Main.pusac.isSelected() && !Main.sportista.isSelected())
						disease.runDiseaseApp("",Main.simpTxt.getSelectedItem().toString(), Integer.parseInt(Main.godTxt.getText()),
								Main.polTxt.getSelectedItem().toString(), "ne", "ne");
					
					else if(Main.pusac.isSelected() && !Main.sportista.isSelected())
						disease.runDiseaseApp("",Main.simpTxt.getSelectedItem().toString(), Integer.parseInt(Main.godTxt.getText()),
								Main.polTxt.getSelectedItem().toString(), "da", "ne");
					
					else if(!Main.pusac.isSelected() && Main.sportista.isSelected())
						disease.runDiseaseApp("",Main.simpTxt.getSelectedItem().toString(), Integer.parseInt(Main.godTxt.getText()),
								Main.polTxt.getSelectedItem().toString(), "ne", "da");
					
					for(String s : DiseaseApplication.aaa){			
						String[] ss = s.split(",");
						String bolest11 = ss[0];
						String[] visak = bolest11.split("=");
						String bolestZarez = visak[1];
						String b = bolestZarez.replace(",","");

						if(b.contains("asthma"))
							b = "Asthma";
																
						if(b.contains("pneumonia"))
							b = "Pneumonia";
							
						if(b.contains("acute bronchitis"))
							b = "Acute bronchitis";
										
						if(b.contains("chronic obstructive pulmonary disease"))
							b = "COPD";
						
						if(b.contains("pulmonary fibrosis"))
							b = "Pulmonary fibrosis";
						
						if(b.contains("abscess of the lung"))
							b = "Abscess of the lung";
						
						if(b.contains("pulmonary hypertension"))
							b = "Pulmonary hypertension";
						
						if(b.contains("emphysema")) {
							b = "Emphysema";
						}
						
						if(b.contains("pulmonary embolism")) {
							b = "Pulmonary embolism";
						}
						
						if(b.contains("sarcoidosis")) {
							b = "Sarcoidosis";
						}
																
						if(!Main.bolesti.contains(b)){	
							Main.bolesti.add(b);
						}
						else {
							continue;
						}							
					}
					
					combo.setModel(new DefaultComboBoxModel<String>(Main.bolesti.toArray(new String[0])));
					combo.setVisible(true);
					
					Main.bolTxt.setText(combo.getSelectedItem().toString());
				}					
			}
		});

		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = combo.getSelectedItem().toString();
				Main.bolTxt.setText(text);
			}
		});
	}
}
