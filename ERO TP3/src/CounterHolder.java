
/**
* CounterHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Counter.idl
* Thursday, June 3, 2021 at 3:03:05 PM Western European Summer Time
*/


//Counter IDL
public final class CounterHolder implements org.omg.CORBA.portable.Streamable
{
  public Counter value = null;

  public CounterHolder ()
  {
  }

  public CounterHolder (Counter initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CounterHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CounterHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CounterHelper.type ();
  }

}