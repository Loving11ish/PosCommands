package me.loving11ish.poscommands.Commands;

import me.loving11ish.poscommands.PosCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfig implements CommandExecutor {

    PosCommands plugin;

    public ReloadConfig(PosCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("posCommands.reload")){
                plugin.reloadConfig();
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
                player.sendMessage(ChatColor.GREEN + "[PosCommands] plugin by Loving11ish");
                player.sendMessage(ChatColor.GREEN + "[PosCommands] Configuration file has been successfully reloaded!");
                player.sendMessage(ChatColor.YELLOW + "[---------------------------------------------------]");
            }else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have the permission " + ChatColor.YELLOW +  "posCommands.reload "  + ChatColor.DARK_RED + "needed to run that command");
            }
        }else if (!(sender instanceof Player)){
            plugin.reloadConfig();
            System.out.println(ChatColor.YELLOW + "[---------------------------------------------------]");
            System.out.println(ChatColor.GREEN + "[PosCommands] plugin by Loving11ish");
            System.out.println(ChatColor.GREEN + "[PosCommands] Configuration file has been successfully reloaded!");
            System.out.println(ChatColor.YELLOW + "[---------------------------------------------------]");
        }
        return true;
    }
}
