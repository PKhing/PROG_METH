package logic;

public class GuildMember {
	private String name;
	private String jobTitle;
	private String myDepartment;
	private int salary;

	public GuildMember(String name, String jobTitle, int salary) {
		setName(name);
		setJobTitle(jobTitle);
		setSalary(salary);
		setMyDepartment("Unassigned");
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Anon";
		} else {
			this.name = name;
		}

	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {

		if (jobTitle.isBlank()) {
			this.jobTitle = "Adventurer";
		} else {
			this.jobTitle = jobTitle;
		}

	}

	public String getMyDepartment() {
		return this.myDepartment;
	}

	public void setMyDepartment(String myDepartment) {
		this.myDepartment = myDepartment;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		if (salary < 0) {
			this.salary = 0;
		} else if (salary > 100000) {
			this.salary = 100000;
		} else {
			this.salary = salary;
		}
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public String toString() {
		return name + " the " + jobTitle + " of the " + myDepartment + " Department (Salary: " + salary + ")";
	}
}
