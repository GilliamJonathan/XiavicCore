package Commands.UserCmds.Essential;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import utils.Files.Permissions;

public class Dispose implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration p = Permissions.get();

        if (sender instanceof Player) {
            if (label.equalsIgnoreCase("dispose") || label.equalsIgnoreCase("trash")) {
                Player player = (Player) sender;
                Inventory inventory = Bukkit.createInventory(null, 54, "Chest");
                if (player.hasPermission(p.getString("Dispose")) || player.isOp()) {
                    player.openInventory(inventory);
                }
            }
        }
        return false;
    }
}
