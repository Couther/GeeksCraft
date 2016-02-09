package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.FMLCommonHandler;

public class GetTemplate {
	Map<String,String> template = new HashMap<String, String>();
	
	public GetTemplate(boolean ifFromIntenet) {
		if(ifFromIntenet){
//			该功能建设中
		}else{
			template = readTempFromFile("/assets/Template.temp");
		}
		
	}
	
	Map<String,String> readTempFromFile(String path){
		
		Map<String,String> temp = new HashMap<String, String>();
		
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
		
		
		
	
	
	
	Map<String,String> getTmeplate(){
		return template;
	}
	
}
