package org.luiscodework.exsimplify.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.luiscodework.exsimplify.EXSimplify;

public class PlayerHandler implements Listener {
    public PlayerHandler(EXSimplify plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bukkit.getLogger().info("[EXSimplify Dev] Someone joined! Yay!, (This will be removed in the future)");
        event.getPlayer().sendMessage(Component.text("Hello " + event.getPlayer().getName() + "!, Welcome to the server!").color(NamedTextColor.BLUE));
    }
}
