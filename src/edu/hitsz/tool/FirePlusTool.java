package edu.hitsz.tool;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.strategy.CircleShoot;

public class FirePlusTool extends FireTool{
    public FirePlusTool(int locationX, int locationY, int speedX, int speedY, int type) {
        super(locationX, locationY, speedX, speedY, type);
    }
    @Override
    public void activate (HeroAircraft heroAircraft){
        heroAircraft.SetStrategy(new CircleShoot());
    }
}
