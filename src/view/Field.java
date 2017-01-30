package view;

public class Field implements Cloneable {

    Cell[][] arrayOfState;

    public Field(int height, int width) {
        arrayOfState = new Cell[height][width];
        for (int heightIndex = 0; heightIndex < getHeightSize(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < getWidthSize(); widthIndex++) {
                arrayOfState[heightIndex][widthIndex] = new Cell(new FreePlace());
            }
        }
    }

    public void setCell(int heightIndex, int widthIndex, State state) {
        arrayOfState[heightIndex][widthIndex] = new Cell(state);
    }

    public int getWidthSize() {
        return arrayOfState[0].length;
    }

    public int getHeightSize() {
        return arrayOfState.length;
    }

    public Cell getCell(int heightIndex, int widthIndex) {
        return arrayOfState[heightIndex][widthIndex];
    }

    @Override
    public Field clone() {
        Field clone = new Field(getHeightSize(), getWidthSize());
        for (int row = 0; row < clone.getHeightSize(); row++) {
            for (int column = 0; column < clone.getWidthSize(); column++) {
                clone.setCell(row, column, arrayOfState[row][column].getState());
            }
        }
        return clone;
    }
}
