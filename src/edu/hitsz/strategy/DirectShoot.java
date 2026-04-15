package edu.hitsz.strategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.aircraft.MobEnemy_plus;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class DirectShoot implements Strategy{
    @Override
    public List<BaseBullet> shoot(AbstractAircraft abstractAircraftint, int LocationX, int LocationY, int SpeedX, int SpeedY, int direction, int power) {
        List<BaseBullet> res = new LinkedList<>();
        int shootNum = 1;
        Class cls = abstractAircraftint.getClass();
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            BaseBullet bullet_1;
            if (cls == MobEnemy_plus.class){
                bullet_1 = new EnemyBullet(LocationX ,
                        LocationY,
                        SpeedX,
                        SpeedY,
                        power);
            }else{
                bullet_1 = new HeroBullet(LocationX ,
                        LocationY,
                        0,
                        -5,
                        power);
            }
            res.add(bullet_1);
        }
        return res;
    }
}
