package mc.magmanium.mod.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MagmaBlock extends Block {

	private int damageValue = 1;

	public MagmaBlock(int par1, Material par2Material) {
		super(par1, par2Material);

		this.setBlockName("magma_block");

		this.setHardness(0.3f);
		this.setResistance(0.3f);
		this.setLightValue(0.3f);

		this.setTickRandomly(true);

		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void onEntityWalking(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_,
			Entity p_149670_5_) {
		super.onEntityWalking(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, p_149670_5_);

		if (p_149670_5_ instanceof EntityPlayer)
			((EntityPlayer) p_149670_5_).addChatMessage("asd");

		if (!p_149670_5_.isImmuneToFire() && !p_149670_5_.isSneaking())
			p_149670_5_.attackEntityFrom(DamageSource.inFire, this.damageValue);
	}

	@Override
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

		int upperBlock = p_149674_1_.getBlockId(p_149674_2_, p_149674_3_ + 1, p_149674_4_);

		if (upperBlock == Block.waterStill.blockID || upperBlock == Block.waterMoving.blockID)
			p_149674_1_.playSoundEffect(p_149674_2_ + 0.5d, p_149674_3_ + 0.5d, p_149674_4_ + 0.5d, "random.fizz", 0.3f,
					1.0f);
	}

	public void setDamageValue(int damageValue) {
		this.damageValue = damageValue;
	}

	@Override
	public int tickRate() {
		return 5;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

		int next = this.blockIndexInTexture == 3 ? 0 : this.blockIndexInTexture++;

		this.blockIndexInTexture = next;
	}

}
