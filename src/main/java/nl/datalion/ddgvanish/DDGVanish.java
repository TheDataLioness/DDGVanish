package nl.datalion.ddgvanish;

import org.bukkit.plugin.java.JavaPlugin;

public final class DDGVanish extends JavaPlugin {

    @Override
    public void onEnable() {
        //register eventlistener
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {

    }


}
