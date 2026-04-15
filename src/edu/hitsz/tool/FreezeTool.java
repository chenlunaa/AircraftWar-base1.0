package edu.hitsz.tool;

import edu.hitsz.aircraft.HeroAircraft;

public class FreezeTool extends BaseTool{
    public FreezeTool(int locationX, int locationY, int speedX, int speedY, int type) {
        super(locationX, locationY, speedX, speedY, type);
    }
    @Override
    public void activate(HeroAircraft heroAircraft){
        System.out.println("获得冰冻道具");
    }
}
