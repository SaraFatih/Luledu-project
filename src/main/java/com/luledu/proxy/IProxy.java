package com.luledu.proxy;

import com.luledu.edumod.EduMod;

public interface IProxy {

	public abstract void registerKeyBindings();
	public abstract void registerRenderers(EduMod ins);
	//public abstract void openMyGui();
	void openMyGui(String assignment);
}
