package hw.lab3.weapons;

import hw.lab3.heroes.Hero;

/**
 * @author Evgeny Borisov
 */
public interface Weapon {
    int kick(Hero attacker, Hero defender);
}
