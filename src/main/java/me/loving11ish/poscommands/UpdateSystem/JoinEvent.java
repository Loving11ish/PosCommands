package me.loving11ish.poscommands.UpdateSystem;

import me.loving11ish.poscommands.PosCommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    PosCommands plugin;

    public JoinEvent(PosCommands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("posCommands.update")) {
            new UpdateChecker(plugin, 85571).getVersion(version -> {
                if (!(plugin.getDescription().getVersion().equalsIgnoreCase(version))) {
                    player.sendMessage(ChatColor.DARK_RED + "*-------------------------------------------*");
                    player.sendMessage(ChatColor.AQUA + "       [PosCommands] " + ChatColor.RED + "- A new version is available!");
                    player.sendMessage(ChatColor.DARK_RED + "*-------------------------------------------*");
                }
            });
        }
    }
}
