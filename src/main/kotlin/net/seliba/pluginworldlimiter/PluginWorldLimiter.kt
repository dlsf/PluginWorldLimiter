package net.seliba.pluginworldlimiter

import net.seliba.pluginworldlimiter.configuration.Config
import net.seliba.pluginworldlimiter.listener.PlayerCommandPreProcessListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class PluginWorldLimiter : JavaPlugin() {

    override fun onEnable() {
        val config = Config("config.yml", this)
        config.setDefault("plugin-disabled-message", "&cSorry, but you can't use this command here!")
        config.setDefault("world.blocked-plugins", listOf("WeirdPlugin1", "WeirdPlugin2"))
        config.setDefault("world.allowed-commands", listOf("allowedcommand1", "allowedcommand2 test :)"))
        config.save()

        Bukkit.getPluginManager().registerEvents(PlayerCommandPreProcessListener(config), this)

        logger.info("Successfully started!")
    }

}