// GUIClient.java
//import Count.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import static java.lang.System.*;

public class GUIClient extends JPanel {
    private Horloge c;
    private ORB orb;

    private void initializeORB(String[] args) {
        Properties props = getProperties();
        orb = ORB.init(args, props);
    }


    private void createGUI() {
        setLayout(new GridLayout(2, 1));
        JPanel p = new JPanel();
        p.setBackground(Color.GREEN);
        add(p, BorderLayout.CENTER);
        final JLabel value;
        p.add(new JLabel("Heure value ", JLabel.RIGHT));
        p.add(value = new JLabel(String.valueOf(c.heure())));
        add(p);
        p = new JPanel();
        JButton GMT, ETE;
        p.add(GMT = new JButton("GetGMT"));
        p.add(ETE = new JButton("GetHEte"));
        add(p);
        GMT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.setGMT();
                value.setText("GMT = "+String.valueOf(c.heure()));
            }
        });
        ETE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c.setHeureEte();
                value.setText("ETE = "+String.valueOf(c.heure()));
            }
        });
    }
    public GUIClient(String[] args) {
        try {
            initializeORB(args);
            NamingContext nc = NamingContextHelper.narrow(
                    orb.resolve_initial_references("NameService"));
            NameComponent[] name = new NameComponent[1];
            name[0] = new NameComponent();
            name[0].id = "Horloge";
            name[0].kind = "Objet";
            org.omg.CORBA.Object obj = nc.resolve(name);
            c = HorlogeHelper.narrow(obj);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
            LocalDateTime now = LocalDateTime.now();
           System.out.println("l'heure  actuelle GMT="+dtf.format(now).toString());

            c.setGMT();
            c.setHeureEte();
           System.out.println("l'Heure d'ete ="+ c.heure());
          createGUI();
        } catch (BAD_PARAM ex) {
            out.println("Narrowing failed");
            exit(3);
        } catch(Exception ex) {
            out.println("Exception: " + ex.getMessage());
            exit(1); }
    }
    public static void main(String[] args) {
        new GUIClient(args);
        JFrame f = new JFrame("Horloge Client");
        f.getContentPane().add(new GUIClient(args));
        f.pack();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }
}