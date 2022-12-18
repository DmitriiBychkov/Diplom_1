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
                {400, ""},
                {500, "black bun white bun red bun"},
                {600, null},
                {700, "!@#$%^&*()_+"},
                {800, "батон нарезной"},
                {900, " red bun "},
                {1000, "Black bun"},
                {9999, "wHiTe BuN"},
                {1234567890, "redbun"},
                {-100, "black bun"},
                {0, "white bun"},
                {1.4e-45f, "red bun"},
                {3.4e+38f, "black bun"},
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