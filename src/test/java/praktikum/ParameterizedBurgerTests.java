package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParameterizedBurgerTests {
    private final Bun bun;
    private final Ingredient ingredient;
    private final float price;

    public ParameterizedBurgerTests(Bun bun, Ingredient ingredient, float price) {
        this.bun = bun;
        this.ingredient = ingredient;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBurger() {
        return new Object[][] {
                {new Bun("Bun1", 100F),
                new Ingredient(IngredientType.SAUCE, "Ingredient1", 50F), 250F},
                {new Bun("Bun2", 150F),
                new Ingredient(IngredientType.FILLING, "Ingredient2", 100F), 400F},
                {new Bun("Bun3", 200F),
                new Ingredient(IngredientType.SAUCE, "Ingredient3", 150F),550F}
        };
    }

    @Test
    public void getReseiptParametrized() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        assertEquals(price, actual, 0.01F);
    }
}
