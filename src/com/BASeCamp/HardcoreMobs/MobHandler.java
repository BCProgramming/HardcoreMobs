package com.BASeCamp.HardcoreMobs;

import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MobHandler implements Listener{

	private HardcoreMobs Owner;
	private boolean Recursivecall=false;
	public HardcoreMobs getOwner(){ return Owner;}
	public MobHandler(HardcoreMobs owner){
		Owner=owner;
	}
	@EventHandler
	public void onCreatureSpawned(org.bukkit.event.entity.CreatureSpawnEvent e){
		if(Recursivecall) return;
		try {
			Recursivecall=true;
		//check if hostile.
			if(!Owner.cfg.getEnabled(e.getEntity().getWorld().getName())) {
				//disabled!
				return;
			}
		if(e.getEntity() instanceof Monster){
			
			int rating =  HardcoreMobs.getRating(e.getEntity().getLocation());
			System.out.println("Attempting to randomize entity, using local rating of " + rating);
			Owner.RandomizeEntity(e.getEntity(),rating);
		}
		
		}
		finally{
			Recursivecall=false;
		}
	}
	
}
