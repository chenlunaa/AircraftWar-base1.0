package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class BossMobEnemyFactory implements AircraftFactory{

    @Override
    public BossMobEnemy CreatAircraft(){
        return new BossMobEnemy((int)((Main.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth()) / 2), 0 ,1 ,0 , 50);
    }
}
