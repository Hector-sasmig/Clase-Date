package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		
		try {
			today = new Date(19,11,2022);
			System.out.println(today.getDayOfWeek(6));
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}
