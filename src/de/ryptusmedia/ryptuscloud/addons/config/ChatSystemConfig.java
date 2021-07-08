package de.ryptusmedia.ryptuscloud.addons.config;

import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.permission.PermissionTeam;
import de.ryptusmedia.minecraft.cloudsystem.ryptuscloud.utilities.annotions.AddonConfig;
import org.bukkit.entity.Player;

@AddonConfig(configName = "ChatSystem")
public class ChatSystemConfig {

    private final String format;

    public ChatSystemConfig() {
        this.format = "%teamSuffix%%teamName% &8● %teamSuffix%%playerName% &8× &f%message%";
    }

    public String getFormat(Player player, PermissionTeam permissionTeam, String message) {
        return format
                .replace("%teamName%", permissionTeam.getTeamName())
                .replace("%teamPrefix%", permissionTeam.getTeamPrefix())
                .replace("%teamSuffix%", permissionTeam.getTeamSuffix())
                .replace("%teamDisplay%", permissionTeam.getTeamDisplay())
                .replace("%playerName%", player.getName())
                .replace("%message%", message)
                .replace("&", "§");
    }

}
