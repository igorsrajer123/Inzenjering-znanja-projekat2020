package ruleBasedReasoning;

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

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;

import main.Main;

@SuppressWarnings("serial")
public class AddBolest extends JPanel{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddBolest() {
		
		RbrPanel.podaciPanel4 = new JPanel();
		RbrPanel.podaciPanel4.setBackground(new Color(204,153,255));
		RbrPanel.podaciPanel4.setBorder(BorderFactory.createLineBorder(Color.black));
		RbrPanel.podaciPanel4.setPreferredSize(new Dimension(1000,80));
		RbrPanel.podaciPanel4.setMaximumSize(new Dimension(1000,80));
		RbrPanel.podaciPanel4.setMinimumSize(new Dimension(1000,80));
		RbrPanel.podaciPanel4.setLayout(new BoxLayout(RbrPanel.podaciPanel4, BoxLayout.X_AXIS));
		RbrPanel.rbrPanel.add(RbrPanel.podaciPanel4);
		
		JLabel simp = new JLabel("    Simptomi pacijenta: ");
		simp.setPreferredSize(new Dimension(127,25));
		simp.setMinimumSize(new Dimension(127,25));
		simp.setMaximumSize(new Dimension(127,25));
		
		Main.simpTxt2 = new JComboBox();
		Main.simpTxt2.setBackground(new Color(204,153,255));
		Main.simpTxt2.setModel(new DefaultComboBoxModel<String>(Main.simptomi2.toArray(new String[0])));
		Main.simpTxt2.setPreferredSize(new Dimension(133,25));
		Main.simpTxt2.setMinimumSize(new Dimension(133,25));
		Main.simpTxt2.setMaximumSize(new Dimension(133,25));
		
		JButton btnSimp = new JButton("Predložene bolesti>>");
		btnSimp.setBackground(new Color(204,153,255));
		btnSimp.setPreferredSize(new Dimension(153,25));
		btnSimp.setMinimumSize(new Dimension(153,25));
		btnSimp.setMaximumSize(new Dimension(153,25));
		
		RbrPanel.combo = new JComboBox();
		RbrPanel.combo.setBackground(new Color(204,153,255));
		RbrPanel.combo.setPreferredSize(new Dimension(150,25));
		RbrPanel.combo.setMinimumSize(new Dimension(150,25));
		RbrPanel.combo.setMaximumSize(new Dimension(150,25));
		RbrPanel.combo.setVisible(false);
		
		RbrPanel.podaciPanel4.add(simp);
		RbrPanel.podaciPanel4.add(Box.createHorizontalStrut(5));
		RbrPanel.podaciPanel4.add(Main.simpTxt2);
		RbrPanel.podaciPanel4.add(Box.createHorizontalStrut(2));
		RbrPanel.podaciPanel4.add(btnSimp);
		RbrPanel.podaciPanel4.add(Box.createHorizontalStrut(5));
		RbrPanel.podaciPanel4.add(RbrPanel.combo);
		
		//=================================================================================================================
		//Dodavanje bolesti------------------------------------------------------------------------------------------------
			
