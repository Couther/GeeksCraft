package net.mechgear.geekscraft.geekscraft.anticheat;

public class Encrypt {
	
	private String seed;
	
	Encrypt(String seed) {
		this.seed = seed;
	}
	
	String encryptString(String s){
		
		char[] seeds = seed.toCharArray();

		char[] x = s.toCharArray();
		int m = 0;
		for(int p = 0;p < x.length;++p){
			x[p]=(char)(x[p]^(seeds[m]*1123));
			++m;
			if (m==seeds.length){
				m=0;
			}
		}
		return new String(x);
	}
	
	
}
