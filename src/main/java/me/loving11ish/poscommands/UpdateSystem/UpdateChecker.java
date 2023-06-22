package me.loving11ish.poscommands.UpdateSystem;

import com.tcoded.folialib.FoliaLib;
import me.loving11ish.poscommands.PosCommands;
import me.loving11ish.poscommands.Utils.ColorUtils;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class UpdateChecker {

    private int resourceId;
    Logger logger = PosCommands.getPlugin().getLogger();

    public UpdateChecker(int resourceId) {
        this.resourceId = resourceId;
    }

    public void getVersion(final Consumer<String> consumer) {
        FoliaLib foliaLib = PosCommands.getFoliaLib();
        foliaLib.getImpl().runAsync(() -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                logger.warning(ColorUtils.translateColorCodes(PosCommands.getPlugin().getConfig().getString("Update-check-failure") + exception.getMessage()));
            }
        });
    }
}