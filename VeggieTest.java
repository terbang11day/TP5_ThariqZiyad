import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VeggieTest {

    @Test
    public void testDiscountForOrganicVeggie() {
        Veggie organicVeggie = new Veggie("Organic Spinach", 50, 10, true);
        
        int discount1 = organicVeggie.checkDiscount(1);
        int discount3 = organicVeggie.checkDiscount(3);
        int discount5 = organicVeggie.checkDiscount(5);

        assertEquals(0, discount1);
        assertEquals(10, discount3);
        assertEquals(20, discount5);
    }

    @Test
    public void testDiscountForNonOrganicVeggie() {
        Veggie nonOrganicVeggie = new Veggie("Cabbage", 30, 20, false);
        
        int discount1 = nonOrganicVeggie.checkDiscount(1);
        int discount3 = nonOrganicVeggie.checkDiscount(3);
        int discount5 = nonOrganicVeggie.checkDiscount(5);

        assertEquals(0, discount1);
        assertEquals(20, discount3);
        assertEquals(25, discount5);
    }
}
