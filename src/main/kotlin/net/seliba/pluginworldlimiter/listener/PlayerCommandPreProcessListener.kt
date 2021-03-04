package net.seliba.pluginworldlimiter.listener

import net.seliba.pluginworldlimiter.configuration.Config
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class PlayerCommandPreProcessListener(private val config: Config) : Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onPlayerCommand(event: PlayerCommandPreprocessEvent) {
        val player = event.player
        if (player.hasPermission("pwl.bypass")) return

        val commandContent = event.message.substring(1).split(" ")
        val executedCommand = Bukkit.getPluginCommand(commandContent[0]) ?: return

        val pluginName = executedCommand.plugin.name
        val worldName = player.world.name

        val blockedPlugins = config.getStringList("$worldName.blocked-plugins")
        val allowedCommands = config.getStringList("$worldName.allowed-commands")

        if (allowedCommands.any { commandContent.joinToString(" ").startsWith(it) }) return

        if (blockedPlugins.contains(pluginName)) {
            event.isCancelled = true
            player.sendMessage(config.getColoredString("plugin-disabled-message"))
        }
    }

}
