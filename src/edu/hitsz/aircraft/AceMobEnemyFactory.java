package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class AceMobEnemyFactory implements AircraftFactory{
    @Override
    public AceMobEnemy CreatAircraft(){
        return new AceMobEnemy(
                (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.ELITE_PRO_IMAGE.getWidth())),
                (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05),
                3,
                10,
                30);
    }
}
