package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.ValueUtils;

public class ValueUtilsTest {
    @Test
    public void testCheckValueInt() {
        Assert.assertEquals(ValueUtils.checkValueInt("a"), false);
        Assert.assertEquals(ValueUtils.checkValueInt("9"), true);
        Assert.assertEquals(ValueUtils.checkValueInt("100"), true);
    }

    @Test
    public void testCheckValueDouble() {
        Assert.assertEquals(ValueUtils.checkValueDouble("0.1"), true);
        Assert.assertEquals(ValueUtils.checkValueDouble("1.1"), true);
        Assert.assertEquals(ValueUtils.checkValueDouble("25"), false);
        Assert.assertEquals(ValueUtils.checkValueDouble("b"), false);
    }

}