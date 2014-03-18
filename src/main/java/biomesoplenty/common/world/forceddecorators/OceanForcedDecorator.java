package biomesoplenty.common.world.forceddecorators;

import biomesoplenty.common.world.decoration.ForcedDecorator;

public class OceanForcedDecorator extends ForcedDecorator
{
	public OceanForcedDecorator()
	{
        this.bopWorldFeatures.setFeature("seaweedPerChunk", 20);
	}
}