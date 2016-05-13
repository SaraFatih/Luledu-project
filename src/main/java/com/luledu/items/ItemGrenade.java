package com.luledu.items;

import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends Item{

	public ItemGrenade(){
		this.setUnlocalizedName("grenade");
		this.setTextureName(EduMod.MODID+":grenade");
		this.setCreativeTab(CreativeTabs.tabCombat); //This Item will be in the Combat Creative Tab!
		GameRegistry.registerItem(this,this.getUnlocalizedName());
	}
	
	
	public boolean hasEffect(ItemStack par1ItemStack, int pass)
	{
	//This means it will look "special" in the inventory
	return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
    	if (!world.isRemote)
    	{
    	/* This method in World spawn in an entity,
    	* You can use with anything that extends
    	* the Entity class, in this case it's
    	* the EntityGrenade class
    	*/
    		world.spawnEntityInWorld(new EntityGrenade(world, player));
    	//Decrease an item from the stack because you just used it!
    	 --itemStack.stackSize;    }
		return itemStack;
    }
	
}
