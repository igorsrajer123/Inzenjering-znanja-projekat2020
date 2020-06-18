package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Pacijent;
import ruleBasedReasoning.RbrPanel;

public class Main {

	public static ArrayList<String> bolesti;
	public static ArrayList<String> lekovi;
	public static ArrayList<String> lekovi2;
	public static ArrayList<String> procedure;
	public static ArrayList<String> procedure2;
	public static ArrayList<Pacijent> pacijenti;
	public static ArrayList<String> simptomi;
	public static ArrayList<String> simptomi2;
	public static ArrayList<String> pol;
	public static ArrayList<String> pol2;
	
	public static ArrayList<String> bolesti2;
	
	
	public static JTextField bolTxt;
	public static JTextField godTxt;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox simpTxt;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox simpTxt2;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox polTxt;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox polTxt2;
	
	public static JCheckBox pusac;
	public static JCheckBox sportista;
	public static JCheckBox pusac2;
	public static JCheckBox sportista2;
	
	public static PanelLek lekoviPanel;
	public static JPanel panel;
	public static JFrame frame;
	
	public static ViewPanel viewPanel;
	public static RbrPanel rbrPanel;
	
	@SuppressWarnings("unused")
	public static void DrawGui(){
		
		//GUI---------------------------------------------------------------------------------------
				frame = new JFrame();
				frame.setSize(1100,600);
				frame.setLocationRelativeTo(null);
				frame.pack();
		
				panel = new JPanel();
				panel.setBackground(Color.lightGray);
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.setBorder(BorderFactory.createEmptyBorder());
				
				frame.getContentPane().add(panel, "Center");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Pulmologija");
				frame.setVisible(true);
				frame.setResizable(false);
				frame.setMinimumSize(new Dimension(1300,600));
				
				
				GridLayout layout1 = new GridLayout(7,1,10,0);
				panel.setLayout(layout1);
		
			//instanciranje panela za unos podataka
				
				//Panel ime, prezime i godine
				PanelPodaci panelPodaci = new PanelPodaci();
							
				//Panel simptomi i bolesti
				PanelBolest panelBolest = new PanelBolest();
							
				//Panel lekovi
				PanelLek panelLek = new PanelLek();
				
				//Panel procedure
				PanelProcedura panelProc = new PanelProcedura();
				
				//View Panel sa desne strane
				viewPanel = new ViewPanel();
				
				//panel za rule based reasoning
				rbrPanel = new RbrPanel();
				
				//Iscrtavanje frejma
				frame.repaint();
				frame.revalidate();
				panel.revalidate();
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		bolesti = new ArrayList<String>();
		lekovi = new ArrayList<String>();
		procedure = new ArrayList<String>();
		pacijenti = new ArrayList<Pacijent>();
		simptomi = new ArrayList<String>();
		simptomi2 = new ArrayList<String>();
		pol = new ArrayList<String>();
		pol2 = new ArrayList<String>();
		bolesti2 = new ArrayList<String>();
		lekovi2 = new ArrayList<String>();
		procedure2 = new ArrayList<String>();
		
		simptomi.add("");
		simptomi.add("Cough");
		simptomi.add("Shortness of breath");
		simptomi.add("Sore throat");
		simptomi.add("Sharp chest pain");
		simptomi.add("Coryza");
		simptomi.add("Nasal congestion");
		simptomi.add("Difficulty breathing");
		simptomi.add("Coughing up sputum");
		simptomi.add("Headache");
		simptomi.add("Chest tightness");
		simptomi.add("Fever");
		
		simptomi2.add("");
		simptomi2.add("Cough");
		simptomi2.add("Shortness of breath");
		simptomi2.add("Sore throat");
		simptomi2.add("Sharp chest pain");
		simptomi2.add("Coryza");
		simptomi2.add("Nasal congestion");
		simptomi2.add("Difficulty breathing");
		simptomi2.add("Coughing up sputum");
		simptomi2.add("Headache");
		simptomi2.add("Chest tightness");
		simptomi2.add("Fever");
		
		pol.add("");
		pol.add("Muški");
		pol.add("Ženski");
		
		pol2.add("");
		pol2.add("Muški");
		pol2.add("Ženski");
				
		DrawGui();
		
		//citanje iz binarne datoteke u "pacijenti" listu
		try {
		      FileInputStream in = new FileInputStream("pacijent2.out");
		      ObjectInputStream ois = new ObjectInputStream(in);
		      pacijenti = (ArrayList<Pacijent>)ois.readObject();
		      in.close();
		      ois.close();
		    } catch (Exception e) {
		      System.out.println("Problem serializing: " + e);
		    }
		
		//popunjavanje tabele prilikom pokratanja aplikacije
		//vrednostima iz "pacijenti" liste
		Object[] rowData = new Object[10];
		
		for(int i = 0; i < pacijenti.size(); i++){		
				rowData[0] = pacijenti.get(i).getIme();
				rowData[1] = pacijenti.get(i).getPrz();
				rowData[2] = pacijenti.get(i).getGod();
				rowData[3] = pacijenti.get(i).getPol();
				rowData[4] = pacijenti.get(i).getPusac();
				rowData[5] = pacijenti.get(i).getSportista();
				rowData[6] = pacijenti.get(i).getSimp();
				rowData[7] = pacijenti.get(i).getBolest();
				rowData[8] = pacijenti.get(i).getLek();
				rowData[9] = pacijenti.get(i).getProcedura();
				ViewPanel.model.addRow(rowData);
		}
	}
}
