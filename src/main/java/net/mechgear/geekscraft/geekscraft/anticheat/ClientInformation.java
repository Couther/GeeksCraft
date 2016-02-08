package net.mechgear.geekscraft.geekscraft.anticheat;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientInformation {
	Map<String,String> info = new HashMap<String,String>();
	
	ClientInformation(){
		List<File> fl = new ReadFile().getFileList();
		
	}
	
	
	Map<String,String> getClientInformation(){
		return info;
	}
	
}
