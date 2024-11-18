package org.skibidi.easyLights;

import org.bukkit.plugin.java.JavaPlugin;

public final class EasyLights extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("light").setExecutor(new LightCommand());;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
