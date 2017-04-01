package me.ekits.main;
import java.util.ArrayList;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.ekits.abilities.Berserk;
import me.ekits.abilities.Fishhook;
import me.ekits.abilities.Heal;
import me.ekits.abilities.Hitteleport;
import me.ekits.abilities.Lava;
import me.ekits.abilities.Lightning;
import me.ekits.abilities.Poison;
import me.ekits.abilities.Randomteleport;
import me.ekits.abilities.Regen;
import me.ekits.abilities.Sneakattack;
import me.ekits.abilities.Speed;
import me.ekits.abilities.Stealth;
import me.ekits.abilities.Swap;
import me.ekits.abilities.Switch;
import me.ekits.abilities.Teleport;
import me.ekits.abilities.Water;
import me.ekits.abilities.Wolf;
import me.ekits.kits.Archer;
import me.ekits.kits.Assassin;
import me.ekits.kits.Chameleon;
import me.ekits.kits.Ender;
import me.ekits.kits.Fisherman;
import me.ekits.kits.Ghost;
import me.ekits.kits.LavaHound;
import me.ekits.kits.Lochness;
import me.ekits.kits.Medic;
import me.ekits.kits.Ninja;
import me.ekits.kits.Phantom;
import me.ekits.kits.Soldier;
import me.ekits.kits.Speedy;
import me.ekits.kits.Switcher;
import me.ekits.kits.Tamer;
import me.ekits.kits.Tank;
import me.ekits.kits.Thor;
import me.ekits.kits.Viper;
import me.ekits.listeners.PlayerListeners;

public class Main extends JavaPlugin{
	
	private static Main instance;
	
	public void log(String string){
		
		System.out.println(string);
	}
	public static Main getInstance(){
		return instance;
	}
    public ArrayList<String> kitused = new ArrayList<String>();
    public ArrayList<String> assassin = new ArrayList<String>();
    public ArrayList<String> thor = new ArrayList<String>();
    public ArrayList<String> ninja = new ArrayList<String>();
    public ArrayList<String> ninja2 = new ArrayList<String>();
    public ArrayList<String> assassin2 = new ArrayList<String>();
    public ArrayList<String> ender = new ArrayList<String>();
    public ArrayList<String> heal = new ArrayList<String>();
    public ArrayList<String> regen = new ArrayList<String>();
    public ArrayList<String> lava = new ArrayList<String>();
    public ArrayList<String> water = new ArrayList<String>();
    public ArrayList<String> wolf = new ArrayList<String>();
    public ArrayList<String> chameleon = new ArrayList<String>();
    public ArrayList<String> rteleport = new ArrayList<String>();
    public ArrayList<String> viper = new ArrayList<String>();
    public ArrayList<String> djump = new ArrayList<String>();
    public ArrayList<String> switcher = new ArrayList<String>();
    public ArrayList<String> hit = new ArrayList<String>();
    public ArrayList<String> phantom = new ArrayList<String>();
    public ArrayList<String> tamedwolf = new ArrayList<String>();

    
	public void registerListeners(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListeners(this), this);
		pm.registerEvents(new Teleport(this), this);
		pm.registerEvents(new Stealth(this), this);
		pm.registerEvents(new Speed(this), this);
		pm.registerEvents(new Berserk(this), this);
		pm.registerEvents(new Lightning(this), this);
		pm.registerEvents(new Heal(this), this);
		pm.registerEvents(new Swap(this), this);
		pm.registerEvents(new Lava(this), this);
		pm.registerEvents(new KitPicker(this), this);
		pm.registerEvents(new Water(this), this);
		pm.registerEvents(new Wolf(this), this);
		pm.registerEvents(new Regen(this), this);
		pm.registerEvents(new Sneakattack(this), this);
		pm.registerEvents(new Poison(this), this);
		pm.registerEvents(new Randomteleport(this), this);
		pm.registerEvents(new Fishhook(this), this);
		pm.registerEvents(new Switch(this), this);
		pm.registerEvents(new Hitteleport(this), this);
		pm.registerEvents(new Speedy(this), this);
	}

	public void registerCommands(){
		this.getCommand("soldier").setExecutor(new Soldier(this));
		this.getCommand("ender").setExecutor(new Ender(this));
		this.getCommand("ghost").setExecutor(new Ghost(this));
		this.getCommand("ninja").setExecutor(new Ninja(this));
		this.getCommand("assassin").setExecutor(new Assassin(this));
		this.getCommand("thor").setExecutor(new Thor(this));
		this.getCommand("medic").setExecutor(new Medic(this));
		this.getCommand("lavahound").setExecutor(new LavaHound(this));
		this.getCommand("lochness").setExecutor(new Lochness(this));
		this.getCommand("tank").setExecutor(new Tank(this));
		this.getCommand("tamer").setExecutor(new Tamer(this));
		this.getCommand("chameleon").setExecutor(new Chameleon(this));
		this.getCommand("viper").setExecutor(new Viper(this));
		this.getCommand("fisherman").setExecutor(new Fisherman(this));
		this.getCommand("switcher").setExecutor(new Switcher(this));
		this.getCommand("phantom").setExecutor(new Phantom(this));
		this.getCommand("archer").setExecutor(new Archer(this));
	}
	//When plugin is enabled!
	@Override
	public void onEnable(){
		getLogger().info("has been enabled!");
		instance = this;
		registerListeners();
		registerCommands();
	}
	//When plugin is disabled
	@Override
	public void onDisable(){
		getLogger().info("has been disabled");
		instance = null;
	}
}
