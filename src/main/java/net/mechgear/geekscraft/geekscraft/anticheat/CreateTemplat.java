package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.Map;

public class CreateTemplat {
	//模板对象生成器（说白了，就是把ClientInformation的结果拿过来了而已）
	private Map<String,String> temp;
	
	CreateTemplat(){
		temp = new ClientInformation().getClientInformation();
	}
	
	Map<String,String> getTemp(){
		return temp;
	}
	
}
