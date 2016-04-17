

public class LessonServiceTest {

	public static void main(String[] args) {
		String mail = "[\"2050588049@qq.com\",\"dongfeng1992@163.com\"]";
		System.out.println(mail.toString().replace("[", "").replace("]", "").split(","));
		mail = mail.replaceAll(",", ";");
		System.out.println(mail);
	}
}
