package com.luledu.client.settings;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import com.luledu.edumod.AddAssignment;
import com.luledu.reference.Names;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyBindings {
	public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_B, Names.Keys.CATEGORY);
	public static KeyBinding makeGUI = new KeyBinding(Names.Keys.MAKEGUI, Keyboard.KEY_G, Names.Keys.CATEGORY);
	public static Object instance;
	/*
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			if (makeGUI.isPressed()) {
				EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
				int i = (int)entity.posX;
				int j = (int)entity.posY;
				int k = (int)entity.posZ;
				
				MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
				World world = server.worldServers[0];

            	if(true){
if(true){

if(true){
if(entity instanceof EntityPlayer)((EntityPlayer)entity).openGui(instance, AddAssignment.GUIID, world, i, j, k);
}

}
}

			}
		}
	}
	*/

}
