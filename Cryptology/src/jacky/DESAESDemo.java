package jacky;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DESAESDemo {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		String input = "PSNPCPQyhPo=";
		String key = "12345678"; //如果使用DES進行加密，key 長度必須為8 byte
		String algorithm = "DES";
		Cipher cipher = Cipher.getInstance("DES");//transformation
		
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
		//第一個參數 : 模式(加密/解密)
		//第二個參數 : 加密規則
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			
		Decoder base64 = Base64.getDecoder();
		//調用加密方法
		byte[] bytes = cipher.doFinal(base64.decode(input));
		System.out.println(new String(bytes)); //亂碼，因為在編碼表上找不到對應的字符，再用base64轉碼
	
	}

}
