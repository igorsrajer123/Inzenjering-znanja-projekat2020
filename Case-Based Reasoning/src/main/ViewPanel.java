package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Pacijent;

public class ViewPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static JPanel panelView;
	
	public static JScrollPane scroll;
	
	public static JTable t;
	
	public static DefaultTableModel model;
	
	public static Pacijent selectedPatient;

	public ViewPanel(){
		panelView = new JPanel();
		
		BorderLayout layout = new BorderLayout();
		panelView.setLayout(layout);
		panelView.setBackground(Color.lightGray);
		panelView.setBorder(BorderFactory.createLineBorder(Color.black));
		panelView.setPreferredSize(new Dimension(500,500));
		panelView.setMinimumSize(new Dimension(500,500));
		Main.frame.getContentPane().add(panelView, "East");
		
		//inicijalizacija tabele
		model = new DefaultTableModel();
		t = new JTable(model);
		
		model.addColumn("Ime");
		model.addColumn("Prezime");
		model.addColumn("Godine");
		model.addColumn("Simptom");
		model.addColumn("Bolest");
		model.addColumn("Lek");
		model.addColumn("Procedura");
		t.getColumnModel().getColumn(0).setPreferredWidth(59);
		t.getColumnModel().getColumn(1).setPreferredWidth(59);
		t.getColumnModel().getColumn(2).setPreferredWidth(59);
		t.getColumnModel().getColumn(3).setPreferredWidth(59);
		t.getColumnModel().getColumn(4).setPreferredWidth(59);
		t.getColumnModel().getColumn(5).setPreferredWidth(59);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		t.setRowHeight(20);
		
		//popunjavanje tabele vrednostima iz liste "Main.pacijenti"
		Object[] rowData = new Object[7];
		
		for(int i = 0; i < Main.pacijenti.size(); i++){		
				rowData[0] = Main.pacijenti.get(i).getIme();
				rowData[1] = Main.pacijenti.get(i).getPrz();
				rowData[2] = Main.pacijenti.get(i).getGod();
				rowData[3] = Main.pacijenti.get(i).getSimp();
				rowData[4] = Main.pacijenti.get(i).getBolest();
				rowData[5] = Main.pacijenti.get(i).getLek();
				rowData[6] = Main.pacijenti.get(i).getProcedura();
				model.addRow(rowData);
		}
		
		//postavljanje tabele u scrollPane da bi se lepo prikazala
		scroll = new JScrollPane(t);
		scroll.setPreferredSize(new Dimension(100,150));
		panelView.add(scroll, BorderLayout.NORTH);
		
		//panel i dugmici za dodavanje i brisanje pacijenata
		JPanel manipulacija = new JPanel();
		manipulacija.setBackground(Color.LIGHT_GRAY);
		manipulacija.setPreferredSize(new Dimension(300,100));
		manipulacija.setMinimumSize(new Dimension(300,100));
		panelView.add(manipulacija, BorderLayout.SOUTH);
		manipulacija.setLayout(new BoxLayout(manipulacija, BoxLayout.X_AXIS));
		
		//dugme za dodavanje
		JButton dodaj = new JButton("Dodaj");
		dodaj.setPreferredSize(new Dimension(70,30));
		dodaj.setMaximumSize(new Dimension(70,30));
		dodaj.setMinimumSize(new Dimension(70,30));
		
		//dugme za uklanjanje
		JButton ukloni = new JButton("Ukloni");
		ukloni.setPreferredSize(new Dimension(70,30));
		ukloni.setMaximumSize(new Dimension(70,30));
		ukloni.setMinimumSize(new Dimension(70,30));
		
		manipulacija.add(Box.createHorizontalStrut(10));
		manipulacija.add(dodaj);
		manipulacija.add(Box.createHorizontalStrut(10));
		manipulacija.add(ukloni);
		
		//akcija dodavanja
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(PanelPodaci.imeTxt.getText().isEmpty() || PanelPodaci.przTxt.getText().isEmpty() ||
					Main.godTxt.getText().isEmpty() || Main.bolTxt.getText().isEmpty() ||
						Main.simpTxt.getText().isEmpty() ||!PanelProcedura.comboProcedura.isVisible() || !PanelLek.comboLek.isVisible()){

						 JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");	
				}
				else {
					
					Pacijent p = new Pacijent();
					p.setIme(PanelPodaci.imeTxt.getText());
					p.setPrz(PanelPodaci.przTxt.getText());
					p.setGod(Integer.parseInt(Main.godTxt.getText()));
					p.setSimp(Main.simpTxt.getText());
					p.setBolest(Main.bolTxt.getText());
					p.setLek(PanelLek.comboLek.getSelectedItem().toString());
					p.setProcedura(PanelProcedura.comboProcedura.getSelectedItem().toString());	
					
					Main.pacijenti.add(p);
					
					PanelPodaci.imeTxt.setText("");
					PanelPodaci.przTxt.setText("");
					Main.godTxt.setText("");
					Main.simpTxt.setText("");
					Main.bolTxt.setText("");
					PanelBolest.combo.setVisible(false);
					PanelLek.comboLek.setVisible(false);
					PanelProcedura.comboProcedura.setVisible(false);
					
					Main.bolesti.clear();
					Main.lekovi.clear();
					Main.procedure.clear();
					
					//dodavanje reda u tabeli
					String pacijent = p.toString();
					Object[] rowData = new Object[7];
					
					String[] pParts = pacijent.split(",");
					
					String imeP = pParts[0];
					String[] ime1 = imeP.split("=");
					String ime = ime1[1];
					
					String przP = pParts[1];
					String[] prz1 = przP.split("=");
					String prz = prz1[1];
					
					String godP = pParts[2];
					String[] god1 = godP.split("=");
					String god = god1[1];
					
					String simP = pParts[3];
					String[] sim1 = simP.split("=");
					String sim = sim1[1];
					
					String bolP = pParts[4];
					String[] bol1 = bolP.split("=");
					String bol = bol1[1];
					
					String lekP = pParts[5];
					String[] lek1 = lekP.split("=");
					String lek = lek1[1];
					
					String proP = pParts[6];
					String[] pro1 = proP.split("=");
					String pro = pro1[1];
					String pro2 = pro.replace("]","");
					
					rowData[0] = ime;
					rowData[1] = prz;
					rowData[2] = god;
					rowData[3] = sim;
					rowData[4] = bol;
					rowData[5] = lek;
					rowData[6] = pro2;
					
					model.addRow(rowData);
					
					panelView.revalidate();
					panelView.repaint();
					
					 try {
					      FileOutputStream out = new FileOutputStream("pacijent.out");
					      ObjectOutputStream oos = new ObjectOutputStream(out);
					      oos.writeObject(Main.pacijenti);
					      oos.flush();
					      oos.close();
					    } catch (Exception e) {
					      System.out.println("Problem serializing: " + e);
					    }
				}	
			}
		});
		
		//akcija selektovanja reda u tabeli
		t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
			
				if(arg0.getValueIsAdjusting())
			      {
					String ime =t.getValueAt(t.getSelectedRow(), 0).toString();
					String prz = t.getValueAt(t.getSelectedRow(), 1).toString();
					String god = t.getValueAt(t.getSelectedRow(), 2).toString();
					String simp = t.getValueAt(t.getSelectedRow(), 3).toString();
					String bol = t.getValueAt(t.getSelectedRow(), 4).toString();
					String lek = t.getValueAt(t.getSelectedRow(), 5).toString();
					String proc = t.getValueAt(t.getSelectedRow(), 6).toString();
					
					selectedPatient = new Pacijent();					
					selectedPatient.setIme(ime);
					selectedPatient.setPrz(prz);
					selectedPatient.setGod(Integer.parseInt(god));
					selectedPatient.setSimp(simp);
					selectedPatient.setBolest(bol);
					selectedPatient.setLek(lek);
					selectedPatient.setProcedura(proc);
			      }				
			}
		});
		
		//akcija uklanjanja selektovanog pacijenta i serijalizacija liste
		ukloni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				for(int i = 0; i < Main.pacijenti.size(); i++){
					if(selectedPatient.getIme().equals(Main.pacijenti.get(i).getIme()) &&
							selectedPatient.getPrz().equals(Main.pacijenti.get(i).getPrz()) &&
							selectedPatient.getGod()== Main.pacijenti.get(i).getGod()){
						
						Main.pacijenti.remove(Main.pacijenti.get(i));
						
						//uklanja selektovani red u tabeli
						DefaultTableModel model = (DefaultTableModel)t.getModel();
						int[] rows = t.getSelectedRows();					  
						for(int j=0;j<rows.length;j++)
							model.removeRow(rows[j]-j);
						
						  try {
						      FileOutputStream out = new FileOutputStream("pacijent.out");
						      ObjectOutputStream oos = new ObjectOutputStream(out);
						      oos.writeObject(Main.pacijenti);
						      oos.flush();
						      oos.close();
						    } catch (Exception e) {
						      System.out.println("Problem serializing: " + e);
						    }
						  
						break;						
					}
				}
			}
		});
	}
}
