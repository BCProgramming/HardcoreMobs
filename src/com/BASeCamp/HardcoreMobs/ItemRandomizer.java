package com.BASeCamp.HardcoreMobs;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.BrewingStand;
import org.bukkit.block.Chest;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class ItemRandomizer {

	private HardcoreMobs _owner = null;
	private Chest mchest;
	private Inventory mInventory;
	private int _MinItems = 1;
	private int _MaxItems = 10;

	public int getMinItems() {
		return _MinItems;
	}

	public void setMinItems(int value) {
		_MinItems = value;
	}

	public int getMaxItems() {
		return _MaxItems;
	}

	public void setMaxItems(int value) {
		_MaxItems = value;
	}

	private static LinkedList<RandomData> randData = null;
	private static LinkedList<RandomData> addall = null; // items that will
															// always be added
															// once.
	private String _SourceFile = "";

	
	public static LinkedList<RandomData> getRandomData() { return randData;}
	public static LinkedList<RandomData> getStaticData() { return addall;}
	
	public static LinkedList<RandomData> getRandomData(HardcoreMobs owner) {
		if (randData == null)
			reload(owner,null);
		return randData;

	}
	
	public static List<RandomData> getHelmetData(HardcoreMobs _owner) {

		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return HelmetFilter(rd);

					}

				});

	}

	public static List<RandomData> getChestplateData(HardcoreMobs _owner) {

		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return ChestplateFilter(rd);

					}

				});

	}

	public static List<RandomData> getLeggingsData(HardcoreMobs _owner) {

		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return LeggingsFilter(rd);

					}

				});

	}
	public static List<RandomData> getPotionData(HardcoreMobs _owner) {
		return Filters.filterList(ItemRandomizer.getRandomData(_owner)
				,new IFilterPredicate<RandomData>(){
			
			public boolean predicate(RandomData rd){
				return PotionFilter(rd);
			}
		});
		
		
		
	}
	public static List<RandomData> getBootsData(HardcoreMobs _owner) {

		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return BootsFilter(rd);

					}

				});

	}
	public static List<RandomData> getBowData(HardcoreMobs _owner) {
		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return BowFilter(rd);

					}

				});
	}
	
	public static List<RandomData> getWeaponsData(HardcoreMobs _owner) {

		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return WeaponsFilter(rd);

					}

				});

	}
	public static List<RandomData> getProjectileData(HardcoreMobs _owner) {
		return Filters.filterList(ItemRandomizer.getRandomData(_owner),
				new IFilterPredicate<RandomData>() {

					public boolean predicate(RandomData rd) {
						// filter out helmets.
						return ProjectileFilter(rd);

					}

				});
		
		
		
	}
	private static boolean HelmetFilter(RandomData testdata) {

		// only return true for RandomData's that are head-equippable.
		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		//System.out.println(m.toString());
		return m.equals(Material.LEATHER_HELMET)
				|| m.equals(Material.CHAINMAIL_HELMET)
				|| m.equals(Material.IRON_HELMET)
				|| m.equals(Material.GOLD_HELMET)
				|| m.equals(Material.DIAMOND_HELMET) ||
				m.equals(Material.SKULL_ITEM);

	}

	private static boolean ChestplateFilter(RandomData testdata) {

		// only return true for RandomData's that are chest-plate equippable.
		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		//System.out.println(m.toString());
		return m.equals(Material.LEATHER_CHESTPLATE)
				|| m.equals(Material.CHAINMAIL_CHESTPLATE)
				|| m.equals(Material.IRON_CHESTPLATE)
				|| m.equals(Material.GOLD_CHESTPLATE)
				|| m.equals(Material.DIAMOND_CHESTPLATE);

	}
	
	private static boolean LeggingsFilter(RandomData testdata) {

		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		//System.out.println(m.toString());
		return m.equals(Material.LEATHER_LEGGINGS)
				|| m.equals(Material.CHAINMAIL_LEGGINGS)
				|| m.equals(Material.IRON_LEGGINGS)
				|| m.equals(Material.GOLD_LEGGINGS)
				|| m.equals(Material.DIAMOND_LEGGINGS);

	}
	private static boolean PotionFilter(RandomData testdata){
	if(testdata==null) return false;
	Material m = testdata.getItemMaterial();
	if(m==null) return false;
	return m.equals(Material.POTION);
		
	}
	private static boolean BootsFilter(RandomData testdata) {
		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		//System.out.println(m.toString());
		return m.equals(Material.LEATHER_BOOTS)
				|| m.equals(Material.CHAINMAIL_BOOTS)
				|| m.equals(Material.IRON_BOOTS)
				|| m.equals(Material.GOLD_BOOTS)
				|| m.equals(Material.DIAMOND_BOOTS);

	}
	private static boolean ProjectileFilter(RandomData testdata)
	{
		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		
		if(m.equals(Material.POTION)){
			return testdata.getMinCount()>0;
			
			
			
		}
		
		return m.equals(Material.ARROW) || m.equals(Material.FIREBALL) || m.equals(Material.FIREWORK) ||
				m.equals(Material.ENDER_PEARL);
		//Ender pearl is a bit of a toss-up...
		
		
		
		
	}
	private static boolean BowFilter(RandomData testdata) {
		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		//System.out.println(m.toString());
		return m.equals(Material.BOW);
	}
	private static boolean WeaponsFilter(RandomData testdata) {

		if(testdata==null) return false;
		Material m = testdata.getItemMaterial();
		if(m==null) return false;
		//System.out.println(m.toString());
		return m.equals(Material.WOOD_SWORD) || m.equals(Material.IRON_SWORD)
				|| m.equals(Material.GOLD_SWORD) || m.equals(Material.DIAMOND_SWORD)
				|| m.equals(Material.DIAMOND_SWORD) || m.equals(Material.SIGN)
				|| m.equals(Material.SHEARS);

	}
	public ItemRandomizer(){
		
	}
	
	public ItemRandomizer(HardcoreMobs owner, String pURL) {
		_owner = owner;
		

		String buildpath = HardcoreMobs.pluginMainDir;
		if (!buildpath.endsWith("\\"))
			buildpath = buildpath + "\\";
		File gotfile = new File(buildpath + pURL);
		if (gotfile != null && gotfile.exists()) {
			pURL = gotfile.getAbsolutePath();

		}

		
		if (randData == null) {
			_SourceFile = pURL;
			reload(owner,_SourceFile);

		}
	}
	
	
	public static void reload(HardcoreMobs owner,String Source) {
		
		
		
		//System.out.println("ChestRandomizer::reload()");
		//Thread.dumpStack();
		
		randData = new LinkedList<RandomData>();
		addall = new LinkedList<RandomData>();

		// Scanner sc=null;
		Scanner sc = owner.acquireStream("hardcoremobs.cfg");
		/*
		 * try {
		 * 
		 * if(_SourceFile!=""){
		 * 
		 * sc = new Scanner(new URL(_SourceFile).openStream());
		 * 
		 * } else if(new File(BCRandomizer.pluginMainDir).exists() && new
		 * File(BCRandomizer.pluginConfigLocation).exists()){ //read each line.
		 * sc = new Scanner(new File(BCRandomizer.pluginConfigLocation)); } }
		 * catch(Exception exx){sc=null;}
		 */
		if (sc == null) {
			// Bukkit.getLogger().log(Level.WARNING,
			// "Warning: Config/List file not found at " +
			// BCRandomizer.pluginConfigLocation + " using built in.");
			// sc = new
			// Scanner(getClass().getClassLoader().getResourceAsStream("survivalchests.cfg"));
		}

		while (sc.hasNextLine()) {
			String lineread = sc.nextLine();
			if (!(lineread.startsWith("//") || lineread.trim().length() == 0)) {
				if (lineread.startsWith("STATIC:")) {
					lineread = lineread.substring(7);
					RandomData staticdata = new RandomData(lineread);
					if(staticdata!=null)
						addall.add(staticdata);
					else
						System.out.println("Error from line:" + lineread);
				} else {

					RandomData gendata = new RandomData(lineread);
					if(gendata!=null)
						randData.add(gendata);
					else
						System.out.println("Error from line" + lineread);
					gendata.getEnchantmentInformation().preCache();
				}
			}

		}

		System.out.println("Read in " + randData.size() + " elements");

	}
	/*
	public void clear() {

		Inventory gotinventory = mchest.getBlockInventory();
		// OK, loop the appropriate number of times, choose a randomData and
		// generate it.
		gotinventory.clear();

	}

	private Integer[] emptyslots(Inventory inv) {
		Integer[] createit = new Integer[inv.getSize()];
		int currempty = 0;
		for (int i = 0; i < inv.getSize(); i++) {
			if (inv.getItem(i) == null || inv.getItem(i).getTypeId() == 0)
				createit[currempty] = new Integer(i);
			currempty++;

		}
		return createit;

	}

	private static HashMap<Chest, ItemStack[]> StoredInventories = new HashMap<Chest, ItemStack[]>();

	public static void resetStorage() {

		StoredInventories = new HashMap<Chest, ItemStack[]>();

	}

	public static void resetStoredInventories() {

		System.out.println("Resetting inventories on "
				+ StoredInventories.size() + " Items.");

		for (Chest iterate : StoredInventories.keySet()) {

			// iterate.getInventory().clear();
			ItemStack[] gotcontents = StoredInventories.get(iterate);
			iterate.getInventory().setContents(gotcontents);

		}

	}

	public static void StoreInventory(Chest cheststore) {
		//System.out.println("Storing inventory...");
		ItemStack[] copythis = cheststore.getBlockInventory().getContents();
		ItemStack[] copied = new ItemStack[copythis.length];
		int itemcount = 0;
		for (int i = 0; i < copythis.length; i++) {
			if (copythis[i] != null) {
				copied[i] = copythis[i].clone();
				itemcount++;
			}
		}
		System.out.println("Stored " + itemcount + " items.");
		StoredInventories.put(cheststore, copied);

	}

	public int Shuffle() {
		boolean PackedChest = false;
		// if the block beneath the chest is wool, break out. We don't randomize
		// chests with wool underneath.
		if (mchest != null) {
			
			Location chestspot = mchest.getLocation();
			Location spotbelow = new Location(mchest.getWorld(), chestspot
					.getX(), chestspot.getY() - 1, chestspot.getZ());
			if (mchest.getWorld().getBlockAt(spotbelow).getType() == _owner.Configuration.getContainerStatic()) {

				return 0;
			} else if (mchest.getWorld().getBlockAt(spotbelow).getType() == _owner.Configuration.getContainerPacked())
				PackedChest = true;
		}
		
		// select a random number of items.
		//System.out.println("Randomizing chest...");
		if (_owner != null) {
			try {
				FileConfiguration fc = _owner.getConfig();
				_MaxItems = Integer.parseInt(fc.getString("maxgen"));
				_MinItems = Integer.parseInt(fc.getString("mingen"));
			} catch (NumberFormatException nfe) {

			}
		}

		int _numgenerate = 0;
		if (_MaxItems == _MinItems)
			_numgenerate = _MaxItems;
		else
			_numgenerate = RandomData.rgen.nextInt(_MaxItems - _MinItems)
					+ _MinItems;
		if (PackedChest)
			_numgenerate = mInventory.getSize();

		Inventory gotinventory = mInventory;
		// OK, loop the appropriate number of times, choose a randomData and
		// generate it.
		gotinventory.clear();
		String holidayName="";
		if(mchest!=null && !PackedChest && (null!=(holidayName=BCRandomizer.getHoliday(new Date())))){
			ItemStack fireworkitem = RandomData.createRandomFireworkItem(16);
			fireworkitem = ItemNamer.renameItem(fireworkitem, holidayName);
			mchest.getInventory().addItem(fireworkitem);
		}
		//	
		
		
		// BCRandomizer.emitmessage("Minitems:" + _MinItems + "MaxItems " +
		// _MaxItems + "Gen:" + _numgenerate);
		List<RandomData> fromlist = randData;
		if(bstand!=null) fromlist = getPotionData(_owner);
		for (int i = 1; i < _numgenerate; i++) {
			
			RandomData rdata;
			
			
			
			rdata = RandomData.ChooseRandomData(fromlist);
			if (rdata != null) {
				
				ItemStack created = rdata.Generate();
				if(created==null) {
					
					//System.out.println("generated item is null. ID=" + rdata.getItemID());
					//Bukkit.broadcastMessage(BCRandomizer.Prefix + " Error in configuration. (ID=" + rdata.getItemID() + " Name=" + rdata.getName());
					continue;
				}
				
				BCRandomizer.emitmessage("Data:" + created.getData().getData());
				if (created != null) {
					
					ItemPopulateEvent populated = new ItemPopulateEvent(created,gotinventory);
					Bukkit.getPluginManager().callEvent(populated);
					
					if(created.getType()==Material.ENCHANTED_BOOK){
					//System.out.println("Enchanted Book...");
					}
					
					// get all empty slots.
					Integer[] empties = emptyslots(gotinventory);
					
					Integer selectedslot = RandomData.Choose(empties);
					if (selectedslot != null) {
						gotinventory.setItem(selectedslot, created);
					} else {
						try {
							gotinventory.addItem(created);
						} catch (NullPointerException ex) {
							BCRandomizer.emitmessage("Created==null:"
									+ (created == null)
									+ (!(created == null) ? created.getTypeId()
											: ""));
							ex.printStackTrace();
							return 0;
						}
					}

				}
			}

		}
		return gotinventory.getContents().length;

	}*/
}
