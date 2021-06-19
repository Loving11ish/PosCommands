package me.loving11ish.poscommands.Commands;

import me.loving11ish.poscommands.PosCommands;
import me.loving11ish.poscommands.Utils.ColorUtils;
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
            if (player.hasPermission("posCommands.reload")||player.hasPermission("posCommands.*")||player.isOp()){
                plugin.reloadConfig();
                player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-1")));
                player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-2")));
                player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-3")));
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-command-no-permission")));
            }
        }else if (!(sender instanceof Player)){
            plugin.reloadConfig();
            System.out.println(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-1")));
            System.out.println(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-2")));
            System.out.println(ColorUtils.translateColorCodes(plugin.getConfig().getString("Reload-3")));
        }
        return true;
    }
}