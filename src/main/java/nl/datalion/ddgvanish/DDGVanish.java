package nl.datalion.ddgvanish;

import nl.datalion.ddgvanish.commands.VanishCommand;
import nl.datalion.ddgvanish.utils.Vanish;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DDGVanish extends JavaPlugin {

    private static String prefix = color("&l&7[&cDDG&7] &r");
    private static DDGVanish instance;
    private static Vanish vanish;

    @Override
    public void onEnable() {
        // Register EventListener.
        this.getServer().getPluginManager().registerEvents(new EventListener(), this);

        // Commands
        this.getCommand("vanish").setExecutor(new VanishCommand());

        // Define instance for easier use in other classes
        instance = this;

        // Define vanish instance for easier use in other classes
        vanish = new Vanish();

    }

    @Override
    public void onDisable() {
        instance = null;
        vanish = null;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static DDGVanish getInstance() {
        return instance;
    }

    public static Vanish getVanishUtil() {
        return vanish;
    }

    public static String color(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}
