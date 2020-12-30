package me.loving11ish.poscommands.Events;

import me.loving11ish.poscommands.PosCommands;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerWalkEvent implements Listener {

    PosCommands plugin;

    public PlayerWalkEvent(PosCommands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerWalk(org.bukkit.event.player.PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location blockunder = player.getLocation();
        blockunder.setY(blockunder.getY() - 1);
        if (player.getLocation().getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Top-Trigger-Block-1"))) && blockunder.getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Bottom-Trigger-Block-1")))) {
            if (plugin.getConfig().getBoolean("1-TP-Enabled")){
                int x = plugin.getConfig().getInt("1-TP-Once-Triggered-X");
                int y = plugin.getConfig().getInt("1-TP-Once-Triggered-Y");
                int z = plugin.getConfig().getInt("1-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (plugin.getConfig().getBoolean("1-Command-1-enabled")){
                player.performCommand(plugin.getConfig().getString("1-Command-1"));
            }if (plugin.getConfig().getBoolean("1-Command-2-enabled")){
                player.performCommand(plugin.getConfig().getString("1-Command-2"));
            }if (plugin.getConfig().getBoolean("1-Command-3-enabled")){
                player.performCommand(plugin.getConfig().getString("1-Command-3"));
            }if (plugin.getConfig().getBoolean("1-Command-4-enabled")){
                player.performCommand(plugin.getConfig().getString("1-Command-4"));
            }
        }if (player.getLocation().getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Top-Trigger-Block-2"))) && blockunder.getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Bottom-Trigger-Block-2")))) {
            if (plugin.getConfig().getBoolean("2-TP-Enabled")){
                int x = plugin.getConfig().getInt("2-TP-Once-Triggered-X");
                int y = plugin.getConfig().getInt("2-TP-Once-Triggered-Y");
                int z = plugin.getConfig().getInt("2-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (plugin.getConfig().getBoolean("2-Command-1-enabled")){
                player.performCommand(plugin.getConfig().getString("2-Command-1"));
            }if (plugin.getConfig().getBoolean("2-Command-2-enabled")){
                player.performCommand(plugin.getConfig().getString("2-Command-2"));
            }if (plugin.getConfig().getBoolean("2-Command-3-enabled")){
                player.performCommand(plugin.getConfig().getString("2-Command-3"));
            }if (plugin.getConfig().getBoolean("2-Command-4-enabled")){
                player.performCommand(plugin.getConfig().getString("2-Command-4"));
            }
        }if (player.getLocation().getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Top-Trigger-Block-3"))) && blockunder.getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Bottom-Trigger-Block-3")))) {
            if (plugin.getConfig().getBoolean("3-TP-Enabled")){
                int x = plugin.getConfig().getInt("3-TP-Once-Triggered-X");
                int y = plugin.getConfig().getInt("3-TP-Once-Triggered-Y");
                int z = plugin.getConfig().getInt("3-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (plugin.getConfig().getBoolean("3-Command-1-enabled")){
                player.performCommand(plugin.getConfig().getString("3-Command-1"));
            }if (plugin.getConfig().getBoolean("3-Command-2-enabled")){
                player.performCommand(plugin.getConfig().getString("3-Command-2"));
            }if (plugin.getConfig().getBoolean("3-Command-3-enabled")){
                player.performCommand(plugin.getConfig().getString("3-Command-3"));
            }if (plugin.getConfig().getBoolean("3-Command-4-enabled")){
                player.performCommand(plugin.getConfig().getString("3-Command-4"));
            }
        }if (player.getLocation().getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Top-Trigger-Block-4"))) && blockunder.getBlock().getType().equals(Material.getMaterial(plugin.getConfig().getString("Bottom-Trigger-Block-4")))) {
            if (plugin.getConfig().getBoolean("4-TP-Enabled")){
                int x = plugin.getConfig().getInt("4-TP-Once-Triggered-X");
                int y = plugin.getConfig().getInt("4-TP-Once-Triggered-Y");
                int z = plugin.getConfig().getInt("4-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (plugin.getConfig().getBoolean("4-Command-1-enabled")){
                player.performCommand(plugin.getConfig().getString("4-Command-1"));
            }if (plugin.getConfig().getBoolean("4-Command-2-enabled")){
                player.performCommand(plugin.getConfig().getString("4-Command-2"));
            }if (plugin.getConfig().getBoolean("4-Command-3-enabled")){
                player.performCommand(plugin.getConfig().getString("4-Command-3"));
            }if (plugin.getConfig().getBoolean("4-Command-4-enabled")){
                player.performCommand(plugin.getConfig().getString("4-Command-4"));
            }
        }
    }
}
