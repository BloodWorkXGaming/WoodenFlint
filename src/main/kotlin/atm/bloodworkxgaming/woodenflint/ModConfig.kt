package atm.bloodworkxgaming.woodenflint

import net.minecraftforge.common.config.Config
import net.minecraftforge.common.config.Configuration
import net.minecraftforge.common.config.Property
import java.io.File

@Config(modid = WoodenFlint.MOD_ID)
object ModConfig {
    private val config = Configuration(File("config/woodenflint2.cfg"))
    private var propToolDurability = LazyProp(49)
    private lateinit var testPropToolDurability: PropDelegate<Int>
    private var propForceAxe = LazyProp(true)
    private var propHurtPlayer = LazyProp(true)
    private var propWhitelistedNoneTools = LazyProp(emptyArray<String>())
    private var propBlacklistedTools = LazyProp(arrayOf("minecraft:wooden_axe"))
    private var propsSickDropChange = LazyProp(0.1)

    init {
        reload()

        config.save()
    }

    val toolDurability: Int by { testPropToolDurability.int}
    // val toolDurability: Int by propToolDurability
    val forceAxe: Boolean by propForceAxe
    val hurtPlayer: Boolean  by propHurtPlayer
    val whitelistedNoneTools: Array<String> by propWhitelistedNoneTools
    val blacklistedTools: Array<String> by propBlacklistedTools
    val stickDropChange: Double by propsSickDropChange

    fun reload() {
        println("reloading")
        config.load()

        testPropToolDurability = config.get("general", "toolDurability", propToolDurability.defaultValue)



        propToolDurability += config.get("general", "toolDurability", propToolDurability.defaultValue)
        propForceAxe += config.get("general", "forceAxe", propForceAxe.defaultValue)
        propHurtPlayer += config.get("general", "hurtPlayer", propHurtPlayer.defaultValue)
        propWhitelistedNoneTools += config.get("general", "whitelistedNoneTools", propWhitelistedNoneTools.defaultValue)
        propBlacklistedTools += config.get("general", "blacklistedTools", propBlacklistedTools.defaultValue)
        propsSickDropChange += config.get("general", "stickDropChange", propsSickDropChange.defaultValue)

        println("propToolDurability = ${propForceAxe!!.value} or $forceAxe")
    }
}

/*fun <T> Property.wrap(): LazyProp<T> {
    prop<Int>()

    return LazyProp(this)
}*/