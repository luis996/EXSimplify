package org.luiscodework.exsimplify.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getLogger().info("[EXSimplifyLogs]" + sender.getName() + " tired to run /fly command!.");
        if (args.length == 0) {
            if (!sender.hasPermission("exsimplify.fly")) {
                sender.sendMessage(Component.text("You do not have permission to run this command.").color(NamedTextColor.RED));
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(Component.text("Only players can run this command.").color(NamedTextColor.RED));
                return true;
            }
            Player player = (Player) sender;
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(Component.text("Fly has been disabled.").color(NamedTextColor.AQUA));
            } else {
                player.setAllowFlight(true);
                player.sendMessage(Component.text("Fly has been enabled.").color(NamedTextColor.AQUA));
            }
            return true;
        }
        if (args.length == 1) {
            if (!sender.hasPermission("exsimplify.fly.others")) {
                sender.sendMessage(Component.text("You do not have permission to run this command.").color(NamedTextColor.RED));
                return true;
            }
            Player target = sender.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(Component.text("Player not found.").color(NamedTextColor.RED));
                return true;
            }
            if (target.getAllowFlight()) {
                target.setAllowFlight(false);
                sender.sendMessage(Component.text("Fly has been disabled for " + target.getName()).color(NamedTextColor.AQUA));
            } else {
                target.setAllowFlight(true);
                sender.sendMessage(Component.text("Fly has been enabled for " + target.getName()).color(NamedTextColor.AQUA));
            }
            return true;
        }
        return false;
    }
}
