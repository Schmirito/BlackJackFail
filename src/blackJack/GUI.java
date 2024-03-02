package blackJack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField tfSetzen;
	private JTextField tfGeld;
	private JTextField tfDealer;
	private JTextField tfDeck;
	private JTextField tfSpieler1;
	private JTextField tfSpieler2;
	private JTextField tfSpieler3;
	private JTextField tfVerlauf;
	private JTextField tfSpieler4;
	
	Steuerung dieSteuerung;
	boolean showOff = false;
	
	public ArrayList<String> verlauf = new ArrayList<>();

	private JTextField tfEinsatzS1;
	private JTextField tfEinsatzS2;
	private JTextField tfEinsatzS3;
	private JTextField tfEinsatzS4;
	private JTextField tfKartenWertS2;
	private JTextField tfKartenWertS1;
	private JTextField tfKartenWertS3;
	private JTextField tfKartenWertS4;
	private JTextField tfKartenWertD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		dieSteuerung = new Steuerung(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 780, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setResizable(false);
		
		JPanel pAction = new JPanel();
		frame.getContentPane().add(pAction, BorderLayout.SOUTH);
		
		JButton btVersicherung = new JButton("Verischerung");
		btVersicherung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Einfuegen, dass bei keinem Ass, Button deaktiviert wird.
				dieSteuerung.state = "versicherung";
			}
		});
		pAction.add(btVersicherung);
		
		JButton btStand = new JButton("Stand");
		btStand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		pAction.add(btStand);
		
		JButton btDouble = new JButton("Double");
		btDouble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "double";
			}
		});
		pAction.add(btDouble);
		
		JButton btHit = new JButton("Hit");
		btHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "hit";
			}
		});
		pAction.add(btHit);
		
		JPanel pSetzen = new JPanel();
		frame.getContentPane().add(pSetzen, BorderLayout.WEST);
		GridBagLayout gbl_pSetzen = new GridBagLayout();
		gbl_pSetzen.columnWidths = new int[]{86, 0};
		gbl_pSetzen.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pSetzen.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pSetzen.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pSetzen.setLayout(gbl_pSetzen);
		
		tfSetzen = new JTextField();
		tfSetzen.setEditable(false);
		tfSetzen.setHorizontalAlignment(SwingConstants.CENTER);
		tfSetzen.setText("Setzen:");
		GridBagConstraints gbc_tfSetzen = new GridBagConstraints();
		gbc_tfSetzen.insets = new Insets(0, 0, 5, 0);
		gbc_tfSetzen.anchor = GridBagConstraints.NORTH;
		gbc_tfSetzen.gridx = 0;
		gbc_tfSetzen.gridy = 0;
		pSetzen.add(tfSetzen, gbc_tfSetzen);
		tfSetzen.setColumns(10);
		
		JButton btFuenf = new JButton("5");
		btFuenf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=5;
				
				erhoeheEinsatz();
				
			}
		});
		GridBagConstraints gbc_btFuenf = new GridBagConstraints();
		gbc_btFuenf.fill = GridBagConstraints.HORIZONTAL;
		gbc_btFuenf.insets = new Insets(0, 0, 5, 0);
		gbc_btFuenf.gridx = 0;
		gbc_btFuenf.gridy = 1;
		pSetzen.add(btFuenf, gbc_btFuenf);
		
		JButton btZehn = new JButton("10");
		btZehn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=10;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btZehn = new GridBagConstraints();
		gbc_btZehn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btZehn.insets = new Insets(0, 0, 5, 0);
		gbc_btZehn.gridx = 0;
		gbc_btZehn.gridy = 2;
		pSetzen.add(btZehn, gbc_btZehn); 
		
		JButton btFuenfUndZwanzig = new JButton("25");
		btFuenfUndZwanzig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=25;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btFuenfUndZwanzig = new GridBagConstraints();
		gbc_btFuenfUndZwanzig.fill = GridBagConstraints.HORIZONTAL;
		gbc_btFuenfUndZwanzig.insets = new Insets(0, 0, 5, 0);
		gbc_btFuenfUndZwanzig.gridx = 0;
		gbc_btFuenfUndZwanzig.gridy = 3;
		pSetzen.add(btFuenfUndZwanzig, gbc_btFuenfUndZwanzig);
		
		JButton btFuenfzig = new JButton("50");
		btFuenfzig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=50;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btFuenfzig = new GridBagConstraints();
		gbc_btFuenfzig.insets = new Insets(0, 0, 5, 0);
		gbc_btFuenfzig.fill = GridBagConstraints.HORIZONTAL;
		gbc_btFuenfzig.gridx = 0;
		gbc_btFuenfzig.gridy = 4;
		pSetzen.add(btFuenfzig, gbc_btFuenfzig);
		
		JButton btHundert = new JButton("100");
		btHundert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=100;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btHundert = new GridBagConstraints();
		gbc_btHundert.insets = new Insets(0, 0, 5, 0);
		gbc_btHundert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btHundert.gridx = 0;
		gbc_btHundert.gridy = 5;
		pSetzen.add(btHundert, gbc_btHundert);
		
		JButton btZweihundertFuenfzig = new JButton("250");
		btZweihundertFuenfzig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=250;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btZweihundertFuenfzig = new GridBagConstraints();
		gbc_btZweihundertFuenfzig.insets = new Insets(0, 0, 5, 0);
		gbc_btZweihundertFuenfzig.fill = GridBagConstraints.HORIZONTAL;
		gbc_btZweihundertFuenfzig.gridx = 0;
		gbc_btZweihundertFuenfzig.gridy = 6;
		pSetzen.add(btZweihundertFuenfzig, gbc_btZweihundertFuenfzig);
		
		JButton btFuenfHundert = new JButton("500");
		btFuenfHundert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=500;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btFuenfHundert = new GridBagConstraints();
		gbc_btFuenfHundert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btFuenfHundert.insets = new Insets(0, 0, 5, 0);
		gbc_btFuenfHundert.gridx = 0;
		gbc_btFuenfHundert.gridy = 7;
		pSetzen.add(btFuenfHundert, gbc_btFuenfHundert);
		
		JButton btTausend = new JButton("1.000");
		btTausend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=1000;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btTausend = new GridBagConstraints();
		gbc_btTausend.insets = new Insets(0, 0, 5, 0);
		gbc_btTausend.fill = GridBagConstraints.HORIZONTAL;
		gbc_btTausend.gridx = 0;
		gbc_btTausend.gridy = 8;
		pSetzen.add(btTausend, gbc_btTausend);
		
		JButton btZweiTausendFuenfHundert = new JButton("2.500");
		btZweiTausendFuenfHundert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=2500;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btZweiTausendFuenfHundert = new GridBagConstraints();
		gbc_btZweiTausendFuenfHundert.insets = new Insets(0, 0, 5, 0);
		gbc_btZweiTausendFuenfHundert.anchor = GridBagConstraints.NORTH;
		gbc_btZweiTausendFuenfHundert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btZweiTausendFuenfHundert.gridx = 0;
		gbc_btZweiTausendFuenfHundert.gridy = 9;
		pSetzen.add(btZweiTausendFuenfHundert, gbc_btZweiTausendFuenfHundert);
		
		JButton btFuenfTausend = new JButton("5.000");
		btFuenfTausend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.state = "setzen";
				dieSteuerung.momSpieler.einsatz+=5000;
				
				erhoeheEinsatz();
			}
		});
		GridBagConstraints gbc_btFuenfTausend = new GridBagConstraints();
		gbc_btFuenfTausend.insets = new Insets(0, 0, 5, 0);
		gbc_btFuenfTausend.anchor = GridBagConstraints.NORTH;
		gbc_btFuenfTausend.fill = GridBagConstraints.HORIZONTAL;
		gbc_btFuenfTausend.gridx = 0;
		gbc_btFuenfTausend.gridy = 10;
		pSetzen.add(btFuenfTausend, gbc_btFuenfTausend);
		
		JPanel pMain = new JPanel();
		frame.getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(null);
		
		tfGeld = new JTextField();
		tfGeld.setHorizontalAlignment(SwingConstants.LEFT);
		tfGeld.setEditable(false);
		tfGeld.setText("Geld:");
		tfGeld.setBounds(10, 11, 97, 20);
		pMain.add(tfGeld);
		tfGeld.setColumns(10);
		
		tfDealer = new JTextField();
		tfDealer.setHorizontalAlignment(SwingConstants.CENTER);
		tfDealer.setEditable(false);
		tfDealer.setText("Dealer");
		tfDealer.setBounds(217, 40, 77, 20);
		pMain.add(tfDealer);
		tfDealer.setColumns(10);
		
		tfDeck = new JTextField();
		tfDeck.setHorizontalAlignment(SwingConstants.LEFT);
		tfDeck.setEditable(false);
		tfDeck.setText("Deck:");
		tfDeck.setBounds(450, 11, 77, 20);
		pMain.add(tfDeck);
		tfDeck.setColumns(10);
		
		tfSpieler1 = new JTextField();
		tfSpieler1.setHorizontalAlignment(SwingConstants.CENTER);
		tfSpieler1.setEditable(false);
		tfSpieler1.setText("Spieler 1");
		tfSpieler1.setBounds(30, 218, 77, 20);
		pMain.add(tfSpieler1);
		tfSpieler1.setColumns(10);
		
		tfSpieler2 = new JTextField();
		tfSpieler2.setHorizontalAlignment(SwingConstants.CENTER);
		tfSpieler2.setEditable(false);
		tfSpieler2.setText("Spieler 2");
		tfSpieler2.setBounds(144, 271, 77, 20);
		pMain.add(tfSpieler2);
		tfSpieler2.setColumns(10);
		
		tfSpieler3 = new JTextField();
		tfSpieler3.setEditable(false);
		tfSpieler3.setText("Spieler 3");
		tfSpieler3.setHorizontalAlignment(SwingConstants.CENTER);
		tfSpieler3.setBounds(289, 271, 77, 20);
		pMain.add(tfSpieler3);
		tfSpieler3.setColumns(10);
		
		tfSpieler4 = new JTextField();
		tfSpieler4.setText("Spieler 4");
		tfSpieler4.setHorizontalAlignment(SwingConstants.CENTER);
		tfSpieler4.setEditable(false);
		tfSpieler4.setBounds(405, 218, 77, 20);
		pMain.add(tfSpieler4);
		tfSpieler4.setColumns(10);
		
		tfEinsatzS1 = new JTextField();
		tfEinsatzS1.setHorizontalAlignment(SwingConstants.CENTER);
		tfEinsatzS1.setEditable(false);
		tfEinsatzS1.setBounds(30, 236, 77, 20);
		pMain.add(tfEinsatzS1);
		tfEinsatzS1.setColumns(10);
		
		tfEinsatzS2 = new JTextField();
		tfEinsatzS2.setHorizontalAlignment(SwingConstants.CENTER);
		tfEinsatzS2.setEditable(false);
		tfEinsatzS2.setBounds(144, 290, 77, 20);
		pMain.add(tfEinsatzS2);
		tfEinsatzS2.setColumns(10);
		
		tfEinsatzS3 = new JTextField();
		tfEinsatzS3.setHorizontalAlignment(SwingConstants.CENTER);
		tfEinsatzS3.setEditable(false);
		tfEinsatzS3.setBounds(289, 290, 77, 20);
		pMain.add(tfEinsatzS3);
		tfEinsatzS3.setColumns(10);
		
		tfEinsatzS4 = new JTextField();
		tfEinsatzS4.setHorizontalAlignment(SwingConstants.CENTER);
		tfEinsatzS4.setEditable(false);
		tfEinsatzS4.setBounds(405, 236, 77, 20);
		pMain.add(tfEinsatzS4);
		tfEinsatzS4.setColumns(10);
		
		tfKartenWertS2 = new JTextField();
		tfKartenWertS2.setHorizontalAlignment(SwingConstants.CENTER);
		tfKartenWertS2.setEditable(false);
		tfKartenWertS2.setBounds(144, 222, 77, 38);
		pMain.add(tfKartenWertS2);
		tfKartenWertS2.setColumns(10);
		
		tfKartenWertS1 = new JTextField();
		tfKartenWertS1.setHorizontalAlignment(SwingConstants.CENTER);
		tfKartenWertS1.setEditable(false);
		tfKartenWertS1.setBounds(30, 169, 77, 38);
		pMain.add(tfKartenWertS1);
		tfKartenWertS1.setColumns(10);
		
		tfKartenWertS3 = new JTextField();
		tfKartenWertS3.setHorizontalAlignment(SwingConstants.CENTER);
		tfKartenWertS3.setEditable(false);
		tfKartenWertS3.setBounds(289, 221, 77, 39);
		pMain.add(tfKartenWertS3);
		tfKartenWertS3.setColumns(10);
		
		tfKartenWertS4 = new JTextField();
		tfKartenWertS4.setHorizontalAlignment(SwingConstants.CENTER);
		tfKartenWertS4.setEditable(false);
		tfKartenWertS4.setBounds(405, 165, 77, 42);
		pMain.add(tfKartenWertS4);
		tfKartenWertS4.setColumns(10);
		
		tfKartenWertD = new JTextField();
		tfKartenWertD.setHorizontalAlignment(SwingConstants.CENTER);
		tfKartenWertD.setEditable(false);
		tfKartenWertD.setBounds(217, 71, 77, 38);
		pMain.add(tfKartenWertD);
		tfKartenWertD.setColumns(10);
		
		JPanel pTools = new JPanel();
		frame.getContentPane().add(pTools, BorderLayout.NORTH);
		
		JButton btNaechsterSpieler = new JButton("Naechster Spieler");
		btNaechsterSpieler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				if (dieSteuerung.spielerZaehler < dieSteuerung.spielerAnz-1) {
					dieSteuerung.setMomSpieler();
				}
				else {
					dieSteuerung.austeilen();
				}
			}
		});
		pTools.add(btNaechsterSpieler);
		
		JButton btPausieren = new JButton("Pausieren");
		pTools.add(btPausieren);
		
		JButton btSpielBeginnen = new JButton("Spiel beginnen");
		btSpielBeginnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dieSteuerung.austeilen();
				update();
			}
		});
		pTools.add(btSpielBeginnen);
		
		JButton btSpielBeenden = new JButton("Spiel beenden");
		pTools.add(btSpielBeenden);
		
		JPanel pVerlauf = new JPanel();
		frame.getContentPane().add(pVerlauf, BorderLayout.EAST);
		GridBagLayout gbl_pVerlauf = new GridBagLayout();
		gbl_pVerlauf.columnWidths = new int[]{86, 0};
		gbl_pVerlauf.rowHeights = new int[]{20, 0, 0};
		gbl_pVerlauf.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pVerlauf.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pVerlauf.setLayout(gbl_pVerlauf);
		
		tfVerlauf = new JTextField();
		tfVerlauf.setHorizontalAlignment(SwingConstants.CENTER);
		tfVerlauf.setEditable(false);
		tfVerlauf.setText("Verlauf:");
		GridBagConstraints gbc_tfVerlauf = new GridBagConstraints();
		gbc_tfVerlauf.insets = new Insets(0, 0, 5, 0);
		gbc_tfVerlauf.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfVerlauf.gridx = 0;
		gbc_tfVerlauf.gridy = 0;
		pVerlauf.add(tfVerlauf, gbc_tfVerlauf);
		tfVerlauf.setColumns(10);
		
		
	}
	public void addNachricht(String nachricht) {
		verlauf.add(nachricht);
		
	}
	public void erhoeheEinsatz() {
		switch (dieSteuerung.momSpieler.name) {
		case "Spieler 1":
			tfEinsatzS1.setEditable(true);
			tfEinsatzS1.setText(" "+dieSteuerung.momSpieler.einsatz+" ");
			tfEinsatzS1.setEditable(false);
			break;
		case "Spieler 2":
			tfEinsatzS2.setEditable(true);
			tfEinsatzS2.setText(" "+dieSteuerung.momSpieler.einsatz+" ");
			tfEinsatzS2.setEditable(false);
			break;
		case "Spieler 3":
			tfEinsatzS3.setEditable(true);
			tfEinsatzS3.setText(" "+dieSteuerung.momSpieler.einsatz+" ");
			tfEinsatzS3.setEditable(false);
			break;
		case "Spieler 4":
			tfEinsatzS4.setEditable(true);
			tfEinsatzS4.setText(" "+dieSteuerung.momSpieler.einsatz+" ");
			tfEinsatzS4.setEditable(false);
			break;
		default:
			break;
		}
	}
	public void update() {

		tfKartenWertS1.setEditable(true);
		tfKartenWertS1.setText(" "+dieSteuerung.dieSpieler[0].kartenWertGes+" ");
		tfKartenWertS1.setEditable(false);
		tfGeld.setEditable(true);
		tfGeld.setText("Geld: "+dieSteuerung.dieSpieler[0].geld+" ");
		tfGeld.setEditable(false);
		
		tfKartenWertS2.setEditable(true);
		tfKartenWertS2.setText(" "+dieSteuerung.dieSpieler[1].kartenWertGes+" ");
		tfKartenWertS2.setEditable(false);
		tfGeld.setEditable(true);
		tfGeld.setText("Geld: "+dieSteuerung.dieSpieler[1].geld+" ");
		tfGeld.setEditable(false);
		
		tfKartenWertS3.setEditable(true);
		tfKartenWertS3.setText(" "+dieSteuerung.dieSpieler[2].kartenWertGes+" ");
		tfKartenWertS3.setEditable(false);
		tfGeld.setEditable(true);
		tfGeld.setText("Geld: "+dieSteuerung.dieSpieler[2].geld+" ");
		tfGeld.setEditable(false);
		
		tfKartenWertS4.setEditable(true);
		tfKartenWertS4.setText(" "+dieSteuerung.dieSpieler[3].kartenWertGes+" ");
		tfKartenWertS4.setEditable(false);
		tfGeld.setEditable(true);
		tfGeld.setText("Geld: "+dieSteuerung.dieSpieler[3].geld+" ");
		tfGeld.setEditable(false);
		
		tfKartenWertD.setEditable(true);
		tfKartenWertD.setText(" "+dieSteuerung.derDealer.kartenWertOffen+" ");
		tfKartenWertD.setEditable(false);
		
		if (showOff) {
			tfKartenWertD.setEditable(true);
			tfKartenWertD.setText(" "+dieSteuerung.derDealer.kartenWertGes+" ");
			tfKartenWertD.setEditable(false);
			
			dieSteuerung.dealerAlg();
		}
	}
}
