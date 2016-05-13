package com.luledu.edumod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.luledu.blocks.BlockBook;
import com.luledu.blocks.TileEntityVisitor;
import com.luledu.client.gui.BookGui;
import com.luledu.commands.PlaceBlock;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SuppressWarnings("unchecked")
public class AddAssignment {
	
	private static final String USER_AGENT = "Mozilla/5.0";
	public static Object instance;
	public static int countY;
	public static int GUIID = 4;
	
	public static StringBuffer otherresponse = new StringBuffer();

	public AddAssignment(){
		
	}
	

	public void load(){
		
	}

	public void registerRenderers(){}
	public void generateNether(World world, Random random, int chunkX, int chunkZ){}
	public void generateSurface(World world, Random random, int chunkX, int chunkZ){}
	public int addFuel(ItemStack fuel){
		return 0;
	}
	public void serverLoad(FMLServerStartingEvent event){}
	public void preInit(FMLInitializationEvent event){}


	public static IInventory inherited;

	public static class GuiContainerMod extends Container {
			
			World world = null;
			EntityPlayer entity = null;
			int i,j,k;
			
	        public GuiContainerMod (World world, int i, int j, int k, EntityPlayer player){
				
				this.world = world;
				this.entity = player;
				this.i = i;
				this.j = j;
				this.k = k;
				
	        }
	 
	        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
				int i;
	        	int j;
			
	        	for (i = 0; i < 3; ++i){
					for (j = 0; j < 9; ++j){
						this.addSlotToContainer(new Slot(inventoryPlayer, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
					}
	        	}

	        	for (i = 0; i < 9; ++i){
					this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
	        	}
	        }

	        @Override
	        public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(index);

	        if (slot != null && slot.getHasStack()){
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (index < 9){
	                if (!this.mergeItemStack(itemstack1, 9, (45-9), true)){//fixes shiftclick error
	                    return null;
	                }
	            }else if (!this.mergeItemStack(itemstack1, 0, 9, false)){
	                return null;
	            }

	            if (itemstack1.stackSize == 0){
	                slot.putStack((ItemStack)null);
	            }else{
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize){
	                return null;
	            }

	            slot.onPickupFromSlot(playerIn, itemstack1);
	        }

	        return itemstack;
	    }
		
		public void onContainerClosed(EntityPlayer playerIn)
	    {
	        super.onContainerClosed(playerIn);
	        
	    }

		@Override
		public boolean canInteractWith(EntityPlayer p_75145_1_) {
			return true;
		}
	}

	public static class GuiWindow extends GuiContainer
	{

		int i = 0;
		int j = 0;
		int k = 0;
		EntityPlayer entity = null;
	
		GuiTextField assignmentType;
		GuiTextField assignmentURL;
		
		String GuiAssignmentText;

		public GuiWindow(World world, int i, int j, int k, EntityPlayer entity){
			super(new GuiContainerMod(world, i, j, k, entity));
			this.i = i;
			this.j = j;
			this.k = k;
			this.entity = entity;
			this.xSize=244;
			this.ySize=166;
		}

		private static final ResourceLocation texture = new ResourceLocation(EduMod.MODID+":textures/gui/addAssignment.png");

		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3){
			int posX = (this.width) /2;
			int posY = (this.height) /2;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
			zLevel = 100.0F;
		}

		protected void mouseClicked(int par1, int par2, int par3){
			this.assignmentURL.mouseClicked(par1 - this.guiLeft, par2 - this.guiTop, par3);
			this.assignmentType.mouseClicked(par1 - this.guiLeft, par2 - this.guiTop, par3);
			super.mouseClicked(par1, par2, par3);
		}

		public void updateScreen(){
			int posX = (this.width) /2;
			int posY = (this.height) /2;
			this.assignmentURL.updateCursorCounter();
			this.assignmentType.updateCursorCounter();
			
		}

