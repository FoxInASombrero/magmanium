package mc.magmanium.mod.proxy;

import com.google.common.base.Preconditions;

import mc.magmanium.mod.ModBootstrap;
import net.minecraftforge.common.Configuration;

public class CommonProxy {

	protected ModBootstrap modInstance;

	protected Configuration config;

	public void load(ModBootstrap modInstance) {
		Preconditions.checkArgument(modInstance != null, "The ModBootstrap cannot be null!");

		this.modInstance = modInstance;
	}

	public void init() {
		// just leave this empty..
	}

	public void post() {
		// this is also somewhat useless..
	}

}
