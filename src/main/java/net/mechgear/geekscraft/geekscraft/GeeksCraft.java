package net.mechgear.geekscraft.geekscraft;

import net.mechgear.geekscraft.geekscraft.anticheat.AntiCheatCore;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GeeksCraft.MODID, version = GeeksCraft.VERSION)
public class GeeksCraft
{
    public static final String MODID = "GeeksCraft";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLPreInitializationEvent event){
    	new AntiCheatCore();
    }
}