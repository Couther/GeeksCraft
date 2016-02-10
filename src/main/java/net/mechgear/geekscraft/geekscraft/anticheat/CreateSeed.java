package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.Random;

public class CreateSeed {
	
	//种子随机生成器
	static String createSeed(){
		//创建存放种子的数组
		char[] seed = new char[16];
		//创建随机数生成器
		Random r = new Random();
		//创建中间变量
		int v;
		//用for循环生成 种子
		for(int i=0;i<16;++i){
			
			//随机生成48~122之间的数
			v= 48+r.nextInt(74);
			//用if去除符号
			if((v>=58&&v<=64)||(v>=91&&v<=96)){
				//若包含符号，循环中间量退回1
				--i;
				//舍去该随机数
				continue;
			}
			seed[i]=(char)v;
		}
		//返回字符串型的种子文本
		return new String(seed);
	}
}
