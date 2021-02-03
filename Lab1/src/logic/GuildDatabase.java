package logic;

import java.util.ArrayList;

public class GuildDatabase {
	private ArrayList<Department> myDepartments;

	public GuildDatabase() {
		myDepartments = new ArrayList<Department>();
	}

	public boolean createDepartment(String name) {
		if (isExists(name)) {
			return false;
		}
		myDepartments.add(new Department(name));

		return true;
	}

	public boolean isExists(String name) {
		for (Department department : myDepartments) {
			if (department.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<GuildMember> removeDepartment(int index) {
		Department tmp = myDepartments.get(index);
		myDepartments.remove(index);
		return tmp.getAllMembers();
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public Department getDepartment(int index) {
		return myDepartments.get(index);
	}

	public void printDepartments() {
		int i = 0;
		for (Department d : myDepartments) {
			System.out.println(i + ") " + d);
			i++;
		}
	}

	public int departmentCount() {
		return myDepartments.size();
	}
}
