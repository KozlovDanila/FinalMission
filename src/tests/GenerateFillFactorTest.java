package tests;

import utils.GenerateFillFactor;
import org.junit.Assert;
import org.junit.Test;

public class GenerateFillFactorTest {
    @Test
    public void checkGenerate() {
        Assert.assertEquals(GenerateFillFactor.generate(3, 3, 0.5), 5);
        Assert.assertEquals(GenerateFillFactor.generate(5, 9, 0.88), 40);
    }

}