package jacky;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MessageDigestDemo {

	public static void main(String[] args) throws Exception {
		
		String input = "aa";
		
		String algorithm = "MD5";
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		byte[] digest1 = digest.digest(input.getBytes());
		
//		byte[] enByte = Base64.getEncoder().encode(digest1);
//		System.out.println(new String(enByte)); //QSS8CpM1wn8IbyS6IHpJEg==
		
		for(byte b : digest1) {
			String s = Integer.toHexString(b & 0xff);
			//高位補0
			if(s.length() == 1 ) {
				s = "0" + s;
			}
			System.out.print(s);
		}
		
	}

}
