package net.mechgear.geekscraft.geekscraft.anticheat;

import java.util.Random;

public class CreateSeed {
	static String createSeed(){
		char[] seed = new char[16];
		Random r = new Random();
		for(int i=0;i<16;++i){
			int v = 48+r.nextInt(74);
			if((v>=58&&v<=64)||(v>=91&&v<=96)){
				--i;
				continue;
			}
			seed[i]=(char)v;
		}
		return new String(seed);
	}
}
