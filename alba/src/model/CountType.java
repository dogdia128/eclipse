package model;

public class CountType {
	private String type;
	private int count;
	public CountType(String type, int count) {
		if (type.equals("office")) {
			type = "사무직";
		} else if (type.equals("service")) {
			type = "서비스";
		} else if (type.equals("seller")) {
			type = "판매";
		} else if (type.equals("cooking")) {
			type = "외식/음료";
		} else if (type.equals("delivery")) {
			type = "배달";
		}
		this.type = type;
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
	
		return "CountType [type=" + type + ", count=" + count + "]";
	}
	
}


