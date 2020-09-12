package jacky;

public class ASCIITest {

	public static void main(String[] args) {
		
		int a = 'A';
		System.out.println(a);
		
		String str = "Aaz";
		char[] chars = str.toCharArray();
		for(char c : chars) {
			int asciiCode = c;
			System.out.println(asciiCode);
		}
		
	}

}
