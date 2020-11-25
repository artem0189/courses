package by.bsuir.dao.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256Hasher {
	public static String hash(String value) {
		StringBuilder stringBuilder = new StringBuilder();
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");	
		} catch (Exception e) { }
		
		byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
		for (byte b : hash) {
			stringBuilder.append(String.format("%02x", b));
		}
		return stringBuilder.toString();
	}
}
