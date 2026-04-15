package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.strategy.*;
import edu.hitsz.tool.BaseTool;

import java.util.LinkedList;
import java.util.List;

/**
 * 英雄飞机，游戏玩家操控
 * @author hitsz
 */
public class HeroAircraft extends AbstractAircraft {

    //每次射击发射子弹数量
    private int shootNum = 1;

    //子弹威力
    private int power = 30;

    //子弹射击方向 (向上发射：-1，向下发射：1)
    private int direction = -1;
    private Strategy strategy = new DirectShoot();

    private volatile static HeroAircraft heroAircraft;

    private HeroAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    public void SetStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public static HeroAircraft getHeroAircraft() {
        if (heroAircraft == null) {
            synchronized (HeroAircraft.class) {
                if ( heroAircraft == null) {
                    heroAircraft = new HeroAircraft(Main.WINDOW_WIDTH / 2,
                            Main.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight() ,
                            0, 0, 100);

                }
            }
        }
        return heroAircraft;
    }

    @Override
    public void forward() {
        // 英雄机由鼠标控制，不通过forward函数移动
    }
    @Override
    /**
     * 通过射击产生子弹
     * @return 射击出的子弹List
     */
    public List<BaseBullet> shoot() {
        return strategy.shoot(this, this.getLocationX(), this.getLocationY(), this.getSpeedX(), this.getSpeedY(), direction, power);
    }
   public void Healing(){
        if (this.getHp() + 20 <= 100) {
            this.hp = this.hp + 20;
        } else {
            this.hp = 100;
        }
    }
    @Override
    public List<BaseTool> GetTools(int LocationX, int LocationY){ return new LinkedList<>();}
}
