package hw.lab3.infra;

import hw.lab3.heroes.Hero;
import hw.lab3.heroes.Hobbit;

/**
 * @author Evgeny Borisov
 */
public class HobbitCreator implements HeroCreator {
    @Override
    public Hero create() {
        return new Hobbit();

    }
}
