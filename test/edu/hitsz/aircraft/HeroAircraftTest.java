package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.tool.BaseTool;
import edu.hitsz.tool.ToolFactory;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {
    private HeroAircraft heroAircraft;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("**--- Executed before each test method in this class ---**");
        this.heroAircraft = HeroAircraft.getHeroAircraft();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("**--- Executed after each test method in this class ---**");
        heroAircraft = null;
    }

    @org.junit.jupiter.api.Test
    void decreaseHp() {
        System.out.println("**--- Executed test method decreaseHp() ---**");
        heroAircraft.decreaseHp(10);
        assertEquals(90, heroAircraft.getHp());
    }

    @org.junit.jupiter.api.Test
    void crash() {
        System.out.println("**--- Executed test method crash() ---**");
        BaseTool tool = ToolFactory.CreatTool(1, Main.WINDOW_WIDTH / 2, Main.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight());
        heroAircraft.crash(tool);
        assertFalse(heroAircraft.notValid());
    }

    @org.junit.jupiter.api.Test
    void Healing() {
        System.out.println("**--- Executed test method healing() ---**");
        heroAircraft.Healing();
        assertEquals(100, heroAircraft.getHp());
    }
}