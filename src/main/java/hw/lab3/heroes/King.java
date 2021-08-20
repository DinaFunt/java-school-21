package hw.lab3.heroes;

import hw.lab3.utils.RandomUtil;
import hw.lab3.weapons.Sword;
import hw.lab3.weapons.Weapon;

/**
 * @author Evgeny Borisov
 */
public class King extends AbstractHero {
    private Weapon weapon = new Sword();

    public King() {
        setHp(RandomUtil.between(5,15));
        setPower(RandomUtil.between(5,15));
    }

    @Override
    public int kick(Hero enemy) {
        return weapon.kick(this, enemy);
    }
}
