package com.gmail.giorgioproductions;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Principal extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§aEl plugin Giorgio ha sido activado correctamente");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§4Deshabilitando plugin Giorgio");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("vida")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player)sender;
				p.setMaxHealth(100);
				p.setHealth(100);
				p.setFoodLevel(20);
				p.sendMessage("§aAhora tienes 50 corazones");
				
			} else {
				sender.sendMessage("§4Este comando no se puede ejecutar desde la consola");
			}
			
			return true;
			
		}
		
		if(cmd.getName().equalsIgnoreCase("craft")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player)sender;
				p.openWorkbench(null, true);
				p.sendMessage("§aMesa de crafteo abierta");
				
			} else {
				sender.sendMessage("§4Este comando no se puede ejecutar desde la consola");
			}
			
			return true;
			
		}
		
if(cmd.getName().equalsIgnoreCase("vidanormal")) {
			
			if(sender instanceof Player) {
				
				Player p = (Player)sender;
				p.setMaxHealth(20);
				p.sendMessage("§aAhora tienes 20 corazones");
				
			} else {
				sender.sendMessage("§4Este comando no se puede ejecutar desde la consola");
			}
			
			return true;
			
		}
		
		return false;
		
	}
	
	@EventHandler
	public void alDropear(PlayerDropItemEvent e) {
		
		if(e.getPlayer().hasPermission("giorgio.drop")) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§4No tienes permiso para dropear items");
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.VILLAGER_NO, 1, 1);
		}
		
	}
	
	@EventHandler
	public void abrirInventario(PlayerDropItemEvent e) {
		
		if(e.getPlayer().hasPermission("giorgio.inventory")) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§4No tienes permiso para abrir el inventario");
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.VILLAGER_NO, 1, 1);
		}
		
	}
	
	@EventHandler
	public void alEntrar(PlayerJoinEvent e) {
		
		e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 1, 1);
		
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		Bukkit.broadcastMessage("§5" + p.getName() + " §aha entrado al servidor");
		p.sendMessage("§7Bienvenido al servidor §5Yurii§7.\n§7Esperamos que disfrutes de tu estancia.");
		
	}
	
	@EventHandler
	public void alSalir(PlayerQuitEvent e) {
		
		Player p = e.getPlayer();
		e.setQuitMessage(null);
		Bukkit.broadcastMessage("§5" + p.getName() + " §4ha salido del servidor");
		
	}
}

//ladani