		protected void keyTyped(char par1, int par2){
			
			if (this.assignmentType.isFocused())
				this.assignmentType.textboxKeyTyped(par1, par2);
			if (this.assignmentURL.isFocused())
				this.assignmentURL.textboxKeyTyped(par1, par2);
			
			if (!(par2 == Keyboard.KEY_E && (this.assignmentType.isFocused() || this.assignmentURL.isFocused()))) {
				super.keyTyped(par1, par2);
			}
		}

		protected void drawGuiContainerForegroundLayer(int par1, int par2){
			int posX = (this.width) /2;
			int posY = (this.height) /2;
			this.fontRendererObj.drawString("Post a new assignment", (30), (12), 0x600000);
			this.fontRendererObj.drawString("Assignment type", (-15), (33), 0x600000);
			this.fontRendererObj.drawString("Assignment URL", (-15), (61), 0x600000);
			this.assignmentType.drawTextBox();
			this.assignmentURL.drawTextBox();
		}

		public void onGuiClosed(){
			Keyboard.enableRepeatEvents(true);
		}

		public void initGui(){
			super.initGui();
			this.guiLeft = (this.width - 176) / 2;
			this.guiTop = (this.height - 166) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			int posX = (this.width) / 2;
			int posY = (this.height) / 2;
			this.assignmentType = new GuiTextField(this.fontRendererObj, (80), (31), 120, 20);
			this.assignmentType.setMaxStringLength(32767);
			this.assignmentType.setFocused(true);
			this.assignmentType.setCanLoseFocus(true);
			this.assignmentType.setText("Text/Interactive");
			this.assignmentURL = new GuiTextField(this.fontRendererObj, (80), (57), 120, 20);
			this.assignmentURL.setMaxStringLength(32767);
			this.assignmentURL.setFocused(false);
			this.assignmentType.setCanLoseFocus(true);
			this.assignmentURL.setText("");
			this.buttonList.add(new GuiButton(0, this.guiLeft + 15, this.guiTop + 107, 156, 20, "Post assignment"));

		}

