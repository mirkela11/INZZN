package view.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SelectAnamnesisDialog extends JDialog{
	
	private JPanel contentPanel;
	private JPanel infoPanel;
	private JLabel infoLabel;
	private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel infoLeftPanel;
	private JLabel infoLeftLabel;
	private JPanel buttonPanel;
	private JButton leftToRightButton;
	private JButton rightToLeftButton;
	private JScrollPane possibleValuesScrollPane;
	private JPanel rightPanel;
	private JPanel infoRightPanel;
	private JLabel infoRightLabel;
	private JScrollPane selectedValuesScrollPane;
	private JPanel buttonPanelDole;
	private JButton okButton;
	private JButton cancelButton;
	
	//ovo promeniti
	private JList<String> possibleValuesList;
	private JList<String> selectedValuesList;
	
	public SelectAnamnesisDialog() {
		initComponents();
	}
	
	public void initComponents(){
		
		setTitle("Dodavanje nove anamneze");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(600,550);
		setLocationRelativeTo(null);
		
		contentPanel = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		{
			infoPanel = new JPanel();
			contentPanel.add(infoPanel, BorderLayout.NORTH);
			{
				infoLabel = new JLabel("Odaberite anamneze iz spiska dostupnih anamneza:");
				infoPanel.add(infoLabel);
			}
		}
		
		{
			mainPanel = new JPanel();
			contentPanel.add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(new GridLayout(0, 2, 0, 0));
			{
				//levi panel
				leftPanel = new JPanel();
				mainPanel.add(leftPanel);
				leftPanel.setLayout(new BorderLayout(0, 0));
				{
					infoLeftPanel = new JPanel();
					leftPanel.add(infoLeftPanel, BorderLayout.NORTH);
					{
						infoLeftLabel = new JLabel("Odaberite neku od mogucih dijagnoza(bolesti):");
						infoLeftPanel.add(infoLeftLabel);
					}
				}
				{
					buttonPanel = new JPanel();
					leftPanel.add(buttonPanel, BorderLayout.EAST);
					GridBagLayout gbl_buttonPanel = new GridBagLayout();
					gbl_buttonPanel.columnWidths = new int[]{89, 0};
					gbl_buttonPanel.rowHeights = new int[] {42, 42, 30, 30, 30, 30, 30, 0, 30, 0, 30, 42, 42, 42, 42, 42, 42, 42};
					gbl_buttonPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
					gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					buttonPanel.setLayout(gbl_buttonPanel);
					{	//dugme s leva na desno
						leftToRightButton = new JButton();
						leftToRightButton.setIcon(new ImageIcon("images/arrow_right_icon&48.png"));
						leftToRightButton.addActionListener(new AbstractAction() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
						GridBagConstraints gbc_leftToRightButton = new GridBagConstraints();
						gbc_leftToRightButton.insets = new Insets(0, 0, 5, 0);
						gbc_leftToRightButton.fill = GridBagConstraints.BOTH;
						gbc_leftToRightButton.gridx = 0;
						gbc_leftToRightButton.gridy = 7;
						buttonPanel.add(leftToRightButton, gbc_leftToRightButton);
					}
					{	//dugme s desna na levo
						rightToLeftButton = new JButton();
						rightToLeftButton.setIcon(new ImageIcon("images/arrow_left_icon&48.png"));
						rightToLeftButton.addActionListener(new AbstractAction() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
						GridBagConstraints gbc_rightToLeftButton = new GridBagConstraints();
						gbc_rightToLeftButton.fill = GridBagConstraints.BOTH;
						gbc_rightToLeftButton.gridx = 0;
						gbc_rightToLeftButton.gridy = 9;
						buttonPanel.add(rightToLeftButton, gbc_rightToLeftButton);
					}
				}
				{
					//promeniti possibleValuesList
					possibleValuesScrollPane = new JScrollPane(possibleValuesList);
					leftPanel.add(possibleValuesScrollPane, BorderLayout.CENTER);
				}
			}
			{
				//desni panel
				rightPanel = new JPanel();
				mainPanel.add(rightPanel);
				rightPanel.setLayout(new BorderLayout(0, 0));
				{
					infoRightPanel = new JPanel();
					rightPanel.add(infoRightPanel, BorderLayout.NORTH);
					{
						infoRightLabel = new JLabel("Trenutno odabrane dijagnoze(bolest)");
						infoRightPanel.add(infoRightLabel);
					}
				}
				{
					selectedValuesScrollPane = new JScrollPane(selectedValuesList);
					rightPanel.add(selectedValuesScrollPane, BorderLayout.CENTER);
				}
			}
		}
		
		{
			//donji panel sa dugmicima 
			buttonPanelDole = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setHgap(25);
			buttonPanelDole.setLayout(fl_buttonPane);
			getContentPane().add(buttonPanelDole, BorderLayout.SOUTH);
			{
				//dugme Dodaj
				okButton = new JButton("Dodaj");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				buttonPanelDole.add(okButton);
			}
			{
				//dugme Prekini
				cancelButton = new JButton("Prekini");
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
				buttonPanelDole.add(cancelButton);
			}
		}
	}

}
