package atm.bloodworkxgaming.woodenflint

import atm.bloodworkxgaming.bloodyLib.registry.AbstractDataRegistry
import atm.bloodworkxgaming.bloodyLib.util.BloodyModMain
import atm.bloodworkxgaming.woodenflint.WoodenFlint.MOD_ID
import atm.bloodworkxgaming.woodenflint.WoodenFlint.VERSION
import atm.bloodworkxgaming.woodenflint.handler.CommonHandler
import atm.bloodworkxgaming.woodenflint.proxy.SubCommonProxy
import net.minecraft.init.Items
import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.registries.GameData
import net.minecraftforge.registries.RegistryManager

@Mod(modid = MOD_ID, modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter", version = VERSION)
object WoodenFlint : BloodyModMain(CommonHandler) {
    const val MOD_ID = "woodenflint"
    const val VERSION = "0.1"

    @SidedProxy(serverSide = "atm.bloodworkxgaming.woodenflint.proxy.ServerProxy", clientSide = "atm.bloodworkxgaming.woodenflint.proxy.ClientProxy")
    lateinit var proxy: SubCommonProxy

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        Items.WOODEN_AXE.maxDamage = 1
        Items.WOODEN_PICKAXE.maxDamage = 1
        Items.WOODEN_SHOVEL.maxDamage = 1
        Items.WOODEN_SWORD.maxDamage = 1
        Items.WOODEN_HOE.maxDamage = 1
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {

        if (ModConfig.disableWoodenTools) {
            val recipes = RegistryManager.ACTIVE.getRegistry<IRecipe>(GameData.RECIPES)
            val names = recipes.filter {
                it.recipeOutput.item === Items.WOODEN_AXE
                        || it.recipeOutput.item === Items.WOODEN_PICKAXE
                        || it.recipeOutput.item === Items.WOODEN_SHOVEL
                        || it.recipeOutput.item === Items.WOODEN_SWORD
                        || it.recipeOutput.item === Items.WOODEN_HOE
            }.map { it.registryName }

            names.forEach { recipes.remove(it) }
        }
    }
}

object DataRegistry : AbstractDataRegistry()