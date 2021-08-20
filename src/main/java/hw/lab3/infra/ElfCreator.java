package hw.lab3.infra;

import hw.lab3.heroes.Elf;
import hw.lab3.heroes.Hero;

/**
 * @author Evgeny Borisov
 */
public class ElfCreator implements HeroCreator {
    @Override
    public Hero create() {
        return new Elf();
    }
}
