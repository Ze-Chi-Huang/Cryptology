package jacky;

public class CaesarDemo {

	public static void main(String[] args) {
		
		String s = encryptKaiser(3);
		System.out.println("密文 : " + s);
		System.out.println("解密後 : " + decryptKaiser(s, 3));
	}
	private static String decryptKaiser(String s, int key) {
		
		//1. 字串變字元陣列
		//2. 每個字元移動key 值
		//3. 組成新的字串
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for(char aChar : chars) {
			int b = aChar;
			b = b-key;
			sb.append((char)b);
		}
		
		return sb.toString();
	}

	private static String encryptKaiser(int key) {
		String input = "hello world";
		StringBuilder output = new StringBuilder();
//		int key = 3; //加密規則
		
		char[] chars = input.toCharArray();
		
		for(char aChar : chars) {
			int b = aChar;
			b += key;
			
			char newb = (char)b;
			output.append(newb);
		}
		
//		System.out.println(output);
		return output.toString();
	}

}
