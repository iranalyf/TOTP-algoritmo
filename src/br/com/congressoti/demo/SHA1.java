package br.com.congressoti.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

	public static String hash(byte[] input) throws NoSuchAlgorithmException {
		MessageDigest message = MessageDigest.getInstance("SHA1");
		byte[] result = message.digest(input);
		// armazena strings (é mutavel)
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			buffer.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return buffer.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String teste = "testeDe@lgum@Senh@Qu@alquer";
		System.out.println(SHA1.hash(teste.getBytes()));
	}
}
