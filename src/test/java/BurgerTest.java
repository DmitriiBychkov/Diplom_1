import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientFirst;
    @Mock
    Ingredient ingredientSecond;

    //    Проверка добавления ингредиента
    @Test
    public void addIngredientAddItToTheList() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(1));
        int expectedListSize = 1;
        int actualListSize = burger.ingredients.size();
        System.out.println("Expected list size: " + expectedListSize);
        System.out.println("Actual list size: " + actualListSize);
        Assert.assertEquals("Ingredient isn`t added", expectedListSize, actualListSize);
    }

    //    Проверка удаления ингредиента
    @Test
    public void removeIngredientDeleteItFromTheList() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(1));
        burger.removeIngredient(0);
        int expectedListSize = 0;
        int actualListSize = burger.ingredients.size();
        System.out.println("Expected list size: " + expectedListSize);
        System.out.println("Actual list size: " + actualListSize);
        Assert.assertEquals("Ingredient isn`t removed", expectedListSize, actualListSize);
    }

    //    Проверка перемещения ингредиента
    @Test
    public void moveIngredientChangeHisIndexRight() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Ingredient> ingredients = database.availableIngredients();
        burger.addIngredient(ingredients.get(1));
        burger.addIngredient(ingredients.get(4));
        burger.addIngredient(ingredients.get(3));
        burger.addIngredient(ingredients.get(5));
        burger.moveIngredient(2, 1);
        String expectedIngredient = "cutlet";
        String actualIngredient = burger.ingredients.get(1).getName();
        System.out.println("Expected ingredient: " + expectedIngredient);
        System.out.println("Actual ingredient: " + actualIngredient);
        Assert.assertEquals("Ingredient moved wrong", expectedIngredient, actualIngredient);
    }

    //    Проверка корректной цены за бургер
    @Test
    public void getPriceReturnCorrectSumma() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(2F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(3F);
        float expectedPrice = 7F;
        float actualPrice = burger.getPrice();
        System.out.println("Expected price: " + expectedPrice);
        System.out.println("Actual price: " + actualPrice);
        Assert.assertEquals("Price isn`t correct", expectedPrice, actualPrice, 0.0);
    }

    //    Проверка вывода правильного чека
    @Test
    public void getReceiptMakeRightCheck() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredientFirst);
        Mockito.when(bun.getName()).thenReturn("sesame bun");
        Mockito.when(ingredientFirst.getName()).thenReturn("ketchup mayonnaise");
        Mockito.when(ingredientFirst.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(bun.getPrice()).thenReturn(1F);
        Mockito.when(ingredientFirst.getPrice()).thenReturn(2F);
        System.out.println("Expected receipt:\r\n" + burger.getReceipt());
        StringBuilder receipt = new StringBuilder();
        receipt.append("(==== sesame bun ====)\r\n");
        receipt.append("= sauce ketchup mayonnaise =\r\n");
        receipt.append("(==== sesame bun ====)\r\n");
        receipt.append("\r\nPrice: 4,000000\r\n");
        System.out.println("Actual receipt:\r\n" + receipt);
        Assert.assertEquals("Receipt isn`t correct", receipt.toString(), burger.getReceipt());
    }
}