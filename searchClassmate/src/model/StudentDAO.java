package model;

public class StudentDAO {
	public static Student getStudent(String name) {
		if(name.contains("����")) {
			name="������";
			return new Student(name, 29, "'���α׷��ӽ�'<br>���� �ڵ��׽�Ʈ�� �����", "https://media.istockphoto.com/photos/sailboat-in-the-sea-picture-id1130130855");		
		}else if(name.contains("����")) {
			name="�̹���";
			return new Student(name, 24, "'��Ÿ��'<br>sw�� ���������Ŀ", "https://cdn.pixabay.com/photo/2013/07/12/19/16/citron-154449_960_720.png");	
		}else if(name.contains("����")) {
			name="�Ӽ���";
			return new Student(name, 25, "'��Ű��'<br>�츮���� ������ ��Ű��ģ��", "https://w.namu.la/s/0000c5b4bb2599e5eee77d47dcf0fedad216f845a398e85574d3a0d403599624295e628d0d1ad033fb3356fddf0bc872d838ef9a020752a96832a06f486ddc850d08f4ec05020cec0e83f4f4130e1ba7f8225452d209dac1cdadc59b362e451d");		
		}else if(name.contains("�α�")) {
			name="Ȳ�α�";
			return new Student(name, 24, "'��õ�ø�'<br>��õ�ϸ� �ø���� ������", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/KOCIS_Mul-naengmyeon%2C_Chilled_Buckwheat_Noodle_Soup_%284594756202%29.jpg/220px-KOCIS_Mul-naengmyeon%2C_Chilled_Buckwheat_Noodle_Soup_%284594756202%29.jpg");			
		}else if(name.contains("����")) {
			name="�ֻ���";
			return new Student(name, 31, "'�߱�'<br>�߱� �����Ͻ�", "https://img2.yna.co.kr/photo/oldyna/YH/2008/08/22/PYH2008082206260001300_P2.jpg");		
		}else if(name.contains("ȿ��")) {
			name="��ȿ��";
			return new Student(name, 25, "'����ġ'<br>����ġ�����Ͻ�<br>(����ġ�����Ͱ��⵵��)", "https://post-phinf.pstatic.net/MjAxNzA2MjlfMjU5/MDAxNDk4NzM5NzI3MjA0.Aon2aPyhufiwt9-Y21w0v1luZzlYnihR7Xcozypyf8Qg.QLFNlJRzJzd1TqWWSN0DyVeHxe8zsAxGc7PHwkNHy8gg.PNG/1483309553699.png?type=w1200");		
		}else if(name.contains("��ȭ")) {
			name="����ȭ";
			return new Student(name, 28, "'��Ƽ��Ʈ'<br>�ѹ��� �׸��׸��ô°ź���<br> ȭ������", "https://cdn.pixabay.com/photo/2017/10/13/13/24/brush-2847613_960_720.jpg");		
		}else if(name.contains("����")) {
			name="������";
			return new Student(name, 25, "'�İ�'<br>�ڵ����Ͻ�, �ڵ�������", "https://cdn.pixabay.com/photo/2014/04/03/10/09/coffee-309981_960_720.png");			
		}else if(name.contains("�¿�")) {
			name="��¿�";
			return new Student(name, 32, "'e������'<br> fps�ٺ� ��������� �������.<br> �����Ѻи��� �ƽ�", "https://file.mk.co.kr/meet/neds/2017/06/image_readtop_2017_396737_14973966082917550.jpg");		
		}else if(name.contains("�ؼ�")) {
			name="���ؼ�";
			return new Student(name, 33, "'�׶�'<br>�׶� ��Ŀ������", "https://img.newspim.com/news/2020/01/21/2001211434220930.jpg");			
		}else if(name.contains("����")) {
			name="������ �����";
			return new Student(name, 30, "'1Ÿ����'<br>������ ���󰡴ٺ��� �����<br>�ڵ��� �ɼ�������.", "http://www.snunews.com/news/photo/201609/16240_9455_4715.jpg");		
		}else if(name.contains("����")) {
			name="������ �ӱ���";
			return new Student(name, 22, "'�����'<br>���Լ����ð��ܿ��� <br>�� �����Ͽ� �����ֽŴ�.", "https://cdn.pixabay.com/photo/2017/02/01/11/14/catholic-2029717_960_720.png");		
		}else {
			return new Student("�˻�����", 00, "�Է��Ͻ� �л���'" + name + "'�� �������� �ʽ��ϴ�. Ȯ���Ͻð� �ٽ� �Է����ּ���.", "https://media.istockphoto.com/photos/road-sign-3d-rendering-picture-id1098254224");	
		}		
	}
}
