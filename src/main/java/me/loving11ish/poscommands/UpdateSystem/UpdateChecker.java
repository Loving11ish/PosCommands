package me.loving11ish.poscommands.UpdateSystem;

import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class UpdateChecker {

    private Plugin plugin;
    private int resourceId;

    public UpdateChecker(Plugin plugin, int resourceId) {
        this.plugin = plugin;
        this.resourceId = resourceId;
    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                System.out.println(ColorUtils.translateColorCodes("&b[PosCommand] &4- Unable to check for updates! - &c" + exception.getMessage()));

            }
        });
    }
}