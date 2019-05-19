package mythicmc.zorioux.exit;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ExitCommand implements CommandExecutor {

    private Plugin plugin;



    public ExitCommand(Plugin plugin) {
        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


                if (command.getName().equalsIgnoreCase("exit")){

                   if(sender instanceof Player){ Player p = (Player) sender;
                        if (p.getWorld().equals("KitPvP")){
                            p.sendMessage(ChatColor.DARK_AQUA + "you will be teleported to spawn" +
                                    "Do no move for 5 seconds");
                       int taskId = this.plugin.getServer().getScheduler().runTaskLater(this.plugin, () -> {

                           Location spawn = new Location(p.getWorld(), p.getWorld().getSpawnLocation().getX(),
                                   p.getWorld().getHighestBlockYAt(p.getWorld().getSpawnLocation())+2,
                                   p.getWorld().getSpawnLocation().getZ());

                            p.teleport(spawn);

                       }, 5*20).getTaskId();

                       plugin.getServer().getPluginManager().registerEvents
                               (new MovementListener(plugin, (Player) sender, taskId), plugin);

                }else{
                            p.sendMessage(ChatColor.RED + " you are not in pvp world -.-");
                        }
                   }
                else{System.out.println("only players can use this command for now!");}
                }




        return false;
    }
}
