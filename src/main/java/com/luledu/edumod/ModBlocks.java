package com.luledu.edumod;



import java.util.ArrayList;
import java.util.List;

import com.luledu.blocks.BlockBlack;
import com.luledu.blocks.BlockBook;
import com.luledu.blocks.BlockCheck;
import com.luledu.blocks.BlockDivide;
import com.luledu.blocks.BlockEight;
import com.luledu.blocks.BlockEqual;
import com.luledu.blocks.BlockFive;
import com.luledu.blocks.BlockFour;
import com.luledu.blocks.BlockMinus;
import com.luledu.blocks.BlockMulti;
import com.luledu.blocks.BlockNine;
import com.luledu.blocks.BlockOne;
import com.luledu.blocks.BlockPlus;
import com.luledu.blocks.BlockQuestionMark;
import com.luledu.blocks.BlockSeven;
import com.luledu.blocks.BlockSix;
import com.luledu.blocks.BlockThree;
import com.luledu.blocks.BlockTwo;
import com.luledu.blocks.BlockZero;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;

public class ModBlocks {
	
	public static Block blackblock;
	public static Block bookblock;
	public static Block checkblock;
	public static Block divideblock;
	public static Block eightblock;
	public static Block equalblock;
	public static Block fiveblock;
	public static Block fourblock;
	public static Block minusblock;
	public static Block multiblock;
	public static Block nineblock;
	public static Block oneblock;
	public static Block plusblock;
	public static Block questionMarkblock;
	public static Block sevenblock;
	public static Block sixblock;
	public static Block threeblock;
	public static Block twoblock;
	public static Block zeroblock;


	public static List<Block> blockList = new ArrayList<Block>();
	
	public static void registerBlocks(){
		blockList.add(blackblock=new BlockBlack());
		blockList.add(bookblock=new BlockBook());
		blockList.add(checkblock=new BlockCheck());
		blockList.add(divideblock=new BlockDivide());
		blockList.add(eightblock=new BlockEight());
		blockList.add(equalblock=new BlockEqual());
		blockList.add(fiveblock=new BlockFive());
		blockList.add(fourblock=new BlockFour());
		blockList.add(minusblock=new BlockMinus());
		blockList.add(multiblock=new BlockMulti());
		blockList.add(nineblock=new BlockNine());
		blockList.add(oneblock=new BlockOne());
		blockList.add(plusblock=new BlockPlus());
		blockList.add(questionMarkblock=new BlockQuestionMark());
		blockList.add(sevenblock=new BlockSeven());
		blockList.add(sixblock=new BlockSix());
		blockList.add(threeblock=new BlockThree());
		blockList.add(twoblock=new BlockTwo());
		blockList.add(zeroblock=new BlockZero());



		
	}
	
   
	
}
