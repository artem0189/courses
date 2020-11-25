package by.bsuir.dao.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
	public static String hash(String value, String algorithm) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algorithm);	
		} catch (NoSuchAlgorithmException | NullPointerException e) {
			try {
				digest = MessageDigest.getInstance("SHA-256");	
			} catch (Exception ex) {};
		}
		
		byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
		return new String(hash);
	}
}
