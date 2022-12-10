import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private final float bunPrice;
    private final String bunName;

    public BunTest(float bunPrice, String bunName) {
        this.bunPrice = bunPrice;
        this.bunName = bunName;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {100, "black bun"},
                {200, "white bun"},
                {300, "red bun"},
        };
    }

    @Test
    public void getPriceReturnRightValue() {
        Bun bun = new Bun(bunName, bunPrice);
        float actualPrice = bun.getPrice();
        Assert.assertEquals("bun price isn`t correct", bunPrice, actualPrice, 0.0);
    }

    @Test
    public void getNameReturnRightBun() {
        Bun bun = new Bun(bunName, bunPrice);
        String actualName = bun.getName();
        Assert.assertEquals("bun name is wrong", bunName, actualName);
    }
}