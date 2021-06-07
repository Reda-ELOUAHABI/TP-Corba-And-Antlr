//Counter IMP
public class CounterImp extends CounterPOA{
    private int count;
    public CounterImp() {
        count=0;
    }
    public void inc(){
        count++;
    }
    public void desc(){
        count --;
    }
public int value(){
    return count;
}
}
