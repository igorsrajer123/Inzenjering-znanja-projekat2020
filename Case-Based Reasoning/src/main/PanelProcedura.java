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

import cbr.ProcedureApplication;

public class PanelProcedura extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox comboProcedura;

	@SuppressWarnings("rawtypes")
	public PanelProcedura(){
		
		//preporucene procedure-------------------------------------------------------------------
		JPanel procedurePanel = new JPanel();
		procedurePanel.setBackground(Color.lightGray);
		procedurePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		procedurePanel.setMaximumSize(new Dimension(300,30));
		procedurePanel.setMinimumSize(new Dimension(300,50));
		JLabel procedura = new JLabel("  Preporučene procedure: ");
		procedura.setPreferredSize(new Dimension(95,10));
				
		JButton btnProc = new JButton(">>");
		btnProc.setBackground(Color.GREEN);
		btnProc.setPreferredSize(new Dimension(50,25));
		btnProc.setMinimumSize(new Dimension(50,25));
		btnProc.setMaximumSize(new Dimension(50,25));
				
		comboProcedura = new JComboBox();
		comboProcedura.setBackground(Color.GREEN);
		comboProcedura.setPreferredSize(new Dimension(160,25));
		comboProcedura.setMinimumSize(new Dimension(160,25));
		comboProcedura.setMaximumSize(new Dimension(160,25));
		comboProcedura.setVisible(false);
				
		btnProc.addActionListener(new ActionListener() {
					
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent arg0) {					
				 if(!Main.godTxt.getText().isEmpty() && !Main.simpTxt.getText().isEmpty() &&
					!Main.bolTxt.getText().isEmpty() && !PanelLek.comboLek.getSelectedItem().equals(null)){
							
					Main.procedure.clear();
							
					ProcedureApplication procedure = new ProcedureApplication();
							
					procedure.runProcedureApp("", Main.bolTxt.getText(), PanelLek.comboLek.getSelectedItem().toString(),
							Integer.parseInt(Main.godTxt.getText()), Main.simpTxt.getText());
							
					for(String s : ProcedureApplication.aaa){
						String[] ss = s.split(" ");
						String proc1 = ss[1];
						String[] p = proc1.split("=");
						String proc2 = p[1];
						String procedura = proc2.replace(",","");		
						
						if(procedura.contains("nebulizer_therapy"))
							procedura = "Nebulizer therapy";
						
						if(procedura.contains("hematologic_tests"))
							procedura = "Hematologic tests";
						
						if(procedura.contains("complete_blood_count"))
							procedura = "Complete blood count";
						
						if(procedura.contains("blood_culture"))
							procedura = "Blood culture";
						
						if(procedura.contains("radiographic_imaging_procedure"))
							procedura = "Radiographic imaging procedure";
						
						if(procedura.contains("electrocardiogram"))
							procedura = "Electrocardiogram";
						
						if(procedura.contains("plain_x_ray"))
							procedura = "Plain X ray";
						
						if(procedura.contains("x_ray_computed_tomography"))
							procedura = "X ray computed tomography";
						
						if(procedura.contains("electrocardiogram"))
							procedura = "Electrocardiogram";
						
						if(procedura.contains("intravenous_fluid_replacement"))
							procedura = "Intravenous fluid replacement";
						
						if(!Main.procedure.contains(procedura)){
							Main.procedure.add(procedura);
						}
						else {
							continue;
						}
					}
					comboProcedura.setModel(new DefaultComboBoxModel<String>(Main.procedure.toArray(new String[0])));
					comboProcedura.setVisible(true);	
				 }
				 else {
					 comboProcedura.setVisible(false);
					 JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
					 Main.procedure.clear();
				 }
			}
		});
				
		procedurePanel.setLayout(new BoxLayout(procedurePanel, BoxLayout.X_AXIS));
		procedurePanel.add(procedura);
		procedurePanel.add(Box.createHorizontalStrut(5));
		procedurePanel.add(btnProc);
		procedurePanel.add(Box.createHorizontalStrut(5));
		procedurePanel.add(comboProcedura);
		Main.panel.add(procedurePanel);	
	}
}
