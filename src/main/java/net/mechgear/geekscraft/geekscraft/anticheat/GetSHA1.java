package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetSHA1 {

	void fx(File f){
		if (!f.isFile()) {
			System.err.println("这不是个文件");
			return;
		}
		
		MessageDigest md = null;
//		FileInputStream in = new FileInputStream(f);
		long l = f.length()+1;
		byte[] buffer = new byte[(int)l];
		
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
//			md.update(buffer, 0, len); 
		
//		in.close();
		
		BigInteger bigInt = new BigInteger(1, md.digest());
//		md5.put(bigInt.toString(16), f.getPath());
		
	}
	
}
