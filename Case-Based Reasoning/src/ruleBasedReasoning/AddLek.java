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
public class AddLek extends JPanel{
	
	@SuppressWarnings("rawtypes")
	public AddLek() {
		
		
		RbrPanel.podaciPanel5 = new JPanel();
		RbrPanel.podaciPanel5.setBackground(new Color(204,153,255));
		RbrPanel.podaciPanel5.setBorder(BorderFactory.createLineBorder(Color.black));
		RbrPanel.podaciPanel5.setPreferredSize(new Dimension(1000,80));
		RbrPanel.podaciPanel5.setMaximumSize(new Dimension(1000,80));
		RbrPanel.podaciPanel5.setMinimumSize(new Dimension(1000,80));
		RbrPanel.podaciPanel5.setLayout(new BoxLayout(RbrPanel.podaciPanel5, BoxLayout.X_AXIS));
		RbrPanel.rbrPanel.add(RbrPanel.podaciPanel5);
		
		JLabel lek = new JLabel("    Preporučeni lekovi: ");
		JButton btnLek = new JButton(">>");
		btnLek.setBackground(new Color(204,153,255));
		btnLek.setPreferredSize(new Dimension(55,25));
		btnLek.setMinimumSize(new Dimension(55,25));
		btnLek.setMaximumSize(new Dimension(55,25));
		
		RbrPanel.comboLek = new JComboBox();
		RbrPanel.comboLek.setBackground(new Color(204,153,255));
		RbrPanel.comboLek.setPreferredSize(new Dimension(150,25));
		RbrPanel.comboLek.setMinimumSize(new Dimension(150,25));
		RbrPanel.comboLek.setMaximumSize(new Dimension(150,25));
		RbrPanel.comboLek.setVisible(false);
		
		RbrPanel.podaciPanel5.add(lek);
		RbrPanel.podaciPanel5.add(Box.createHorizontalStrut(5));
		RbrPanel.podaciPanel5.add(btnLek);
		RbrPanel.podaciPanel5.add(Box.createHorizontalStrut(5));
		RbrPanel.podaciPanel5.add(RbrPanel.comboLek);
		//============================================================================================================================
		//Dodavanje novog leka--------------------------------------------------------------------------------------------------------
			btnLek.addActionListener(new ActionListener() {
				
				@SuppressWarnings("unchecked")
				@Override
				public void actionPerformed(ActionEvent e) {

					if(RbrPanel.godTxt.getText().isEmpty() || Main.polTxt2.getSelectedItem() == ""
									|| Main.simpTxt2.getSelectedItem() == "" || RbrPanel.combo.isVisible() == false) {
						
						RbrPanel.comboLek.setVisible(false);
						JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
						Main.lekovi2.clear();
					}else {
						Main.lekovi2.clear();
						
						JIPEngine engine = new JIPEngine();
						
						engine.consultFile("/rbr/lekovi.pl");
						
						String s1 = RbrPanel.combo.getSelectedItem().toString();
						String prosledjujem2 = "";
						
						if(s1.equals("Asthma"))
							prosledjujem2 = "asthma";
						if(s1.equals("Pneumonia"))
							prosledjujem2 = "pneumonia";
						if(s1.equals("Acute bronchitis"))
							prosledjujem2 = "acute_bronchitis";
						if(s1.equals("COPD"))
							prosledjujem2 = "chronic_obstructive_pulmonary_disease";
						if(s1.equals("Pulmonary fibrosis"))
							prosledjujem2 = "pulmonary_fibrosis";
						if(s1.equals("Abscess of the lung"))
							prosledjujem2 = "abscess_of_the_lung";
						if(s1.equals("Pulmonary hypertension"))
							prosledjujem2 = "pulmonary_hypertension";
						if(s1.equals("Emphysema"))
							prosledjujem2 = "emphysema";
						if(s1.equals("Pulmonary embolism"))
							prosledjujem2 = "pulmonary_embolism";
						if(s1.equals("Sarcoidosis"))
							prosledjujem2 = "sarcoidosis";
						
						JIPQuery query = engine.openSynchronousQuery("medications_sorted(" + prosledjujem2 +",L)");
						
						JIPTerm solution;
						while ((solution = query.nextSolution()) != null) {
							String solution1 = solution.toString();
							String solution2 = solution1.replace("(", ")");
							String solution3 = solution2.replace("[]",")");
							String solution4 = solution3.replace(")"," ");
							String solution5 = solution4.replace("'.'", "");
							String solution6 = solution5.replace(" ", "");
							String[] parts = solution6.split(",");
							String lek1 = parts[17];
							String lek2 = parts[14];
							String lek3 = parts[11];
						
							if(lek1.contains("albuterol"))
								lek1 = "Albuterol";
							
							if(lek1.contains("prednisone"))
								lek1 = "Prednisone";
						
							if(lek1.contains("combivent"))
								lek1 = "Combivent";
							
							if(lek1.contains("guaifenesin"))
								lek1 = "Guaifenesin";
							
							if(lek1.contains("azithromycin"))
								lek1 = "Azithromycin";
							
							if(lek1.contains("meropenem"))
								lek1 = "Meropenem";
							
							if(lek1.contains("oxygen"))
								lek1 = "Oxygen";
							
							if(lek1.contains("furosemide"))
								lek1 = "Furosemide";
							
							if(lek1.contains("tiotropium"))
								lek1 = "Tiotropium";
						
							if(lek1.contains("acetylcysteine"))
								lek1 = "Acetylcysteine";
							
							if(lek1.contains("warfarin"))
								lek1 = "Warfarin";
							
							if(lek1.contains("metformin"))
								lek1 = "Metformin";
							
							if(lek1.contains("raloxifene"))
								lek1 = "Raloxifene";
							
							if(lek1.contains("montelukast"))
								lek1 = "Montelukast";
							
							if(lek1.contains("ceftriaxone"))
								lek1 = "Ceftriaxone";
							
							if(lek1.contains("carvedilol"))
								lek1 = "Carvedilol";
							
							if(lek1.contains("benzonatate"))
								lek1 = "Benzonatate";
							
							if(lek1.contains("sodium_chloride"))
								lek1 = "Sodium chloride";
							
							if(lek1.contains("enoxaparin"))
								lek1 = "Enoxaparin";
							
							if(lek1.contains("heparin"))
								lek1 = "Heparin";
							
							if(lek1.contains("diphenhydramin"))
								lek1 = "Diphenhydramin";
							
							if(lek1.contains("hydromorphone"))
								lek1 = "Hydromorphone";
							
							if(lek1.contains("hydroxychloroquine"))
								lek1 = "Hydroxychloroquine";
							
							if(lek1.contains("insulin"))
								lek1 = "Insulin";
							//----------------------------------------------------------------------------
							if(lek2.contains("prednisone"))
								lek2 = "Prednisone";
						
							if(lek2.contains("combivent"))
								lek2 = "Combivent";
							
							if(lek2.contains("guaifenesin"))
								lek2 = "Guaifenesin";
							
							if(lek2.contains("azithromycin"))
								lek2 = "Azithromycin";
							
							if(lek2.contains("meropenem"))
								lek2 = "Meropenem";
							
							if(lek2.contains("oxygen"))
								lek2 = "Oxygen";
							
							if(lek2.contains("furosemide"))
								lek2 = "Furosemide";
							
							if(lek2.contains("tiotropium"))
								lek2 = "Tiotropium";
						
							if(lek2.contains("acetylcysteine"))
								lek2 = "Acetylcysteine";
							
							if(lek2.contains("warfarin"))
								lek2 = "Warfarin";
							
							if(lek2.contains("metformin"))
								lek2 = "Metformin";
							
							if(lek2.contains("raloxifene"))
								lek2 = "Raloxifene";
							
							if(lek2.contains("montelukast"))
								lek2 = "Montelukast";
							
							if(lek2.contains("ceftriaxone"))
								lek2 = "Ceftriaxone";
							
							if(lek2.contains("carvedilol"))
								lek2 = "Carvedilol";
							
							if(lek2.contains("benzonatate"))
								lek2 = "Benzonatate";
							
							if(lek2.contains("sodium_chloride"))
								lek2 = "Sodium chloride";
							
							if(lek2.contains("enoxaparin"))
								lek2 = "Enoxaparin";
							
							if(lek2.contains("heparin"))
								lek2 = "Heparin";
							
							if(lek2.contains("diphenhydramin"))
								lek2 = "Diphenhydramin";
							
							if(lek2.contains("hydromorphone"))
								lek2 = "Hydromorphone";
							
							if(lek2.contains("hydroxychloroquine"))
								lek2 = "Hydroxychloroquine";
							

							if(lek2.contains("insulin"))
								lek2 = "Insulin";						
							//------------------------------------------------------------------------------------
							if(lek3.contains("prednisone"))
								lek3 = "Prednisone";
						
							if(lek3.contains("combivent"))
								lek3 = "Combivent";
							
							if(lek3.contains("guaifenesin"))
								lek3 = "Guaifenesin";
							
							if(lek3.contains("azithromycin"))
								lek3 = "Azithromycin";
							
							if(lek3.contains("meropenem"))
								lek3 = "Meropenem";
							
							if(lek3.contains("oxygen"))
								lek3 = "Oxygen";
							
							if(lek3.contains("furosemide"))
								lek3 = "Furosemide";
							
							if(lek3.contains("tiotropium"))
								lek3 = "Tiotropium";
						
							if(lek3.contains("acetylcysteine"))
								lek3 = "Acetylcysteine";
							
							if(lek3.contains("warfarin"))
								lek3 = "Warfarin";
							
							if(lek3.contains("metformin"))
								lek3 = "Metformin";
							
							if(lek3.contains("raloxifene"))
								lek3 = "Raloxifene";
							
							if(lek3.contains("montelukast"))
								lek3 = "Montelukast";
							
							if(lek3.contains("ceftriaxone"))
								lek3 = "Ceftriaxone";
							
							if(lek3.contains("carvedilol"))
								lek3 = "Carvedilol";
							
							if(lek3.contains("benzonatate"))
								lek3 = "Benzonatate";
							
							if(lek3.contains("sodium_chloride"))
								lek3 = "Sodium chloride";
							
							if(lek3.contains("enoxaparin"))
								lek3 = "Enoxaparin";
							
							if(lek3.contains("heparin"))
								lek3 = "Heparin";
							
							if(lek3.contains("diphenhydramin"))
								lek3 = "Diphenhydramin";
							
							if(lek3.contains("hydromorphone"))
								lek3 = "Hydromorphone";
							
							if(lek3.contains("hydroxychloroquine"))
								lek3 = "Hydroxychloroquine";
							
							if(lek3.contains("insulin"))
								lek3 = "Insulin";
							
							Main.lekovi2.add(lek1);
							Main.lekovi2.add(lek2);
							Main.lekovi2.add(lek3);
						}
						
						RbrPanel.comboLek.setModel(new DefaultComboBoxModel<String>(Main.lekovi2.toArray(new String[0])));
						RbrPanel.comboLek.setVisible(true);		
					}				
				}
			});					
	}
}
