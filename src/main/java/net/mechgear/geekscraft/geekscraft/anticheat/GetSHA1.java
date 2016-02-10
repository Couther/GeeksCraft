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
		//判断是否是个文件（而不是文件夹，和未创建的文件）
		if (!f.isFile()) {
			System.err.println("这不是个文件");
			return null;
		}
		
		try {
			//创建文件输入流
			FileInputStream in = new FileInputStream(f);
			//根据文件大小创建byte数组
			byte[] b = new byte[(int)f.length()];
			//创建哈希计算器
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			
			//更新哈希值计算器，将b数组从0计算到文件末尾（in.read(b)==f.length()）
			md.update(b, 0, in.read(b)); 
			//关闭文件输入流
			in.close();
			
			//返回String类型的哈希值
			return new BigInteger(1, md.digest()).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//失败则返回null
		return null;
	}
	
}
