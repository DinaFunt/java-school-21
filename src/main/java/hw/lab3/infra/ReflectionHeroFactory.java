package hw.lab3.infra;

import hw.lab3.heroes.*;
import hw.lab3.utils.RandomUtil;
import lombok.SneakyThrows;

import java.util.List;

public class ReflectionHeroFactory implements HeroFactory {


    private final List<Class<? extends Hero>> heroClasses =
            List.of(Elf.class, Hobbit.class, King.class, Knight.class);



    @SneakyThrows
    @Override
    public Hero createHero() {

        Class<? extends Hero> heroClass = RandomUtil.getRandomElement(heroClasses);

        Hero hero = heroClass.getDeclaredConstructor().newInstance();


        return hero;
    }
}
