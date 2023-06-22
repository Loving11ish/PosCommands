package me.loving11ish.poscommands;

import com.rylinaux.plugman.api.PlugManAPI;
import com.tcoded.folialib.FoliaLib;
import io.papermc.lib.PaperLib;
import me.loving11ish.poscommands.Commands.ReloadConfig;
import me.loving11ish.poscommands.Events.PlayerWalkEvent;
import me.loving11ish.poscommands.UpdateSystem.JoinEvent;
import me.loving11ish.poscommands.UpdateSystem.UpdateChecker;
import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class PosCommands extends JavaPlugin {

    private PluginDescriptionFile pluginInfo = getDescription();
    private String pluginVersion = pluginInfo.getVersion();
    private static PosCommands plugin;
    private static FoliaLib foliaLib;
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        //Plugin startup logic
        plugin = this;
        foliaLib = new FoliaLib(plugin);

        //Server version compatibility check
        if (!(Bukkit.getServer().getVersion().contains("1.13")||Bukkit.getServer().getVersion().contains("1.14")
                ||Bukkit.getServer().getVersion().contains("1.15")||Bukkit.getServer().getVersion().contains("1.16")
                ||Bukkit.getServer().getVersion().contains("1.17")||Bukkit.getServer().getVersion().contains("1.18")
                ||Bukkit.getServer().getVersion().contains("1.19")||Bukkit.getServer().getVersion().contains("1.20"))){
            logger.warning(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &4Your server version is: &d" + Bukkit.getServer().getVersion()));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &4This plugin is only supported on the Minecraft versions listed below:"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.13.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.14.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.15.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.16.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.17.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.18.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.19.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &41.20.x"));
            logger.warning(ColorUtils.translateColorCodes("&6PosCommands: &4Is now disabling!"));
            logger.warning(ColorUtils.translateColorCodes("-------------------------------------------"));
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }else {
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aA supported Minecraft version has been detected"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aYour server version is: &d" + Bukkit.getServer().getVersion()));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aContinuing plugin startup"));
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        }

        //Suggest PaperMC if not using
        if (foliaLib.isUnsupported()||foliaLib.isSpigot()){
            PaperLib.suggestPaper(this);
        }

        //Check if PlugManX is enabled
        if (isPlugManXEnabled()){
            if (!PlugManAPI.iDoNotWantToBeUnOrReloaded("PosCommands")){
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&4WARNING WARNING WARNING WARNING!"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4You appear to be using an unsupported version of &d&lPlugManX"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4Please &4&lDO NOT USE PLUGMANX TO LOAD/UNLOAD/RELOAD THIS PLUGIN!"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4Please &4&lFULLY RESTART YOUR SERVER!"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4This plugin &4&lHAS NOT &4been validated to use this version of PlugManX!"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4&lNo official support will be given to you if you use this!"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4&lUnless Loving11ish has explicitly agreed to help!"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &4Please add PosCommands to the ignored-plugins list in PlugManX's config.yml"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&6PosCommands: &6Continuing plugin startup"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
                logger.severe(ColorUtils.translateColorCodes("&c-------------------------------------------"));
            }else {
                logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
                logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aSuccessfully hooked into PlugManX"));
                logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aSuccessfully added PosCommands to ignoredPlugins list."));
                logger.info(ColorUtils.translateColorCodes("&6PosCommands: &6Continuing plugin startup"));
                logger.info(ColorUtils.translateColorCodes("&a-------------------------------------------"));
            }
        }else {
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &cPlugManX not found!"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &cDisabling PlugManX hook loader"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &6Continuing plugin startup"));
            logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        }

        //Create & Save Config File
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Register Commands
        getCommand("pcreload").setExecutor(new ReloadConfig());

        //Register Event Listeners
        getServer().getPluginManager().registerEvents(new PlayerWalkEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);

        //Startup Console Message
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        logger.info(ColorUtils.translateColorCodes("&6PosCommands: &3Plugin by: &b&lLoving11ish"));
        logger.info(ColorUtils.translateColorCodes("&6PosCommands: &3has been loaded successfully"));
        logger.info(ColorUtils.translateColorCodes("&6PosCommands: &3Plugin Version: &d&l" + pluginVersion));
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));

        //Check For Available Updates
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
        //Plugin shutdown logic

        //Unregister plugin listeners
        HandlerList.unregisterAll(this);

        //Final plugin shutdown message
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));
        logger.info(ColorUtils.translateColorCodes("&6PosCommands: &3Plugin Version: &d&l" + pluginVersion));
        logger.info(ColorUtils.translateColorCodes("&6PosCommands: &3Has been shutdown successfully"));
        logger.info(ColorUtils.translateColorCodes("&6PosCommands: &3Goodbye!"));
        logger.info(ColorUtils.translateColorCodes("-------------------------------------------"));

        //Cleanup any plugin remains
        foliaLib = null;
        plugin = null;
    }

    public boolean isPlugManXEnabled() {
        try {
            Class.forName("com.rylinaux.plugman.PlugMan");
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aFound PlugManX main class at:"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &dcom.rylinaux.plugman.PlugMan"));
            return true;
        }catch (ClassNotFoundException e){
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &aCould not find PlugManX main class at:"));
            logger.info(ColorUtils.translateColorCodes("&6PosCommands: &dcom.rylinaux.plugman.PlugMan"));
            return false;
        }
    }

    public static PosCommands getPlugin() {
        return plugin;
    }

    public static FoliaLib getFoliaLib() {
        return foliaLib;
    }
}