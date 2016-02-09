package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Compare {
	private Map<String,String> temp;
	private Map<String,String> cinfo;
	private boolean resalt =true;
	
	Compare(Map<String,String> t,Map<String,String> c) {
		this.temp = t;
		this.cinfo = c;
		com();
	}
	Compare(Map<String,String> t,Map<String,String> c,String seed){
		this.temp = t;
		this.cinfo = c;
		temp.remove("seed");
		antiEncrypt(seed);
		com();
		
	}
	
	private void antiEncrypt(String seed){
		Map<String,String> m = new HashMap<String,String>();
		AntiEncrypt a = new AntiEncrypt(seed);
		Set<String> key = temp.keySet();
		for(String s:key){
			m.put(a.encryptString(s),a.encryptString(temp.get(s)));
		}
		temp = m;
	}
	
	private void com(){
		if(temp.size()<cinfo.size()){
			Set<String> se = cinfo.keySet();
			se.removeAll(temp.keySet());
			for(String s:se){
				System.out.println("多出的文件："+s+"；"+cinfo.get(s));
			}
			System.out.println("temp"+temp.size());
			System.out.println("Client"+cinfo.size());
			
			return;
		}
		
		Set<String> key = cinfo.keySet();
		
		for(String s:key){
			if((!(temp.containsKey(s)&&temp.get(s).equals(cinfo.get(s))))&&(!(cinfo.get(s).equals("mods/GeeksCraft.jar")))){
				System.err.println(temp.containsKey(s));
				System.out.println(s);
				System.err.println("Client:"+cinfo.get(s));
				System.err.println("temp:"+temp.get(s));
				
				
				return;
			}
		}
		resalt = false;
		
	}
	boolean getResalt(){
		return resalt;
	}
	
	
}
