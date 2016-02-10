package net.mechgear.geekscraft.geekscraft.anticheat;

public class Encrypt {
	
	private String seed;
	
	Encrypt(String seed) {
		//构造函数获取种子
		this.seed = seed;
	}
	
	String encryptString(String s){
		
		//将种子字符串转化为char数组
		char[] seeds = seed.toCharArray();
		//将待加密的字符串转化为char数组
		char[] x = s.toCharArray();
		
		//创建中间变量，用于表示种子的元素序号
		int m = 0;
		//用for循环进行加密
		for(int p = 0;p < x.length;++p){
			//x中第p个元素使用seed中第m个元素进行加密
			x[p]=(char)(x[p]^(seeds[m]*1123));
			
			++m;
			//判断m是否到达种子末尾
			if (m==seeds.length){
				m=0;
			}
		}
		//返回字符串型的加密文本
		return new String(x);
	}
	
	
}
