package is.vinnsla;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MealsTest {
    @Test
    public void testMeals() {
        Meals meal=new Meals("Pizza",1500);
        assertEquals(1500,meal.getPrice());

    }
}
