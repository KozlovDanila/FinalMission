package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import view.Field;

public class FieldTest {

    Field field = new Field(3, 4);

    @Test
    public void checkGetWeightSize() {
        Assert.assertEquals(field.getHeightSize(), 3);
        Assert.assertNotEquals(field.getHeightSize(), 5);
    }

    @Test
    public void checkGetHeightSize() {
        Assert.assertEquals(field.getWidthSize(), 4);
        Assert.assertNotEquals(field.getWidthSize(), 5);
    }

    @Test
    public void checkGetCell() {
        Cell cell = new Cell(new BusyPlace());
        Assert.assertEquals(field.getCell(0, 0).getValueState(), cell.getValueState());
    }


}