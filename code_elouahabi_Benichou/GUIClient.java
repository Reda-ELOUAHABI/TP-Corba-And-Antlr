import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Properties;
import javax.swing.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import static java.lang.System.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIClient extends JFrame {

	private JPanel contentPane;
	private Alarm c;
	private ORB orb;

    private void initializeORB(String[] args) {
      Properties props = getProperties();
      orb = ORB.init(args, props);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIClient frame = new GUIClient(args);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUIClient(String[] args) {
		createGUI(args);
	}
	/**
	 * Create the frame.
	 */
	public void createGUI(String[] args) {
		try {
        initializeORB(args);
        NamingContextExt nc = NamingContextExtHelper.narrow(
          orb.resolve_initial_references("NameService"));

        NameComponent[] name = nc.to_name("Home.Object/Alarm.Fonction");
        
        

        org.omg.CORBA.Object obj = nc.resolve(name);
        this.c = AlarmHelper.narrow(obj);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 11, 1));
		spinner.setFont(new Font("OCR A Extended", Font.PLAIN, 50));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 4;
		gbc_spinner.gridy = 5;
		contentPane.add(spinner, gbc_spinner);
		
		JButton btnNewButton = new JButton("Time Now");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c.LocalTime ();
				}
			});
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("OCR A Extended", Font.PLAIN, 50));
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 5;
		gbc_spinner_1.gridy = 5;
		contentPane.add(spinner_1, gbc_spinner_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Set alarme");

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = (int) spinner.getValue();
				int j = (int) spinner_1.getValue();
				c.setAlarm(i,j);
			}
		});

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 8;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		

		
	}
	 catch (BAD_PARAM ex) {
        out.println("Narrowing failed");
        exit(3);
      } catch(Exception ex) {
        out.println("Exception: " + ex.getMessage());
        exit(1); 
      }

}
}