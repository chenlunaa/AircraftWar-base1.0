package edu.hitsz.strategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.BossMobEnemy;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class CircleShoot implements Strategy{
    private int shootNum = 20;
    private double anglestep = 360 / this.shootNum;
    @Override
    public List<BaseBullet> shoot(AbstractAircraft abstractAircraftint, int LocationX, int LocationY, int SpeedX, int SpeedY, int direction, int power){
        int totalspeed = 10;
        List<BaseBullet> res = new LinkedList<>();
        BaseBullet bullet_1 = null;
        for(int i=0; i < this.shootNum; i++){
            double currentangleDegrees = i * anglestep;
            double currentanglRadians =  Math.toRadians(currentangleDegrees);
            double directionX = Math.cos(currentanglRadians);
            double directionY = Math.sin(currentanglRadians);
            SpeedX = (int)(totalspeed * directionX);
            SpeedY = (int) (totalspeed * directionY);
            Class cls = abstractAircraftint.getClass();
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if (cls == BossMobEnemy.class){
                bullet_1 = new EnemyBullet(LocationX ,
                        LocationY,
                        SpeedX,
                        SpeedY,
                        power);
            }else{
                bullet_1 = new HeroBullet(LocationX ,
                        LocationY,
                        SpeedX,
                        SpeedY,
                        power);
            }
            res.add(bullet_1);
        }
        return res;
    }
}
