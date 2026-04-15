package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.strategy.ScatterShoot;
import edu.hitsz.tool.BaseTool;
import edu.hitsz.tool.ToolFactory;

import java.util.LinkedList;
import java.util.List;

public class AceMobEnemy extends MobEnemy_plus{
    private int power = 10;
    private int shootNum = 3;
    private int direction = 1;
    public AceMobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    public void forward() {
        super.forward();
    }

    @Override
    public List<BaseBullet> shoot(){
        ScatterShoot scatterShoot = new ScatterShoot();
        List<BaseBullet> res = scatterShoot.shoot(this, this.getLocationX(), this.getLocationY(), 1, this.getSpeedY(), direction, power);
        return res;
    }

    @Override
    public List<BaseTool> GetTools (int LocationX, int LocationY){
        List<BaseTool> tools;
        tools = new LinkedList<>();
        tools.add(ToolFactory.CreatTool((int)(Math.random() * 4 + 1), LocationX, LocationY));
        return tools;
    }
}
