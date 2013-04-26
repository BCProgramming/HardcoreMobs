package com.BASeCamp.HardcoreMobs;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;




public class HardcoreMobs extends JavaPlugin{
	public enum MaterialTier{None,
		Wood,
		Stone,
		Leather,
		Iron,Gold,Chainmail,Diamond		
	}
	public enum ArmourType{
		NotArmour,Helmet,Chestplate,Leggings,Boots
		
		
	}
	public enum WeaponType{
		Sword,Bow,Axe
	}
	//retrieves the active BCRandomizer plugin, or null of the plugin is not found.

	public static String pluginMainDir = "./plugins/HardcoreMobs";
	public static String defaultINI = pluginMainDir + "/config.ini";
	public static NameGenerator NameGen;
	
	public static String getEntityDescription(LivingEntity entityfor,boolean useentitycolor){
		return getEntityDescription(entityfor,useentitycolor,true);
	}
	public static String getEntityDescription(LivingEntity entityfor,boolean useentitycolor,boolean usesimple){
		
		//retrieves a description; instead of Skeleton, for example, if the skeleton is a Wither skeleton, it returns Wither Skeleton;
		//if it has armour, it will be a "armoured Skeleton" if a Charged Creeper, it will be described thus, etcetera.
		
		
		//useentitycolour is whether the returned value should be coloured.
		ChatColor tcolor = ChatColor.RED;
		
		//first, we sorta need a special case for certain types. Oh well.
		//first, Skeleton...
		String BuildDescription = "";
		
		if(entityfor.getType().equals(EntityType.SKELETON)){
			tcolor=ChatColor.GRAY;
			BuildDescription = "Skeleton";
			Skeleton cs = (Skeleton)entityfor;
			if(cs.getSkeletonType()==SkeletonType.WITHER){
				
				//Wither...
				BuildDescription="Wither Skeleton";
				tcolor = ChatColor.BLACK;
				
				
			}
			
			
			
		}
		else if(entityfor.getType().equals(EntityType.PIG_ZOMBIE)){
			tcolor = ChatColor.DARK_GREEN;
			BuildDescription = "Zombie Pigman";
			
			
		}
		else if(entityfor.getType().equals(EntityType.ZOMBIE)){
			
			tcolor = ChatColor.GREEN;	
			BuildDescription = "Zombie";
		}
		else if(entityfor.getType().equals(EntityType.BLAZE)){
			
			tcolor = ChatColor.GOLD;
			BuildDescription = "Blaze";
		}
		else if(entityfor.getType().equals(EntityType.CAVE_SPIDER)){
		tcolor=ChatColor.DARK_AQUA;	
			BuildDescription = "Cave Spider";
		}
		else if(entityfor.getType().equals(EntityType.CREEPER)){
			Creeper cc = (Creeper)entityfor;
			if(cc.isPowered()){
				BuildDescription = "Charged Creeper";
				tcolor = ChatColor.BLUE;
			}
			else{
				BuildDescription = "Creeper";
				tcolor = ChatColor.GREEN;
			}
			
		}
		else if(entityfor.getType().equals(EntityType.SPIDER)){
		BuildDescription="Spider";
		tcolor = ChatColor.DARK_GRAY;
			
		}
		else if(entityfor.getType().equals(EntityType.ENDERMAN)){
		tcolor = ChatColor.BLACK;
		BuildDescription = "Enderman";
			
			
		}
		else if(entityfor.getType().equals(EntityType.MAGMA_CUBE)){
		BuildDescription = "Magma Cube";
		tcolor = ChatColor.RED;
			
		}
		else if(entityfor.getType().equals(EntityType.GHAST)){
		BuildDescription = "Ghast";
		tcolor = ChatColor.WHITE;
			
		}
		else if(entityfor.getType().equals(EntityType.WITCH))
		{
			BuildDescription = "Witch";
			tcolor = ChatColor.BOLD;
		}
		else{
			
			BuildDescription = entityfor.getType().toString();
			
			
		}
		
		if(entityfor instanceof Zombie){
		
			if(((Zombie)entityfor).isBaby()){
			BuildDescription = "baby " + BuildDescription;
			}
		}
		else if(entityfor instanceof Villager){
			if(!((Villager)entityfor).isAdult())
				BuildDescription = "baby " + BuildDescription;
			
		}
		
		
		
		if(useentitycolor){
			
			BuildDescription = tcolor + BuildDescription + ChatColor.RESET;
		}
		String[] armourprefix = new String[] {"","Lightly Armoured","Armoured","Armoured","Fully Armoured"};
		
		String postfix = "";
		String useprefix = "";
		if(entityfor instanceof Zombie || entityfor instanceof Skeleton){
		//CraftLivingEntity cle = (CraftLivingEntity)entityfor;
		ItemStack EntityWeapon = entityfor.getEquipment().getItemInHand();
		ItemStack EntityBoots = entityfor.getEquipment().getBoots();
		ItemStack EntityLeggings = entityfor.getEquipment().getLeggings();
		ItemStack EntityChestplate = entityfor.getEquipment().getChestplate();
		ItemStack EntityHelmet = entityfor.getEquipment().getHelmet();
		//net.minecraft.server.v1_4_R1.ItemStack EntityWeapon = cle.getHandle().getEquipment(0);
		//net.minecraft.server.v1_4_R1.ItemStack EntityBoots =cle.getHandle().getEquipment(1);
		//net.minecraft.server.v1_4_R1.ItemStack EntityLeggings =cle.getHandle().getEquipment(2);
		//net.minecraft.server.v1_4_R1.ItemStack EntityChestplate =cle.getHandle().getEquipment(3);
		//net.minecraft.server.v1_4_R1.ItemStack EntityHelmet =cle.getHandle().getEquipment(4);
		
		int armourcount = 
			(EntityBoots==null?0:1) +
			(EntityLeggings==null?0:1) +
			(EntityChestplate==null?0:1) + 
			(EntityHelmet==null?0:1);
		
		
		useprefix = armourprefix[armourcount];
		if(entityfor.getActivePotionEffects().size() > 0){
			BuildDescription = "Buffed " + BuildDescription ;
		}
		if(EntityWeapon!=null){
			if(useprefix.equals("")) useprefix = "armed "; else useprefix = "Armed and ";
			
			
		}

		
		}
		if(usesimple) useprefix="";
		return (useprefix.trim() +  " " + BuildDescription.trim() + " " + postfix.trim()).replace("  ", " ");
		
		
		
		
	}
	private static String FriendlizeName(String source) {
		source = source.replace("item_", " ");
		source = source.replace('_', ' ');

		return allCaps(source) ? capitalizeString(source) : source;

	}
	public static boolean allCaps(String strtest) {
		for (int i = 0; i < strtest.length(); i++) {

			char currchar = strtest.charAt(i);
			if (currchar != Character.toUpperCase(currchar))
				return false;

		}
		return true;

	}

