package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.AboutActionDialog;
import controller.NewPatientDialogAction;
import model.Table.PatientBase;
import model.Table.PatientTable;


public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	
	private JPanel contentPane;
	private JLabel logoLabel;
	private JPanel mainPanel;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}

	private MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth/2 + 400, screenHeight/2 + 250);
        setLocationRelativeTo(null);
		
		setIconImage(new ImageIcon("images/medCareLogo.png").getImage());
		setTitle("Dobrodo\u0161li u medCare aplikaciju");
		//setBounds(100, 100, 550, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu patientsMenu = new JMenu("Pacijenti");
		menuBar.add(patientsMenu);
		
		JMenuItem viewPatientsMenuItem = new JMenuItem(("Svi pacijenti"));
		viewPatientsMenuItem.setIcon(new ImageIcon("images/db_icon&24.png"));
		patientsMenu.add(viewPatientsMenuItem);
		
		JMenuItem newPatientMenuItem = new JMenuItem(new NewPatientDialogAction("Dodavanje novog pacijenta"));
		newPatientMenuItem.setIcon(new ImageIcon("images/create_icon&24.png"));
		patientsMenu.add(newPatientMenuItem);
		
		JMenu helpMenu = new JMenu("Pomoc");
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("O aplikaciji");
		aboutMenuItem.addActionListener(new AboutActionDialog());
		aboutMenuItem.setIcon(new ImageIcon("images/info_icon&24.png"));
		helpMenu.add(aboutMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton newPatientButton = new JButton(new NewPatientDialogAction());
		newPatientButton.setText("Novi pacijent");
		newPatientButton.setIcon(new ImageIcon("images/create_icon&24.png"));
		toolBar.add(newPatientButton);
		
		JButton viewPatientsButton = new JButton();
		viewPatientsButton.setText("Svi pacijenti");
		viewPatientsButton.setIcon(new ImageIcon("images/db_icon&24.png"));
		viewPatientsButton.setToolTipText("Svi pacijenti");
		toolBar.add(viewPatientsButton);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setText("O pacijentu");
		btnNewButton.setIcon(new ImageIcon("images/info_icon&24.png"));
		toolBar.add(btnNewButton);
		
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		mainPanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		
		ImageIcon logoIcon = new ImageIcon ("images/medCareLogo.png");
		Image image = logoIcon.getImage();
		Image newImg = image.getScaledInstance(screenWidth/6, screenWidth/6, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(newImg);
		   
		logoLabel = new JLabel("");
		//logoLabel.setIcon(new ImageIcon("images/medCareLogo.png"));
		logoLabel.setIcon(logoIcon);
		logoLabel.setHorizontalAlignment(JLabel.CENTER);
		logoLabel.setVerticalAlignment(JLabel.CENTER);
				
		mainPanel.add(logoLabel, BorderLayout.CENTER);
		
		//status bar
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.DARK_GRAY);
		statusPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		contentPane.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(240, 248, 255));
		statusPanel.add(infoPanel, BorderLayout.CENTER);
		
		JLabel infoLabel = new JLabel("Dobrodo\u0161li u medCare aplikaciju!");
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		infoLabel.setForeground(new Color(0, 128, 0));
		infoPanel.add(infoLabel);
		
		JPanel datePanel = new JPanel();
		statusPanel.add(datePanel, BorderLayout.EAST);
		
		// Formatiranje i preuzimanje trenutnog datuma
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDate localDate = LocalDate.now();
		
		JLabel dateLabel = new JLabel(dtf.format(localDate));
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setVerticalAlignment(JLabel.CENTER);
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		datePanel.add(dateLabel);
		
		
		
		     
	}
	
	

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(JLabel logoLabel) {
		this.logoLabel = logoLabel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	
}
