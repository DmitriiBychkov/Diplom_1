import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void getPriceWhiteBunReturn200() {
        Bun bun = new Bun("white bun", 200);
        float expectedPrice = 200;
        float actualPrice = bun.getPrice();
        Assert.assertEquals("white bun price is 200", expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void getNameRedBunReturnRedBun() {
        Bun bun = new Bun("red bun", 300);
        String expectedName = "red bun";
        String actualName = bun.getName();
        Assert.assertEquals("red bun name is wrong", expectedName, actualName);
    }
}
