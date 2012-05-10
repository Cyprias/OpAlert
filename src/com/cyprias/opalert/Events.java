package com.cyprias.opalert;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class Events implements Listener {
	private OpAlert plugin;

	public Events(OpAlert plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		if (p.isOp()) {
			if (!p.isPermissionSet("opalert.login")) {
				String msg = String.format(plugin.config.stPlayerIsOp, plugin.getDisplayName(p));
				
				if (plugin.config.boolSendAlertToConsole == true)
					plugin.info(msg);
				

				for (Player o : plugin.getServer().getOnlinePlayers()) {
					if (o.isPermissionSet("opalert.login") && o.hasPermission("opalert.login"))
						o.sendMessage(plugin.chatPrefix + msg);
				}
			}
		}

	}
}
