package logic;

import java.util.ArrayList;

public class Department {
	private String name;
	private ArrayList<GuildMember> departmentMembers;

	public Department(String name) {
		departmentMembers = new ArrayList<GuildMember>();
		setName(name);

	}

	public boolean setName(String name) {
		if (name.isBlank()) {
			return false;
		}
		this.name = name;
		return true;
	}

	public String getName() {
		return this.name;
	}

	public void addMember(GuildMember m) {
		departmentMembers.add(m);
		m.setMyDepartment(this.name);
	}

	public void addMultipleMembers(ArrayList<GuildMember> memberList) {
		for (GuildMember member : memberList) {
			addMember(member);
		}
	}

	public GuildMember removeMember(int index) {
		GuildMember tmp = getMember(index);
		departmentMembers.remove(index);
		return tmp;
	}

	public GuildMember getMember(int index) {
		return departmentMembers.get(index);
	}

	public ArrayList<GuildMember> getAllMembers() {
		return departmentMembers;
	}

	// ------------------------------------------
	// ---do not edit anything below this line---
	// ----but feel free to look at the code!----
	// ------------------------------------------

	public void printMembers() {
		if (departmentMembers.size() <= 0) {
			System.out.println("This department is empty!");
			return;
		}

		int i = 0;
		for (GuildMember m : departmentMembers) {
			System.out.println(i + ") " + m);
			i++;
		}
	}

	public void clearDepartment() {
		departmentMembers.clear();
	}

	public String toString() {
		return name + " Department";
	}

	public int memberCount() {
		return departmentMembers.size();
	}
}
