package co.skyclient.scc.gui.greeting

import gg.essential.elementa.components.UIText
import gg.essential.elementa.constraints.CenterConstraint
import gg.essential.elementa.constraints.SiblingConstraint
import gg.essential.elementa.dsl.*
import co.skyclient.scc.gui.greeting.components.GreetingSlide
import co.skyclient.scc.utils.Files
import net.minecraft.client.gui.GuiMainMenu
import java.awt.Color

class EndSlide : GreetingSlide<GuiMainMenu>(GuiMainMenu::class.java, {
    Files.greetingFile.createNewFile()
    Files.greetingFile.writeText("DELETING OR EDITING THIS FILE WILL CAUSE WEIRD THINGS TO HAPPEN! DO NOT TOUCH THIS UNLESS A SKYCLIENT STAFF MEMBER HAS GIVEN YOU PERMISSION TO DO SO!\n2")
    Thread.sleep(1000)
}) {
    val title by UIText("That's it!") constrain {
        x = CenterConstraint()
        y = CenterConstraint()
        textScale = 5.pixels()
        color = Color.GREEN.darker().toConstraint()
    } childOf window

    val subtitle by UIText("Have fun using SkyClient!") constrain {
        x = CenterConstraint()
        y = SiblingConstraint(2f)
    } childOf window

    override fun onScreenClose() {
        super.onScreenClose()
        if (previousScale != Int.MIN_VALUE) {
            mc.gameSettings.guiScale = previousScale
            mc.gameSettings.saveOptions()
        }
    }
}