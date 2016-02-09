package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.HashMap;
import java.util.Map;

public class CreateTemplat {
	
	Map<String,String> temp;
	
	CreateTemplat(){
		temp = new ClientInformation().getClientInformation();
	}
	
	Map<String,String> getTemp(){
		return temp;
	}
	
}
