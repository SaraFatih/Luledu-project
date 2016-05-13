package com.luledu.blocks;



import java.util.ArrayList;
import java.util.List;

//import com.sara.commands.printSuccess;








import tv.twitch.chat.ChatMessage;

import com.luledu.edumod.EduMod;
import com.luledu.edumod.ModItems;
import com.luledu.items.EntityGrenade;
import com.luledu.items.ItemGrenade;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLever;
import net.minecraft.block.material.Material;
//import net.minecraft.block.state.BlockState;
//import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandException;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
//import net.minecraft.util.BlockPos;
import net.minecraft.world.World;


public class BlockCheck extends Block{
	
	String name = "check";
	public static boolean answer;
	public BlockCheck() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":check");
		setBlockName("check");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe",2);
		setBlockUnbreakable();
		setBlockUnbreakable();
	}
	public String getName(){
		return name;
	}
	
	@Override
    public boolean onBlockActivated(World parWorld, int blockX, int blockY, int blockZ, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if(!parWorld.isRemote)
        {
			System.out.println("HELLO");
			List<Integer> firstArgument = new ArrayList<Integer>();
			List<Integer> secondArgument = new ArrayList<Integer>();
			List<Character> operators = new ArrayList<Character>();
			List<Integer> result = new ArrayList<Integer>();
			int correctResult=0;
			int operatorCounter=0;
			int i=1;
		
		Block currentBlock = parWorld.getBlock(blockX + i, blockY, blockZ);
		String currentBlockName = currentBlock.getLocalizedName();
		System.out.println(currentBlockName);
		
		while(!parWorld.isAirBlock(blockX + i, blockY, blockZ)){
			if(currentBlockName.equals("zero")){
				
				if(operatorCounter==0)
					firstArgument.add(0);
				else if(operatorCounter==1)
					secondArgument.add(0);
				else if(operatorCounter==2)
					result.add(0);
				i++;
				
			}
				
			else if(currentBlockName.equals("one")){

				if(operatorCounter==0)
					firstArgument.add(1);
				else if(operatorCounter==1)
					secondArgument.add(1);
				else if(operatorCounter==2)
					result.add(1);
				i++;
			}
				
			else if(currentBlockName.equals("two")){

				if(operatorCounter==0)
					firstArgument.add(2);
				else if(operatorCounter==1)
					secondArgument.add(2);
				else if(operatorCounter==2)
					result.add(2);
				i++;
			}
				
			else if(currentBlockName.equals("three")){

				if(operatorCounter==0)
					firstArgument.add(3);
				else if(operatorCounter==1)
					secondArgument.add(3);
				else if(operatorCounter==2)
					result.add(3);
				i++;
			}
				
			else if(currentBlockName.equals("four")){

				if(operatorCounter==0)
					firstArgument.add(4);
				else if(operatorCounter==1)
					secondArgument.add(4);
				else if(operatorCounter==2)
					result.add(4);
				i++;
			}
				
			else if(currentBlockName.equals("five")){

				if(operatorCounter==0)
					firstArgument.add(5);
				else if(operatorCounter==1)
					secondArgument.add(5);
				else if(operatorCounter==2)
					result.add(5);
				i++;
			}
				
			else if(currentBlockName.equals("six")){

				if(operatorCounter==0)
					firstArgument.add(6);
				else if(operatorCounter==1)
					secondArgument.add(6);
				else if(operatorCounter==2)
					result.add(6);
				i++;
			}
				
			else if(currentBlockName.equals("seven")){

				if(operatorCounter==0)
					firstArgument.add(7);
				else if(operatorCounter==1)
					secondArgument.add(7);
				else if(operatorCounter==2)
					result.add(7);
				i++;
			}
				
			else if(currentBlockName.equals("eight")){

				if(operatorCounter==0)
					firstArgument.add(8);
				else if(operatorCounter==1)
					secondArgument.add(8);
				else if(operatorCounter==2)
					result.add(8);
				i++;
			}
				
			else if(currentBlockName.equals("nine")){

				if(operatorCounter==0)
					firstArgument.add(9);
				else if(operatorCounter==1)
					secondArgument.add(9);
				else if(operatorCounter==2)
					result.add(9);
				i++;
			}
				
			else if(currentBlockName.equals("plus")){

				operators.add('+');
				operatorCounter++;
				i++;
			}
				
			else if(currentBlockName.equals("minus")){

				operators.add('-');
				operatorCounter++;
				i++;
			}
				
			else if(currentBlockName.equals("multi")){

				operators.add('*');
				operatorCounter++;
				i++;
			}
			
			else if(currentBlockName.equals("divide")){

				operators.add('/');
				operatorCounter++;
				i++;
			}
				
			else if(currentBlockName.equals("equal")){

				operators.add('=');
				operatorCounter++;
				i++;
			}
				
			else if(currentBlockName.equals("questionMark")){

				operators.add('?');
				i++;
			}
			currentBlock = parWorld.getBlock(blockX + i, blockY, blockZ);
			currentBlockName = currentBlock.getLocalizedName();
		} 
			
			int firstArgumentSize = firstArgument.size();
			int secondArgumentSize = secondArgument.size();
			int resultSize = result.size();
			
			if(firstArgumentSize==0 || secondArgumentSize==0 || resultSize==0 || operators.isEmpty()){
				return false;
			}
			
			int firstArgumentNumber=0;
			int secondArgumentNumber=0;
			int resultArgumentNumber=0;

			int z;
			int k;
			if(firstArgumentSize==1)
				firstArgumentNumber=firstArgument.get(0);
			else{
				z=firstArgumentSize-1;
				for(k=0;k<firstArgumentSize;k++){
					firstArgumentNumber = (int) (firstArgumentNumber + (firstArgument.get(k))*Math.pow(10,z));
					z--;
				}
			}
		
			
			if(secondArgumentSize==1)
				secondArgumentNumber=secondArgument.get(0);
			else{
				z=secondArgumentSize-1;
				for(k=0;k<secondArgumentSize;k++){
					secondArgumentNumber = (int) (secondArgumentNumber + (secondArgument.get(k))*Math.pow(10,z));
					z--;
				}
			}
		
			if(resultSize==1)
				resultArgumentNumber=result.get(0);
			else{
				z=resultSize-1;
				for(k=0;k<resultSize;k++){
					resultArgumentNumber = (int) (resultArgumentNumber + (result.get(k))*Math.pow(10,z));
					z--;
				}
			}
			
			
				if((operators.get(0))=='+')
					correctResult= firstArgumentNumber+secondArgumentNumber;
				
				else if ((operators.get(0))=='-')
					correctResult= firstArgumentNumber-secondArgumentNumber;
				
				else if ((operators.get(0))=='*')
					correctResult= firstArgumentNumber*secondArgumentNumber;
				
				else if ((operators.get(0))=='/')
					correctResult= firstArgumentNumber/secondArgumentNumber;
			
				if(resultArgumentNumber==correctResult){
					System.out.println("Correct answer");
					EduMod.playerScore+=5;
					player.addChatMessage(new ChatComponentText("Your new score is: "+EduMod.playerScore));
					player.inventory.addItemStackToInventory(new ItemStack(ModItems.itemList.get(0)));
					player.inventory.inventoryChanged= true;
					
					player.addChatMessage(new ChatComponentText("You unlocked the Grenade! Try it out in your inventory"));

				}
				else{
					System.out.println("wrong answer");
				
				}
	
	}
		return true;
	}

}
