package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientInformation {
	private Map<String,String> info = new HashMap<String,String>();
	
	ClientInformation(){
		List<File> fl = new ReadFile().getFileList();
		for(File f : fl){
			info.put("SHA-1:"+pathWork(f),"SHA-1:"+GetSHA1.sha1Reader(f));
		}
		for(File f : fl){
			info.put("MD5:"+pathWork(f),"MD5:"+GetMD5.md5Reader(f));
		}
		
	}
	
	ClientInformation(String seed){
		
		Encrypt e = new Encrypt(seed);
		
		List<File> fl = new ReadFile().getFileList();
		for(File f : fl){
			info.put( e.encryptString("SHA-1:"+pathWork(f)),e.encryptString("SHA-1:"+GetSHA1.sha1Reader(f)));
		}
		for(File f : fl){
			info.put( e.encryptString("MD5:"+pathWork(f)),e.encryptString("MD5:"+GetMD5.md5Reader(f)));
		}
	}
	
	private String pathWork(File f){
		String s = f.getAbsolutePath().replace('\\', '/');
		return s.substring(s.lastIndexOf(".minecraft")+11);
	}
	
	Map<String,String> getClientInformation(){
		return info;
	}
	
}
