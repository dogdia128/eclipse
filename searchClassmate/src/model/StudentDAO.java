package model;

public class StudentDAO {
	public static Student getStudent(String name) {
		if(name.contains("진혁")) {
			name="신진혁";
			return new Student(name, 29, "'프로그래머스'<br>요즘 코딩테스트가 재밌음", "https://media.istockphoto.com/photos/sailboat-in-the-sea-picture-id1130130855");		
		}else if(name.contains("민지")) {
			name="이민지";
			return new Student(name, 24, "'비타민'<br>sw반 분위기메이커", "https://cdn.pixabay.com/photo/2013/07/12/19/16/citron-154449_960_720.png");	
		}else if(name.contains("성빈")) {
			name="임성빈";
			return new Student(name, 25, "'쿠키런'<br>우리반의 유일한 쿠키런친구", "https://w.namu.la/s/0000c5b4bb2599e5eee77d47dcf0fedad216f845a398e85574d3a0d403599624295e628d0d1ad033fb3356fddf0bc872d838ef9a020752a96832a06f486ddc850d08f4ec05020cec0e83f4f4130e1ba7f8225452d209dac1cdadc59b362e451d");		
		}else if(name.contains("인기")) {
			name="황인기";
			return new Student(name, 24, "'옥천냉면'<br>옥천하면 냉면부터 생각남", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/KOCIS_Mul-naengmyeon%2C_Chilled_Buckwheat_Noodle_Soup_%284594756202%29.jpg/220px-KOCIS_Mul-naengmyeon%2C_Chilled_Buckwheat_Noodle_Soup_%284594756202%29.jpg");			
		}else if(name.contains("상현")) {
			name="주상현";
			return new Student(name, 31, "'야구'<br>야구 좋아하심", "https://img2.yna.co.kr/photo/oldyna/YH/2008/08/22/PYH2008082206260001300_P2.jpg");		
		}else if(name.contains("효선")) {
			name="허효선";
			return new Student(name, 25, "'어피치'<br>어피치좋아하심<br>(어피치닮은것같기도함)", "https://post-phinf.pstatic.net/MjAxNzA2MjlfMjU5/MDAxNDk4NzM5NzI3MjA0.Aon2aPyhufiwt9-Y21w0v1luZzlYnihR7Xcozypyf8Qg.QLFNlJRzJzd1TqWWSN0DyVeHxe8zsAxGc7PHwkNHy8gg.PNG/1483309553699.png?type=w1200");		
		}else if(name.contains("정화")) {
			name="이정화";
			return new Student(name, 28, "'아티스트'<br>한번씩 그림그리시는거보면<br> 화가같음", "https://cdn.pixabay.com/photo/2017/10/13/13/24/brush-2847613_960_720.jpg");		
		}else if(name.contains("찬준")) {
			name="김찬준";
			return new Student(name, 25, "'컴공'<br>코딩잘하심, 코딩전문가", "https://cdn.pixabay.com/photo/2014/04/03/10/09/coffee-309981_960_720.png");			
		}else if(name.contains("승원")) {
			name="장승원";
			return new Student(name, 32, "'e스포츠'<br> fps근본 스페셜포스 선수출신.<br> 유명한분많이 아심", "https://file.mk.co.kr/meet/neds/2017/06/image_readtop_2017_396737_14973966082917550.jpg");		
		}else if(name.contains("준석")) {
			name="신준석";
			return new Student(name, 33, "'테라'<br>테라 랭커찍으심", "https://img.newspim.com/news/2020/01/21/2001211434220930.jpg");			
		}else if(name.contains("혜경")) {
			name="김혜경 강사님";
			return new Student(name, 30, "'1타강사'<br>수업을 따라가다보면 어느새<br>코딩에 능숙해진다.", "http://www.snunews.com/news/photo/201609/16240_9455_4715.jpg");		
		}else if(name.contains("서영")) {
			name="강서영 속기사님";
			return new Student(name, 22, "'헌신적'<br>정규수업시간외에도 <br>늘 참석하여 도와주신다.", "https://cdn.pixabay.com/photo/2017/02/01/11/14/catholic-2029717_960_720.png");		
		}else {
			return new Student("검색에러", 00, "입력하신 학생명'" + name + "'은 존재하지 않습니다. 확인하시고 다시 입력해주세요.", "https://media.istockphoto.com/photos/road-sign-3d-rendering-picture-id1098254224");	
		}		
	}
}
