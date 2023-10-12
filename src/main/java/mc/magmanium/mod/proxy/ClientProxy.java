package mc.magmanium.mod.proxy;

import cpw.mods.fml.common.registry.LanguageRegistry;
import mc.magmanium.mod.ModBootstrap;
import mc.magmanium.mod.ModConstants;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void load(ModBootstrap modInstance) {
		super.load(modInstance);

		this.modInstance.magma_block.setTextureFile(ModConstants.BLOCK_ATLAS);
		this.modInstance.magma_block.blockIndexInTexture = 0;
	}

	@Override
	public void init() {
		super.init();

		MinecraftForgeClient.preloadTexture(ModConstants.BLOCK_ATLAS);
		LanguageRegistry.instance().loadLocalization("/lang/en_US.properties", "en_US", false);
	}

	@Override
	public void post() {
		super.post();
	}

}
