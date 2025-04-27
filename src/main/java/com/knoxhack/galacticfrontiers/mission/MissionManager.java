package com.knoxhack.galacticfrontiers.mission;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import java.util.Random;

public class MissionManager {

    private static final String[] MISSION_TYPES = {
        "Repair the Solar Panels",
        "Activate the Shield Generator",
        "Eliminate Alien Threats",
        "Scan the Space Station Modules",
        "Collect Meteor Samples"
    };

    private static final Random random = new Random();
    private static String currentMission = "";

    public static void assignNewMission(Player player) {
        currentMission = MISSION_TYPES[random.nextInt(MISSION_TYPES.length)];
        player.displayClientMessage(Component.literal("New Mission: " + currentMission), false);
    }

    public static String getCurrentMission() {
        return currentMission.isEmpty() ? "No active mission" : currentMission;
    }

    public static void completeCurrentMission(Player player) {
        if (!currentMission.isEmpty()) {
            player.displayClientMessage(Component.literal("Mission Complete: " + currentMission), false);
            currentMission = "";
        }
    }
}
