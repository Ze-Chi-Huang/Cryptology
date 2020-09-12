package jacky;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class SignatureDemo {
	
	/*
	 * 	String algorithm = "RSA";
	 *  KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
	 *  KeyPair keyPair = keyPairGenerator.generateKeyPair();
	 *  PrivateKey privateKey = keyPair.getPrivate();
	 *  PublicKey publicKey = keyPair.getPublic();
	 * */
	
	//algorithm: sha256withrsa 
	private static String getSignature(String input,String algorithm, PrivateKey privateKey) throws Exception {
		Signature signature = Signature.getInstance(algorithm);
		//初始化簽名
		signature.initSign(privateKey);
		//傳入原文
		signature.update(input.getBytes());
		//開始簽名
		byte[] sign = signature.sign();
		
		return Base64.getEncoder().encodeToString(sign);
	} 
	
	private static Boolean verifySignature(String input,String algorithm, PublicKey publicKey, String signatureData) throws Exception {
		Signature signature = Signature.getInstance(algorithm);
		//初始化校驗
		signature.initVerify(publicKey);
		//傳入原文
		signature.update(input.getBytes());
		//校驗數據
		
		return signature.verify(Base64.getDecoder().decode(signatureData));
	} 
}
