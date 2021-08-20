package hw.lab3.heroes;

import hw.lab3.utils.RandomUtil;
import hw.lab3.weapons.Sword;
import hw.lab3.weapons.Weapon;

/**
 * @author Evgeny Borisov
 */
public class Knight extends AbstractHero {

    private Weapon weapon = new Sword();

    public Knight() {
        setHp(RandomUtil.between(2,12));
        setPower(RandomUtil.between(2,12));
    }

    @Override
    public int kick(Hero enemy) {
        return weapon.kick(this,enemy);
    }
}
