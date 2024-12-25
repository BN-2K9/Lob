package com.bn_2k9;

import com.bn_2k9.DataValues.LogType;
import com.bn_2k9.Features.Ambient.Ambient;
import com.bn_2k9.Features.Ambient.Listener.AmbientListener;
import com.bn_2k9.Util.Color;
import com.bn_2k9.Util.Logger;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lob extends JavaPlugin {


    @Getter
    private static Lob plugin;
    @Getter
    private Color color;
    @Getter
    private Logger consolelogger;
    @Getter
    private Ambient ambient;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        plugin.saveDefaultConfig();

        // Register All Classes.
        LoadFeatures();

        // Let The Console Know The Plugin Started.
        consolelogger.Log("Started!", LogType.INFO);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void LoadFeatures() {

        // Registers All Must Have Classes
        color = new Color();
        consolelogger = new Logger();

        // Registers All Event Listeners
        if (plugin.getConfig().getBoolean("Features.Ambient.Enabled")) {
            Bukkit.getPluginManager().registerEvents(new AmbientListener(), plugin);
            ambient = new Ambient();
        }

    }
}
