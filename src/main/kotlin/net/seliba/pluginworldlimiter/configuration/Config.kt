package net.seliba.pluginworldlimiter.configuration

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.InvalidConfigurationException
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.IOException

class Config(private val fileName: String, private val javaPlugin: JavaPlugin) : YamlConfiguration() {

    private val file: File = File(javaPlugin.dataFolder, fileName)

    init {
        reload()
    }

    private fun reload() {
        try {
            file.createNewFile()
            load(file)
        } catch (e: IOException) {
            // Do nothing
        } catch (e: InvalidConfigurationException) {
            e.printStackTrace()
            Bukkit.getPluginManager().disablePlugin(javaPlugin)
        }
    }

    fun save() {
        try {
            save(file)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun setDefault(path: String, value: Any?) {
        if (!isSet(path)) {
            set(path, value)
        }
    }

    fun getColoredString(path: String) = ChatColor.translateAlternateColorCodes('&', getString(path)!!)

}