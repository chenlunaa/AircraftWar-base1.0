package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class SuperMobEnemyFactory implements AircraftFactory{
    @Override
    public SuperMobEnemy CreatAircraft(){
        return new SuperMobEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_PLUS_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                3,
                10,
                30);
    }
}
