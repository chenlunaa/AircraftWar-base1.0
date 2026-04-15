package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.strategy.CircleShoot;
import edu.hitsz.tool.BaseTool;
import edu.hitsz.tool.ToolFactory;

import java.util.LinkedList;
import java.util.List;

public class BossMobEnemy extends MobEnemy{
    private int power = 10;
    private int shootNum = 1;
    private int direction = 1;
    private volatile static BossMobEnemy boss;
    public BossMobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    public static BossMobEnemy getBoss() {
        if (boss == null) {
            synchronized (HeroAircraft.class) {
                if ( boss == null) {
                    boss = new BossMobEnemyFactory().CreatAircraft();
                }
            }
        }
        return boss;
    }
    @Override
    public void vanish() {
        isValid = false;
        boss = null;
    }
    @Override
    public List<BaseBullet> shoot() {
        CircleShoot circleShoot = new CircleShoot();
        return circleShoot.shoot(this, this.getLocationX(), this.getLocationY(), this.getSpeedX(), this.getSpeedY(), direction, power);
    }

    @Override
    public List<BaseTool> GetTools(int LocationX, int LocationY) {
        List<BaseTool> tools;
        tools = new LinkedList<>();
        for (int i = 0; i < 3 ; i++){
            tools.add(ToolFactory.CreatTool((int)(Math.random() * 5 + 1), LocationX, LocationY));
        }
        return tools;
    }
}
