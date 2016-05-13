package com.luledu.edumod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabsMyMod extends CreativeTabs {

	public CreativeTabsMyMod(String tabLabel)
	{
	super(tabLabel);
	}


	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.bookblock);
	}

}
