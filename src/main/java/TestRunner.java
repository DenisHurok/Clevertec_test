import org.junit.Assert;
import org.junit.Test;

public class TestRunner {
    Purchase purchase1 = new Purchase("Bublik",0);

    @Test
    public void testTotalCost() {
        Assert.assertEquals("0.0", purchase1.getTotal());

    }
}
