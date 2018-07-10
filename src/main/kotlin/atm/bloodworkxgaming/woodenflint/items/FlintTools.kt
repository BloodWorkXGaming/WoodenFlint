package atm.bloodworkxgaming.woodenflint.items

import atm.bloodworkxgaming.bloodyLib.registry.IHasModel
import atm.bloodworkxgaming.woodenflint.DataRegistry
import atm.bloodworkxgaming.woodenflint.ModConfig
import atm.bloodworkxgaming.woodenflint.WoodenFlint
import net.minecraft.creativetab.CreativeTabs.TOOLS
import net.minecraft.item.*
import net.minecraft.util.ResourceLocation

class FlintShovel : ItemSpade(ToolMaterial.STONE), IHasModel {
    init {
        registerMe("flint_shovel")
    }
}

class FlintAxe : ItemAxe(ToolMaterial.STONE), IHasModel {
    init {
        registerMe("flint_axe")
    }
}

class FlintPickaxe : ItemPickaxe(ToolMaterial.STONE), IHasModel {
    init {
        registerMe("flint_pickaxe")
    }
}
class FlintSword : ItemSword(ToolMaterial.STONE), IHasModel {
    init {
        registerMe("flint_sword")
    }
}


fun Item.registerMe(name: String) {
    this.registryName = ResourceLocation(WoodenFlint.MOD_ID, name)
    this.unlocalizedName = name

    this.maxDamage = ModConfig.toolDurability
    this.creativeTab = TOOLS

    DataRegistry.ITEMS += this
}