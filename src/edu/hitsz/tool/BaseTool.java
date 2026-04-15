package edu.hitsz.tool;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;
public abstract class BaseTool extends AbstractFlyingObject {
    private int type;
    public BaseTool(int locationX, int locationY, int speedX, int speedY, int type){
        super(locationX, locationY, speedX, speedY);
        this.type = type;
    }

    @Override
    public void forward(){
        super.forward();
        // 判定飞出屏幕下方出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    public int Gettype(){return this.type;}
    public void activate(HeroAircraft heroAircraft){}
}
