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
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Patient;
import model.PhysicalExamination;
import model.Table.PatientBase;
import view.MainFrame;

public class NovaProceduraDijalog extends JDialog{
	
	private JPanel contentPanel = new JPanel();
	
	private JPanel panel;
	private JLabel label_1;
	private JComboBox<String> combo;
	private JButton button;
	private JPanel panel_1;
	private JLabel label_2;
	private JButton btnUradi;
	
	public NovaProceduraDijalog() {
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Dodavanje preventivnog pregleda");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(450,350);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {30, 30, 0, 30, 30, 30};
		gbl_contentPanel.rowHeights = new int[] {30, 0, 30, 0, 30, 0, 30, 0, 30, 0, 30, 30, 30};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		{
			panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 5);
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{30, 30, 0, 30, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{50, 50, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			label_1 = new JLabel("Zakljucivanje:");
			label_1.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 0, 5);
			gbc_label_1.gridx = 2;
			gbc_label_1.gridy = 1;
			panel.add(label_1, gbc_label_1);
			
			combo = new JComboBox<String>();
			combo.addItem("Rule based");
			combo.addItem("Case based");
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.gridx = 4;
			gbc_comboBox.gridy = 1;
			panel.add(combo, gbc_comboBox);
			
			//dugme pogledaj
			button = new JButton("Pogledaj");
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.gridx = 5;
			gbc_button.gridy = 1;
			panel.add(button, gbc_button);
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		{
			panel_1 = new JPanel();
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.gridheight = 4;
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 1;
			contentPanel.add(panel_1, gbc_panel_1);
			
			label_2 = new JLabel("Preporucena dopunska ispitivanja su:");
			label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel_1.add(label_2);
		}
		{
			//dugme uradi
			btnUradi = new JButton("Uradi");
			GridBagConstraints gbc_btnUradi = new GridBagConstraints();
			gbc_btnUradi.insets = new Insets(0, 0, 0, 5);
			gbc_btnUradi.gridx = 0;
			gbc_btnUradi.gridy = 11;
			contentPanel.add(btnUradi, gbc_btnUradi);
		}
	}
}
