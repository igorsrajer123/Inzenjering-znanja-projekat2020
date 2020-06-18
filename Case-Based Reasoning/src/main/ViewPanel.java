package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ruleBasedReasoning.RbrPanel;
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
	
	public static JLabel labela1;

	@SuppressWarnings("serial")
	public ViewPanel(){
		panelView = new JPanel();
		
		BorderLayout layout = new BorderLayout();
		panelView.setLayout(layout);
		panelView.setBackground(Color.lightGray);
		panelView.setBorder(BorderFactory.createLineBorder(Color.black));
		panelView.setPreferredSize(new Dimension(700,500));
		panelView.setMinimumSize(new Dimension(700,500));
		Main.frame.getContentPane().add(panelView, "East");
		
		//inicijalizacija tabele
		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		t = new JTable(model);
		
		model.addColumn("Ime");
		model.addColumn("Prezime");
		model.addColumn("Godine");
		model.addColumn("Pol");
		model.addColumn("Pusac");
		model.addColumn("Sportista");
		model.addColumn("Simptom");
		model.addColumn("Bolest");
		model.addColumn("Lek");
		model.addColumn("Procedura");
		t.getColumnModel().getColumn(0).setPreferredWidth(59);
		t.getColumnModel().getColumn(1).setPreferredWidth(59);
		t.getColumnModel().getColumn(2).setPreferredWidth(47);
		t.getColumnModel().getColumn(3).setPreferredWidth(47);
		t.getColumnModel().getColumn(4).setPreferredWidth(40);
		t.getColumnModel().getColumn(5).setPreferredWidth(40);
		t.getColumnModel().getColumn(6).setPreferredWidth(59);
		t.getColumnModel().getColumn(7).setPreferredWidth(59);
		t.getColumnModel().getColumn(8).setPreferredWidth(59);
		t.getColumnModel().getColumn(9).setPreferredWidth(59);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		t.setRowHeight(20);
		
		//popunjavanje tabele vrednostima iz liste "Main.pacijenti"
		Object[] rowData = new Object[10];
		
		for(int i = 0; i < Main.pacijenti.size(); i++){		
				rowData[0] = Main.pacijenti.get(i).getIme();
				rowData[1] = Main.pacijenti.get(i).getPrz();
				rowData[2] = Main.pacijenti.get(i).getGod();
				rowData[3] = Main.pacijenti.get(i).getPol();
				rowData[4] = Main.pacijenti.get(i).getPusac();
				rowData[5] = Main.pacijenti.get(i).getSportista();
				rowData[6] = Main.pacijenti.get(i).getSimp();
				rowData[7] = Main.pacijenti.get(i).getBolest();
				rowData[8] = Main.pacijenti.get(i).getLek();
				rowData[9] = Main.pacijenti.get(i).getProcedura();
				model.addRow(rowData);
		}
		
		//postavljanje tabele u scrollPane da bi se lepo prikazala
		scroll = new JScrollPane(t);
		t.setBackground(Color.WHITE);
		scroll.setPreferredSize(new Dimension(100,150));
		panelView.add(scroll, BorderLayout.NORTH);
		t.getTableHeader().setOpaque(false);
		t.getTableHeader().setBackground(Color.LIGHT_GRAY);
		scroll.getViewport().setBackground(Color.LIGHT_GRAY);
		
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
		dodaj.setBackground(Color.LIGHT_GRAY);
		
		//dugme za uklanjanje
		JButton ukloni = new JButton("Ukloni");
		ukloni.setPreferredSize(new Dimension(70,30));
		ukloni.setMaximumSize(new Dimension(70,30));
		ukloni.setMinimumSize(new Dimension(70,30));
		ukloni.setBackground(Color.LIGHT_GRAY);
		
		manipulacija.add(Box.createHorizontalStrut(10));
		manipulacija.add(dodaj);
		manipulacija.add(Box.createHorizontalStrut(10));
		manipulacija.add(ukloni);
		
		//panel zamene rezonovanja
		JPanel zameniPanel = new JPanel();
		zameniPanel.setPreferredSize(new Dimension(500,300));
		zameniPanel.setMaximumSize(new Dimension(500,300));
		zameniPanel.setMinimumSize(new Dimension(500,300));
		zameniPanel.setLayout(new BoxLayout(zameniPanel, BoxLayout.X_AXIS));
		zameniPanel.setBackground(Color.LIGHT_GRAY);
		
		labela1 = new JLabel("Odabrani metod rezonovanja: CBR");
		labela1.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//dugme za promenu metode rezonovanja
		JButton zameni = new JButton("Zameni");
		zameni.setPreferredSize(new Dimension(100,40));
		zameni.setMaximumSize(new Dimension(100,40));
		zameni.setMinimumSize(new Dimension(100,40));
		zameni.setBackground(Color.LIGHT_GRAY);
		
		zameniPanel.add(Box.createHorizontalStrut(10));
		zameniPanel.add(labela1);
		zameniPanel.add(Box.createHorizontalStrut(10));
		zameniPanel.add(zameni);
		
		panelView.add(zameniPanel, BorderLayout.WEST);
	
		zameni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(PanelPodaci.imePanel.isVisible() && !RbrPanel.rbrPanel.isVisible()) {				
					PanelPodaci.imePanel.setVisible(false);
					PanelPodaci.godinePanel.setVisible(false);
					PanelPodaci.podPanel.setVisible(false);
					PanelLek.lekoviPanel.setVisible(false);
					PanelBolest.simptomiPanel.setVisible(false);
					PanelBolest.bolestPanel.setVisible(false);
					PanelProcedura.procedurePanel.setVisible(false);
					RbrPanel.rbrPanel.setVisible(true);
					panelView.setBackground(new Color(204,153,255));
					manipulacija.setBackground(new Color(204,153,255));
					zameniPanel.setBackground(new Color(204,153,255));
					t.setBackground(Color.WHITE);
					t.getTableHeader().setBackground(new Color(204,153,255));
					scroll.getViewport().setBackground(new Color(204,153,255));
					dodaj.setBackground(new Color(204,153,255));
					ukloni.setBackground(new Color(204,153,255));
					zameni.setBackground(new Color(204,153,255));
					labela1.setText("Odabrani metod rezonovanja: RBR");
				}
				else {
					PanelPodaci.imePanel.setVisible(true);
					PanelPodaci.godinePanel.setVisible(true);
					PanelPodaci.podPanel.setVisible(true);
					PanelLek.lekoviPanel.setVisible(true);
					PanelBolest.simptomiPanel.setVisible(true);
					PanelBolest.bolestPanel.setVisible(true);
					PanelProcedura.procedurePanel.setVisible(true);
					RbrPanel.rbrPanel.setVisible(false);
					panelView.setBackground(Color.LIGHT_GRAY);
					manipulacija.setBackground(Color.LIGHT_GRAY);
					zameniPanel.setBackground(Color.LIGHT_GRAY);
					t.setBackground(Color.WHITE);
					t.getTableHeader().setBackground(Color.LIGHT_GRAY);
					scroll.getViewport().setBackground(Color.LIGHT_GRAY);
					dodaj.setBackground(Color.LIGHT_GRAY);
					ukloni.setBackground(Color.LIGHT_GRAY);
					zameni.setBackground(Color.LIGHT_GRAY);
					labela1.setText("Odabrani metod rezonovanja: CBR");
				}
			}
		});
		
		//--------------------------------------------------------------------------------------------------------------------------
		//akcija dodavanja
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(labela1.getText().contains("RBR")) {
					if(RbrPanel.godTxt.getText().isEmpty() || RbrPanel.imeTxt.getText().isEmpty() || RbrPanel.przTxt.getText().isEmpty() ||
								RbrPanel.combo.isVisible() == false || RbrPanel.comboLek.isVisible() == false ||
								RbrPanel.comboProc.isVisible() == false || Main.simpTxt2.getSelectedItem() =="") {
						JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");
					}else {
						
						Pacijent p = new Pacijent();
						p.setIme(RbrPanel.imeTxt.getText());
						p.setPrz(RbrPanel.przTxt.getText());
						p.setGod(Integer.parseInt(RbrPanel.godTxt.getText()));
						p.setPol(Main.polTxt2.getSelectedItem().toString());
						
						if(Main.pusac2.isSelected())
							p.setPusac("Da");
						else if(!Main.pusac2.isSelected())
							p.setPusac("Ne");
						
						if(Main.sportista2.isSelected())
							p.setSportista("Da");
						else if(!Main.sportista2.isSelected())
							p.setSportista("Ne");
						
						p.setSimp(Main.simpTxt2.getSelectedItem().toString());
						p.setBolest(RbrPanel.combo.getSelectedItem().toString());
						p.setLek(RbrPanel.comboLek.getSelectedItem().toString());
						p.setProcedura(RbrPanel.comboProc.getSelectedItem().toString());	
						
						Main.pacijenti.add(p);
						
						RbrPanel.imeTxt.setText("");
						RbrPanel.przTxt.setText("");
						RbrPanel.godTxt.setText("");
						Main.simpTxt2.setSelectedItem(null);
						RbrPanel.combo.setVisible(false);
						RbrPanel.comboLek.setVisible(false);
						RbrPanel.comboProc.setVisible(false);
						Main.polTxt2.setSelectedItem(null);
						Main.sportista2.setSelected(false);
						Main.pusac2.setSelected(false);
						
						Main.bolesti2.clear();
						Main.lekovi2.clear();
						Main.procedure2.clear();
						
						//dodavanje reda u tabeli
						String pacijent = p.toString();
						Object[] rowData = new Object[10];
						
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
						//String pro2 = pro.replace("]","");
						
						String pol = pParts[7];
						String[] pol1 = pol.split("=");
						String praviPol = pol1[1];
						
						String pusac = pParts[8];
						String[] pus1 = pusac.split("=");
						String praviPusac = pus1[1];
						
						String sport = pParts[9];
						String[] sp1 = sport.split("=");
						String sportista = sp1[1];
						String praviSportista = sportista.replace("]", "");
						
						rowData[0] = ime;
						rowData[1] = prz;
						rowData[2] = god;
						rowData[3] = praviPol;
						rowData[4] = praviPusac;
						rowData[5] = praviSportista;
						rowData[6] = sim;					
						rowData[7] = bol;
						rowData[8] = lek;
						rowData[9] = pro;
						
						model.addRow(rowData);
						
						panelView.revalidate();
						panelView.repaint();
						
						 try {
						      FileOutputStream out = new FileOutputStream("pacijent2.out");
						      ObjectOutputStream oos = new ObjectOutputStream(out);
						      oos.writeObject(Main.pacijenti);
						      oos.flush();
						      oos.close();
						    } catch (Exception e) {
						      System.out.println("Problem serializing: " + e);
						    }					
					}
				}else if(labela1.getText().contains("CBR")){
					if(PanelPodaci.imeTxt.getText().isEmpty() || PanelPodaci.przTxt.getText().isEmpty() ||
						Main.godTxt.getText().isEmpty() || Main.bolTxt.getText().isEmpty() ||
							Main.simpTxt.getSelectedItem()=="" || Main.polTxt.getSelectedItem() =="" 
									|| !PanelProcedura.comboProcedura.isVisible() || !PanelLek.comboLek.isVisible()){
	
							 JOptionPane.showMessageDialog(null, "Molimo Vas popunite odgovarajuća polja!");	
					}
					else {
						
						Pacijent p = new Pacijent();
						p.setIme(PanelPodaci.imeTxt.getText());
						p.setPrz(PanelPodaci.przTxt.getText());
						p.setGod(Integer.parseInt(Main.godTxt.getText()));
						p.setPol(Main.polTxt.getSelectedItem().toString());
						
						if(Main.pusac.isSelected())
							p.setPusac("Da");
						else if(!Main.pusac.isSelected())
							p.setPusac("Ne");
						
						if(Main.sportista.isSelected())
							p.setSportista("Da");
						else if(!Main.sportista.isSelected())
							p.setSportista("Ne");
						
						p.setSimp(Main.simpTxt.getSelectedItem().toString());
						p.setBolest(Main.bolTxt.getText());
						p.setLek(PanelLek.comboLek.getSelectedItem().toString());
						p.setProcedura(PanelProcedura.comboProcedura.getSelectedItem().toString());	
															
						Main.pacijenti.add(p);
						
						PanelPodaci.imeTxt.setText("");
						PanelPodaci.przTxt.setText("");
						Main.godTxt.setText("");
						Main.simpTxt.setSelectedItem(null);
						Main.bolTxt.setText("");
						PanelBolest.combo.setVisible(false);
						PanelLek.comboLek.setVisible(false);
						PanelProcedura.comboProcedura.setVisible(false);
						Main.polTxt.setSelectedItem(null);
						Main.sportista.setSelected(false);
						Main.pusac.setSelected(false);
						
						Main.bolesti.clear();
						Main.lekovi.clear();
						Main.procedure.clear();
						
						//dodavanje reda u tabeli
						String pacijent = p.toString();
						Object[] rowData = new Object[10];
						
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
						//String pro2 = pro.replace("]","");
						
						String pol = pParts[7];
						String[] pol1 = pol.split("=");
						String praviPol = pol1[1];
						
						String pusac = pParts[8];
						String[] pus1 = pusac.split("=");
						String praviPusac = pus1[1];
						
						String sport = pParts[9];
						String[] sp1 = sport.split("=");
						String sportista = sp1[1];
						String praviSportista = sportista.replace("]", "");
						
						rowData[0] = ime;
						rowData[1] = prz;
						rowData[2] = god;
						rowData[3] = praviPol;
						rowData[4] = praviPusac;
						rowData[5] = praviSportista;
						rowData[6] = sim;					
						rowData[7] = bol;
						rowData[8] = lek;
						rowData[9] = pro;
						
						model.addRow(rowData);
						
						panelView.revalidate();
						panelView.repaint();
						
						 try {
						      FileOutputStream out = new FileOutputStream("pacijent2.out");
						      ObjectOutputStream oos = new ObjectOutputStream(out);
						      oos.writeObject(Main.pacijenti);
						      oos.flush();
						      oos.close();
						    } catch (Exception e) {
						      System.out.println("Problem serializing: " + e);
						    }
					}	
				}
			}
		});
		
		//---------------------------------------------------------------------------------------------------------------
		//akcija selektovanja reda u tabeli
		t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
			
				if(arg0.getValueIsAdjusting())
			      {
					String ime =t.getValueAt(t.getSelectedRow(), 0).toString();
					String prz = t.getValueAt(t.getSelectedRow(), 1).toString();
					String god = t.getValueAt(t.getSelectedRow(), 2).toString();
					String pol = t.getValueAt(t.getSelectedRow(), 3).toString();
					String pusac = t.getValueAt(t.getSelectedRow(), 4).toString();
					String sport = t.getValueAt(t.getSelectedRow(), 5).toString();
					String simp = t.getValueAt(t.getSelectedRow(), 6).toString();			
					String bol = t.getValueAt(t.getSelectedRow(), 7).toString();
					String lek = t.getValueAt(t.getSelectedRow(), 8).toString();
					String proc = t.getValueAt(t.getSelectedRow(), 9).toString();
					
					selectedPatient = new Pacijent();					
					selectedPatient.setIme(ime);
					selectedPatient.setPrz(prz);
					selectedPatient.setGod(Integer.parseInt(god));
					selectedPatient.setPol(pol);
					selectedPatient.setPusac(pusac);
					selectedPatient.setSportista(sport);
					selectedPatient.setSimp(simp);
					selectedPatient.setBolest(bol);
					selectedPatient.setLek(lek);
					selectedPatient.setProcedura(proc);
			      }				
			}
		});
		
		//------------------------------------------------------------------------------------------------------------------
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
						      FileOutputStream out = new FileOutputStream("pacijent2.out");
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
