package persistence;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String name;
	
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmpList() {
		return EmpList;
	}

	public void setEmpList(List<Employee> empList) {
		EmpList = empList;
	}

	@OneToMany(mappedBy = "department")
	private List<Employee> EmpList;
	
	

}