		protected void actionPerformed(GuiButton button){
			MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
			World world = server.worldServers[0];
			if (button.id == 0){
				if(true){
					try {
						
						String teacherURL = assignmentURL.getText();
						String teacherURLextracted = teacherURL.substring(teacherURL.indexOf("d/") + 2, teacherURL.indexOf("/edit"));
						String httpURL = "https://www.googleapis.com/drive/v2/files/" + teacherURLextracted + "?key=AIzaSyBj4N7uYMIE5qkDugddrV_fXhgzx-rW4xE";
						URL obj = new URL(httpURL);
						HttpURLConnection con = (HttpURLConnection) obj.openConnection();

						// optional default is GET
						con.setRequestMethod("GET");

						//add request header
						con.setRequestProperty("User-Agent", USER_AGENT);

						int responseCode = con.getResponseCode();
						System.out.println("\nSending 'GET' request to URL : " + httpURL);
						System.out.println("Response Code : " + responseCode);

						BufferedReader in = new BufferedReader(
						        new InputStreamReader(con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();

						
						
						JSONObject newObj = new JSONObject(response.toString());
						String newURL = newObj.getJSONObject("exportLinks").getString("text/plain");
						
						System.out.println(newURL);
						
						URL secondobj = new URL(newURL);
						HttpURLConnection secondcon = (HttpURLConnection) secondobj.openConnection();
						
						secondcon.setRequestMethod("GET");

						//add request header
						secondcon.setRequestProperty("User-Agent", USER_AGENT);

						int secondresponseCode = secondcon.getResponseCode();
						

						BufferedReader otherin = new BufferedReader(
						        new InputStreamReader(secondcon.getInputStream()));
						String otherinputLine;
						
						int lineCount = 0;
						if(assignmentType.getText().equalsIgnoreCase("Interactive")){
							while ((otherinputLine = otherin.readLine()) != null) {
								System.out.println(otherinputLine);
								String[] args = otherinputLine.split("");
								/*
								PlaceBlock placeBlock = new PlaceBlock();
								placeBlock.processCommand(this.entity, args);
							*/
								int x = (int) this.entity.getLookVec().xCoord;
								int y = (int) this.entity.getLookVec().yCoord;
								int z = (int) this.entity.getLookVec().zCoord;
								int i;
								int countX=0;
							    world.setBlock(((int) this.entity.posX )+ x + countX, ((int)this.entity.posY) + y + AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.checkblock);

								for(i=0;i<args.length;i++){
									
									if(!(args[i]==null)){
										
										if(args[i].equals("0")){
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y + AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.zeroblock);
										    countX++;

										}
											
										else if (args[i].equals("1")){
									
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.oneblock);
										    countX++;

										}
										else if(args[i].equals("2")){
										
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.twoblock);
										    countX++;

										}
										else if(args[i].equals("3")){	
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.threeblock);
										    countX++;

										}
										else if(args[i].equals("4")){	
										
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.fourblock);
										    countX++;

										}	
										else if(args[i].equals("5")){
										
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.fiveblock);
										    countX++;

										}
										else if(args[i].equals("6")){
										
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.sixblock);
										    countX++;

										}
										else if(args[i].equals("7")){
										
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.sevenblock);
										    countX++;

										}	
										else if(args[i].equals("8")){
										
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.eightblock);
										    countX++;

										}
										else if(args[i].equals("9")){
									
										    world.setBlock(((int) this.entity.posX )+ x + countX + 1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.nineblock);
										    countX++;

										}
										else if(args[i].equals("+")){	
										
										    world.setBlock(((int) this.entity.posX )+ x + countX +1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.plusblock);
										    countX++;

										}
										
										else if(args[i].equals("-")){
										    world.setBlock(((int) this.entity.posX )+ x + countX+1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.minusblock);
										    countX++;

										}
										else if(args[i].equals("*")){
									
										    world.setBlock(((int) this.entity.posX )+ x + countX+1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.multiblock);
										    countX++;

										}
										else if(args[i].equals("/")){
										
										    world.setBlock(((int) this.entity.posX )+ x + countX+1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.divideblock);
										    countX++;

										}
										else if(args[i].equals("=")){
									
										    world.setBlock(((int) this.entity.posX )+ x + countX+1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.equalblock);
										    countX++;

										}
										else if(args[i].equals("?")){
									
										    world.setBlock(((int) this.entity.posX )+ x + countX+1, ((int)this.entity.posY) + y+ AddAssignment.countY, ((int) this.entity.posZ) + z , ModBlocks.questionMarkblock);
										    countX++;

										}
										//else	
											//xOffset--;	
									
									}
									
								
								}
								countY++;
								otherresponse.append(otherinputLine);
							
							}
						}
						else if(assignmentType.getText().equalsIgnoreCase("Text")){
							while ((otherinputLine = otherin.readLine()) != null) {
								System.out.println(otherinputLine);
								String[] args = otherinputLine.split("");
								otherresponse.append(otherinputLine);
							}
						
							this.GuiAssignmentText = otherresponse.toString();
							int x = (int) this.entity.getLookVec().xCoord;
							int y = (int) this.entity.getLookVec().yCoord;
							int z = (int) this.entity.getLookVec().zCoord;
							world.setBlock(((int) this.entity.posX ) + x, ((int) this.entity.posY ) + y, ((int) this.entity.posZ ) + z , EduMod.bookBlock);
							
							TileEntityVisitor visitor = (TileEntityVisitor)world.getTileEntity(((int) this.entity.posX ) + x, ((int) this.entity.posY ) + y, ((int) this.entity.posZ ) + z);
							visitor.assignmentText = otherresponse.toString();
						}
						otherin.close();
						secondcon.disconnect();
						con.disconnect();
			
						
						
					}catch(Exception e){e.printStackTrace();}
				}

			}
		}
		
		public boolean doesGuiPauseGame(){
			return false;
		}

	}
	
	}


