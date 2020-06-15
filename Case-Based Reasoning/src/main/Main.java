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

public class Main {

	public static ArrayList<String> bolesti;
	public static ArrayList<String> lekovi;
	public static ArrayList<String> procedure;
	public static ArrayList<Pacijent> pacijenti;
	public static ArrayList<String> simptomi;
	public static ArrayList<String> pol;
	
	public static JTextField bolTxt;
	public static JTextField godTxt;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox simpTxt;
	
	@SuppressWarnings("rawtypes")
	public static JComboBox polTxt;
	
	public static JCheckBox pusac;
	public static JCheckBox sportista;
	
	public static PanelLek lekoviPanel;
	public static JPanel panel;
	public static JFrame frame;
	
	public static ViewPanel viewPanel;
	
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
		pol = new ArrayList<String>();
		
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
		
		pol.add("");
		pol.add("Muški");
		pol.add("Ženski");
		
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
