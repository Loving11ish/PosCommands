package me.loving11ish.poscommands.UpdateSystem;

import me.loving11ish.poscommands.PosCommands;
import me.loving11ish.poscommands.Utils.ColorUtils;
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
                try {
                    if (!(plugin.getDescription().getVersion().equalsIgnoreCase(version))) {
                        player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Update-1")));
                        player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Update-2")));
                        player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Update-3")));
                    }
                }catch (NullPointerException e){
                    player.sendMessage(ColorUtils.translateColorCodes(plugin.getConfig().getString("Update-check-failure")));
                }
            });
        }
    }
}