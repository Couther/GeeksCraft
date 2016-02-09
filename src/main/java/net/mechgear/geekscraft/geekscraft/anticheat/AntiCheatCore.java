package net.mechgear.geekscraft.geekscraft.anticheat;

import net.mechgear.geekscraft.geekscraft.Window.Prompt;

public class AntiCheatCore {
	
	public AntiCheatCore() {
		
		ReadTemplate rt = new ReadTemplate(false);
		Compare c = new Compare(rt.getTmeplate(), new ClientInformation().getClientInformation(),rt.getSeed());
		if(c.getResalt()){
			Prompt p = new Prompt("请不要修改客户端");
		}
		
		
		
		
		
	}
	
}
