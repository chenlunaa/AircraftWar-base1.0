package edu.hitsz.strategy;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.bullet.BaseBullet;

import java.util.List;

public interface Strategy {
     List<BaseBullet> shoot(AbstractAircraft abstractAircraft,int LocationX, int LocationY, int SpeedX, int SpeedY, int direction, int power);
}
