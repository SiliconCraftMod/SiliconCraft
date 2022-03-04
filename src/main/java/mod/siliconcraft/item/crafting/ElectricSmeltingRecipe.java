package mod.siliconcraft.item.crafting;

import mod.siliconcraft.SiliconCraftMod;
import mod.siliconcraft.block.ElectricArcFurnaceBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ElectricSmeltingRecipe extends AbstractCookingRecipe {
    public static ResourceLocation TYPE_ID = new ResourceLocation(SiliconCraftMod.MOD_ID, "electric_smelting");

    public static final RecipeType<ElectricSmeltingRecipe> ELECTRIC_SMELTING = new RecipeType<ElectricSmeltingRecipe>() {
        public String toString() {
            return "electric_smelting";
        }
    };
    public static final RecipeSerializer<ElectricSmeltingRecipe> ELECTRIC_SMELTING_SERIAL = new CustomCookingSerializer<ElectricSmeltingRecipe>(ElectricSmeltingRecipe::new, 200);

    public ElectricSmeltingRecipe(ResourceLocation res, String p_44461_, Ingredient ingredient, ItemStack stack, float p_44464_, int p_44465_) {
        super(ELECTRIC_SMELTING, res, p_44461_, ingredient, stack, p_44464_, p_44465_);
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(ElectricArcFurnaceBlock.BLOCK);
    }

    public RecipeSerializer<?> getSerializer() {
        return ELECTRIC_SMELTING_SERIAL;
    }
}