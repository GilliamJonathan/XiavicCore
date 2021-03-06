package Commands.StaffCmds.noncheat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.Utils;

import static Main.mainClass.messages;
import static Main.mainClass.permissions;

public class ClearAllCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 1) {
                if (player.hasPermission(permissions.getString("ClearOthers")) || player.isOp()) {
                    try {
                        Player target = Bukkit.getPlayer(strings[0]);
                        clear(target);
                        player.sendMessage(Utils.chat(messages.getString("ClearInventoryOther").replace("%target%", target.getDisplayName())));
                        return true;
                    } catch (Exception e) {
                        player.sendMessage(Utils.chat(messages.getString("PlayerNotFound")));
                        return true;
                    }
                }
            } else {
                if (player.hasPermission(permissions.getString("Clear")) || player.isOp()) {
                    clear(player);
                } else {
                    player.sendMessage(Utils.chat(messages.getString("NoPerms")));
                }
                return true;
            }
        } else {
            if (strings.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(strings[0]);
                    clear(target);
                    commandSender.sendMessage(Utils.chat(messages.getString("ClearInventoryOther").replace("%target%", target.getDisplayName())));
                    return true;
                } catch (Exception e) {
                    commandSender.sendMessage(Utils.chat(messages.getString("PlayerNotFound")));
                    return true;
                }
            } else {
                commandSender.sendMessage("You need to specify a player to clear their inventory!");
            }
        }
        return false;
    }

    private void clear(Player player) {
        player.getInventory().clear();
        player.sendMessage(Utils.chat(messages.getString("ClearInventory")));
    }

}
