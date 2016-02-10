package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Compare {
	
	private Map<String,String> temp;
	private Map<String,String> cinfo;
	//ture为不通过，false为通过
	private boolean resalt =true;
	
	//不加密时比较的构造方法
	Compare(Map<String,String> t,Map<String,String> c) {
		this.temp = t;
		this.cinfo = c;
		com();
	}
	//加密时的构造方法
	Compare(Map<String,String> t,Map<String,String> c,String seed){
		this.temp = t;
		this.cinfo = c;
		//删除temp中的种子信息
		temp.remove("seed");
		//反加密
		antiEncrypt(seed);
		com();
		
	}
	
	//反加密方法
	private void antiEncrypt(String seed){
		//创建临时Map对象
		Map<String,String> m = new HashMap<String,String>();
		//创建反加密器对象
		AntiEncrypt a = new AntiEncrypt(seed);
		//获取key的set列表
		Set<String> key = temp.keySet();
		//用for循环反加密
		for(String s:key){
			//在m中放入反加密的key和反加密的value
			m.put(a.encryptString(s),a.encryptString(temp.get(s)));
		}
		temp = m;
	}
	
	//比较方法
	private void com(){
		
		//通过长度判断（在玩家自行添加mod时提高比较效率）
		//当客户端的被检查文件比模板中的被检查文件多时
		if(temp.size()<cinfo.size()){
			
			//在控制台输出详细信息
			Set<String> se = cinfo.keySet();
			se.removeAll(temp.keySet());
			for(String s:se){
				System.out.println("多出的文件："+s+"，"+cinfo.get(s));
			}
			System.out.println("temp"+temp.size());
			System.out.println("Client"+cinfo.size());
			
			//终止比较，保留结果为true；
			return;
		}
		
		//获取客户端信息的key的set列表
		Set<String> key = cinfo.keySet();
		
		//用foreach循环检查每一个映射
		for(String s:key){
			//if判断（长达121字的判别式不解释，用心去感受）
			//判别式中文解释：当 temp中不包含这个key或者对应文件的哈希值不正确时且不符合前者判断的文件不是mods/GeeksCraft.jar对应的文件时，返回true
			if((!(temp.containsKey(s)&&temp.get(s).equals(cinfo.get(s))))&&(!(s.substring(s.length()-19).equals("mods/GeeksCraft.jar")))){
				
				//输出详细信息
				System.err.println(temp.containsKey(s));
				System.out.println(s);
				System.err.println("Client:"+cinfo.get(s));
				System.err.println("temp:"+temp.get(s));
				
				//终止方法，保留结果为true
				return;
			}
		}
		
		//若通过以上所有检查，将结果修改为false
		resalt = false;
		
	}
	
	//获取检查结果
	boolean getResalt(){
		return resalt;
	}
	
	
}
