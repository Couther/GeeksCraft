package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.FMLCommonHandler;

public class ReadTemplate {
	private Map<String,String> template = new HashMap<String, String>();
	
	ReadTemplate(boolean ifFromIntenet) {
		//当ifFromIntenet为ture是从网络获取模板，否则从本地获取模板
		if(ifFromIntenet){
//			该功能建设中
		}else{
			//调用readTempFromFile（String path）读取模板
			template = readTempFromFile("/assets/template.temp");
		}
		
	}
	
	private Map<String,String> readTempFromFile(String path){
		//创建模板临时寄存对象
		Map<String,String> temp=null;
		
		try {
			
			//创建输入流标识符
			InputStream is;
			//创建对象输入流标识符
			ObjectInputStream ois;
			
			//用本对象的getClass获取包内路径，并获得模板文件的输入流，并用ois包装
			ois = new ObjectInputStream((is = this.getClass().getResourceAsStream(path)));
			//写入模板到temp对象
			temp = (Map) ois.readObject();
			
			//关闭流
			is.close();
			ois.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//返回temp
		return temp;
		
	}
		
		
		
	String getSeed(){
		
		return template.get("seed");
		
	}
	
	
	Map<String,String> getTmeplate(){
		return template;
	}
	
}
