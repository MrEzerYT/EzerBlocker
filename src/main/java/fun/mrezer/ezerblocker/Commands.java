package fun.mrezer.ezerblocker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static fun.mrezer.ezerblocker.Util.Utils.cfg;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("ezerblocker.commands.admin")) {
            sender.sendMessage(cfg.getString("messages.reload").replace("&", "\u00a7"));
            return true;
        }
        if (args[0] == "reload") {
            EzerBlocker.getInstance().reloadConfig();
            sender.sendMessage("Reloaded succesfully!");
        }
        return true;
    }

    }


