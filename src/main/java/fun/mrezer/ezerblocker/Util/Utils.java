package fun.mrezer.ezerblocker.Util;

import fun.mrezer.ezerblocker.EzerBlocker;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    private static final Logger log = Logger.getLogger("Minecraft");
    private static final String prefix = "[EzerBlocker] ";

    public static void info(String output) {
        log.log(Level.INFO,prefix + "{0}", "\u00a7a"+output);
    }

    public static void severe(String output) {
        log.log(Level.SEVERE,prefix + "{0}", output);
    }

    public static void warning(String output) {
        log.log(Level.WARNING,prefix + "{0}", output);
    }

    public static FileConfiguration cfg = EzerBlocker.getInstance().getConfig();
}
