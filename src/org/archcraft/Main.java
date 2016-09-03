package org.archcraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    @Override
    public void onEnable() {

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this,new ParticlesEffectProcessor(),0L,1L);
    }

    @Override
    public void onDisable(){

    }
}
