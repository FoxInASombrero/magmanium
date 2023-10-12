package mc.magmanium.mod;

import java.io.File;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import mc.magmanium.mod.block.MagmaBlock;
import mc.magmanium.mod.proxy.CommonProxy;
import mc.magmanium.mod.worldGen.MagmaBlockGenerator;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;

@Mod(modid = ModConstants.MOD_ID, name = ModConstants.MOD_NAME, version = ModConstants.MOD_VERSION, useMetadata = true)
@NetworkMod(serverSideRequired = false, clientSideRequired = true)
public class ModBootstrap {

	public final Logger LOGGER = Logger.getLogger("magmanium");

	@SidedProxy(serverSide = "mc.magmanium.mod.proxy.CommonProxy", clientSide = "mc.magmanium.mod.proxy.ClientProxy")
	public static CommonProxy proxy;

	public Configuration config;

	public int magma_block_id = 2001;
	public MagmaBlock magma_block;

	public MagmaBlockGenerator worldGenerator;

	public ModBootstrap() {
		this.LOGGER.setParent(FMLLog.getLogger());
	}

	@PreInit
	public void load(FMLPreInitializationEvent event) {
		this.LOGGER.info("Preinitializing the mod...");

		this.handleConfiguration();

		GameRegistry.registerBlock(this.magma_block, "magma_block");

		proxy.load(this);
	}

	@Init
	public void init(FMLInitializationEvent event) {
		proxy.init();

		GameRegistry.registerWorldGenerator(this.worldGenerator);
	}

	@PostInit
	public void post(FMLPostInitializationEvent event) {
		proxy.post();

		this.LOGGER.info("Done loading!");
		this.LOGGER.info(
				"This mod has been created as part of a project committed to bring back life to old, unsupported Minecraft versions.");
		this.LOGGER.info("It's so sad to see, that a lot of people just don't care about these versions anymore...");
	}

	public void handleConfiguration() {
		this.config = new Configuration(new File(ModConstants.CONFIG_FILE));

		try {
			this.LOGGER.info("Initializing configuration...");

			this.config.load();

			this.config.addCustomCategoryComment("generator",
					"This is the configuration of the generator that supposed to generate the Magma Block in the Nether.");
			this.config.addCustomCategoryComment("magma_block", "These are the settings of the Magma Block.");

			this.magma_block_id = this.config.get("magma_block", "id", this.magma_block_id).getInt();

			int damageValue = this.config.get("magma_block", "damageValue", 1).getInt();

			int minBlobSize = this.config.get("generator", "minBlobSize", 3).getInt();
			int maxBlobSize = this.config.get("generator", "maxBlobSize", 32).getInt();
			int chance = this.config.get("generator", "chance", 5).getInt();
			int minY = this.config.get("generator", "minY", 26).getInt();
			int maxY = this.config.get("generator", "maxY", 128).getInt();

			this.LOGGER.info("Registering the Magma Block...");

			this.magma_block = new MagmaBlock(this.magma_block_id, Material.rock);

			this.magma_block.setDamageValue(damageValue);

			this.worldGenerator = new MagmaBlockGenerator(this.magma_block, minBlobSize, maxBlobSize, chance, minY,
					maxY);
		} finally {
			this.config.save();
		}
	}

}
