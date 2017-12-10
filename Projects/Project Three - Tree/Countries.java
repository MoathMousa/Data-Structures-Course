
public class Countries {
	
	private String countryName;
	private String fileName;

	public Countries(String countryName, String fileName) {
		super();
		this.countryName = countryName;
		this.fileName = fileName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return countryName + "/" + fileName ;
	}

	
}
