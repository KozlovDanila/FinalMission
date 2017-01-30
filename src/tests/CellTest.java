package tests;

import org.junit.Assert;
import org.junit.Test;
import view.Field;

public class CellTest {

    Field field = new Field(3, 4);

    @Test
    public void checkGetState() {
        Assert.assertEquals(field.getCell(0, 0).getValueState(), "|X|");
        Assert.assertEquals(field.getCell(0, 1).getValueState(), " - ");
        Assert.assertNotEquals(field.getCell(0, 1).getValueState(), "|X|");
        Assert.assertNotEquals(field.getCell(0, 0).getValueState(), " - ");
    }
}