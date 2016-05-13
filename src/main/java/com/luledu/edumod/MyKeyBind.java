package com.luledu.edumod;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.luledu.client.settings.KeyBindings;
import com.luledu.reference.Names;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class MyKeyBind {
	

		public static Object instance;

		public MyKeyBind(){}

		public void load(){
			FMLCommonHandler.instance().bus().register(new KeyHandlerClass());
		}

		public void generateNether(World world, Random random, int chunkX, int chunkZ){}
		public void generateSurface(World world, Random random, int chunkX, int chunkZ){}
		public void registerRenderers(){}
		public int addFuel(ItemStack fuel){
			return 0;
		}
		public void serverLoad(FMLServerStartingEvent event){}
		public void preInit(FMLInitializationEvent event){}

		public class KeyHandlerClass
		{
			/*
			private static final String desc = "key.tut_inventory.desc";
			private static final int keyValues = Keyboard.KEY_B ;
			private final KeyBinding mykeys;
			public KeyHandlerClass() {
				mykeys = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_N, Names.Keys.CATEGORY);
				ClientRegistry.registerKeyBinding(mykeys);
			}
	*/
			KeyBinding myKey = KeyBindings.makeGUI;
			
			@SubscribeEvent
			public void onKeyInput(InputEvent.KeyInputEvent event) {
				if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
					if (myKey.isPressed()) {
						EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
						int i = (int)entity.posX;
						int j = (int)entity.posY;
						int k = (int)entity.posZ;
						
						MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
						World world = server.worldServers[0];

		            	if(true){
		            		if(true){

		            			if(true){
		            				if(entity instanceof EntityPlayer)
		            					((EntityPlayer)entity).openGui(instance, AddAssignment.GUIID, world, i, j, k);
		            			}

		            		}
		            	}

					}
				}
			}
		}

		}

	
	
	
	
	
	
	
	
	
	
	

