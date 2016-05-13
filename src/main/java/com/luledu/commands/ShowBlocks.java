package com.luledu.commands;



import com.luledu.edumod.ModBlocks;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ShowBlocks extends CommandBase{

	@Override
	public String getCommandName() {
		return "show";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/show <number>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		ReadFromFile read = new ReadFromFile();
		int counter = read.getCounter();
		if(sender instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) sender;
			World world = player.getEntityWorld();
			double x = player.getLookVec().xCoord;
			double y = player.getLookVec().yCoord;
			double z = player.getLookVec().zCoord;
			if(args.length ==0){
				sender.addChatMessage(new ChatComponentText("Invalid arguments"));
			}
			else{
				//BlockPos startPosition =  new BlockPos(player.posX  + x * 2 - 2,  player.posY + counter, player.posZ + z );
				int i, xOffset = 1;
				
				for(i=0;i<args.length;i++){
					//BlockPos blockpos = startPosition.offset(EnumFacing.EAST, xOffset);
					System.out.println(args[i]);
					if(!(args[i]==null)){
						xOffset++;
					
						if(args[i].equals("0")){
							//world.setBlockState(blockpos, ModBlocks.zeroblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 0 added to your game"));
						}
							
						else if (args[i].equals("1")){
					
							//world.setBlockState(blockpos, ModBlocks.oneblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 1 added to your game"));
						}
						else if(args[i].equals("2")){
						
							//world.setBlockState(blockpos, ModBlocks.twoblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 2 added to your game"));
						}
						else if(args[i].equals("3")){	
							//world.setBlockState(blockpos, ModBlocks.threeblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 3 added to your game"));
						}
						else if(args[i].equals("4")){	
						
							//world.setBlockState(blockpos, ModBlocks.fourblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 4 added to your game"));
						}	
						else if(args[i].equals("5")){
						
							//world.setBlockState(blockpos, ModBlocks.fiveblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 5 added to your game"));
						}
						else if(args[i].equals("6")){
						
							//world.setBlockState(blockpos, ModBlocks.sixblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 6 added to your game"));
						}
						else if(args[i].equals("7")){
						
							//world.setBlockState(blockpos, ModBlocks.sevenblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 7 added to your game"));
						}	
						else if(args[i].equals("8")){
						
							//world.setBlockState(blockpos, ModBlocks.eightblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 8 added to your game"));
						}
						else if(args[i].equals("9")){
					
							//world.setBlockState(blockpos, ModBlocks.nineblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block 9 added to your game"));
						}
						else if(args[i].equals("+")){	
						
							//world.setBlockState(blockpos, ModBlocks.plusblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block + added to your game"));
						}
						
						else if(args[i].equals("-")){
							//world.setBlockState(blockpos, ModBlocks.minusblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block - added to your game"));
						}
						else if(args[i].equals("*")){
					
							//world.setBlockState(blockpos, ModBlocks.multiblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block x added to your game"));
						}
						else if(args[i].equals("/")){
						
							//world.setBlockState(blockpos, ModBlocks.divideblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block / added to your game"));
						}
						else if(args[i].equals("=")){
					
							//world.setBlockState(blockpos, ModBlocks.equalblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block = added to your game"));
						}
						else if(args[i].equals("?")){
					
							//world.setBlockState(blockpos, ModBlocks.questionMarkblock.getDefaultState());
							sender.addChatMessage(new ChatComponentText("Block ? added to your game"));
						}
						else	
							xOffset--;	
					
					}
					
					if (xOffset > 1) {
						//world.setBlockState(startPosition, ModBlocks.checkblock.getDefaultState());
						
						
						
						

						
					}
					
				}
				
			}
			
				
		}
		
		
		
		
		
		
		
	}

}
