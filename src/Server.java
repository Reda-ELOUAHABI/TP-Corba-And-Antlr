
// Server.java
import java.io.*;

import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;

public class Server {
	public static void main(String[] args) {
		try {
			System.out.println("runnig the server");
			Properties props = getProperties();
			ORB orb = ORB.init(args, props);
			org.omg.CORBA.Object obj = null;
			POA rootPOA = null;
			try {
				obj = orb.resolve_initial_references("RootPOA");
				rootPOA = POAHelper.narrow(obj);	
			} catch (org.omg.CORBA.ORBPackage.InvalidName e) {  }
				CounterImp c_imp = new CounterImp();
				System.out.println("here the programm crashes");
				Counter c = c_imp._this(orb);
				try {
					
					
					FileOutputStream file = new FileOutputStream("Counter.ref");
					//qu’un client peut nécessiter à distance afin de localiser
					//l’objet serveur et invoquer les opérations : (Adresse IP, Numéro du port du poste serveur,
					//Référence de l’objet etc.. )
					PrintWriter writer = new PrintWriter(file);
					String ref = orb.object_to_string(c); //convertir l"IOR to string , pour le manipuler , et par la suite on va faire l'inverce
					writer.println("server started" + "Stop : ctl+C");

				} catch (IOException e2) {
					out.println("FIle error ; " + e2.getMessage());
					exit(2);
				}
				rootPOA.the_POAManager().activate();
			
				orb.run();
			
		} catch (Exception e) {
			out.println("FIle error ; " + e.getMessage());
			exit(1);
		}
	}
}
