package com.cyprias.opalert;

import org.bukkit.configuration.Configuration;


public class Config {
	private OpAlert plugin;
	private static Configuration config;

	String stPlayerIsOp;
	boolean boolUseMChatName;
	boolean boolSendAlertToConsole;
	
	public Config(OpAlert plugin) {
		this.plugin = plugin;
		config = plugin.getConfig().getRoot();
		config.options().copyDefaults(true);
		plugin.saveConfig();
		
		stPlayerIsOp = config.getString("stPlayerIsOp").replaceAll("(?i)&([a-k0-9])", "\u00A7$1");// §
		boolUseMChatName = config.getBoolean("boolUseMChatName");
		boolSendAlertToConsole = config.getBoolean("boolSendAlertToConsole");
	}
}
