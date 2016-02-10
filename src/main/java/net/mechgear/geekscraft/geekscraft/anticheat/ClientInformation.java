package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientInformation {
	
	private Map<String,String> info = new HashMap<String,String>();
	
	//不需要种子加密时的构造方法
	ClientInformation(){
		//获取被检测客户端文件File对象列表
		List<File> fl = new ReadFile().getFileList();
		//for循环写入SHA-1信息
		for(File f : fl){
			//key：hash类型+相对路径 value：hash类型+hash值
			info.put("SHA-1:"+pathWork(f),"SHA-1:"+GetSHA1.sha1Reader(f));
		}
		//for循环写入MD5信息
		for(File f : fl){
			//key：hash类型+相对路径 value：hash类型+hash值
			info.put("MD5:"+pathWork(f),"MD5:"+GetMD5.md5Reader(f));
		}
		
	}
	
	//需要加密时的构造方法
	ClientInformation(String seed){
		
		//创建加密器对象
		Encrypt e = new Encrypt(seed);
		
		//获取被检测客户端文件File对象列表
		List<File> fl = new ReadFile().getFileList();
		//for循环写入加密的SHA-1信息
		for(File f : fl){
			//key：加密的hash类型+相对路径 value：hash类型+hash值
			info.put( e.encryptString("SHA-1:"+pathWork(f)),e.encryptString("SHA-1:"+GetSHA1.sha1Reader(f)));
		}
		//for循环写入加密的MD5信息
		for(File f : fl){
			//key：加密的hash类型+相对路径 value：hash类型+hash值
			info.put( e.encryptString("MD5:"+pathWork(f)),e.encryptString("MD5:"+GetMD5.md5Reader(f)));
		}
	}
	
	//路径加工方法，将绝对路径字符串转化为相对路径
	private String pathWork(File f){
		//将Windows下路径分隔符'\'转化为Unix下的路径分隔符'/'
		String s = f.getAbsolutePath().replace('\\', '/');
		//返回剪裁后的字符串
		return s.substring(s.lastIndexOf(".minecraft")+11);
	}
	
	//获取客户端信息Map
	Map<String,String> getClientInformation(){
		return info;
	}
	
}
