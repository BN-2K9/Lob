package com.bn_2k9.Features.Ambient;

import com.bn_2k9.Lob;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ambient {

    List<Player> Players = new ArrayList<>();

    public void StartAmbient(Player player) {

        // Add The Player To The Loop List.
        Players.add(player);

        if (Players.size() == 1) {

            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().runTaskAsynchronously(Lob.getPlugin(), () -> {
                        for (Player p: Players) {
                            Random random = new Random();
                            p.spawnParticle(Particle.valueOf(Lob.getPlugin().getConfig().getString("Features.Ambient.Particle")), p.getLocation(), Lob.getPlugin().getConfig().getInt("Features.Ambient.ParticleAmount"), random.nextInt(Lob.getPlugin().getConfig().getInt("Features.Ambient.BoxSize")), random.nextInt(Lob.getPlugin().getConfig().getInt("Features.Ambient.BoxSize")), random.nextInt(Lob.getPlugin().getConfig().getInt("Features.Ambient.BoxSize")));
                        }

                    });

                    if (Players.isEmpty()) {
                        this.cancel();
                    }
                }
            }.runTaskTimer(Lob.getPlugin(), 0L, 20L * Lob.getPlugin().getConfig().getLong("Features.Ambient.SpawnRate"));

        }

    }

    public void RemoveAmbient(Player player) {
        Players.remove(player);
    }


    public static Ambient getInstance() {
        return Lob.getPlugin().getAmbient();
    }
}
