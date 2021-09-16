package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HeroRepositoryTest {

    private HeroRepository heroRepository;

    //Hero
    private Hero hero1;
    private Hero hero2;

    //Item
    private Item item;
    private Item item2;



    @Before
    public void before() {

        this.item = new Item(10, 10, 10);
        this.item2 = new Item(20, 20, 20);
        this.hero1 = new Hero("Name2", 1, this.item);
        this.hero2 = new Hero("Name1", 10, this.item2);
        this.heroRepository = new HeroRepository();
    }


    @Test
    public void addHeroShouldWorkCorectly() {
        heroRepository.add(hero1);
        Assert.assertEquals(1, heroRepository.getCount());


    }

    @Test(expected = IllegalArgumentException.class)
    public void addHeroShouldThrowIfExist() {
        heroRepository.add(hero1);
        heroRepository.add(hero1);
    }


    @Test
    public void removeHeroShouldWork() {
        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        this.heroRepository.remove(hero1.getName());
        Assert.assertEquals(1, heroRepository.getCount());

    }

    @Test(expected = NullPointerException.class)
    public void removeHeroShouldThrowNull() {
        this.heroRepository.remove(hero1.getName());
    }

    @Test
    public void getHeroWithHighestStrength() {
        this.heroRepository.add(this.hero1);
        Hero hero3 = new Hero("Name3", 1, new Item(20, 1, 1));
        this.heroRepository.add(hero3);

        Hero expectedHero = hero3;

        Assert.assertEquals(expectedHero, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrow() {
        heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestAgility() {
        this.heroRepository.add(this.hero1);
        Hero hero3 = new Hero("Name3", 1, new Item(1, 20, 1));
        this.heroRepository.add(hero3);

        Hero expectedHero = hero3;

        Assert.assertEquals(expectedHero, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrow() {

        heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestIntelligence() {
        this.heroRepository.add(this.hero1);
        Hero hero3 = new Hero("Name3", 1, new Item(1, 1, 20));
        this.heroRepository.add(hero3);

        Hero expectedHero = hero3;

        Assert.assertEquals(expectedHero, this.heroRepository.getHeroWithHighestIntelligence());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrow() {
        heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getCount() {
        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        int expected = 2;

        Assert.assertEquals(expected, this.heroRepository.getCount());
    }

    @Test
    public void toStringTest() {
        heroRepository.add(hero1);
        String expected = hero1.toString();

        Assert.assertEquals(expected, heroRepository.toString());
    }


}