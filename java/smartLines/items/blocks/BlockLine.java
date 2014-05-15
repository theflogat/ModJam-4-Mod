package smartLines.items.blocks;

import smartLines.tile.TEPipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLine extends BlockContainer{

	protected BlockLine() {
		super(Material.iron);
		
	}
	
	

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TEPipe();
	}

}
