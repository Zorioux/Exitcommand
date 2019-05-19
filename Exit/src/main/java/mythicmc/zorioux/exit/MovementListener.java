package mythicmc.zorioux.exit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class MovementListener implements Listener {


    //Plugin instance to cancel the task
    private Plugin plugin;

    //The player that called /exit
    private Player player;

    //The task we set up to teleport the player
    private int taskId;


    public MovementListener(Plugin plugin, Player player, int taskId) {
        this.plugin = plugin;
        this.player = player;
        this.taskId = taskId;
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        //We only care if our player has moved, so we check for that
        if (event.getPlayer().equals(player)) {
            /*
            If he did, we cancel the task, since he shouldn't be teleported anymore
            Then we inform the player that his tp was canceled because he moved
            And finally, we unregister this listener since we don't care anymore if the player moved
             */
            plugin.getServer().getScheduler().cancelTask(taskId);
            event.getPlayer().sendMessage(ChatColor.DARK_RED + "Your teleportation has been cancelled because you moved!");
            event.getHandlers().unregister(this);
        }
    }







}
