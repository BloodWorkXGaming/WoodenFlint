package atm.bloodworkxgaming.woodenflint.handler

import atm.bloodworkxgaming.bloodyLib.util.AbstractCommonHandler
import atm.bloodworkxgaming.woodenflint.ModConfig
import atm.bloodworkxgaming.woodenflint.ModItems
import net.minecraft.block.BlockLog
import net.minecraft.entity.item.EntityItem
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.event.world.BlockEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object CommonHandler : AbstractCommonHandler(modItems = ModItems) {
    private val damageSource = DamageSource("pokingTrees")

    @SubscribeEvent
    fun onHarvestSpeed(event: PlayerEvent.BreakSpeed) {
        if (event.state.block is BlockLog) {
            val item = event.entityPlayer.heldItemMainhand
            val heldItem = item.item
            val heldItemName = heldItem.registryName.toString()

            if (
                    (ModConfig.forceAxe
                            && heldItem.getHarvestLevel(item, "axe", null, null) < 0
                            && !ModConfig.whitelistedNoneTools.contains(heldItemName))
                    || ModConfig.blacklistedTools.contains(heldItemName)
            ) {
                event.newSpeed = 0.0f
                event.isCanceled = true

                if (ModConfig.hurtPlayer) {
                    event.entityPlayer.attackEntityFrom(damageSource, 2f)
                }
            }
        }
    }

    @SubscribeEvent
    fun onBlockBreak(event: BlockEvent.BreakEvent) {
        if (event.state.block.isLeaves(event.state, event.world, event.pos) && Math.random() <= ModConfig.stickDropChange) {
            event.world.spawnEntity(EntityItem(event.world, event.pos.x + 0.5, event.pos.y + 0.5, event.pos.z + 0.5, ItemStack(Items.STICK)))
        }
    }
}