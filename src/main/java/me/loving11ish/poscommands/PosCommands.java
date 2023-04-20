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

import java.util.logging.Logger;

public final class PosCommands extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();
    private static PosCommands plugin;
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")
                ||Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")
                ||Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18")
                ||Bukkit.getServer().getVersion().contains("1.19"))){
            logger.warning(ChatColor.RED + "-------------------------------------------");
            logger.warning(ChatColor.RED + "PosCommands - This plugin is only supported on the Minecraft versions listed below:");
            logger.warning(ChatColor.RED + "PosCommands - 1.13.x");
            logger.warning(ChatColor.RED + "PosCommands - 1.14.x");
            logger.warning(ChatColor.RED + "PosCommands - 1.15.x");
            logger.warning(ChatColor.RED + "PosCommands - 1.16.x");
            logger.warning(ChatColor.RED + "PosCommands - 1.17.x");
            logger.warning(ChatColor.RED + "PosCommands - 1.18.x");
            logger.warning(ChatColor.RED + "PosCommands - 1.19.x");
            logger.warning(ChatColor.RED + "PosCommands - Is now disabling!");
            logger.warning(ChatColor.RED + "-------------------------------------------");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }else {
            logger.info(ChatColor.GREEN + "-------------------------------------------");
            logger.info(ChatColor.GREEN + "PosCommands - A supported Minecraft version has been detected");
            logger.info(ChatColor.GREEN + "PosCommands - Continuing plugin startup");
            logger.info(ChatColor.GREEN + "-------------------------------------------");
        }

        // Create & Save Config File
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Register Commands
        getCommand("pcreload").setExecutor(new ReloadConfig());

        // Register Event Listeners
        getServer().getPluginManager().registerEvents(new PlayerWalkEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        // Startup Console Message
        logger.info("-------------------------------------------");
        logger.info(ChatColor.AQUA + "PosCommands PosCommands plugin By Loving11ish");
        logger.info(ChatColor.AQUA + "PosCommands has been loaded successfully");
        logger.info(ChatColor.AQUA + "PosCommands Version " + pluginVersion);
        logger.info("-------------------------------------------");

        // Check For Available Updates
        new UpdateChecker(85571).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info(ColorUtils.translateColorCodes(getConfig().getString("No-update-1")));
                logger.info(ColorUtils.translateColorCodes(getConfig().getString("No-update-2")));
                logger.info(ColorUtils.translateColorCodes(getConfig().getString("No-update-3")));
            }else {
                logger.warning(ColorUtils.translateColorCodes(getConfig().getString("Update-1")));
                logger.warning(ColorUtils.translateColorCodes(getConfig().getString("Update-2")));
                logger.warning(ColorUtils.translateColorCodes(getConfig().getString("Update-3")));
            }
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static PosCommands getPlugin() {
        return plugin;
    }
}