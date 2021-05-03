package com.gmail.Annarkwin.Platinum.API;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FileStorage {
	private JavaPlugin plugin;
	private String filename;
	
	private FileConfiguration customConfig = null;
	private File customConfigFile = null;
	
	public FileStorage(JavaPlugin plugin, String filename) {
		this.plugin = plugin;
		this.filename = filename;
		customConfigFile = new File(plugin.getDataFolder(), filename);
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
		loadFromDisk();
	}
	
	private void loadFromDisk() {
		if (customConfigFile == null) {
			customConfigFile = new File(plugin.getDataFolder(), filename);
		}
		customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
		
		// Look for defaults in the jar
		InputStream i = plugin.getResource(filename);
		if (i != null) {
			Reader defConfigStream = new InputStreamReader(i);
			if (defConfigStream != null) {
				YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
				try {
					defConfigStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				customConfig.setDefaults(defConfig);
			}
		}
	}
	
	public FileConfiguration getData() {
		if (customConfig == null) {
			loadFromDisk();
		}
		return customConfig;
	}
	
	public void saveToDisk() {
		if (customConfig == null || customConfigFile == null) { return; }
		try {
			getData().save(customConfigFile);
		} catch (IOException ex) {
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + customConfigFile, ex);
		}
	}
	
	public void saveDefaultConfig() {
		if (customConfigFile == null) {
			customConfigFile = new File(plugin.getDataFolder(), filename);
		}
		if (!customConfigFile.exists()) {
			plugin.saveResource(filename, false);
		}
	}
	
	public String getFileName() {
		return filename;
	}

	
}
