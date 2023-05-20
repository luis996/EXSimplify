package org.luiscodework.exsimplify;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.luiscodework.exsimplify.commands.fly;
import org.luiscodework.exsimplify.listeners.PlayerHandler;

public final class EXSimplify extends JavaPlugin {

    @Override
    public void onEnable() {
        new PlayerHandler(this);
        getCommand("fly").setExecutor(new fly());

        Bukkit.getLogger().info("[EXSimplify] Enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[EXSimplify] Disabled");
    }
}
