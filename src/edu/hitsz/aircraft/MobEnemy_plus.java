package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.strategy.DirectShoot;
import edu.hitsz.tool.BaseTool;
import edu.hitsz.tool.ToolFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * 精英敌机
 * 可以射击并且掉落3个道具 blood\fire\fire_plus
 */
public  class MobEnemy_plus extends AbstractAircraft {
    private int power = 10;
    private int shootNum = 1;
    private int direction = 1;


    public MobEnemy_plus(int locationX, int locationY, int speedX, int speedY, int hp){
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot() {
        DirectShoot directShoot = new DirectShoot();
        return directShoot.shoot(this, this.getLocationX(), this.getLocationY(), 0, this.getSpeedY(), direction, power);
    }

    @Override
    public List<BaseTool> GetTools(int LocationX, int LocationY) {
        List<BaseTool> tools;
        tools = new LinkedList<>();
        int type = (int)(Math.random() * 5 + 1);
        if (type != 6){
            tools.add(ToolFactory.CreatTool(type, LocationX, LocationY));
        }
        return tools;
    }

}