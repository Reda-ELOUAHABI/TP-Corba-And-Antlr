
import javax.swing.*;


public class CounterDelegate extends JPanel implements CounterOperations {

    private int count ;
    private JTextField value;
    public CounterDelegate(){
        count =0;
        add(new JLabel("Countervalue:",JLabel.RIGHT));
        add(value=new JTextField ((String.valueOf(count)),10));
        value.setEditable(false);

    }
    public void inc(){
        value.setText(String.valueOf(++count));

    }
    public void desc(){
        value.setText(String.valueOf(--count));

    }
    public int value() {
        // TODO Auto-generated method stub
        return count;
    }


}
