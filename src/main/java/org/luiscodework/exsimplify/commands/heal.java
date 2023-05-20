package org.luiscodework.exsimplify.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.getLogger().info("[EXSimplifyLogs] " + sender.getName() + " tried to run /heal command!.");
        if (args.length == 0) {
            if (!sender.hasPermission("exsimplify.heal")) {
                sender.sendMessage(Component.text("You do not have permission to run this command.").color(NamedTextColor.RED));
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage(Component.text("Only players can run this command.").color(NamedTextColor.RED));
                return true;
            }
            Player player = (Player) sender;
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            player.setFoodLevel(20);
            player.setSaturation(20);
            player.sendMessage(Component.text("You have been healed.").color(NamedTextColor.AQUA));
            return true;
        }
        if (args.length == 1) {
            if (!sender.hasPermission("exsimplify.heal.others")) {
                sender.sendMessage(Component.text("You do not have permission to run this command.").color(NamedTextColor.RED));
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(Component.text("Player not found.").color(NamedTextColor.RED));
                return true;
            }
            target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            target.setFoodLevel(20);
            target.setSaturation(20);
            sender.sendMessage(Component.text(target.getName() + " has been healed.").color(NamedTextColor.AQUA));
            return true;
        }
        return false;
    }
}
