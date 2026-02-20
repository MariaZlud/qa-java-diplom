package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedBurgerTests {
    private final float bunPrice;
    private final float ingredientPrice;
    private final float price;

    public ParameterizedBurgerTests(float bunPrice, float ingredientPrice, float price) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] setBurger() {
        return new Object[][] {
                {100F, 50F, 250F},
                {150F, 100F, 400F},
                {200F, 150F,550F}
        };
    }

    @Test
    public void getReseiptParametrized() {
        Burger burger = new Burger();
        Bun mockBun = Mockito.mock(Bun.class);
        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(mockBun);
        Ingredient mockIngredient = Mockito.mock(Ingredient.class);
        Mockito.when(mockIngredient.getPrice()).thenReturn(ingredientPrice);
        burger.addIngredient(mockIngredient);
        float actual = burger.getPrice();
        assertEquals(price, actual, 0.01F);
    }
}
