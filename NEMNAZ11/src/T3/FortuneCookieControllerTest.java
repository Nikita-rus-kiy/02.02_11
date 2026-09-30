package T3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortuneCookieControllerTest {

    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    public static FortuneCookieFactory create(boolean isPositive) {
        FortuneConfig config = new FortuneConfig(isPositive);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        return new FortuneCookieFactory(config,
                positive,
                negative
        );
    }

    @BeforeAll
    public static void beforeAll() {
        goodFactoryController = new FortuneCookieController(create(true));
        badFactoryController = new FortuneCookieController(create(false));
    }

    @Test
    public void shouldReturnPositiveFortune() {
        FortuneCookie cookie = goodFactoryController.tellFortune();
        assertEquals("positive", cookie.getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        FortuneCookie cookie = badFactoryController.tellFortune();
        assertEquals("negative", cookie.getFortuneText());
    }
}