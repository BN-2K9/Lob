package com.bn_2k9.Features.Ambient.Listener;

import com.bn_2k9.Features.Ambient.Ambient;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AmbientListener implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {
        Ambient.getInstance().StartAmbient(event.getPlayer());
    }

    @EventHandler
    public void OnPlayerQuit(PlayerQuitEvent event) {
        Ambient.getInstance().RemoveAmbient(event.getPlayer());
    }

}
