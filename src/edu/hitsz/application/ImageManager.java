package edu.hitsz.application;


import edu.hitsz.aircraft.*;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.tool.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 综合管理图片的加载，访问
 * 提供图片的静态访问方法
 * @author hitsz
 */
public class ImageManager {

    /**
     * 类名-图片 映射，存储各基类的图片 <br>
     * 可使用 CLASSNAME_IMAGE_MAP.get( obj.getClass().getName() ) 获得 obj 所属基类对应的图片
     */
    private static final Map<String, BufferedImage> CLASSNAME_IMAGE_MAP = new HashMap<>();

    public static BufferedImage BACKGROUND_IMAGE;
    public static BufferedImage HERO_IMAGE;
    public static BufferedImage HERO_BULLET_IMAGE;
    public static BufferedImage ENEMY_BULLET_IMAGE;
    public static BufferedImage MOB_ENEMY_IMAGE;
    public static BufferedImage ELITE_ENEMY_IMAGE;
    public static BufferedImage ELITE_PLUS_IMAGE;
    public static BufferedImage ELITE_PRO_IMAGE;
    public static BufferedImage BOSS_IMAGE;

    public static BufferedImage BLOOD_TOOL_IMAGE;
    public static BufferedImage FIRE_TOOL_IMAGE;
    public static BufferedImage FIREPLUS_TOOL_IMAGE;
    public static BufferedImage FREEZE_TOOL_IMAGER;
    public static BufferedImage BOMB_TOOL_IMAGER;

    static {
        try {

            BACKGROUND_IMAGE = ImageIO.read(new FileInputStream("src/images/bg.jpg"));

            HERO_IMAGE = ImageIO.read(new FileInputStream("src/images/hero.png"));
            MOB_ENEMY_IMAGE = ImageIO.read(new FileInputStream("src/images/mob.png"));
            ELITE_ENEMY_IMAGE = ImageIO.read(new FileInputStream("src/images/elite.png"));
            ELITE_PLUS_IMAGE = ImageIO.read(new FileInputStream("src/images/elitePlus.png"));
            ELITE_PRO_IMAGE = ImageIO.read(new FileInputStream("src/images/elitePro.png"));
            BOSS_IMAGE = ImageIO.read(new FileInputStream("src/images/boss.png"));

            HERO_BULLET_IMAGE = ImageIO.read(new FileInputStream("src/images/bullet_hero.png"));
            ENEMY_BULLET_IMAGE = ImageIO.read(new FileInputStream("src/images/bullet_enemy.png"));
            BLOOD_TOOL_IMAGE = ImageIO.read(new FileInputStream("src/images/prop_blood.png"));
            FIRE_TOOL_IMAGE = ImageIO.read(new FileInputStream("src/images/prop_bullet.png"));
            FIREPLUS_TOOL_IMAGE = ImageIO.read(new FileInputStream("src/images/prop_bulletPlus.png"));
            FREEZE_TOOL_IMAGER = ImageIO.read(new FileInputStream("src/images/prop_freeze.png"));
            BOMB_TOOL_IMAGER = ImageIO.read(new FileInputStream("src/images/prop_bomb.png"));

            CLASSNAME_IMAGE_MAP.put(HeroAircraft.class.getName(), HERO_IMAGE);
            CLASSNAME_IMAGE_MAP.put(MobEnemy.class.getName(), MOB_ENEMY_IMAGE);
            CLASSNAME_IMAGE_MAP.put(MobEnemy_plus.class.getName(), ELITE_ENEMY_IMAGE);
            CLASSNAME_IMAGE_MAP.put(SuperMobEnemy.class.getName(), ELITE_PLUS_IMAGE);
            CLASSNAME_IMAGE_MAP.put(AceMobEnemy.class.getName(), ELITE_PRO_IMAGE);
            CLASSNAME_IMAGE_MAP.put(BossMobEnemy.class.getName(), BOSS_IMAGE);

            CLASSNAME_IMAGE_MAP.put(HeroBullet.class.getName(), HERO_BULLET_IMAGE);
            CLASSNAME_IMAGE_MAP.put(EnemyBullet.class.getName(), ENEMY_BULLET_IMAGE);
            CLASSNAME_IMAGE_MAP.put(BloodTool.class.getName(), BLOOD_TOOL_IMAGE);
            CLASSNAME_IMAGE_MAP.put(FireTool.class.getName(), FIRE_TOOL_IMAGE);
            CLASSNAME_IMAGE_MAP.put(FirePlusTool.class.getName(), FIREPLUS_TOOL_IMAGE);
            CLASSNAME_IMAGE_MAP.put(FreezeTool.class.getName(), FREEZE_TOOL_IMAGER);
            CLASSNAME_IMAGE_MAP.put(BombTool.class.getName(), BOMB_TOOL_IMAGER);



        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static BufferedImage get(String className){
        return CLASSNAME_IMAGE_MAP.get(className);
    }

    public static BufferedImage get(Object obj){
        if (obj == null){
            return null;
        }
        return get(obj.getClass().getName());
    }

}
