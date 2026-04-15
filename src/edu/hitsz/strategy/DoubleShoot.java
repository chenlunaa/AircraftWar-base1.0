package edu.hitsz.strategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.SuperMobEnemy;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class DoubleShoot implements Strategy{
    @Override
    public List<BaseBullet> shoot(AbstractAircraft abstractAircraftint, int LocationX, int LocationY, int SpeedX, int SpeedY, int direction, int power){
        List<BaseBullet> res = new LinkedList<>();
        int shootNum = 2;
        int x = LocationX;
        int y = LocationY + direction * 2;
        int speedY = SpeedY + direction*5;
        BaseBullet bullet_1;
        Class cls = abstractAircraftint.getClass();
        for(int i=0; i < shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if (cls == SuperMobEnemy.class){
                bullet_1 = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, SpeedX, speedY, power);
            }else{
                    bullet_1 = new HeroBullet(x + (i*2 - shootNum + 1)*10, y, SpeedX, speedY, power);
            }
            res.add(bullet_1);
        }
        return res;
    }
}