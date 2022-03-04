package mod.siliconcraft.block.entity;

import mod.siliconcraft.SiliconCraftMod;
import mod.siliconcraft.block.ElectricArcFurnaceBlock;
import mod.siliconcraft.inventory.ElectricArcFurnaceMenu;
import mod.siliconcraft.item.crafting.ElectricSmeltingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class ElectricArcFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    public static RegistryObject<BlockEntityType<ElectricArcFurnaceBlockEntity>> ELECTRIC_ARC_FURNACE_BLOCK;

    public ElectricArcFurnaceBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
        super(ELECTRIC_ARC_FURNACE_BLOCK.get(), p_155545_, p_155546_, ElectricSmeltingRecipe.ELECTRIC_SMELTING);
    }

    protected Component getDefaultName() {
        return new TranslatableComponent("container.electric_arc_furnace");
    }

    protected AbstractContainerMenu createMenu(int p1, Inventory inventory) {
        SiliconCraftMod.LOGGER.error("createMenu");
        return new ElectricArcFurnaceMenu(p1, inventory, this, this.dataAccess);
    }

    public static void registerBlockEntity(){
        ELECTRIC_ARC_FURNACE_BLOCK = register("electric_arc_furnace_be", BlockEntityType.Builder.of(ElectricArcFurnaceBlockEntity::new, ElectricArcFurnaceBlock.BLOCK));
    }

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.Builder<T> builder) {
        return SiliconCraftMod.BLOCK_ENTITY_REGISTER.register(name, () -> builder.build(null));
    }

    public static void serverTick(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, AbstractFurnaceBlockEntity p_155017_) {
        AbstractFurnaceBlockEntity.serverTick(p_155014_, p_155015_, p_155016_, p_155017_);
    }
}