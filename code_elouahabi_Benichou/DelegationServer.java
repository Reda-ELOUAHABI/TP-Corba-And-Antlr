// Server.java
  //import Count.*;
  import java.util.Properties;
  import org.omg.CORBA.*;
  import org.omg.PortableServer.*;
  import org.omg.CosNaming.*;
  import org.omg.CosNaming.NamingContextPackage.*;
  import static java.lang.System.*;

  public class DelegationServer {
       private ORB orb;
       private POA rootPOA;
       private void initializeORB(String[] args) {
         Properties props = getProperties();
          orb = ORB.init(args, props);
          try {
            rootPOA = POAHelper.narrow(orb.
              resolve_initial_references("RootPOA"));
          } catch (org.omg.CORBA.ORBPackage.InvalidName ex) { }
        }
        public DelegationServer(String[] args) {
          try {
            AlarmDelegate cd= new AlarmDelegate();
            initializeORB(args);
            NamingContextExt nc = NamingContextExtHelper.narrow(
              orb.resolve_initial_references("NameService"));
            AlarmPOATie c_impl = new AlarmPOATie(cd);
            Alarm c = c_impl._this(orb);
            //ici
            nc.unbind(nc.to_name("Home.Object"));
            NameComponent[] name = nc.to_name("Home.Object");
            NamingContext nc1 = nc.bind_new_context(name);
            NameComponent[] name1 = nc.to_name("Alarm.Fonction");
            nc1.rebind(name1,c);

            out.println("Server started. Stop: Ctrl-C");
            rootPOA.the_POAManager().activate();
            orb.run();
            } catch(Exception ex) {
            out.println("Exception: " + ex.getMessage());
            exit(1);
            } 
        }
            public static void main(String args[]) {
              new DelegationServer(args);
             } 
    }