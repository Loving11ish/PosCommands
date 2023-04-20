package me.loving11ish.poscommands.UpdateSystem;

import me.loving11ish.poscommands.PosCommands;
import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("posCommands.update")||player.hasPermission("posCommands.*")||player.isOp()) {
            new UpdateChecker(85571).getVersion(version -> {
                try {
                    if (!(PosCommands.getPlugin().getDescription().getVersion().equalsIgnoreCase(version))) {
                        player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Update-1")));
                        player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Update-2")));
                        player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Update-3")));
                    }
                }catch (NullPointerException e){
                    player.sendMessage(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Update-check-failure")));
                }
            });
        }
    }
}