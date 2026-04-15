package edu.hitsz.tool;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.strategy.ScatterShoot;

public class FireTool extends BaseTool{
    public FireTool(int locationX, int locationY, int speedX, int speedY, int type) {
        super(locationX, locationY, speedX, speedY, type);
    }
    @Override
    public void activate(HeroAircraft heroAircraft){
        heroAircraft.SetStrategy(new ScatterShoot());
    }
}
