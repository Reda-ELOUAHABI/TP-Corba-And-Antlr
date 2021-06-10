import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HorlogeImpl extends HorlogePOA{
	private String heure;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	LocalDateTime now = LocalDateTime.now();
	public HorlogeImpl(){
		heure=dtf.format(now).toString();
	}

	@Override
	public String heure() {
		return heure;
	}

	public void setGMT(){
		heure=dtf.format(now).toString();
	}

	@Override
	public void setHeureEte() {
		String time = Integer.parseInt(dtf.format(now).toString().split(":")[0])+1+":"+dtf.format(now).toString().split(":")[1];
		heure=time;

	}

}

