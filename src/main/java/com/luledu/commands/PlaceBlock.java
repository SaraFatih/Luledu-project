package com.luledu.commands;

import com.luledu.edumod.AddAssignment;
import com.luledu.edumod.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class PlaceBlock extends CommandBase{

	@Override
	public String getCommandName() {
		return "placeBlock";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/placeBlock";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) sender;
			World world = player.getEntityWorld();
			int x = (int) player.getLookVec().xCoord;
			int y = (int) player.getLookVec().yCoord;
			int z = (int) player.getLookVec().zCoord;
			int i;
			int countX=0;
			for(i=0;i<args.length;i++){
				
				if(!(args[i]==null)){
					
					if(args[i].equals("0")){
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y + AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.zeroblock);
					    countX++;

					}
						
					else if (args[i].equals("1")){
				
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.oneblock);
					    countX++;

					}
					else if(args[i].equals("2")){
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.twoblock);
					    countX++;

					}
					else if(args[i].equals("3")){	
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.threeblock);
					    countX++;

					}
					else if(args[i].equals("4")){	
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.fourblock);
					    countX++;

					}	
					else if(args[i].equals("5")){
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.fiveblock);
					    countX++;

					}
					else if(args[i].equals("6")){
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.sixblock);
					    countX++;

					}
					else if(args[i].equals("7")){
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.sevenblock);
					    countX++;

					}	
					else if(args[i].equals("8")){
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.eightblock);
					    countX++;

					}
					else if(args[i].equals("9")){
				
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.nineblock);
					    countX++;

					}
					else if(args[i].equals("+")){	
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.plusblock);
					    countX++;

					}
					
					else if(args[i].equals("-")){
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.minusblock);
					    countX++;

					}
					else if(args[i].equals("*")){
				
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.multiblock);
					    countX++;

					}
					else if(args[i].equals("/")){
					
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.divideblock);
					    countX++;

					}
					else if(args[i].equals("=")){
				
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.equalblock);
					    countX++;

					}
					else if(args[i].equals("?")){
				
					    world.setBlock(((int) player.posX )+ x + countX, ((int)player.posY) + y+ AddAssignment.countY, ((int) player.posZ) + z , ModBlocks.questionMarkblock);
					    countX++;

					}
					//else	
						//xOffset--;	
				
				}
				
			
			}
		}
	}

}
