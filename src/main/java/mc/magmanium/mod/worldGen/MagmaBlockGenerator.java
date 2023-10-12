package mc.magmanium.mod.worldGen;

import java.util.Random;

import com.google.common.base.Preconditions;

import cpw.mods.fml.common.IWorldGenerator;
import mc.magmanium.mod.worldGen.feature.CustomWorldGenMinable;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class MagmaBlockGenerator implements IWorldGenerator {

	private Block magma_block;

	private int minBlobSize;
	private int maxBlobSize;
	private int chance;
	private int minY;
	private int maxY;

	public MagmaBlockGenerator(Block magma_block, int minBlobSize, int maxBlobSize, int chance, int minY, int maxY) {
		Preconditions.checkArgument(magma_block != null, "The specified block cannot be null!");

		this.magma_block = magma_block;

		this.minBlobSize = minBlobSize;
		this.maxBlobSize = maxBlobSize;
		this.chance = chance;
		this.minY = minY;
		this.maxY = maxY;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		WorldProvider worldProvider = world.provider;
		int dimensionId = worldProvider.dimensionId;

		if (!(dimensionId == -1))
			return;

		int blobSize = this.minBlobSize + random.nextInt(this.maxBlobSize - this.minBlobSize);
		int heightRange = this.maxY - this.minY;

		CustomWorldGenMinable generator = new CustomWorldGenMinable(this.magma_block.blockID, blobSize,
				Block.netherrack.blockID);

		for (int j = 0; j < this.chance; j++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + this.minY;
			int zRand = chunkZ * 16 + random.nextInt(16);

			generator.generate(world, random, xRand, yRand, zRand);
		}
	}

}
