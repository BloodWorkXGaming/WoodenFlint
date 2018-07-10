package atm.bloodworkxgaming.woodenflint

import atm.bloodworkxgaming.bloodyLib.registry.AbstractModItems
import atm.bloodworkxgaming.woodenflint.items.FlintAxe
import atm.bloodworkxgaming.woodenflint.items.FlintPickaxe
import atm.bloodworkxgaming.woodenflint.items.FlintShovel
import atm.bloodworkxgaming.woodenflint.items.FlintSword

object ModItems : AbstractModItems(DataRegistry) {
    val flintShovel = FlintShovel()
    val flintAxe = FlintAxe()
    val flintPickaxe = FlintPickaxe()
    val flintSword = FlintSword()
}