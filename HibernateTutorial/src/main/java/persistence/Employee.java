package persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")	
	private String firstName;
	
	@Column(name="last_name")	
	private String lastName;
	
	@Column(name="userName")	
	private String userName;
	
	@Column(name="password")	
	private String password;
	
	@Column(name="address")	
	private String address;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name="contact")	
	private String contact;
	
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="employee_meeting",
		joinColumns = {@JoinColumn(name="employee_id")},
		inverseJoinColumns = {@JoinColumn(name="meeting_id")})
	private Set<Meeting> meetings = new HashSet<Meeting>();

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}


}
