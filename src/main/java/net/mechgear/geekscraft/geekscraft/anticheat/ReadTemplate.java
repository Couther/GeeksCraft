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
		if(ifFromIntenet){
//			该功能建设中
		}else{
			template = readTempFromFile("/assets/template.temp");
		}
		
	}
	
	private Map<String,String> readTempFromFile(String path){
		
		Map<String,String> temp=null;
		
		try {
			
			InputStream is;
			ObjectInputStream ois;
			
			ois = new ObjectInputStream((is = this.getClass().getResourceAsStream(path)));
			temp = (Map) ois.readObject();
			
			is.close();
			ois.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return temp;
		
	}
		
		
		
	String getSeed(){
		
		return template.get("seed");
		
	}
	
	
	Map<String,String> getTmeplate(){
		return template;
	}
	
}
