package atm.bloodworkxgaming.woodenflint.items

import atm.bloodworkxgaming.bloodyLib.registry.IHasModel
import atm.bloodworkxgaming.woodenflint.DataRegistry
import atm.bloodworkxgaming.woodenflint.ModConfig
import atm.bloodworkxgaming.woodenflint.WoodenFlint
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemSpade
import net.minecraft.item.ItemStack
import net.minecraft.util.ActionResult
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.world.World

class FlintShovel : ItemSpade(ToolMaterial.STONE), IHasModel {
    init {
        this.registryName = ResourceLocation(WoodenFlint.MOD_ID, "flint_shovel")
        this.unlocalizedName = "flint_shovel"

        this.maxDamage = ModConfig.toolDurability
        DataRegistry.ITEMS += this
    }

    override fun onItemRightClick(worldIn: World?, playerIn: EntityPlayer?, handIn: EnumHand?): ActionResult<ItemStack> {
        if (handIn == EnumHand.OFF_HAND) {
            ModConfig.reload()
        }

        println("ModConfig.forceAxe = ${ModConfig.forceAxe}")

        return super.onItemRightClick(worldIn, playerIn, handIn)
    }
}