package atm.bloodworkxgaming.woodenflint

import atm.bloodworkxgaming.bloodyLib.registry.AbstractModItems
import atm.bloodworkxgaming.woodenflint.items.*
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraftforge.oredict.OreDictionary
import net.minecraftforge.registries.IForgeRegistry

object ModItems : AbstractModItems(DataRegistry) {
    val flintShovel = FlintShovel()
    val flintAxe = FlintAxe()
    val flintPickaxe = FlintPickaxe()
    val flintSword = FlintSword()
    val flintHoe = FlintHoe()

    override fun registerItems(registry: IForgeRegistry<Item>) {
        super.registerItems(registry)

        registerOredict()
    }

    private fun registerOredict() {
        OreDictionary.registerOre("flint", Items.FLINT)
        OreDictionary.registerOre("gravel", Blocks.GRAVEL)
    }
}