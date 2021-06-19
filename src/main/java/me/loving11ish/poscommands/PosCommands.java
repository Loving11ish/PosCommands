package me.loving11ish.poscommands;

import me.loving11ish.poscommands.Commands.ReloadConfig;
import me.loving11ish.poscommands.Events.PlayerWalkEvent;
import me.loving11ish.poscommands.UpdateSystem.JoinEvent;
import me.loving11ish.poscommands.UpdateSystem.UpdateChecker;
import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class PosCommands extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")||Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")||Bukkit.getServer().getVersion().contains("1.17"))){
            System.out.println(ChatColor.RED + "-------------------------------------------");
            System.out.println(ChatColor.RED + "PosCommands - This plugin is only supported on the Minecraft versions listed below:");
            System.out.println(ChatColor.RED + "PosCommands - 1.13.x");
            System.out.println(ChatColor.RED + "PosCommands - 1.14.x");
            System.out.println(ChatColor.RED + "PosCommands - 1.15.x");
            System.out.println(ChatColor.RED + "PosCommands - 1.16.x");
            System.out.println(ChatColor.RED + "PosCommands - 1.17.x");
            System.out.println(ChatColor.RED + "PosCommands - Is now disabling!");
            System.out.println(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(this);
        }else {
            System.out.println(ChatColor.GREEN + "-------------------------------------------");
            System.out.println(ChatColor.GREEN + "PosCommands - A supported Minecraft version has been detected");
            System.out.println(ChatColor.GREEN + "PosCommands - Continuing plugin startup");
            System.out.println(ChatColor.GREEN + "-------------------------------------------");
        }

        // Create & Save Config File
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register Commands
        getCommand("pcreload").setExecutor(new ReloadConfig(this));

        // Register Event Listeners
        getServer().getPluginManager().registerEvents(new PlayerWalkEvent(this),this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);

        // Startup Console Message
        System.out.println("-------------------------------------------");
        System.out.println(ChatColor.AQUA + "PosCommands PosCommands plugin By Loving11ish");
        System.out.println(ChatColor.AQUA + "PosCommands has been loaded successfully");
        System.out.println(ChatColor.AQUA + "PosCommands Version " + pluginVersion);
        System.out.println("-------------------------------------------");

        // Check For Available Updates
        new UpdateChecker(this, 85571).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println(ColorUtils.translateColorCodes(getConfig().getString("Update-1")));
                System.out.println(ColorUtils.translateColorCodes(getConfig().getString("Update-2")));
                System.out.println(ColorUtils.translateColorCodes(getConfig().getString("Update-3")));
            }else {
                System.out.println(ColorUtils.translateColorCodes(getConfig().getString("No-update-1")));
                System.out.println(ColorUtils.translateColorCodes(getConfig().getString("No-update-2")));
                System.out.println(ColorUtils.translateColorCodes(getConfig().getString("No-update-3")));
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}