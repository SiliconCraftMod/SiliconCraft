package mod.siliconcraft;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Smartphone extends Item {
    public Smartphone() {
        super(new Properties().tab(CreativeModeTab.TAB_REDSTONE).durability(0).stacksTo(1));
    }

    public static final Smartphone SMARTPHONE = create();

    private static Smartphone create() {
        Smartphone smh = new Smartphone();
        smh.setRegistryName("smartphone");
        return smh;
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(SMARTPHONE);
    }
}
