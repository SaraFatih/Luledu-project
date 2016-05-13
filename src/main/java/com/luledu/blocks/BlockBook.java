package com.luledu.blocks;



import com.luledu.edumod.AddAssignment;
import com.luledu.edumod.EduMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
//import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.world.World;

public class BlockBook extends Block{

	String name = "assignBook";
	public static String assignment;
	public BlockBook() {
		super(Material.wood);
		
		GameRegistry.registerBlock(this, name);
		setBlockTextureName(EduMod.MODID+":assignBook");
		setBlockName("assignBook");
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
	

	

	
	@Override
    public boolean onBlockActivated(World parWorld, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if (!parWorld.isRemote)
	    {
			System.out.println("DONE");
	        //EduMod.proxy.openMyGui(); 
	       
	    }
	        
	    return true;
		
		
	}

}
