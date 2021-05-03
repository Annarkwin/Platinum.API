package com.gmail.Annarkwin.Platinum.API;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class API extends JavaPlugin {
	
	@Override
	public void onEnable(){		
		//Load configuration serializable classes
		registerSerializables();
		
		//Retrieve file data

		//Enable plugin features
		enableListeners();
		enableCommands();
		
		//Initialize update event
	}
	
	@Override
	public void onDisable(){
		//Save data
	}
	
	private void registerSerializables() {
		ConfigurationSerialization.registerClass(Cube.class, "Cube");
	}
	
	public void enableCommands(){
		
	}
	
	public void enableListeners(){
		
	}
}
