package utils;

import view.Field;

public final class Randomiser {

    public static void createRandomBusyPlace(Field field, int fillFactor) {
        for (int fillFactorIndex = 1; fillFactorIndex <= fillFactor; fillFactorIndex++) {
            int heightIndex = (int) (Math.random() * field.getHeightSize());
            int widthIndex = (int) (Math.random() * field.getWidthSize());
            if (!field.getCell(heightIndex, widthIndex).getValueState().equals("|X|")) {
                field.setCell(heightIndex, widthIndex, new BusyPlace());
            } else {
                fillFactorIndex--;
            }
        }
    }
}
