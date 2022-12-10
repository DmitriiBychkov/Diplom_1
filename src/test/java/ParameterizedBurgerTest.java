import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;

import java.util.List;

@RunWith(Parameterized.class)
public class ParameterizedBurgerTest {

    //    Проверка установки новой булки
    private final int bunIndex;
    private final String bunName;

    public ParameterizedBurgerTest(int bunIndex, String bunName) {
        this.bunIndex = bunIndex;
        this.bunName = bunName;
    }

    @Parameterized.Parameters
    public static Object[][] dataBun() {
        return new Object[][]{
                {0, "black bun"},
                {1, "white bun"},
                {2, "red bun"},
        };
    }

    @Test
    public void setBunsAddNewBun() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(bunIndex));
        String expectedBunName = bunName;
        String actualBunName = burger.bun.getName();
        System.out.println("Expected bun name: " + expectedBunName);
        System.out.println("Actual bun name: " + actualBunName);
        Assert.assertEquals("Bun isn`t added", expectedBunName, actualBunName);
    }
}