package mod.siliconcraft;

import mod.siliconcraft.gui.SmartphoneScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Smartphone extends Item {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Smartphone() {
        super(new Properties().tab(CreativeModeTab.TAB_REDSTONE).durability(0).stacksTo(1));
    }

    public static final Item ITEM = new Smartphone().setRegistryName("smartphone");

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player player, InteractionHand hand) {
        LOGGER.debug("use smartphone");
        ItemStack itemStack = player.getItemInHand(hand);
        System.out.println("isClientSide: " + p_41432_.isClientSide());
        if (p_41432_.isClientSide()) {
            Minecraft.getInstance().setScreen(new SmartphoneScreen());
        }
        return InteractionResultHolder.success(itemStack);
    }
}
