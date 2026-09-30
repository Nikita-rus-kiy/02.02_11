package T4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    // ---------- BIKE ----------

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        int price = priceCalculator.calculatePrice(TransportType.BIKE, 0);
        Assertions.assertTrue(price < 0);
    }

    @Test
    public void shouldReturn100ForBikeAndDistanceIs10Km() {
        int price = priceCalculator.calculatePrice(TransportType.BIKE, 10);
        Assertions.assertEquals(100, price);
    }

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs21Km() {
        int price = priceCalculator.calculatePrice(TransportType.BIKE, 21);
        Assertions.assertTrue(price < 0);
    }

    // ---------- CAR ----------

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        int price = priceCalculator.calculatePrice(TransportType.CAR, 0);
        Assertions.assertTrue(price < 0);
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1001Km() {
        int price = priceCalculator.calculatePrice(TransportType.CAR, 1001);
        Assertions.assertTrue(price < 0);
    }

    @Test
    public void shouldReturn100ForCarAndDistanceIs1000Km() {
        int price = priceCalculator.calculatePrice(TransportType.CAR, 1000);
        Assertions.assertEquals(7000, price);
    }

    // ---------- TRUCK ----------

    @Test
    public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
        int price = priceCalculator.calculatePrice(TransportType.TRUCK, 0);
        Assertions.assertTrue(price < 0);
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        int price = priceCalculator.calculatePrice(TransportType.TRUCK, 1000);
        Assertions.assertEquals(5000, price);
    }

    // ---------- DRONE ----------

    @Test
    public void shouldBeNullWhenDroneAndDistanceIs0Km() {
        Integer price = priceCalculator.calculatePrice(TransportType.DRONE, 0);
        Assertions.assertNull(price);
    }
}