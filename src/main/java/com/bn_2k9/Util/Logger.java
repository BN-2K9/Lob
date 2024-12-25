package com.bn_2k9.Util;

import com.bn_2k9.DataValues.LogType;
import com.bn_2k9.Lob;
import org.bukkit.Bukkit;

public class Logger {

    public void Log(String Message, LogType type) {
        if (type == LogType.ERROR) {
            Bukkit.getConsoleSender().sendMessage(Color.getInstance().colorPrefix("&4&lERROR &8>>&F " + Message));
        } else if (type == LogType.INFO) {
            Bukkit.getConsoleSender().sendMessage(Color.getInstance().colorPrefix("&2&lINFO &8>>&F " + Message));
        }
    }

    public static Logger getInstance() {
        return Lob.getPlugin().getConsolelogger();
    }

}
