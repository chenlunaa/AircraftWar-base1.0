package edu.hitsz.tool;

import edu.hitsz.aircraft.HeroAircraft;

public class BombTool extends BaseTool{
    public BombTool(int locationX, int locationY, int speedX, int speedY, int type) {
        super(locationX, locationY, speedX, speedY, type);
    }

    @Override
    public void activate (HeroAircraft heroAircraft){
        System.out.println("获得炸弹道具");
    }
}
