package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
	}

	public Date () {
		this.day = 1;
		this.month = 1;
		this.year = 2021;
	}
	
	public void setDay(int day) throws DateException {
		if ( day < 1 || day > this.getDaysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if ( month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		}
		this.month = month;
	}
	
	public void setYear (int year) {
		this.year = year;
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}
	
	private int getDaysOfMonth(int monthNumber) {
		int numDays;
		
		numDays = 0;
		switch (monthNumber) {
		case 1: 
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10: 
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}

	public int getDaysOfMonth() {
		return this.getDaysOfMonth(this.month);
	}

	public boolean isSameYear(Date date) {
		return (date.getYear() == this.year);
	}

	public boolean isSameMonth(Date date) {
		return (date.getMonth() == this.month);
	}

	public boolean isSameDay(Date date) {
		return (date.getDay() == this.day);
	}

	public boolean isSame(Date date) {
		return (isSameDay(date) && isSameMonth(date) && isSameYear(date));
	}

	public String getMonthName() {
		String monthName = "";
		switch (this.month) {
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				break;
		}

		return monthName;
	}

	public String getMonthSeason() {
		String monthSeason = "";
		switch (this.month) {
			case 1:
			case 2:
			case 12:
				monthSeason = "Winter";
				break;
			case 3:
			case 4:
			case 5:
				monthSeason = "Spring";
				break;
			case 6:
			case 7:
			case 8:
				monthSeason = "Summer";
				break;
			case 9:
			case 10:
			case 11:
				monthSeason = "Autumn";
				break;
			default:
				break;
		}

		return monthSeason;
	}

	public int getMonthsLeftUntilEndOfYear() {
		int monthOfDate = this.getMonth();
		return 12 - monthOfDate;
	}

	public String getDatesUntilEndOfMonth() {
		StringBuffer datesUntilEndOfMonth = new StringBuffer();
		int dayOfDate = this.getDay();
		int daysOfMonth = this.getDaysOfMonth();
		Date date = new Date();

		for (int i = dayOfDate + 1; i <= daysOfMonth; i++) {
			try {
				date.setDay(i);
				date.setMonth(this.getMonth());
				date.setYear(this.getYear());
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
			datesUntilEndOfMonth.append(date.toString() + "\n");
		}
		return datesUntilEndOfMonth.toString();
	}

	public String getMothsWithSameDays() {
		int daysOfMonthDate = this.getDaysOfMonth();
		String months = "";
		switch (daysOfMonthDate) {
			case 28:
				months = "February";
				break;
			case 30:
				months = "April, June, September and November";
				break;
			case 31:
				months = "January, March, May, July, August, October and December";
			default:
				break;
		}
		return months;
	}

	public int getNumberOfDaysSinceStartOfYear() {
		int daysSinceStart = this.getDay();
		for (int i = 1; i < this.getMonth(); i++) {
			daysSinceStart += getDaysOfMonth(i);
		}
		return daysSinceStart;
	}

	public int countAttemptsGenerateRandomDate() {
		Date generatedDate = new Date();
		generatedDate.setYear(this.getYear());
		int attempts = 0;

		while (!(this.isSame(generatedDate))) {
			int randomMonth = (int) ((Math.random() * 12) + 1);
			int randomDay = (int) ((Math.random() * getDaysOfMonth(randomMonth)) + 1);
			
			try {
				generatedDate.setDay(randomDay);
				generatedDate.setMonth(randomMonth);
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
			attempts += 1;
		}

					//FORMA DO WHILE
		// do {
		// 	int randomMonth = (int) ((Math.random() * 12) + 1);
		// 	int randomDay = (int) ((Math.random() * getDaysOfMonth(randomMonth)) + 1);
			
		// 	try {
		// 		generatedDate.setDay(randomDay);
		// 		generatedDate.setMonth(randomMonth);
		// 	} catch (DateException e) {
		// 		System.out.println(e.getMessage());
		// 	}
		// 	attempts += 1;
		// } while (!(this.isSame(generatedDate)));

		return attempts;
	}

	public String getDayName(int dayNumber) {
		String dayName = "";
		switch (dayNumber) {
			case 0:
				dayName = "Monday";
				break;
			case 1:
				dayName = "Tuesday";
				break;
			case 2:
				dayName = "Wednesday";
				break;
			case 3:
				dayName = "Thursday";
				break;
			case 4:
				dayName = "Friday";
				break;
			case 5:
				dayName = "Saturday";
				break;
			case 6:
				dayName = "Sunday";
				break;
		
			default:
				break;
		}

		return dayName;
	}

	public String getDayOfWeek(int nameOfFirstDay) {
		if (nameOfFirstDay >= 5) {
			nameOfFirstDay = -1;
		}
		int shift = nameOfFirstDay - 1;
		int daysSinceStartOfYear = this.getNumberOfDaysSinceStartOfYear();
		return getDayName(daysSinceStartOfYear % 7 + shift);
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}


}
