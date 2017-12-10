
public class Person {

	private Long passportNum;
	private String name;
	private int Age;
	private String Gender;
	private String dateOfArrival;
	private String dateOfDeparture;

	public Person(Long passportNum, String full_name, int age, String gender, String intended_date_of_arrival,
			String intended_date_of_departure) {
		super();
		this.passportNum = passportNum;
		name = full_name;
		Age = age;
		Gender = gender;
		dateOfArrival = intended_date_of_arrival;
		dateOfDeparture = intended_date_of_departure;
	}

	public Long getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(Long passportNum) {
		this.passportNum = passportNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(String dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public String getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(String dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public String toString() {
		return passportNum + "/" + name + "/" + Age + "/" + Gender + "/" + dateOfArrival + "/" + dateOfDeparture;
	}
}
