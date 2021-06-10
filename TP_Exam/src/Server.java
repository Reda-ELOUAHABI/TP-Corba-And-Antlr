import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import static java.lang.System.*;
import java.util.Properties;


public class Server {
    private ORB orb;
    private POA rootPOA;

    private void initializeORB(String[] args) {
        Properties props = getProperties();
        orb = ORB.init(args, props);
        try {
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        } catch (org.omg.CORBA.ORBPackage.InvalidName ex) {}
    }

    public Server(String[] args) {
        try {
            initializeORB(args);
            NamingContext nc = NamingContextHelper.narrow(
                    orb.resolve_initial_references("NameService"));
            HorlogeImpl c_impl = new HorlogeImpl();
            Horloge c = c_impl._this(orb);
            NameComponent[] name = new NameComponent[1];
            name[0] = new NameComponent();
            name[0].id = "Horloge";
            name[0].kind = "Objet";
            nc.rebind(name, c);
            System.out.println("Server started. Stop : Ctrl-C");
            rootPOA.the_POAManager().activate();
            orb.run();
        } catch (Exception ex) {
            System.out.println("Exception : "+ex.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args) {
        new Server(args);
    }
}