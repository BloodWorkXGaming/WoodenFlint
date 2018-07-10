package atm.bloodworkxgaming.woodenflint

import net.minecraftforge.common.config.Config
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.common.config.Property
import java.io.File

@Config(modid = WoodenFlint.MOD_ID)
object ModConfig {
    @JvmField
    var toolDurability: Int = 49

    @JvmField
    var disableWoodenTools: Boolean = true

    @JvmField
    var forceAxe: Boolean = true
    @JvmField
    var hurtPlayer: Boolean  = true
    @JvmField
    var whitelistedNoneTools: Array<String> = emptyArray()
    @JvmField
    var blacklistedTools: Array<String> = arrayOf("minecraft:wooden_axe")
    @JvmField
    var stickDropChange: Double = 0.1
}