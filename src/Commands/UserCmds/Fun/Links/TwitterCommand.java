package Commands.UserCmds.Fun.Links;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.Utils;

import static Main.mainClass.messages;
import static Main.mainClass.permissions;

public class TwitterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (player.hasPermission(permissions.getString("Twitter")) || player.isOp()) {
            player.sendMessage(Utils.chat(messages.getString("Twitter")));
        } else {
            player.sendMessage(Utils.chat(messages.getString("NoPerms")));
        }
        return false;
    }
}