package com.BASeCamp.HardcoreMobs;

import java.io.IOException;

import BASeCamp.Configuration.INIFile;
import BASeCamp.Configuration.INISection;

public class Config {

	private INIFile Settings = null;
	public Config(String sourcefile) {
		try {
		Settings = new INIFile(sourcefile);
		}
		catch(IOException ex){
			Settings = new INIFile();
		}
		
		
	}
	public boolean getEnabled(String worldname){
		
		//search for enabled in appropriate section.
		INISection grabsection = Settings.getSection(worldname.toLowerCase());
		try {
			return Boolean.parseBoolean(grabsection.getValue(worldname.toLowerCase(),"false").getValue());
			
		}
		catch(Exception exx){
			return false;
		}
		
		
	}
	
	
}
