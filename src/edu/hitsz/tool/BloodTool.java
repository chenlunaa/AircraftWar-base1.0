package edu.hitsz.tool;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;

public class BloodTool extends BaseTool{
    public BloodTool(int locationX, int locationY, int speedX, int speedY, int type) {
        super(locationX, locationY, speedX, speedY, type);
    }
    @Override
    public void activate(HeroAircraft heroAircraft){
        heroAircraft.Healing();
    }
}
