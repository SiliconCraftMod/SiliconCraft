package mod.siliconcraft.inventory;

import mod.siliconcraft.item.crafting.ElectricSmeltingRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ElectricArcFurnaceMenu extends AbstractFurnaceMenu {
    public ElectricArcFurnaceMenu(int p_39532_, Inventory p_39533_) {
        super(MenuType.FURNACE, ElectricSmeltingRecipe.ELECTRIC_SMELTING, RecipeBookType.FURNACE, p_39532_, p_39533_);
    }

    public ElectricArcFurnaceMenu(int p_39535_, Inventory p_39536_, Container p_39537_, ContainerData p_39538_) {
        super(MenuType.FURNACE, ElectricSmeltingRecipe.ELECTRIC_SMELTING, RecipeBookType.FURNACE, p_39535_, p_39536_, p_39537_, p_39538_);
    }

    @Override
    protected boolean isFuel(ItemStack stack) {
        return stack.is(Items.COAL) || stack.is(Items.CHARCOAL);
    }
}