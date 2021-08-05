package me.loving11ish.poscommands.Events;

import me.loving11ish.poscommands.PosCommands;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class PlayerWalkEvent implements Listener {

    @EventHandler
    public void onPlayerWalk(org.bukkit.event.player.PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location blockunder = player.getLocation();
        blockunder.setY(blockunder.getY() - 1);
        if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-1")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-1")))) {
            if (PosCommands.getPlugin().getConfig().getBoolean("1-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("1-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("1-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("1-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-1")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-1"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-1"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-2")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-2"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-2"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-3")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-3"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-3"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-4")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-4"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-4"));
                }
            }
        }if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-2")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-2")))) {
            if (PosCommands.getPlugin().getConfig().getBoolean("2-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("2-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("2-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("2-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-1")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-1"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-1"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-2")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-2"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-2"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-3")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-3"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-3"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-4")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-4"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-4"));
                }
            }
        }if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-3")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-3")))) {
            if (PosCommands.getPlugin().getConfig().getBoolean("3-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("3-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("3-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("3-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-1")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-1"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-1"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-2")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-2"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-2"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-3")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-3"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-3"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-4")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-4"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-4"));
                }
            }
        }if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-4")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-4")))) {
            if (PosCommands.getPlugin().getConfig().getBoolean("4-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("4-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("4-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("4-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-1")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-1"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-1"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-2")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-2"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-2"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-3")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-3"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-3"));
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-4")){
                    getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-4"));
                }else {
                    player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-4"));
                }
            }
        }
    }
}