package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.Map;
import java.util.Set;

public class Compare {
	Map<String,String> temp = new GetTemplate(false).getTmeplate();
	Map<String,String> cinfo = new ClientInformation().getClientInformation();
	
	boolean resalt(){
		if(temp.size()<cinfo.size()){
			return true;
		}
		
		Set<String> key = cinfo.keySet();
		for(String s:key){
			if((temp.containsKey(s))&&(temp.get(s).equals(cinfo.get(s)))){
				
			}else{
//				break;
				return true;
			}
		}
		return true;
		
	}
	
	
	
}
