package mod.siliconcraft.item;

import mod.siliconcraft.SiliconCraftMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class SiliconItem extends Item {
    public static final SiliconItem ITEM = (SiliconItem) new SiliconItem((new Properties()).tab(CreativeModeTab.TAB_MISC))
            .setRegistryName(new ResourceLocation(SiliconCraftMod.MOD_ID, "silicon"));

    public SiliconItem(Item.Properties properties) {
        super(properties);
    }
}
