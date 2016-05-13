package com.luledu.edumod;

import java.util.ArrayList;
import java.util.List;

import com.luledu.blocks.BlockBlack;
import com.luledu.items.ItemGrenade;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {

	public static Item grenade;
	
	public static List<Item> itemList = new ArrayList<Item>();
	
	public static void registerItems(){
		itemList.add(grenade=new ItemGrenade());
	
	}
	
}
