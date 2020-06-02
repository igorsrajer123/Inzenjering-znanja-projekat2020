package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cbr.DiseaseApplication;
import cbr.MedicationApplication;
import cbr.ProcedureApplication;
import cbr.SymptomApplication;

import com.sun.javafx.tk.Toolkit;

public class Main {

	public static ArrayList<String> bolesti;
	
	public static void DrawGui(){
		
		//GUI---------------------------------------------------------------------------------------
				JFrame frame = new JFrame();
				frame.setSize(700,600);
				frame.setLocationRelativeTo(null);
				frame.pack();
				
				JPanel panel = new JPanel();
				panel.setBackground(Color.lightGray);
				panel.setBorder(BorderFactory.createEmptyBorder());
				
				frame.getContentPane().add(panel, "Center");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Pulmologija");
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setMinimumSize(new Dimension(700,600));
				
				
				GridLayout layout1 = new GridLayout(6,1,10,0);
				panel.setLayout(layout1);
				
			//ime pacijenta---------------------------------------------------------------------------
				JPanel imePanel = new JPanel();
				imePanel.setBackground(Color.lightGray);
				imePanel.setPreferredSize(new Dimension(100,70));
				imePanel.setMaximumSize(new Dimension(100,70));
				imePanel.setMinimumSize(new Dimension(100,70));
				
				JLabel ime = new JLabel("  Ime pacijenta:            ");
				ime.setPreferredSize(new Dimension(95,10));
				JTextField imeTxt = new JTextField();
				imeTxt.setPreferredSize(new Dimension(95,10));
				imeTxt.setMinimumSize(new Dimension(95,10));
				imeTxt.setMaximumSize(new Dimension(95,25));
				
				imePanel.setLayout(new BoxLayout(imePanel, BoxLayout.X_AXIS));
				imePanel.add(ime);
				imePanel.add(imeTxt);	
				panel.add(imePanel);
				
			//prezime pacijenta------------------------------------------------------------------------
				JPanel prezimePanel = new JPanel();
				prezimePanel.setBackground(Color.lightGray);
				prezimePanel.setPreferredSize(new Dimension(100,70));
				prezimePanel.setMaximumSize(new Dimension(100,30));
				prezimePanel.setMinimumSize(new Dimension(100,50));
				
				JLabel prezime = new JLabel("  Prezime pacijenta:    ");
				prezime.setPreferredSize(new Dimension(95,10));
				JTextField przTxt = new JTextField();
				przTxt.setPreferredSize(new Dimension(95,25));
				przTxt.setMinimumSize(new Dimension(95,25));
				przTxt.setMaximumSize(new Dimension(95,25));
				
				prezimePanel.setLayout(new BoxLayout(prezimePanel, BoxLayout.X_AXIS));
				prezimePanel.add(prezime);
				prezimePanel.add(przTxt);
				panel.add(prezimePanel);
				
			//godine pacijenta-------------------------------------------------------------------------
				JPanel godinePanel = new JPanel();
				godinePanel.setBackground(Color.lightGray);
				prezimePanel.setPreferredSize(new Dimension(100,70));
				prezimePanel.setMaximumSize(new Dimension(100,30));
				prezimePanel.setMinimumSize(new Dimension(100,50));
				
				JLabel god = new JLabel("  Godine pacijenta:      ");
				god.setPreferredSize(new Dimension(95,10));
				final JTextField godTxt = new JTextField();
				godTxt.setPreferredSize(new Dimension(95,25));
				godTxt.setMinimumSize(new Dimension(95,25));
				godTxt.setMaximumSize(new Dimension(95,25));
				
				godinePanel.setLayout(new BoxLayout(godinePanel, BoxLayout.X_AXIS));
				godinePanel.add(god);
				godinePanel.add(godTxt);
				panel.add(godinePanel);
				
			//simptomi pacijenta----------------------------------------------------------------------
				JPanel simptomiPanel = new JPanel();
				simptomiPanel.setBackground(Color.lightGray);
				simptomiPanel.setPreferredSize(new Dimension(160,70));
				simptomiPanel.setMaximumSize(new Dimension(160,30));
				simptomiPanel.setMinimumSize(new Dimension(160,50));
				
				JLabel simp = new JLabel("  Simptomi pacijenta: ");
				simp.setPreferredSize(new Dimension(95,10));
				final JTextField simpTxt = new JTextField();
				simpTxt.setPreferredSize(new Dimension(95,25));
				simpTxt.setMinimumSize(new Dimension(95,25));
				simpTxt.setMaximumSize(new Dimension(95,25));
				
				final JButton btnSimp = new JButton("Predložene bolesti>>");
				btnSimp.setBackground(Color.GREEN);
				btnSimp.setPreferredSize(new Dimension(155,25));
				btnSimp.setMinimumSize(new Dimension(100,25));
				btnSimp.setMaximumSize(new Dimension(155,25));
								
				String[] zivotinje = {"aaa", "bb"};
				final JComboBox combo = new JComboBox();
				combo.setBackground(Color.GREEN);
				combo.setPreferredSize(new Dimension(150,25));
				combo.setMinimumSize(new Dimension(150,25));
				combo.setMaximumSize(new Dimension(150,25));
				combo.setVisible(false);
				
				btnSimp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						if(simpTxt.getText().isEmpty()){
							combo.setVisible(false);
							bolesti.clear();
						}
						else {
							bolesti.clear();
							
							DiseaseApplication disease = new DiseaseApplication();
							
							disease.runDiseaseApp("",simpTxt.getText(), Integer.parseInt(godTxt.getText()));
							
							for(String s : DiseaseApplication.aaa){			
								String[] ss = s.split(" ");
								String bolest11 = ss[1];
								String[] visak = bolest11.split("=");
								String bolestZarez = visak[1];
								String b = bolestZarez.replace(","," ");

								if(b.contains("asthma"))
									b = "Asthma";
																		
								if(b.contains("pneumonia"))
									b = "Pneumonia";
									
								if(b.contains("acute_bronchitis"))
									b = "Acute bronchitis";
												
								if(b.contains("chronic_obstructive_pulmonary_disease"))
									b = "COPD";
								
								if(b.contains("pulmonary_fibrosis"))
									b = "Pulmonary fibrosis";
								
								if(b.contains("abscess_of_the_lung"))
									b = "Abscess of the lung";
								
								if(b.contains("pulmonary_hypertension"))
									b = "Pulmonary hypertension";
																		
								if(!bolesti.contains(b)){	
									bolesti.add(b);
								}
								else {
									continue;
								}							
							}
							
							combo.setModel(new DefaultComboBoxModel<String>(bolesti.toArray(new String[0])));
							combo.setVisible(true);
						}					
					}
				});
				
				simptomiPanel.setLayout(new BoxLayout(simptomiPanel, BoxLayout.X_AXIS));
				simptomiPanel.add(simp);
				simptomiPanel.add(simpTxt);
				simptomiPanel.add(Box.createHorizontalStrut(5));
				simptomiPanel.add(btnSimp);
				simptomiPanel.add(Box.createHorizontalStrut(5));
				simptomiPanel.add(combo);
				panel.add(simptomiPanel);
				
			//bolest pacijenta--------------------------------------------------------------------------
				JPanel bolestPanel = new JPanel();
				bolestPanel.setBackground(Color.lightGray);
				bolestPanel.setPreferredSize(new Dimension(100,70));
				bolestPanel.setMaximumSize(new Dimension(100,30));
				bolestPanel.setMinimumSize(new Dimension(100,50));
				
				JLabel bol = new JLabel("  Bolest pacijenta:      ");
				bol.setPreferredSize(new Dimension(95,10));
				final JTextField bolTxt = new JTextField();
				bolTxt.setPreferredSize(new Dimension(95,25));
				bolTxt.setMinimumSize(new Dimension(95,25));
				bolTxt.setMaximumSize(new Dimension(95,25));
				
				bolestPanel.setLayout(new BoxLayout(bolestPanel, BoxLayout.X_AXIS));
				bolestPanel.add(bol);
				bolestPanel.add(bolTxt);
				panel.add(bolestPanel);
				
			//preporuceni lekovi i procedure-------------------------------------------------------------
				JPanel lekoviPanel = new JPanel();
				lekoviPanel.setBackground(Color.lightGray);
				lekoviPanel.setMaximumSize(new Dimension(100,30));
				lekoviPanel.setMinimumSize(new Dimension(100,50));
				JLabel lek = new JLabel("  Preporučeni lekovi i procedure: ");
				lek.setPreferredSize(new Dimension(95,10));
				
				JButton btnLek = new JButton(">>");
				btnLek.setBackground(Color.GREEN);
				btnLek.setPreferredSize(new Dimension(50,25));
				btnLek.setMinimumSize(new Dimension(50,25));
				btnLek.setMaximumSize(new Dimension(50,25));
				
				final JComboBox comboLek = new JComboBox(zivotinje);
				comboLek.setBackground(Color.GREEN);
				comboLek.setPreferredSize(new Dimension(95,25));
				comboLek.setMinimumSize(new Dimension(95,25));
				comboLek.setMaximumSize(new Dimension(95,25));
				comboLek.setVisible(false);
				
				final JComboBox comboProcedura = new JComboBox(zivotinje);
				comboProcedura.setBackground(Color.GREEN);
				comboProcedura.setPreferredSize(new Dimension(95,25));
				comboProcedura.setMinimumSize(new Dimension(95,25));
				comboProcedura.setMaximumSize(new Dimension(95,25));
				comboProcedura.setVisible(false);
											
				btnLek.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(!godTxt.getText().isEmpty() && !bolTxt.getText().isEmpty() && !simpTxt.getText().isEmpty()){
							comboLek.setVisible(true);
						}
						else{
							comboLek.setVisible(false);
						}
						
						comboProcedura.setVisible(false);
					}
				});
				
				lekoviPanel.setLayout(new BoxLayout(lekoviPanel, BoxLayout.X_AXIS));
				lekoviPanel.add(lek);
				lekoviPanel.add(Box.createHorizontalStrut(5));
				lekoviPanel.add(btnLek);
				lekoviPanel.add(Box.createHorizontalStrut(5));
				lekoviPanel.add(comboLek);
				lekoviPanel.add(Box.createHorizontalStrut(5));
				lekoviPanel.add(comboProcedura);
				panel.add(lekoviPanel);
				
			//---------------------------------------------------------------------------
				frame.repaint();
				frame.revalidate();
				panel.revalidate();
	}
	
	public static void main(String[] args) {

		bolesti = new ArrayList<String>();
		
		DrawGui();
		/*
		DiseaseApplication disease = new DiseaseApplication();
		
		disease.runDiseaseApp("asthma","cough", 14);
		
		for(String s : DiseaseApplication.aaa){			
			String[] ss = s.split(" ");
			String bolest11 = ss[1];
			String[] visak = bolest11.split("=");
			String bolestZarez = visak[1];
			String b = bolestZarez.replace(","," ");
			bolesti.add(b);
		}*/
		
		//MedicationApplication medication = new MedicationApplication();
		//ProcedureApplication procedure = new ProcedureApplication();
		//SymptomApplication symptom = new SymptomApplication();
		
		//medication.runMedicationApp("levalbuterol","asthma","cough");
		//procedure.runProcedureApp("plain_x_ray","chronic obstructive pulmonary disease");
		//symptom.runSymptomApp("cough", "asthma");
	}

}
