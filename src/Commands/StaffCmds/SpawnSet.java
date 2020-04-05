package Commands.StaffCmds;

import Main.mainClass;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import utils.Files.Messages;
import utils.Files.Permissions;
import utils.Utils;

public class SpawnSet implements CommandExecutor {

    FileConfiguration m = Messages.get();
    FileConfiguration p = Permissions.get();

    private static mainClass plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(p.getString("SetSpawn")) || player.isOp()) {
                if (cmd.getName().equalsIgnoreCase("setspawn")) {
                    player.getWorld().setSpawnLocation(new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch()));
                    player.sendMessage(Utils.chat(m.getString("SetSpawn")));
                }
                return true;
            }

        }
        return false;
    }
}
