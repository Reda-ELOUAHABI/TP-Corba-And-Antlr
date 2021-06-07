// CounterImpl.java
public class CounterImpl extends CounterPOA {
    private int count;
    public CounterImpl() {
        count = 0; }
    public void inc() {
        count++;
    }
    public void desc() {
        count--; }
    public int value() {
        return count;
    } }