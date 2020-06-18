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
public class AddProcedure extends JPanel{
	
	@SuppressWarnings("rawtypes")
	public AddProcedure() {
		
		RbrPanel.podaciPanel6 = new JPanel();
		RbrPanel.podaciPanel6.setBackground(new Color(204,153,255));
		RbrPanel.podaciPanel6.setBorder(BorderFactory.createLineBorder(Color.black));
		RbrPanel.podaciPanel6.setPreferredSize(new Dimension(1000,100));
		RbrPanel.podaciPanel6.setMaximumSize(new Dimension(1000,100));
		RbrPanel.podaciPanel6.setMinimumSize(new Dimension(1000,100));
		RbrPanel.podaciPanel6.setLayout(new BoxLayout(RbrPanel.podaciPanel6, BoxLayout.X_AXIS));
		RbrPanel.rbrPanel.add(RbrPanel.podaciPanel6);
		
		JLabel procedura = new JLabel("    Preporučene procedure: ");
		JButton btnProc = new JButton(">>");
		btnProc.setBackground(new Color(204,153,255));
		btnProc.setPreferredSize(new Dimension(55,25));
		btnProc.setMinimumSize(new Dimension(55,25));
		btnProc.setMaximumSize(new Dimension(55,25));

		RbrPanel.comboProc = new JComboBox();
		RbrPanel.comboProc.setBackground(new Color(204,153,255));
		RbrPanel.comboProc.setPreferredSize(new Dimension(200,25));
		RbrPanel.comboProc.setMinimumSize(new Dimension(200,25));
		RbrPanel.comboProc.setMaximumSize(new Dimension(200,25));
		RbrPanel.comboProc.setVisible(false);
				
		RbrPanel.podaciPanel6.add(procedura);
		RbrPanel.podaciPanel6.add(Box.createHorizontalStrut(5));
		RbrPanel.podaciPanel6.add(btnProc);
		RbrPanel.podaciPanel6.add(Box.createHorizontalStrut(5));
		RbrPanel.podaciPanel6.add(RbrPanel.comboProc);
		

		//=================================================================================================================
		//Dodavanje dodavanje procedure------------------------------------------------------------------------------------------------
		btnProc.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(RbrPanel.comboLek.isVisible() == false || RbrPanel.combo.isVisible() == false) {
					RbrPanel.comboProc.setVisible(false);
					Main.procedure2.clear();
					JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
				}else {
					Main.procedure2.clear();
					RbrPanel.comboProc.setVisible(true);
					
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
					
					JIPQuery query = engine.openSynchronousQuery("procedure_sorted(" + prosledjujem2 +",L)");
					
					JIPTerm solution;
					while ((solution = query.nextSolution()) != null) {
						String solution1 = solution.toString();	
						String solution2 = solution1.replace("(", ")");
						String solution3 = solution2.replace("[]", ")");
						String solution4 = solution3.replace("'.'", ")");
						String solution5 = solution4.replace(")"," ");
						String[] parts = solution5.split(",");
						String proc1 = parts[14];
						String proc2 = parts[11];
						String proc3 = parts[8];
						
						if(proc1.contains("nebulizer_therapy"))
							proc1  = "Nebulizer therapy";
						
						if(proc1.contains("hematologic_tests"))
							proc1  = "Hematologic tests";
						
						if(proc1.contains("complete_blood_count"))
							proc1  = "Complete blood count";
						
						if(proc1.contains("blood_culture"))
							proc1  = "Blood culture";
						
						if(proc1 .contains("radiographic_imaging_procedure"))
							proc1  = "Radiographic imaging procedure";
						
						if(proc1.contains("electrocardiogram"))
							proc1  = "Electrocardiogram";
						
						if(proc1.contains("plain_x_ray"))
							proc1  = "Plain X-ray";
						
						if(proc1.contains("x_ray_computed_tomography"))
							proc1  = "X-ray computed tomography";
						
						if(proc1.contains("intravenous_fluid_replacement"))
							proc1  = "Intravenous fluid replacement";
						
						if(proc1.contains("complete_physical_skin_exam_performed"))
							proc1  = "Complete physical skin exam performed";
						//--------------------------------------------------------------------
						if(proc2.contains("nebulizer_therapy"))
							proc2  = "Nebulizer therapy";
						
						if(proc2.contains("hematologic_tests"))
							proc2  = "Hematologic tests";
						
						if(proc2.contains("complete_blood_count"))
							proc2  = "Complete blood count";
						
						if(proc2.contains("blood_culture"))
							proc2  = "Blood culture";
						
						if(proc2.contains("radiographic_imaging_procedure"))
							proc2  = "Radiographic imaging procedure";
						
						if(proc2.contains("electrocardiogram"))
							proc2  = "Electrocardiogram";
						
						if(proc2.contains("plain_x_ray"))
							proc2  = "Plain X-ray";
						
						if(proc2.contains("x_ray_computed_tomography"))
							proc2  = "X-ray computed tomography";
						
						if(proc2.contains("intravenous_fluid_replacement"))
							proc2  = "Intravenous fluid replacement";
						
						if(proc2.contains("complete_physical_skin_exam_performed"))
							proc2  = "Complete physical skin exam performed";
						//----------------------------------------------------------
						if(proc3.contains("nebulizer_therapy"))
							proc3  = "Nebulizer therapy";
						
						if(proc3.contains("hematologic_tests"))
							proc3  = "Hematologic tests";
						
						if(proc3.contains("complete_blood_count"))
							proc3  = "Complete blood count";
						
						if(proc3.contains("blood_culture"))
							proc3  = "Blood culture";
						
						if(proc3.contains("radiographic_imaging_procedure"))
							proc3  = "Radiographic imaging procedure";
						
						if(proc3.contains("electrocardiogram"))
							proc3  = "Electrocardiogram";
						
						if(proc3.contains("plain_x_ray"))
							proc3  = "Plain X-ray";
						
						if(proc3.contains("x_ray_computed_tomography"))
							proc3  = "X-ray computed tomography";
						
						if(proc3.contains("intravenous_fluid_replacement"))
							proc3  = "Intravenous fluid replacement";
						
						if(proc3.contains("complete_physical_skin_exam_performed"))
							proc3  = "Complete physical skin exam performed";
						
						Main.procedure2.add(proc1);
						Main.procedure2.add(proc2);
						Main.procedure2.add(proc3);
					}
					RbrPanel.comboProc.setModel(new DefaultComboBoxModel<String>(Main.procedure2.toArray(new String[0])));
					RbrPanel.comboProc.setVisible(true);									
				}				
			}
		});
		
	}
}
