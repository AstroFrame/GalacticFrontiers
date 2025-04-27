package com.knoxhack.galacticfrontiers.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.knoxhack.galacticfrontiers.GalacticFrontiersMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GalacticFrontiersMod.MODID, value = Dist.CLIENT)
public class HUDOverlays {

    private static final ResourceLocation RADAR_TEXTURE = new ResourceLocation(GalacticFrontiersMod.MODID, "textures/gui/radar_overlay.png");
    private static final ResourceLocation MISSION_BAR_TEXTURE = new ResourceLocation(GalacticFrontiersMod.MODID, "textures/gui/mission_bar.png");

    @SubscribeEvent
    public static void renderHUD(RenderGuiOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) {
            return;
        }

        GuiGraphics graphics = event.getGuiGraphics();
        int screenWidth = mc.getWindow().getGuiScaledWidth();
        int screenHeight = mc.getWindow().getGuiScaledHeight();

        RenderSystem.enableBlend();

        // Render Radar
        graphics.blit(RenderType.guiOverlay(), RADAR_TEXTURE, screenWidth - 80, 10, 0, 0, 64, 64, 64, 64);

        // Render Mission Bar
        graphics.blit(RenderType.guiOverlay(), MISSION_BAR_TEXTURE, (screenWidth - 200) / 2, screenHeight - 40, 0, 0, 200, 20, 200, 20);

        RenderSystem.disableBlend();
    }
}
