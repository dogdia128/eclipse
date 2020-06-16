package model;

public class CountType {
	private String type;
	private int count;
	public CountType(String type, int count) {
		if (type.equals("office")) {
			type = "�繫��";
		} else if (type.equals("service")) {
			type = "����";
		} else if (type.equals("seller")) {
			type = "�Ǹ�";
		} else if (type.equals("cooking")) {
			type = "�ܽ�/����";
		} else if (type.equals("delivery")) {
			type = "���";
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


