package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetSHA1 {
	
	static String sha1Reader(File f){
		if (!f.isFile()) {
			System.err.println("这不是个文件");
			return null;
		}
		
		try {
			FileInputStream in = new FileInputStream(f);
			byte[] b = new byte[(int)f.length()];
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(b, 0, in.read(b)); 
			in.close();
			return new BigInteger(1, md.digest()).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