	public static String capitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.') { // You
																				// can
																				// add
																				// other
																				// chars
																				// here
				found = false;
			}
		}
		return String.valueOf(chars);
	}
	public Scanner acquireStream(String SourceName) {

		try {
			if (SourceName != "") {

				try {
					return new Scanner(new URL(SourceName).openStream());

				} catch (Exception urlexception) {

					// String pathgrab =
					// SourceName.substring(0,SourceName.lastIndexOf(File.separatorChar));
					// System.out.println("pathgrab=" + pathgrab);
					try {
						return new Scanner(new File(SourceName));

					} catch (Exception directexception) {
						//didn't even work directly. Let's look in the PluginFolder.
						String uselocation = HardcoreMobs.pluginMainDir;
						if(!uselocation.endsWith("\\")){
							uselocation=uselocation+"\\";
							
						}
						return new Scanner(new File(uselocation + SourceName));
						
					}

				}

			}
		} catch (Exception exx) {
			// attempt to read it from our jar.
			// first we only want the filename.

			Bukkit.getLogger().log(Level.INFO,
					"HARDCOREMOBS:" + SourceName + " Not found. Reading from JAR...");
			// Bukkit.getLogger().log(Level.WARNING,
			// "Warning: Config/List file not found at " +
			// BCRandomizer.pluginConfigLocation + " using built in.");
			// sc = new
			// Scanner(getClass().getClassLoader().getResourceAsStream("survivalchests.cfg"));
			String onlyfname = new File(SourceName).getName();
			InputStream makeresult = null;

			makeresult = getClass().getClassLoader().getResourceAsStream(
					onlyfname);

			if (makeresult == null)
				makeresult = getClass().getClassLoader().getResourceAsStream(
						SourceName);

			return makeresult == null ? null : new Scanner(makeresult);

		}

		String onlyfile = SourceName.substring(SourceName
				.lastIndexOf(File.separatorChar) + 1);
		// System.out.println("Onlyfile=" + onlyfile);

		return new Scanner(this.getClass().getClassLoader()
				.getResourceAsStream(onlyfile));
	}
	public Config cfg = null;
	private MobHandler mh=null;
	@Override
	public void onEnable(){
		if(NameGen==null)
			NameGen = new NameGenerator(this);
		cfg = new Config(defaultINI);
		
		ItemRandomizer.reload(this,"");
		mh = new MobHandler(this);
		Bukkit.getPluginManager().registerEvents(mh, this);
	}

	public static void emitmessage(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	
	public static Player getNearestPlayer(Location testlocation) {
	World applyworld = testlocation.getWorld();

	double MinimumDistance = Double.MAX_VALUE;
	Player minimumPlayer = null;
	// iterate through all the players in this world.
	for (Player p : applyworld.getPlayers()) {
		double gotdistance = p.getLocation().distance(testlocation);
		if (gotdistance < MinimumDistance) {
			MinimumDistance = gotdistance;
			minimumPlayer = p;
		}
	}

	return minimumPlayer;

}
	static Material[] IronMaterials = new Material[] {
			
			Material.IRON_AXE,
			Material.IRON_SWORD,
			Material.IRON_HELMET,
			Material.IRON_CHESTPLATE,
			Material.IRON_LEGGINGS,
			Material.IRON_BOOTS
	};
	
	static Material[] GoldMaterials = new Material[] {
			Material.GOLD_AXE,
			Material.GOLD_SWORD,
			Material.GOLD_HELMET,
			Material.GOLD_CHESTPLATE,
			Material.GOLD_LEGGINGS,
			Material.GOLD_BOOTS,
			
	};
	
	static Material[] DiamondMaterials = new Material[] {
		Material.DIAMOND_AXE,
		Material.DIAMOND_SWORD,
		Material.DIAMOND_HELMET,
		Material.DIAMOND_CHESTPLATE,
		Material.DIAMOND_LEGGINGS,
		Material.DIAMOND_BOOTS
	};
	static Material[] ChainmailMaterials = new Material[] {
		Material.CHAINMAIL_HELMET,
		Material.CHAINMAIL_CHESTPLATE,
		Material.CHAINMAIL_LEGGINGS,
		Material.CHAINMAIL_BOOTS
	};
	static Material[] Helmets = new Material[] {
		Material.LEATHER_HELMET,
	    Material.IRON_HELMET,
	    Material.GOLD_HELMET,
	    Material.DIAMOND_HELMET
	};
	static Material[] Chestplates = new Material[] {
		Material.LEATHER_CHESTPLATE,
		Material.IRON_CHESTPLATE,
		Material.GOLD_CHESTPLATE,
		Material.DIAMOND_CHESTPLATE
	};
	static Material[] Leggings = new Material[] {
		Material.LEATHER_LEGGINGS,
		Material.IRON_LEGGINGS,
		Material.GOLD_LEGGINGS,
		Material.DIAMOND_LEGGINGS
	};
	
	static Material[] Boots = new Material[] {
		Material.LEATHER_BOOTS,
		Material.IRON_BOOTS,
		Material.GOLD_BOOTS,
		Material.DIAMOND_BOOTS
	};
	
	public static boolean isHelmet(Material mat){
		for(Material helm:Helmets) if(helm.equals(mat)) return true;
		return false;
	}
	public static boolean isChestplate(Material mat){
		for(Material chestplate:Chestplates) if(chestplate.equals(mat)) return  true;
		return false;
	}
	public static boolean isLeggings(Material mat){
		for(Material legging:Leggings) if(legging.equals(mat)) return true;
		return false;
	}
	public static boolean isBoots(Material mat){
		for(Material boots:Boots) if(boots.equals(mat)) return true;
		return false;
	}
	public static MaterialTier getMaterialTier(Material mat){
		
		if((mat.equals(Material.WOOD_AXE)||mat.equals(Material.WOOD_SWORD))){
			return MaterialTier.Wood;
		}
		else if(mat.equals(Material.STONE_AXE) || mat.equals(Material.STONE_SWORD)){
			return MaterialTier.Stone;
		}
		for(Material testiron:IronMaterials) if(testiron.equals(mat)) return MaterialTier.Iron;
		for(Material testgold:GoldMaterials) if(testgold.equals(mat)) return MaterialTier.Gold;
		for(Material testdiamond:DiamondMaterials) if(testdiamond.equals(mat)) return MaterialTier.Diamond;
		for(Material testchain:ChainmailMaterials) if(testchain.equals(mat)) return MaterialTier.Chainmail;		
		
		return MaterialTier.None;
	}
	public static ArmourType getArmourType(Material mat){
		if(isHelmet(mat)) return ArmourType.Helmet;
		if(isChestplate(mat)) return ArmourType.Chestplate;
		if(isLeggings(mat)) return ArmourType.Leggings;
		if(isBoots(mat)) return ArmourType.Boots;
		return ArmourType.NotArmour;
	}
	private static HashMap<Enchantment,Integer> EnchantmentBaseScores = new HashMap<Enchantment,Integer>();
	static {
		HashMap<Enchantment,Integer> e = EnchantmentBaseScores; //local copy for brevity.
		
		e.put(Enchantment.ARROW_DAMAGE, 2); //Power
		e.put(Enchantment.ARROW_FIRE, 3);  //Flame
		e.put(Enchantment.ARROW_INFINITE, 5); //Infinity
		e.put(Enchantment.ARROW_KNOCKBACK, 1); //Knockback
		e.put(Enchantment.DAMAGE_ALL, 2); //sharpness
		e.put(Enchantment.DAMAGE_ARTHROPODS, 2);
		e.put(Enchantment.DAMAGE_UNDEAD, 4); //smite. This get's a boost, because we can only give armour/weapons to undead anyway.
		e.put(Enchantment.DURABILITY, 8); //unbreaking. (initial test cranks it)
		e.put(Enchantment.FIRE_ASPECT, 3);
		e.put(Enchantment.OXYGEN,4);
		e.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		e.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
		e.put(Enchantment.PROTECTION_FALL, 3);
		e.put(Enchantment.PROTECTION_FIRE, 3);
		e.put(Enchantment.PROTECTION_PROJECTILE, 4);
		e.put(Enchantment.THORNS, 6);
		
		
		
	}
	
	public static int getItemValue(ItemStack itemtest){
		if(itemtest==null) return 0;
		//determine base score of item based on whether it is a piece of armour or what kind of weapon it is.
		int currscore=0;
	    if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Wood))	
	    	currscore=1;
	    else if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Stone))
	        currscore=2;
	    else if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Gold))
	    	currscore=3;
	    else if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Leather))
	    	currscore=4;
	    else if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Iron))
	    	currscore=4;
	    else if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Chainmail))
	    	currscore=7;
	    else if(getMaterialTier(itemtest.getType()).equals(MaterialTier.Diamond))
	    	currscore=6;
	    		
		int bonusscore=0;
	    
	    //At this point: we've determined the base score for this item based on it's material.
	    if(itemtest.hasItemMeta()){
	    	
	    	//check enchantments, Lore, and whatnot.
	    	ItemMeta grabmeta = itemtest.getItemMeta();
	    	if(grabmeta.getDisplayName()!=null)
	    		bonusscore=2;
	    	
	    	//calculate enchantment value.
	    	int enchantmentscore = 0;
	    	for(Enchantment iterateenchant:grabmeta.getEnchants().keySet()){
	    		
	    		Integer gotvalue =EnchantmentBaseScores.get(iterateenchant);
	    		if(gotvalue!=null){
	    			
	    			//if it counts, add it's base score multiplied by it's enchantment level.
	    			int enchval = gotvalue.intValue();
	    			enchval*=grabmeta.getEnchantLevel(iterateenchant);
	    			
	    			enchantmentscore+=enchval;
	    		}
	    		
	    		
	    		
	    	}
	    	currscore*=enchantmentscore;
	    }
	    //System.out.println("calculated score for Item:" + currscore);
	    return currscore;
	    
		
		
	}
	public static int getEntityRating(LivingEntity p){
		
		//value is determined and calculated based on the average values of all the equipment that is worn.
		//empty armour slots are considered 0, however an empty IteminHand slot is considered to be equivalent to a Iron Sword in value.
		int currentvalue=0;
		EntityEquipment ee = p.getEquipment();
		for(ItemStack iterate:new ItemStack[] {ee.getHelmet(),ee.getChestplate(),ee.getLeggings(),ee.getBoots(),ee.getItemInHand()}){
			if(iterate!=null)
				currentvalue+=getItemValue(iterate);
			
			
		}
		return currentvalue;
		
		
		
	}
	public static List<Player> getPlayersinRange(Location Center,float XZDistance){
		
		List<Player> returnlist = new LinkedList<Player>();
		
		for(Player p: Center.getWorld().getPlayers()){
			if(p.isOnline()){
				double xdiff= p.getLocation().getX()-Center.getX();
				double zdiff = p.getLocation().getZ()-Center.getZ();
				double distance = Math.sqrt((xdiff*xdiff)+(zdiff*zdiff));
				System.out.println("distance:" + distance);
				if(distance < XZDistance){
					returnlist.add(p);
				}
				
				
				
			}
		}
		return returnlist;
		
		
	}
	public static int getRating(Location l){
		//returns the "mob difficulty rating" for the given location.
		//Mob difficulty ratings are done by calculating the average value of equipment on nearby players.
		int basedifficulty=6;
		List<Player> ranged = getPlayersinRange(l,16*16);
		for(Player p:ranged){
			
			basedifficulty+=getEntityRating(p)+2;
			
			
		}
		int multiplicand = 1;
		if(l.getWorld().getDifficulty()==Difficulty.EASY) multiplicand=1;
		if(l.getWorld().getDifficulty()==Difficulty.NORMAL) multiplicand=2;
		if(l.getWorld().getDifficulty()==Difficulty.HARD) multiplicand=3;
		
		
		return basedifficulty*(ranged.size())*multiplicand;
	}
	private static HashMap<Material,Material> ReductionTable = new HashMap<Material,Material>();
	static {
		//leather and wood cannot be reduced, so we keep them the same.
		ReductionTable.put(Material.LEATHER_HELMET,Material.LEATHER_HELMET);
		ReductionTable.put(Material.LEATHER_CHESTPLATE,Material.LEATHER_CHESTPLATE);
		ReductionTable.put(Material.LEATHER_LEGGINGS,Material.LEATHER_LEGGINGS);
		ReductionTable.put(Material.LEATHER_BOOTS,Material.LEATHER_BOOTS);
		ReductionTable.put(Material.WOOD_AXE, Material.WOOD_AXE);
		ReductionTable.put(Material.WOOD_HOE, Material.WOOD_HOE);
		ReductionTable.put(Material.WOOD_PICKAXE, Material.WOOD_PICKAXE);
		ReductionTable.put(Material.WOOD_SWORD, Material.WOOD_SWORD);
		ReductionTable.put(Material.WOOD_SPADE, Material.WOOD_SPADE);
		//Stone tools/swords turn to wood.
		ReductionTable.put(Material.STONE_AXE, Material.WOOD_AXE);
		ReductionTable.put(Material.STONE_HOE, Material.WOOD_HOE);
		ReductionTable.put(Material.STONE_PICKAXE, Material.WOOD_PICKAXE);
		ReductionTable.put(Material.STONE_SWORD, Material.WOOD_SWORD);
		ReductionTable.put(Material.STONE_SPADE, Material.WOOD_SPADE);
		//iron stuff turns to leather or stone.
		
		ReductionTable.put(Material.IRON_AXE, Material.STONE_AXE);
		ReductionTable.put(Material.IRON_HOE, Material.STONE_HOE);
		ReductionTable.put(Material.IRON_PICKAXE, Material.STONE_PICKAXE);
		ReductionTable.put(Material.IRON_SWORD, Material.STONE_SWORD);
		ReductionTable.put(Material.IRON_HELMET, Material.LEATHER_HELMET);
		ReductionTable.put(Material.IRON_CHESTPLATE, Material.LEATHER_CHESTPLATE);
		ReductionTable.put(Material.IRON_LEGGINGS, Material.LEATHER_LEGGINGS);
		ReductionTable.put(Material.IRON_BOOTS, Material.LEATHER_BOOTS);
		
		//gold turns to iron.
		ReductionTable.put(Material.GOLD_AXE, Material.IRON_AXE);
		ReductionTable.put(Material.GOLD_HOE, Material.IRON_HOE);
		ReductionTable.put(Material.GOLD_PICKAXE, Material.IRON_PICKAXE);
		ReductionTable.put(Material.GOLD_SWORD, Material.IRON_SWORD);
		ReductionTable.put(Material.GOLD_HELMET, Material.IRON_HELMET);
		ReductionTable.put(Material.GOLD_CHESTPLATE, Material.IRON_CHESTPLATE);
		ReductionTable.put(Material.GOLD_LEGGINGS, Material.IRON_LEGGINGS);
		ReductionTable.put(Material.GOLD_BOOTS, Material.IRON_BOOTS);
		
		ReductionTable.put(Material.DIAMOND_AXE, Material.GOLD_AXE);
		ReductionTable.put(Material.DIAMOND_HOE, Material.GOLD_HOE);
		ReductionTable.put(Material.DIAMOND_PICKAXE, Material.GOLD_PICKAXE);
		ReductionTable.put(Material.DIAMOND_SWORD, Material.GOLD_SWORD);
		ReductionTable.put(Material.DIAMOND_HELMET, Material.GOLD_HELMET);
		ReductionTable.put(Material.DIAMOND_CHESTPLATE, Material.GOLD_CHESTPLATE);
		ReductionTable.put(Material.DIAMOND_LEGGINGS, Material.GOLD_LEGGINGS);
		ReductionTable.put(Material.DIAMOND_BOOTS, Material.GOLD_BOOTS);
		
		
	}
	private Material ReduceMaterialTier(Material source){
		
		
		Material result = ReductionTable.get(source);
		return result!=null?result:source;
		
		
	}
	private void reduceItemTier(ItemStack target){
		
		
		target.setType(ReduceMaterialTier(target.getType()));
		
		
		
		
	}
	private ItemStack SelectEquipmentItem(List<RandomData> ChooseFrom,int TargetValue){
		int maxtries = 10;
		List<ItemStack> AcquiredElements = new LinkedList<ItemStack>();
		for(int i=0;i<maxtries;i++){
			int genvalue=0;
			
			RandomData selected = RandomData.Choose(ChooseFrom);
			//generate from this..
			if(selected==null) continue; 
			System.out.println("Generated an item (weapon)");
			
			ItemStack generated = selected.Generate();
			AcquiredElements.add(generated);
			int generatedrating = getItemRating(generated);
			if(Math.abs(generatedrating-TargetValue)<5){
				
				return generated;
				
			}
			
			
		}
		ItemStack[] choosefrom = new ItemStack[AcquiredElements.size()];
		AcquiredElements.toArray(choosefrom);
		//choose a random item from the array of items we generated.
		ItemStack reduceit = RandomData.Choose(choosefrom);
		//reduce the teir first. If that works, return it.
		
		reduceItemTier(reduceit);
		if((getItemRating(reduceit)-TargetValue)<5){
			//yep! return it.
				return reduceit;
			}
		//first clamp all enchants to their enchantment limit.
		for(Enchantment getenchant:reduceit.getEnchantments().keySet()){
			if(reduceit.getEnchantmentLevel(getenchant)>new EnchantmentWrapper(getenchant.getId()).getMaxLevel()){
			//remove it..
				reduceit.removeEnchantment(getenchant);
				//add it at max level.
				reduceit.addEnchantment(getenchant, new EnchantmentWrapper(getenchant.getId()).getMaxLevel());
			}
		}
		//are we in the clear now?
		if((getItemRating(reduceit)-TargetValue)<5){
			//yep! return it.
				return reduceit;
			}
		if(RandomData.rgen.nextBoolean()){
			reduceItemTier(reduceit);
			if((getItemRating(reduceit)-TargetValue)<5){
				//yep! return it.
					return reduceit;
				}
		}
		
		
		
		//remove any enchants at level one on the item.
		for(Enchantment getenchant:reduceit.getEnchantments().keySet()){
			if(reduceit.getEnchantmentLevel(getenchant)==1)
				reduceit.removeEnchantment(getenchant);
		}
		
		
		
		
		//is this item now within the tolerance?
		if((getItemRating(reduceit)-TargetValue)<5){
		//yep! return it.
			return reduceit;
		}
		
		if(RandomData.rgen.nextBoolean()){
			reduceItemTier(reduceit);
			if((getItemRating(reduceit)-TargetValue)<5){
				//yep! return it.
					return reduceit;
				}
		}
		
		//otherwise, let's try halving all the remaining enchants.
		for(Enchantment getenchant:reduceit.getEnchantments().keySet()){
			int origlevel = reduceit.getEnchantmentLevel(getenchant);
			//remove the enchant...
			reduceit.removeEnchantment(getenchant);
			//and add at half the original level.
			reduceit.addEnchantment(getenchant,origlevel/2);
		}
		//are we in the clear NOW?
		if((getItemRating(reduceit)-TargetValue)<5){
			//yep! return it.
				return reduceit;
			}
		
			//if not... just return what we have so far.
			reduceItemTier(reduceit);
			return reduceit;
		
		
		
		
		
	}
	public void RandomizeEntity(LivingEntity le,int MobRating) {

		
		//give them a name. First get the name of the Mob.
		String mobdescription = getEntityDescription(le,false);
		String usemobname = NameGen.RandomMobName(mobdescription);
		//Random mob names are shown rarely. It seems to affect the fps...
		if(RandomData.rgen.nextFloat() > 0.95f)
		{
			//make sure we are 1.5
			try {
			le.setCustomName(usemobname);
			le.setCustomNameVisible(true);
			}
			catch(NoSuchMethodError ex){
			
			}
		}
		
		
		
		// Order is Weapon,Boots,Leggings,Chestplate,Helmet

		// Armor/weapons are only equipable by Zombies, Skeletons, and Pigmen.
		int maxtries = 10;
		if(le instanceof Skeleton || le instanceof Zombie){
			//get ratings of nearby players.
			int grabrating = getRating(le.getLocation());
			System.out.println("Attempting to equip entity with total score of " + grabrating);
			//divide it by 5, and use that value as the rating for the weapon to give the mob.
			int entryrating = Math.max(grabrating,1);
			
			//for each piece of equipment, use entryrating to try to generate a piece of equipment.
			//we try up to 10 times, if we cannot create a weapon/item that has a entry rating Within 5 of entryrating,
			//we give up and use a default.
			
			//first we do the weapon.
			List<RandomData> WeaponData = 
					le instanceof Skeleton?
							ItemRandomizer.getBowData(this): 
								ItemRandomizer.getWeaponsData(this);
			System.out.println("Weapons:" + WeaponData.size());
			ItemStack chosenweapon = SelectEquipmentItem(WeaponData,entryrating);
			if(chosenweapon!=null) le.getEquipment().setItemInHand(chosenweapon);
			//attempt to generate helmets, leggings, boots, and chestplates, too.
			
			List<RandomData> HelmetData = ItemRandomizer.getHelmetData(this);
			ItemStack chosenhelmet = SelectEquipmentItem(HelmetData,entryrating);
			if(chosenhelmet!=null) le.getEquipment().setHelmet(chosenhelmet);
			
			//attempt chestplate.
			List<RandomData> ChestplateData = ItemRandomizer.getChestplateData(this);
			ItemStack chosenchestplate = SelectEquipmentItem(ChestplateData,entryrating);
			if(chosenchestplate!=null) le.getEquipment().setChestplate(chosenchestplate);
			
			//attempt Leggings.
			
			List<RandomData> LeggingsData = ItemRandomizer.getLeggingsData(this);
			
			ItemStack chosenleggings = SelectEquipmentItem(LeggingsData,entryrating);
			if(chosenleggings!=null) le.getEquipment().setLeggings(chosenleggings);
			
			//attempt boots.
			List<RandomData> BootsData = ItemRandomizer.getBootsData(this);
			ItemStack chosenboots = SelectEquipmentItem(BootsData,entryrating);
			if(chosenboots!=null) le.getEquipment().setBoots(chosenboots);
			
			
			if(le.getCustomName()!=null){
				
				le.getEquipment().setItemInHandDropChance(1);
				le.getEquipment().setBootsDropChance(1);
				le.getEquipment().setChestplateDropChance(1);
				le.getEquipment().setHelmetDropChance(1);
				le.getEquipment().setLeggingsDropChance(1);
				
			}
			
			
			
		}
		
		

	}
	private int getItemRating(ItemStack generated) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
