
import java.io.*;

import java.util.Properties;
import java.util.Scanner;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import static java.lang.System.*;
import static java.lang.System.*;
public class Client {
public static void main(String[] args) {
try {
Properties props = getProperties(); 
ORB orb= ORB.init(args , props);
String ref = null;
org.omg.CORBA.Object obj = null;
try {
Scanner reader=
new Scanner(new File("Counter.ref"));//recuperer la reference IOR
ref=reader.nextLine();
} catch (IOException ex) {
out.println("file error " + ex.getMessage());
exit(2);}
obj = orb.string_to_object (ref);  //convertir l"IOR to object
if (obj == null) {
	out.println("Invalid IOR");
	exit(4);
}
Counter c=null;
try{
c= CounterHelper.narrow(obj);
} catch (BAD_PARAM ex) {
out.println("narrowing failed");
exit(3); }
int inp = -1;
do {
out.print("Counter value:" + c.value()
+"\n Action (+/-/e/)?");
out.flush();
do {
try {
inp = in.read();
} catch (IOException ioe) { }
} while (inp != '+' && inp != '-' && inp !='e');
if(inp == '+')
c.inc();
else if (inp == '-')
c.desc();
} while (inp != 'e');
} catch (Exception ex) {
out.println("Exception: " + ex.getMessage());
exit(1);}}
}
