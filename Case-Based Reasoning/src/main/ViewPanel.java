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

	public ViewPanel(){
		panelView = new JPanel();
		
		BorderLayout layout = new BorderLayout();
		panelView.setLayout(layout);
		panelView.setBackground(Color.lightGray);
		panelView.setBorder(BorderFactory.createLineBorder(Color.black));
		panelView.setPreferredSize(new Dimension(500,500));
		panelView.setMinimumSize(new Dimension(500,500));
		Main.frame.getContentPane().add(panelView, "East");
		
		//dodavanje tabele
		model = new DefaultTableModel();
		t = new JTable(model);
		
		model.addColumn("Ime");
		model.addColumn("Prezime");
		model.addColumn("Godine");
		model.addColumn("Simptom");
		model.addColumn("Bolest");
		model.addColumn("Lek");
		model.addColumn("Procedur");
		t.getColumnModel().getColumn(0).setPreferredWidth(59);
		t.getColumnModel().getColumn(1).setPreferredWidth(59);
		t.getColumnModel().getColumn(2).setPreferredWidth(59);
		t.getColumnModel().getColumn(3).setPreferredWidth(59);
		t.getColumnModel().getColumn(4).setPreferredWidth(59);
		t.getColumnModel().getColumn(5).setPreferredWidth(59);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		t.setRowHeight(20);
		
		//popunjavanje tabele vrednostima iz liste pacijenata
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
		
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(PanelPodaci.imeTxt.getText().isEmpty() || PanelPodaci.przTxt.getText().isEmpty() ||
					Main.godTxt.getText().isEmpty() || Main.bolTxt.getText().isEmpty() ||
						Main.simpTxt.getText().isEmpty()){
					
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
					System.out.println(ime);
					
					String przP = pParts[1];
					String[] prz1 = przP.split("=");
					String prz = prz1[1];
					System.out.println(prz);
					
					String godP = pParts[2];
					String[] god1 = godP.split("=");
					String god = god1[1];
					System.out.println(god);
					
					String simP = pParts[3];
					String[] sim1 = simP.split("=");
					String sim = sim1[1];
					System.out.println(sim);
					
					String bolP = pParts[4];
					String[] bol1 = bolP.split("=");
					String bol = bol1[1];
					System.out.println(bol);
					
					String lekP = pParts[5];
					String[] lek1 = lekP.split("=");
					String lek = lek1[1];
					System.out.println(lek);
					
					String proP = pParts[6];
					String[] pro1 = proP.split("=");
					String pro = pro1[1];
					System.out.println(pro);
					
					rowData[0] = ime;
					rowData[1] = prz;
					rowData[2] = god;
					rowData[3] = sim;
					rowData[4] = bol;
					rowData[5] = lek;
					rowData[6] = pro;
					
					model.addRow(rowData);
					
					panelView.revalidate();
					panelView.repaint();
					
					 try {
					      FileOutputStream out = new FileOutputStream("pacijent.out");
					      ObjectOutputStream oos = new ObjectOutputStream(out);
					      oos.writeObject(Main.pacijenti);
					      oos.flush();
					    } catch (Exception e) {
					      System.out.println("Problem serializing: " + e);
					    }
				}	
			}
		});
	}
}
