package biomesoplenty.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.BOPBlocks;

public class WorldGenPromisedBush extends WorldGenerator
{
	@Override
	public boolean generate(World var1, Random var2, int var3, int var4, int var5)
	{
		while (var1.isAirBlock(var3, var4, var5) && var4 > 2)
		{
			--var4;
		}

		int var6 = var1.getBlockId(var3, var4, var5);

		if (var6 != BOPBlocks.holyGrass.get().blockID)
			return false;
		else
		{
			for (int var7 = -2; var7 <= 2; ++var7)
			{
				for (int var8 = -2; var8 <= 2; ++var8)
				{
					if (var1.isAirBlock(var3 + var7, var4 - 1, var5 + var8) && var1.isAirBlock(var3 + var7, var4 - 2, var5 + var8))
						return false;
				}
			}

			var1.setBlock(var3, var4, var5, BOPBlocks.holyDirt.get().blockID);
			this.setBlockAndMetadata(var1, var3, var4 + 1, var5, BOPBlocks.logs2.get().blockID,0);
			this.setBlockAndMetadata(var1, var3, var4 + 2, var5, BOPBlocks.logs2.get().blockID,0);
			this.setBlockAndMetadata(var1, var3 + 1, var4 + 2, var5, BOPBlocks.leaves2.get().blockID, 2);
			this.setBlockAndMetadata(var1, var3 - 1, var4 + 2, var5, BOPBlocks.leaves2.get().blockID, 2);
			this.setBlockAndMetadata(var1, var3, var4 + 2, var5 + 1, BOPBlocks.leaves2.get().blockID, 2);
			this.setBlockAndMetadata(var1, var3, var4 + 2, var5 - 1, BOPBlocks.leaves2.get().blockID, 2);
			this.setBlockAndMetadata(var1, var3, var4 + 3, var5, BOPBlocks.leaves2.get().blockID, 2);
			return true;
		}
	}
}