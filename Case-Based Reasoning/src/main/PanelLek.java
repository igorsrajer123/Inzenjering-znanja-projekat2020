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

import cbr.MedicationApplication;

public class PanelLek extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public static JComboBox comboLek;
	
	@SuppressWarnings("rawtypes")
	public PanelLek(){
		
		//preporuceni lekovi-------------------------------------------------------------------
		JPanel lekoviPanel = new JPanel();
		lekoviPanel.setBackground(Color.lightGray);
		lekoviPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		lekoviPanel.setMaximumSize(new Dimension(300,30));
		lekoviPanel.setMinimumSize(new Dimension(300,50));
		JLabel lek = new JLabel("  Preporučeni lekovi: ");
		lek.setPreferredSize(new Dimension(95,10));
		
		JButton btnLek = new JButton(">>");
		btnLek.setBackground(new Color(51,204,255));
		btnLek.setPreferredSize(new Dimension(50,25));
		btnLek.setMinimumSize(new Dimension(50,25));
		btnLek.setMaximumSize(new Dimension(50,25));
		
		comboLek = new JComboBox();
		comboLek.setBackground(new Color(51,204,255));
		comboLek.setPreferredSize(new Dimension(130,25));
		comboLek.setMinimumSize(new Dimension(130,25));
		comboLek.setMaximumSize(new Dimension(130,25));
		comboLek.setVisible(false);
									
		btnLek.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!Main.godTxt.getText().isEmpty() && !Main.bolTxt.getText().isEmpty() && Main.simpTxt.getSelectedItem()!=""){
					Main.lekovi.clear();
					
					MedicationApplication medication = new MedicationApplication();
					
					medication.runMedicationApp("", Main.bolTxt.getText().toLowerCase(), Main.simpTxt.getSelectedItem().toString());
				
					for(String s : MedicationApplication.aaa){
						String[] ss = s.split(",");
						String lek1 = ss[2];
						String[] visak = lek1.split("=");
						String lekZarez = visak[1];
						String lek = lekZarez.replace("]", "");
						
						if(lek.contains("albuterol"))
							lek = "Albuterol";
						
						if(lek.contains("prednisone"))
							lek = "Prednisone";
					
						if(lek.contains("combivent"))
							lek = "Combivent";
						
						if(lek.contains("guaifenesin"))
							lek = "Guaifenesin";
						
						if(lek.contains("azithromycin"))
							lek = "Azithromycin";
						
						if(lek.contains("meropenem"))
							lek = "Meropenem";
						
						if(lek.contains("oxygen"))
							lek = "Oxygen";
						
						if(lek.contains("furosemide"))
							lek = "Furosemide";
						
						if(lek.contains("tiotropium"))
							lek = "Tiotropium";
					
						if(lek.contains("acetylcysteine"))
							lek = "Acetylcysteine";
						
						if(lek.contains("warfarin"))
							lek = "Warfarin";
						
						if(lek.contains("metformin"))
							lek = "Metformin";
						
						if(lek.contains("raloxifene"))
							lek = "Raloxifene";
						
						if(lek.contains("montelukast"))
							lek = "Montelukast";
						
						if(lek.contains("ceftriaxone"))
							lek = "Ceftriaxone";
						
						if(lek.contains("carvedilol"))
							lek = "Carvedilol";
						
						if(lek.contains("benzonatate"))
							lek = "Benzonatate";
						
						if(lek.contains("sodium chloride"))
							lek = "Sodium chloride";
						
						if(lek.contains("enoxaparin"))
							lek = "Enoxaparin";
						
						if(lek.contains("heparin"))
							lek = "Heparin";
						
						if(lek.contains("diphenhydramin"))
							lek = "Diphenhydramin";
						
						if(lek.contains("hydromorphone"))
							lek = "Hydromorphone";
						
						if(lek.contains("hydroxychloroquine"))
							lek = "Hydroxychloroquine";
						
						if(!Main.lekovi.contains(lek)){
							Main.lekovi.add(lek);
						}				
						else {
							continue;
						}
					}
					comboLek.setModel(new DefaultComboBoxModel<String>(Main.lekovi.toArray(new String[0])));
					comboLek.setVisible(true);					
				}
				else{
					comboLek.setVisible(false);
					JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
					Main.lekovi.clear();
				}
			}
		});
		
		lekoviPanel.setLayout(new BoxLayout(lekoviPanel, BoxLayout.X_AXIS));
		lekoviPanel.add(lek);
		lekoviPanel.add(Box.createHorizontalStrut(5));
		lekoviPanel.add(btnLek);
		lekoviPanel.add(Box.createHorizontalStrut(5));
		lekoviPanel.add(comboLek);
		Main.panel.add(lekoviPanel);
	}
}
