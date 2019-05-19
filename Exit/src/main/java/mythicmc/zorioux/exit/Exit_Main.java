package mythicmc.zorioux.exit;



import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Exit_Main extends JavaPlugin implements Listener {




    @Override
    public void onEnable() {
        this.getCommand("exit").setExecutor(new ExitCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



    }




