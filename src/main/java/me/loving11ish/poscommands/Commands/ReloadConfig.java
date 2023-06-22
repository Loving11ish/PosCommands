package me.loving11ish.poscommands.Commands;

import com.tcoded.folialib.FoliaLib;
import me.loving11ish.poscommands.PosCommands;
import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ReloadConfig implements CommandExecutor {

    Logger logger = PosCommands.getPlugin().getLogger();

    private FoliaLib foliaLib = PosCommands.getFoliaLib();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player){
            if (player.hasPermission("posCommands.reload")||player.hasPermission("posCommands.*")||player.isOp()){
                player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Reload-beginning")));
                PosCommands.getPlugin().onDisable();
                foliaLib.getImpl().runLater(() -> {
                    Bukkit.getPluginManager().getPlugin("PosCommands").onEnable();
                }, 5L, TimeUnit.SECONDS);
                foliaLib.getImpl().runLater(() -> {
                    PosCommands.getPlugin().reloadConfig();
                    player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Reload-complete")));
                }, 5L, TimeUnit.SECONDS);
            }else {
                player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Reload-command-no-permission")));
            }
        }

        else if (sender instanceof ConsoleCommandSender){
            logger.info(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Reload-beginning")));
            PosCommands.getPlugin().onDisable();
            foliaLib.getImpl().runLater(() -> {
                Bukkit.getPluginManager().getPlugin("PosCommands").onEnable();
            }, 5L, TimeUnit.SECONDS);
            foliaLib.getImpl().runLater(() -> {
                PosCommands.getPlugin().reloadConfig();
                logger.info(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Reload-complete")));
            }, 5L, TimeUnit.SECONDS);
        }
        return true;
    }
}