			btnSimp.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					if(Main.polTxt2.getSelectedItem()=="" || RbrPanel.godTxt.getText().isEmpty() || Main.simpTxt2.getSelectedItem()== "") {
						RbrPanel.combo.setVisible(false);
						Main.bolesti2.clear();
						JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
					}else {
						
						Main.bolesti2.clear();
						
						JIPEngine engine = new JIPEngine();
						
						engine.consultFile("/rbr/lekovi.pl");
						
						String s = Main.simpTxt2.getSelectedItem().toString();
						String prosledjujem = "";
						
						if(s.equals("Cough")) 
							prosledjujem = "cough";
						else if(s.equals("Sore throat")) 
							prosledjujem = "sore_throat";
						else if(s.equals("Difficulty breathing")) 
							prosledjujem = "difficulty_breathing";
						else if(s.equals("Shortness of breath")) 
							prosledjujem = "shortness_of_breath";
						else if(s.equals("Coryza")) 
							prosledjujem = "coryza";
						else if(s.equals("Sharp chest pain")) 
							prosledjujem = "sharp_chest_pain";
						else if(s.equals("Nasal congestion")) 
							prosledjujem = "nasal_congestion";
						else if(s.equals("Coughing up sputum")) 
							prosledjujem = "coughing_up_sputum";
						else if(s.equals("Headache")) 
							prosledjujem = "headache";
						else if(s.equals("Chest tightness"))
							prosledjujem = "chest_tightness";
						else if(s.equals("Fever"))
							prosledjujem = "fever";
						
						JIPQuery query = engine.openSynchronousQuery("verovatnoca_za_dijagnozu(" + prosledjujem +",L)");
						
						JIPTerm solution;
						while ((solution = query.nextSolution()) != null) {
							String solution1 = solution.toString();	
							String solution2 = solution1.replace("(", ")");
							String solution3 = solution2.replace(")"," ");
							String solution4 = solution3.replace("[]", "'.'");
							String solution5 = solution4.replace("'.'", " ");
							String[] delovi = solution5.split(",");
							String prva = delovi[26];
							String druga = delovi[23];
							String treca = delovi[20];
							String p1 = delovi[25];
							String p2 = delovi[22];
							String p3 = delovi[19];
							String proc1 = p1.replace(" ", "");
							String proc2 = p2.replace(" ", "");
							String proc3 = p3.replace(" ", "");
								
								if(prva.contains("asthma"))
									prva = "Asthma";
																		
								if(prva.contains("pneumonia"))
									prva = "Pneumonia";
									
								if(prva.contains("acute_bronchitis"))
									prva = "Acute bronchitis";
												
								if(prva.contains("chronic_obstructive_pulmonary_disease"))
									prva = "COPD";
								
								if(prva.contains("pulmonary_fibrosis"))
									prva = "Pulmonary fibrosis";
								
								if(prva.contains("abscess_of_the_lung"))
									prva = "Abscess of the lung";
								
								if(prva.contains("pulmonary_hypertension"))
									prva = "Pulmonary hypertension";
								
								if(prva.contains("emphysema")) {
									prva = "Emphysema";
								}
								
								if(prva.contains("pulmonary_embolism")) {
									prva = "Pulmonary embolism";
								}
								
								if(prva.contains("sarcoidosis")) {
									prva = "Sarcoidosis";
								}
								
						//------------------------------
								
								if(druga.contains("asthma"))
									druga = "Asthma";
																		
								if(druga.contains("pneumonia"))
									druga = "Pneumonia";
									
								if(druga.contains("acute_bronchitis"))
									druga = "Acute bronchitis";
												
								if(druga.contains("chronic_obstructive_pulmonary_disease"))
									druga = "COPD";
								
								if(druga.contains("pulmonary_fibrosis"))
									druga = "Pulmonary fibrosis";
								
								if(druga.contains("abscess_of_the_lung"))
									druga = "Abscess of the lung";
								
								if(druga.contains("pulmonary_hypertension"))
									druga = "Pulmonary hypertension";
								
								if(druga.contains("emphysema")) {
									druga = "Emphysema";
								}
								
								if(druga.contains("pulmonary_embolism")) {
									druga = "Pulmonary embolism";
								}
								
								if(druga.contains("sarcoidosis")) {
									druga = "Sarcoidosis";
								}
								//--------------------------------------------
							
								if(treca.contains("asthma"))
									treca = "Asthma";
																		
								if(treca.contains("pneumonia"))
									treca = "Pneumonia";
									
								if(treca.contains("acute_bronchitis"))
									treca = "Acute bronchitis";
												
								if(treca.contains("chronic_obstructive_pulmonary_disease"))
									treca = "COPD";
								
								if(treca.contains("pulmonary_fibrosis"))
									treca = "Pulmonary fibrosis";
								
								if(treca.contains("abscess_of_the_lung"))
									treca = "Abscess of the lung";
								
								if(treca.contains("pulmonary_hypertension"))
									treca = "Pulmonary hypertension";
								
								if(treca.contains("emphysema")) {
									treca = "Emphysema";
								}
								
								if(treca.contains("pulmonary_embolism")) {
									treca = "Pulmonary embolism";
								}
								
								if(treca.contains("sarcoidosis")) {
									treca = "Sarcoidosis";
								}
								
							Main.bolesti2.add(prva);
							Main.bolesti2.add(druga);
							Main.bolesti2.add(treca);
							
							int p1I = Integer.parseInt(proc1);
							int p2I = Integer.parseInt(proc2);
							int p3I = Integer.parseInt(proc3);
							
								
								if(p3I < 3) 
									Main.bolesti2.remove(treca);
															
								if(p2I <3)
									Main.bolesti2.remove(druga);
								
								if(p1I < 3)
									Main.bolesti2.remove(prva);
						}
											
						RbrPanel.combo.setModel(new DefaultComboBoxModel<String>(Main.bolesti2.toArray(new String[0])));
						RbrPanel.combo.setVisible(true);					
					}
				}
			});
	}
}
