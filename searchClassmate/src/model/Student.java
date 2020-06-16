package model;

public class Student {
	private String name;
	private int age;
	private String keyword;
	private String img;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, String keyword, String img) {
		super();
		this.name = name;
		this.age = age;
		this.keyword = keyword;
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", keyword=" + keyword + ", img=" + img + "]";
	}
	
}
