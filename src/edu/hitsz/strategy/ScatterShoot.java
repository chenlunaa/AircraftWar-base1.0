package edu.hitsz.strategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.AceMobEnemy;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class ScatterShoot implements Strategy{
    @Override
    public List<BaseBullet> shoot(AbstractAircraft abstractAircraftint, int LocationX, int LocationY, int SpeedX, int SpeedY, int direction, int power){
        List<BaseBullet> res = new LinkedList<>();
        int shootNum = 3;
        BaseBullet bullet_1;
        for(int i=0; i < shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            Class cls = abstractAircraftint.getClass();
            if (cls == AceMobEnemy.class){
                bullet_1 = new EnemyBullet(LocationX + (i*2 - shootNum + 1)*10,
                        LocationY + direction * 2,
                        (i - SpeedX),
                        SpeedY + direction*5,
                        power);
            }else {
                bullet_1 = new HeroBullet(LocationX + (i*2 - shootNum + 1)*10,
                        LocationY + direction * 2,
                        (i - SpeedX),
                        SpeedY + direction*5,
                        power);

            }
            res.add(bullet_1);
        }
        return res;
    }
}

