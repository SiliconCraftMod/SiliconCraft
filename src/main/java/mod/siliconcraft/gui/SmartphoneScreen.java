package mod.siliconcraft.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;

import java.util.Objects;

public class SmartphoneScreen extends Screen {

    public SmartphoneScreen() {
        super(NarratorChatListener.NO_TITLE);
    }

    @Override
    protected void init() {
        createGlobalControls();
    }

    private void createGlobalControls() {
        Button closeButton = new Button(
                (int) (this.width/2.0), (int) (this.height/4.0*3),
                (int) (this.width/4.0), (int) (this.height/8.0),
                new TextComponent("Close"),
                (b) -> {
                    this.getMinecraft().setScreen(null);
                }
                );
        this.addRenderableWidget(closeButton);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
        this.renderBackground(p_96562_);

        super.render(p_96562_, p_96563_, p_96564_, p_96565_);
    }
}
