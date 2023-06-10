package fun.mrezer.ezerblocker;

import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EzerBlocker extends JavaPlugin implements Listener {
    private String message;
    private List<String> commands;
	private static EzerBlocker instance;

    public void onEnable() {
        getServer().getLogger().info("Плагин успешно включён!");
        this.saveDefaultConfig();
        this.commands = this.getConfig().getStringList("cmds");
        this.message = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.alertmsg"));
        this.getServer().getPluginManager().registerEvents(this, this);
        instance = this;
        getCommand("ezerblocker").setExecutor(new Commands());
    }
	public static EzerBlocker getInstance() {
        return instance;
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (!e.getPlayer().isOp()) {
            Iterator var3 = this.commands.iterator();

            while(var3.hasNext()) {
                String s = (String)var3.next();
                if (e.getMessage().contains(s)) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(this.message);
                    break;
                }
            }

        }
    }
}