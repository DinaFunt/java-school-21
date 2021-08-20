package hw.lab3.weapons;

import hw.lab3.heroes.Hero;
import hw.lab3.utils.RandomUtil;

/**
 * @author Evgeny Borisov
 */
public class Sword implements Weapon {
    @Override
    public int kick(Hero attacker, Hero defender) {
        int damage = RandomUtil.between(0, attacker.getPower());
        defender.decreaseHp(damage);
        return damage;
    }
}
