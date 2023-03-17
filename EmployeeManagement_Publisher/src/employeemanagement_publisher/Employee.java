package employeemanagement_publisher;

public class Employee {
	
	private int id;
	private String name;
	private String contact;
	private int age;
	
	public Employee(int id, String name, String contact, int age) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
