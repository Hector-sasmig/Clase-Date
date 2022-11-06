package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		
		try {
			today = new Date(18,5,2023);
			System.out.println(today.getDayOfWeek(6));
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}
