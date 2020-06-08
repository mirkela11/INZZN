package view.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class PhysicalExaminationDialog extends JDialog{
	
	private JPanel contentPane;
	private JToolBar toolBar;
	private JButton dodajPregledButton;
	
	public PhysicalExaminationDialog() {
		initComponents();
	}
	
	public void initComponents() {
		setTitle("Pregledi pacijenta");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(450,450);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		dodajPregledButton = new JButton("Novi pregled");
		dodajPregledButton.setIcon(new ImageIcon("images/create_icon&24.png"));
		dodajPregledButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NewPhysicalExaminationDialog d = new NewPhysicalExaminationDialog();
				d.setVisible(true);
			}
		});
		
		toolBar.add(dodajPregledButton);
	}

}
