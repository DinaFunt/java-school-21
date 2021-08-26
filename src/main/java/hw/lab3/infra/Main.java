package hw.lab3.infra;

public class Main {
    public static void main(String[] args) {
        ReflectionHeroFactory heroFactory = new ReflectionHeroFactory();

        for (int i = 0; i < 10; i++) {
            System.out.println(heroFactory.createHero());
        }

    }
}
