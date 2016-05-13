package com.luledu.edumod;


import java.util.Random;

import com.luledu.blocks.FirstBookBlock;
import com.luledu.blocks.TileEntityVisitor;
import com.luledu.client.gui.BookGui;
import com.luledu.commands.PlaceBlock;
import com.luledu.commands.ReadText;
import com.luledu.items.EntityGrenade;
import com.luledu.items.ItemGrenade;
import com.luledu.proxy.CommonProxy;
import com.luledu.proxy.IProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.achievement.GuiAchievement;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.GuiConfirmation;
import cpw.mods.fml.client.GuiNotification;
import cpw.mods.fml.client.GuiScrollingList;
import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.client.config.GuiCheckBox;
import cpw.mods.fml.client.config.GuiMessageDialog;
import cpw.mods.fml.client.config.GuiSelectString;
import cpw.mods.fml.client.config.GuiSlider;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;


@Mod(modid = EduMod.MODID, name="eduMod", version = EduMod.VERSION)
public class EduMod implements IFuelHandler, IWorldGenerator{
	public static final String MODID = "edumod";
    public static final String VERSION = "1.0";
 

    @SidedProxy(clientSide = "com.luledu.proxy.ClientProxy", serverSide = "com.luledu.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @Instance(MODID)
    public static EduMod instance;
   
    public static FirstBookBlock bookBlock;
    int blockID=200;
    
   EduModEventHandler events = new EduModEventHandler();
    
    public static AddAssignment addAssignmentGUI = new AddAssignment();
    public MyKeyBind myKeyBind = new MyKeyBind();
    
   public static int playerScore;
  
    @Override
    public int getBurnTime(ItemStack fuel) {
    	if(addAssignmentGUI.addFuel(fuel)!=0) return addAssignmentGUI.addFuel(fuel);
    	if(myKeyBind.addFuel(fuel)!=0) return myKeyBind.addFuel(fuel);
    	return 0;
    }
    
    @Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    	chunkX = chunkX * 16;
    	chunkZ = chunkZ * 16;
    	if(world.provider.dimensionId==-1)addAssignmentGUI.generateNether(world, random, chunkX, chunkZ);
    	if(world.provider.dimensionId==0)addAssignmentGUI.generateSurface(world, random, chunkX, chunkZ);
    	if(world.provider.dimensionId==-1)myKeyBind.generateNether(world, random, chunkX, chunkZ);
    	if(world.provider.dimensionId==0)myKeyBind.generateSurface(world, random, chunkX, chunkZ);
		
	}
    
    @EventHandler
    public void load(FMLInitializationEvent event) {

    	GameRegistry.registerFuelHandler(this);
    	GameRegistry.registerWorldGenerator(this, 1);
    	MinecraftForge.EVENT_BUS.register(new EduModEventHandler());
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	addAssignmentGUI.load();
    	myKeyBind.load();
    	bookBlock = new FirstBookBlock(blockID);
    	
    	GameRegistry.registerTileEntity(TileEntityVisitor.class, "eduMod");
		
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event){
    	addAssignmentGUI.serverLoad(event);
    	myKeyBind.serverLoad(event);
    }

    public static CreativeTabs tabMyMod = new CreativeTabsMyMod("MyMod");
    
    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
    	ModBlocks.registerBlocks();
    	addAssignmentGUI.instance = this.instance;
    	myKeyBind.instance = this.instance;
    	addAssignmentGUI.preInit(event);
    	myKeyBind.preInit(event);
    	
    	proxy.registerKeyBindings();
    	proxy.registerRenderers(this);
    	
    	FMLCommonHandler.instance().bus().register(events);
    	MinecraftForge.EVENT_BUS.register(events);
    	
    }
    
    public static class GuiHandler implements IGuiHandler {
    	
		@Override
		public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			if(ID == AddAssignment.GUIID) return new AddAssignment.GuiContainerMod(world, x, y, z, player);
			return null;
		}
		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			if(ID == AddAssignment.GUIID) return new AddAssignment.GuiWindow(world, x, y, z, player);
			return null;
		}
    	}
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ModItems.registerItems();

		EntityRegistry.registerModEntity(EntityGrenade.class, "Grenade", 4, this, 80, 3, true);
		proxy.registerRendererThings();

    }
    
    @EventHandler
    public void postInit(FMLInitializationEvent event)
    {
    	
    	if(event.getSide() == Side.CLIENT){
    		
    		
    	}
    	
    }
 // New commands
    @EventHandler
    public void registerCommands(FMLServerStartingEvent event){
    	
    	ServerCommandManager manager = (ServerCommandManager) event.getServer().getCommandManager();
    	manager.registerCommand(new PlaceBlock());
    	manager.registerCommand(new ReadText());

    	

    }


	



}




