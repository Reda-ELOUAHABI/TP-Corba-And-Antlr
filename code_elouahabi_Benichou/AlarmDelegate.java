// AlarmDelegate.java
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.BorderLayout;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.*;

public class AlarmDelegate extends JFrame
      implements AlarmOperations {
    private int h;
    private int min;
    private int activater = 0;
    private JPanel contentPane;
    private JLabel lblNewLabel;

    private JPanel contentPane1;
    private JFrame frame;

    public AlarmDelegate() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 320, 110);
      contentPane = new JPanel();
      contentPane.setBackground(Color.BLACK);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      GridBagLayout gbl_contentPane = new GridBagLayout();
      gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
      contentPane.setLayout(gbl_contentPane);
      
      lblNewLabel = new JLabel("New label");
      lblNewLabel.setForeground(new Color(255, 0, 0));
      lblNewLabel.setFont(new Font("OCR A Extended", Font.BOLD, 40));
      GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
      gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
      gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
      gbc_lblNewLabel.gridx = 6;
      gbc_lblNewLabel.gridy = 2;
      contentPane.add(lblNewLabel, gbc_lblNewLabel);
      clock();
    }

  private void clock() {
    Thread th = new Thread() {
      public void run () {
        try {
          for(;;) {
            Calendar cl = new GregorianCalendar();
            int second = cl.get(Calendar.SECOND);
            int minut = cl.get(Calendar.MINUTE);
            int hour = cl.get(Calendar.HOUR);
            int am_pm = cl.get(Calendar.AM_PM);
            String d_n ="";
            if(am_pm ==1) d_n="PM";
            else d_n="AM";
            lblNewLabel.setText(""+hour+":"+minut+":"+second+" "+d_n);
            if(min==minut && h==hour && activater==0){
              activater=1;
              activat();
            }
            sleep(1000);
          }
        }
        catch(Exception e) {
          
        }
      }
    };
    th.start();
    
  }
  
    public void LocalTime () {
       EventQueue.invokeLater(new Runnable() {
        public void run() {
          try {
            AlarmDelegate frame = new AlarmDelegate();
            frame.setVisible(true);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
    }

    public void setAlarm(int h,int min) {
        activater=0;
        this.min = min;
        this.h = h;
    }
    public int min() {
      return min;
    }
    public int h() {
      return h;
    }
    public void activat(){
      Thread th = new Thread() {
      public void run () {
        try {
          for(;;) {
            Toolkit.getDefaultToolkit().beep();
            sleep(1000);
          }
        }
        catch(Exception e) {
          
        }
      }
    };
    th.start();
      EventQueue.invokeLater(new Runnable() {
                public void run() {
                  try {
                    frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(100, 100, 450, 300);
                    contentPane1 = new JPanel();
                    contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
                    contentPane1.setLayout(new BorderLayout(0, 0));
                    
                    
                    JLabel lblItsTime = new JLabel("Debout C'est l'heure ");
                    lblItsTime.setHorizontalAlignment(SwingConstants.CENTER);
                    lblItsTime.setFont(new Font("Tahoma", Font.PLAIN, 60));
                    contentPane1.add(lblItsTime, BorderLayout.CENTER);
                    
                    JButton btnClose = new JButton("Close");
                    btnClose.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        th.stop();
                      }
                    });
                    contentPane1.add(btnClose, BorderLayout.SOUTH);
                    frame.setVisible(true);
                    frame.setContentPane(contentPane1);
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                }
              });
    }
}