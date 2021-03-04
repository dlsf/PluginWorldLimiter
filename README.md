# PluginWorldLimiter
Spigot plugin which is able to block certain plugin commands in specific worlds.

## Usage
You can configure this plugin through a config.yml. Players with the permission `pwl.bypass` will be ignored.

```yaml
# The message which should be send when a command gets blocked
plugin-disabled-message: '&cSorry, but you can''t use this command here!'
# The name of the world for this configuration section
# You can add other ones in the same way
world:
  # The plugins whose commands should not be executable in this world.
  blocked-plugins:
  - WeirdPlugin1
  - WeirdPlugin2
  # All commands starting with these will be executed
  # even if they are blocked in the section above
  allowed-commands:
  - allowedcommand1
  - allowedcommand2 test :)
```

## Download
You can download the plugin from SpigotMC or the releases page.

## Building
1. `git clone https://github.com/dlsf/PluginWorldLimiter/`
2. `cd PluginWorldLimiter`
3. `./gradlew build` on Unix operating systems or `gradlew.bat build` on Windows
4. Locate the .jar file in the build/libs folder

## Contributing
Feel free to open new issues with feature requests or create your own pull requests.

## Contact
You can contact me on my [support server](https://discord.gg/E763gRg).
