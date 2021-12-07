package me.loving11ish.poscommands.Events;

import me.loving11ish.poscommands.PosCommands;
import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class PlayerWalkEvent implements Listener {

    HashMap<UUID, Long> cooldownOne = new HashMap<>();
    HashMap<UUID, Long> cooldownTwo = new HashMap<>();
    HashMap<UUID, Long> cooldownThree = new HashMap<>();
    HashMap<UUID, Long> cooldownFour = new HashMap<>();

    @EventHandler
    public void onPlayerWalk(org.bukkit.event.player.PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location blockunder = player.getLocation();
        UUID uuid = player.getUniqueId();
        String target = player.getName();
        blockunder.setY(blockunder.getY() - 1);
//----------------------------------------------------------------------------------------------------------------------
        if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-1")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-1")))) {
            //Trigger cooldown system 1
            if (PosCommands.getPlugin().getConfig().getBoolean("Enable-cooldown")){
                if (cooldownOne.containsKey(uuid)){
                    if (cooldownOne.get(uuid) > System.currentTimeMillis()){
                        Long timeLeftOne = (cooldownOne.get(uuid) - System.currentTimeMillis()) / 1000;
                        player.sendMessage(ColorUtils.translateColorCodes("&6You have used this recently, please wait &7")
                                + timeLeftOne + ColorUtils.translateColorCodes(" &6seconds!"));
                        return;
                    }
                }
                cooldownOne.put(uuid, System.currentTimeMillis() + (PosCommands.getPlugin().getConfig().getLong("Cooldown-time") * 1000));
            }
            if (PosCommands.getPlugin().getConfig().getBoolean("1-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("1-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("1-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("1-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-1")){
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-1").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-1").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-1"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-1").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-1").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-1"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-2")){
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-2").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-2").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-2"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-2").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-2").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-2"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-3")){
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-3").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-3").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-3"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-3").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-3").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-3"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("1-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("1-run-as-console-4")){
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-4").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-4").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("1-Command-4"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("1-Command-4").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-4").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("1-Command-4"));
                    }
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-2")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-2")))) {
            //Trigger cooldown system 2
            if (PosCommands.getPlugin().getConfig().getBoolean("Enable-cooldown")){
                if (cooldownTwo.containsKey(uuid)){
                    if (cooldownTwo.get(uuid) > System.currentTimeMillis()){
                        Long timeLeftOne = (cooldownTwo.get(uuid) - System.currentTimeMillis()) / 1000;
                        player.sendMessage(ColorUtils.translateColorCodes("&6You have used this recently, please wait &7")
                                + timeLeftOne + ColorUtils.translateColorCodes(" &6seconds!"));
                        return;
                    }
                }
                cooldownTwo.put(uuid, System.currentTimeMillis() + (PosCommands.getPlugin().getConfig().getLong("Cooldown-time") * 1000));
            }
            if (PosCommands.getPlugin().getConfig().getBoolean("2-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("2-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("2-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("2-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-1")){
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-1").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-1").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-1"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-1").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-1").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-1"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-2")){
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-2").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-2").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-2"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-2").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-2").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-2"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-3")){
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-3").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-3").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-3"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-3").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-3").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-3"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("2-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("2-run-as-console-4")){
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-4").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-4").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("2-Command-4"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("2-Command-4").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-4").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("2-Command-4"));
                    }
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-3")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-3")))) {
            //Trigger cooldown system 3
            if (PosCommands.getPlugin().getConfig().getBoolean("Enable-cooldown")){
                if (cooldownThree.containsKey(uuid)){
                    if (cooldownThree.get(uuid) > System.currentTimeMillis()){
                        Long timeLeftOne = (cooldownThree.get(uuid) - System.currentTimeMillis()) / 1000;
                        player.sendMessage(ColorUtils.translateColorCodes("&6You have used this recently, please wait &7")
                                + timeLeftOne + ColorUtils.translateColorCodes(" &6seconds!"));
                        return;
                    }
                }
                cooldownThree.put(uuid, System.currentTimeMillis() + (PosCommands.getPlugin().getConfig().getLong("Cooldown-time") * 1000));
            }
            if (PosCommands.getPlugin().getConfig().getBoolean("3-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("3-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("3-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("3-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-1")){
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-1").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-1").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-1"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-1").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-1").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-1"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-2")){
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-2").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-2").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-2"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-2").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-2").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-2"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-3")){
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-3").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-3").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-3"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-3").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-3").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-3"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("3-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("3-run-as-console-4")){
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-4").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-4").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("3-Command-4"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("3-Command-4").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-4").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("3-Command-4"));
                    }
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------
        if (player.getLocation().getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Top-Trigger-Block-4")))
                && blockunder.getBlock().getType().equals(Material.getMaterial(PosCommands.getPlugin().getConfig().getString("Bottom-Trigger-Block-4")))) {
            //Trigger cooldown system 4
            if (PosCommands.getPlugin().getConfig().getBoolean("Enable-cooldown")){
                if (cooldownFour.containsKey(uuid)){
                    if (cooldownFour.get(uuid) > System.currentTimeMillis()){
                        Long timeLeftOne = (cooldownFour.get(uuid) - System.currentTimeMillis()) / 1000;
                        player.sendMessage(ColorUtils.translateColorCodes("&6You have used this recently, please wait &7")
                                + timeLeftOne + ColorUtils.translateColorCodes(" &6seconds!"));
                        return;
                    }
                }
                cooldownFour.put(uuid, System.currentTimeMillis() + (PosCommands.getPlugin().getConfig().getLong("Cooldown-time") * 1000));
            }
            if (PosCommands.getPlugin().getConfig().getBoolean("4-TP-Enabled")){
                int x = PosCommands.getPlugin().getConfig().getInt("4-TP-Once-Triggered-X");
                int y = PosCommands.getPlugin().getConfig().getInt("4-TP-Once-Triggered-Y");
                int z = PosCommands.getPlugin().getConfig().getInt("4-TP-Once-Triggered-Z");
                Location location = new Location(player.getWorld(), x, y, z);
                player.teleport(location);
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-1-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-1")){
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-1").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-1").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-1"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-1").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-1").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-1"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-2-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-2")){
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-2").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-2").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-2"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-2").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-2").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-2"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-3-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-3")){
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-3").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-3").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-3"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-3").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-3").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-3"));
                    }
                }
            }if (PosCommands.getPlugin().getConfig().getBoolean("4-Command-4-enabled")){
                if (PosCommands.getPlugin().getConfig().getBoolean("4-run-as-console-4")){
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-4").contains("%player%")){
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-4").replace("%player%", target));
                    }else {
                        getServer().dispatchCommand(Bukkit.getConsoleSender(), PosCommands.getPlugin().getConfig().getString("4-Command-4"));
                    }
                }else {
                    if (PosCommands.getPlugin().getConfig().getString("4-Command-4").contains("%player%")){
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-4").replace("%player%", target));
                    }else {
                        player.performCommand(PosCommands.getPlugin().getConfig().getString("4-Command-4"));
                    }
                }
            }
        }
    }
}