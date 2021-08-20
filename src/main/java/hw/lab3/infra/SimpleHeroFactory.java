package hw.lab3.infra;

import hw.lab3.heroes.Hero;
import hw.lab3.utils.RandomUtil;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class SimpleHeroFactory implements HeroFactory {

    private List<HeroCreator> heroCreators = List.of(
            new HobbitCreator(), new ElfCreator());


    @Override
    public Hero createHero() {
        return RandomUtil.getRandomElement(heroCreators).create();
    }
}











