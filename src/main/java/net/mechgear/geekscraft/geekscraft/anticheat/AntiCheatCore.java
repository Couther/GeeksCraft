package net.mechgear.geekscraft.geekscraft.anticheat;

import cpw.mods.fml.common.FMLCommonHandler;
import net.mechgear.geekscraft.geekscraft.Window.Prompt;

public class AntiCheatCore {
	
	public AntiCheatCore() {
		
		System.out.println("GeeksCraft翻作弊检查核心启动");
		//读取模板文件
		ReadTemplate rt = new ReadTemplate(false);
		System.out.println("成功读取模板");
		//比对，获取模板，获取客户端信息，获取种子
		Compare c = new Compare(rt.getTmeplate(), new ClientInformation().getClientInformation(),rt.getSeed());
		//获取比对结果，判断是否通过安检
		if(c.getResalt()){
			Prompt p = new Prompt("请不要修改客户端");
			//终止命令
			new FMLCommonHandler().exitJava(0, false);
		}
		System.out.println("GeeksCraft安全检查已通过");
		
		
		
		
		
	}
	
}
