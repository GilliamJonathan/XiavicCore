package Commands.StaffCmds.noncheat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.Utils;

import static Main.mainClass.messages;
import static Main.mainClass.permissions;

public class WalkSpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (label.equalsIgnoreCase("walkspeed")) {
                if (args.length == 1) {
                    if (player.hasPermission(permissions.getString("Walkspeed")) || player.isOp()) {
                        String speed = args[0];
                        if (speed.equalsIgnoreCase("1")) {
                            player.setWalkSpeed((float) 0.2);
                        } else if (speed.equalsIgnoreCase("2")) {
                            player.setWalkSpeed((float) 0.25);
                        } else if (speed.equalsIgnoreCase("3")) {
                            player.setWalkSpeed((float) 0.3);
                        } else if (speed.equalsIgnoreCase("4")) {
                            player.setWalkSpeed((float) 0.4);
                        } else if (speed.equalsIgnoreCase("5")) {
                            player.setWalkSpeed((float) 0.5);
                        } else if (speed.equalsIgnoreCase("6")) {
                            player.setWalkSpeed((float) 0.6);
                        } else if (speed.equalsIgnoreCase("7")) {
                            player.setWalkSpeed((float) 0.7);
                        } else if (speed.equalsIgnoreCase("8")) {
                            player.setWalkSpeed((float) 0.8);
                        } else if (speed.equalsIgnoreCase("9")) {
                            player.setWalkSpeed((float) 0.9);
                        } else if (speed.equalsIgnoreCase("10")) {
                            player.setWalkSpeed(1);
                        }
                        player.sendMessage(Utils.chat(messages.getString("WalkSpeed").replace("%amount%", speed)));
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
