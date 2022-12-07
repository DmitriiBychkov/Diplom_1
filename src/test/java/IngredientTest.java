import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void getPriceHotSauceReturn100() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        float expectedPrice = 100;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("hot sauce price is 100", expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void getNameCutletReturnCutlet() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        String expectedName = "cutlet";
        String actualName = ingredient.getName();
        Assert.assertEquals("cutlet name is wrong", expectedName, actualName);
    }

    @Test
    public void getTypeSausageReturnFILLING() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
        IngredientType expectedType = IngredientType.FILLING;
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals("sausage Type is FILLING", expectedType, actualType);
    }
}
