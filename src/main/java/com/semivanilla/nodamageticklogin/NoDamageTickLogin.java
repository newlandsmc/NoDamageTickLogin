package com.semivanilla.nodamageticklogin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class NoDamageTickLogin extends JavaPlugin implements Listener {

    private int ticks = 0;

    @Override
    public void onEnable() {
        if (!new File(getDataFolder(),"config.yml").exists()) {
            saveDefaultConfig();
        }
        ticks = getConfig().getInt("ticks",0);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setNoDamageTicks(ticks);
    }
}
