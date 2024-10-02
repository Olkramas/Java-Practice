package chap13.p604;

public class Student {
	public int studentNum;
	public String name;
	
	public Student (int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return student.name.equals(name) && (student.studentNum == studentNum);
		} else {
			return false;
		}
	}
}
