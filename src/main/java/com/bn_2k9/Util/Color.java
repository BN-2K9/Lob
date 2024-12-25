package com.bn_2k9.Util;

import com.bn_2k9.Lob;
import org.bukkit.ChatColor;

public class Color {

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public String colorPrefix(String string) {
        return ChatColor.translateAlternateColorCodes('&', Lob.getPlugin().getConfig().getString("Plugin.Prefix") + string);
    }

    public static Color getInstance() {
        return Lob.getPlugin().getColor();
    }
}
