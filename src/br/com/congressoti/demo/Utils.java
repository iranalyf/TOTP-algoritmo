package br.com.congressoti.demo;

import java.math.BigInteger;

public class Utils {

	public static byte[] hexStr2Bytes(String hex) {// Responsavel por Converter
		// HEX em Bytes
		byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();
		byte[] ret = new byte[bArray.length - 1];
		for (int i = 0; i < ret.length; i++)
			ret[i] = bArray[i + 1];
		return ret;
	}

	public static String convertStringToHex(String str) {// Responsavel por
		// converter String
		// para HEX
		char[] chars = str.toCharArray();

		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}

		return hex.toString();
	}
}
