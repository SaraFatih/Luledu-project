package com.luledu.blocks;

import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraftforge.fml.common.registry.GameRegistry;

//import com.sara.myMod.MyMod;

public class BlockNine extends Block{
String name = "nine";
	
	public BlockNine() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":nine");
		setBlockName("nine");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setResistance(5F);
		setStepSound(soundTypeStone);
		setHarvestLevel("pickaxe",2);
		setBlockUnbreakable();
	}
	
	public String getName(){
		return name;
	}

}
