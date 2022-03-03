package mod.siliconcraft.block;

import mod.siliconcraft.SiliconCraftMod;
import mod.siliconcraft.block.entity.ElectricArcFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;

public class ElectricArcFurnaceBlock extends AbstractFurnaceBlock {
    public static final ElectricArcFurnaceBlock BLOCK = (ElectricArcFurnaceBlock) new ElectricArcFurnaceBlock(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F).lightLevel(SiliconCraftMod.litBlockEmission(13)))
            .setRegistryName(new ResourceLocation(SiliconCraftMod.MOD_ID, "electric_arc_furnace"));

    public ElectricArcFurnaceBlock(BlockBehaviour.Properties p) {
        super(p);
    }

    protected void openContainer(Level level, BlockPos blockPos, Player player) {
        BlockEntity blockentity = level.getBlockEntity(blockPos);
        if (blockentity instanceof ElectricArcFurnaceBlockEntity) {
            player.openMenu((MenuProvider)blockentity);
        }
    }

    public BlockEntity newBlockEntity(BlockPos p_153277_, BlockState p_153278_) {
        return new ElectricArcFurnaceBlockEntity(p_153277_, p_153278_);
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(Level p_151988_, BlockEntityType<T> p_151989_, BlockEntityType<? extends AbstractFurnaceBlockEntity> p_151990_) {
        return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, p_151990_, ElectricArcFurnaceBlockEntity::serverTick);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152382_, BlockState p_152383_, BlockEntityType<T> p_152384_) {
        return createFurnaceTicker(p_152382_, p_152384_, ElectricArcFurnaceBlockEntity.ELECTRIC_ARC_FURNACE_BLOCK.get());
    }
}
