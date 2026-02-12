package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient;

    @Mock
    Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsCreateBun() {
        Mockito.when(bun.getName()).thenReturn("New bun");
        burger.setBuns(bun);
        assertEquals("New bun", burger.bun.getName());
    }

    @Test
    public void addIngredientToList() {
        burger.addIngredient(firstIngredient);
        assertEquals(1, burger.ingredients.size());
        assertEquals(firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientByIndex() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientToList() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        assertEquals(firstIngredient, burger.ingredients.get(0));
        assertEquals(secondIngredient, burger.ingredients.get(1));
        burger.moveIngredient(0, 1);
        assertEquals(firstIngredient, burger.ingredients.get(1));
        assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void getReceiptShouldReturnValidReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        Mockito.when(bun.getName()).thenReturn("New bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(firstIngredient.getName()).thenReturn("New ingredient");
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getPrice()).thenReturn(50F);
        String expected = String.format("(==== New bun ====)%n" + "= sauce New ingredient =%n" + "(==== New bun ====)%n" + "%n" + "Price: 250,000000%n");
        assertEquals(expected, burger.getReceipt());
    }

}
