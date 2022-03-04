package mod.siliconcraft;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import mod.siliconcraft.inventory.ElectricArcFurnaceMenu;

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
        player.startUsingItem(hand);
        player.openMenu(new MenuProvider() {

            @Override
            public AbstractContainerMenu createMenu(int p_39954_, Inventory p_39955_, Player p_39956_) {
                return new ElectricArcFurnaceMenu(p_39954_, p_39955_);
            }

            @Override
            public Component getDisplayName() {
                return new TranslatableComponent("container.electric_arc_furnace");
            }
            
        });
        return InteractionResultHolder.success(itemStack);
    }
}
