package biomesoplenty.common.biomes.overworld;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import biomesoplenty.api.BOPBlockHelper;
import biomesoplenty.common.biomes.BOPBiome;
import biomesoplenty.common.configuration.BOPConfigurationMisc;
import biomesoplenty.common.world.features.WorldGenBOPFlora;
import biomesoplenty.common.world.features.trees.WorldGenBOPSwampTree;
import biomesoplenty.common.world.features.trees.WorldGenBOPTaiga2;
import biomesoplenty.common.world.features.trees.WorldGenDeadTree;

public class BiomeGenOminousWoods extends BOPBiome
{
	private static final Height biomeHeight = new Height(0.1F, 0.2F);
	
	public BiomeGenOminousWoods(int id)
	{
		super(id);

        //TODO: setHeight()
        this.setHeight(biomeHeight);
        //TODO:	setColor()
        this.setColor(4145489);
        this.setTemperatureRainfall(0.8F, 0.9F);
		
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSpider.class, 5, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
		this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
		
		this.waterColorMultiplier = 1973030;
		
		this.theBiomeDecorator.treesPerChunk = 8;
		this.theBiomeDecorator.grassPerChunk = 1;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 8;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;

        this.bopWorldFeatures.setFeature("thornsPerChunk", 9);
        this.bopWorldFeatures.setFeature("poisonIvyPerChunk", 3);
        this.bopWorldFeatures.setFeature("leafPilesPerChunk", 2);
        this.bopWorldFeatures.setFeature("deadLeafPilesPerChunk", 4);
        this.bopWorldFeatures.setFeature("poisonLakesPerChunk", 15);

        this.bopWorldFeatures.setFeature("bopFlowersPerChunk", 1);
        this.bopWorldFeatures.setFeature("bopGrassPerChunk", 1);

        this.bopWorldFeatures.weightedFlowerGen.put(new WorldGenBOPFlora(BOPBlockHelper.get("flowers"), 2), 20);

        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenTallGrass(Blocks.tallgrass, 0), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenTallGrass(Blocks.tallgrass, 1), 1D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenTallGrass(BOPBlockHelper.get("foliage"), 10), 0.5D);
        this.bopWorldFeatures.weightedGrassGen.put(new WorldGenTallGrass(BOPBlockHelper.get("foliage"), 11), 0.5D);
	}

	@Override
	//TODO:						getRandomWorldGenForTrees()
	public WorldGenAbstractTree func_150567_a(Random random)
	{
		return random.nextInt(2) == 0 ? new WorldGenBOPTaiga2(BOPBlockHelper.get("logs1"), BOPBlockHelper.get("leaves1"), 2, 3, false, 14, 6, 0) : (random.nextInt(6) == 0 ? new WorldGenDeadTree() : new WorldGenBOPSwampTree(BOPBlockHelper.get("logs1"), BOPBlockHelper.get("leaves1"), 2, 3, 5, 4, BOPBlockHelper.get("treeMoss"), -1));
	}
	
	@Override
	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		super.decorate(world, random, chunkX, chunkZ);
        int var5 = 12 + random.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(28) + 4;
            int z = chunkZ + random.nextInt(16);

            Block block = world.getBlock(x, y, z);

            if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
            {
                world.setBlock(x, y, z, BOPBlockHelper.get("gemOre"), 10, 2);
            }
        }
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z)
	{
		return 4145489;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z)
	{
		return 4145489;
	}
	
	@Override
	public int getSkyColorByTemp(float par1)
	{
		if (BOPConfigurationMisc.skyColors) return 5522002;
		else return super.getSkyColorByTemp(par1);
	}
	
	/**
	 * Fog Color
	 */
	/*
	@Override
	public int getFogColour()
	{
		return 3420989;
	}
	*/

    /*@Override
    public float getFogCloseness()
    {
        return 0.1F;
    }
    */
}
