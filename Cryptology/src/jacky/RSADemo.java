package jacky;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;

public class RSADemo {

	public static void main(String[] args) throws Exception {
		String algorithm = "RSA";
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
	
		byte[] privateKeyEncode = privateKey.getEncoded();
		byte[] publicKeyEncode = publicKey.getEncoded();
		
		String privateEncodeStr = new String(Base64.getEncoder().encode(privateKeyEncode));
		String publicEncodeStr = new String(Base64.getEncoder().encode(publicKeyEncode));
		
		System.out.println(privateEncodeStr);
		System.out.println(publicEncodeStr);
		
		String input = "帥哥";
		
//私鑰加密
		Cipher cipher = Cipher.getInstance(algorithm); //RSA
		cipher.init(Cipher.ENCRYPT_MODE, privateKey); //加密模式，使用privateKey 加密
		byte[] bytes = cipher.doFinal(input.getBytes()); //加密後的bytes
		Encoder encoder = Base64.getEncoder();
		System.out.println(new String(encoder.encode(bytes)));
//公鑰解密
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] bytes1 = cipher.doFinal(bytes); //解密後的bytes
		System.out.println(new String(bytes1));
				
	}
	
	//字串轉privateKey 物件
	public PrivateKey getPrivateKey(String privateEncodeStr, String algorithm) throws Exception {
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateEncodeStr.getBytes()));
	
		return keyFactory.generatePrivate(keySpec);
	}
	//字串轉publicKey 物件
	public PublicKey getPublicKey(String publicEncodeStr, String algorithm) throws Exception {
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicEncodeStr.getBytes()));
	
		return keyFactory.generatePublic(keySpec);
	}
	
	
}
