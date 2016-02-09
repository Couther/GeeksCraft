package net.mechgear.geekscraft.geekscraft.anticheat;

import cpw.mods.fml.common.FMLCommonHandler;
import net.mechgear.geekscraft.geekscraft.Window.Prompt;

public class AntiCheatCore {
	
	public AntiCheatCore() {
		
		System.out.println("GeeksCraft翻作弊检查核心启动");
		ReadTemplate rt = new ReadTemplate(false);
		System.out.println("成功读取模板");
		Compare c = new Compare(rt.getTmeplate(), new ClientInformation().getClientInformation(),rt.getSeed());
		if(c.getResalt()){
			Prompt p = new Prompt("请不要修改客户端");
			new FMLCommonHandler().exitJava(0, false);
		}
		System.out.println("GeeksCraft安全检查已通过");
		
		
		
		
		
	}
	
}
