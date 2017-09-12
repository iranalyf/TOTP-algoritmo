package br.com.congressoti;

import java.security.NoSuchAlgorithmException;

import br.com.congressoti.demo.Utils;

public class TOTP {

	public String gerarToken(String chaveSecreta) throws NoSuchAlgorithmException {

		String chaveConvertida = Utils.convertStringToHex(chaveSecreta);
		long timeWindow = 60L;
		long exactTime = (System.currentTimeMillis() / 1000L);
		long preRound = (long) (exactTime / timeWindow);
		String roundedTime = Long.toHexString(preRound).toUpperCase();

		while (roundedTime.length() < 16) {
			roundedTime = "0" + roundedTime;
		}

		byte[] hash = HMAC.hmac(Utils.hexStr2Bytes(chaveConvertida), Utils.hexStr2Bytes(roundedTime));
		int offset = hash[hash.length - 1] & 0xf;
		int otp = 
				((hash[offset + 0] & 0x7f) << 24) |
				((hash[offset + 1] & 0xff) << 16) |
				((hash[offset + 2] & 0xff) <<  8) |
				(hash[offset + 3] & 0xff);
				
		otp = otp % 1000000;
		
		String resultado = Integer.toString(otp);
		
		while(resultado.length() < 6){
			resultado = "0" + resultado;
		}
		
		return resultado;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(new TOTP().gerarToken("testeDe@lgum@Senh@Qu@alquer"));
	}
}
