package atm.bloodworkxgaming.woodenflint

import atm.bloodworkxgaming.bloodyLib.registry.AbstractDataRegistry
import atm.bloodworkxgaming.bloodyLib.util.BloodyModMain
import atm.bloodworkxgaming.woodenflint.WoodenFlint.MOD_ID
import atm.bloodworkxgaming.woodenflint.WoodenFlint.VERSION
import atm.bloodworkxgaming.woodenflint.handler.CommonHandler
import atm.bloodworkxgaming.woodenflint.proxy.SubCommonProxy
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = MOD_ID, modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter", version = VERSION)
object WoodenFlint : BloodyModMain(CommonHandler) {
    const val MOD_ID = "woodenflint"
    const val VERSION = "0.1"

    @SidedProxy(serverSide = "atm.bloodworkxgaming.woodenflint.proxy.ServerProxy", clientSide = "atm.bloodworkxgaming.woodenflint.proxy.ClientProxy")
    lateinit var proxy: SubCommonProxy

    @Mod.EventHandler
    fun preInit(event: FMLInitializationEvent) {
        println("MOD_ID = $MOD_ID")
    }
}

object DataRegistry : AbstractDataRegistry()