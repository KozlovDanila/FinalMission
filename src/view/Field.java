package view;

public class Field implements Cloneable {

    private Cell[][] cells;

    public Field(int height, int width) {
        cells = new Cell[height][width];
        for (int heightIndex = 0; heightIndex < getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < getWidthSize(); widthIndex++) {
                cells[heightIndex][widthIndex] = new Cell(" - ");

            }
        }
    }

    public void createRandomBusyPlace(int fillFactor) {
        for (int fillFactorIndex = 1; fillFactorIndex <= fillFactor; fillFactorIndex++) {
            int heightIndex = (int) (Math.random() * getHeightSize());
            int widthIndex = (int) (Math.random() * getWidthSize());
            if (!getCell(heightIndex, widthIndex).equals("|X|")) {
                cells[heightIndex][widthIndex].setBusyCell();
            } else {
                fillFactorIndex--;
            }
        }
    }

    public void setCell(int heightIndex, int widthIndex, String state) {
        cells[heightIndex][widthIndex] = new Cell(state);
    }

    public int getWidthSize() {
        return cells[0].length;
    }

    public int getHeightSize() {
        return cells.length;
    }

    public Cell getCell(int heightIndex, int widthIndex) {
        return cells[heightIndex][widthIndex];
    }

    @Override
    public Field clone() {
        Field clone = new Field(getHeightSize(), getWidthSize());
        for (int row = 0; row < clone.getHeightSize(); row++) {
            for (int column = 0; column < clone.getWidthSize(); column++) {
                clone.setCell(row, column, cells[row][column].getState());
            }
        }
        return clone;
    }
}
